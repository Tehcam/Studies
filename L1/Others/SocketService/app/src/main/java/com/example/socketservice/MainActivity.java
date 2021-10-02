package com.example.socketservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Size;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.demo.CameraXViewModel;
import com.google.mlkit.vision.demo.GraphicOverlay;
import com.google.mlkit.vision.demo.VisionImageProcessor;
import com.google.mlkit.vision.demo.java.barcodescanner.BarcodeScannerProcessor;
import com.google.mlkit.vision.demo.preference.PreferenceUtils;
import com.google.mlkit.vision.demo.preference.SettingsActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private PreviewView previewView;
    private GraphicOverlay graphicOverlay;
    private boolean needUpdateGraphicOverlay;
    private CameraSelector cameraSelector;

    @Nullable private ProcessCameraProvider cameraProvider;
    @Nullable private Preview previewUseCase;
    @Nullable private ImageAnalysis analysisUseCase;
    @Nullable private VisionImageProcessor imageProcessor;

    private static final String BARCODE_SCANNING = "Barcode Scanning";
    private static final String STATE_SELECTED_MODEL = "selected_model";
    private final int lensFacing = CameraSelector.LENS_FACING_BACK;

    private String selectedModel = BARCODE_SCANNING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null)
            return;
        else
            selectedModel = savedInstanceState.getString(STATE_SELECTED_MODEL, BARCODE_SCANNING);
        cameraSelector = new CameraSelector.Builder().requireLensFacing(lensFacing).build();

        setContentView(R.layout.activity_real_time_camera);

        displayRealTimeSettings();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!MainService.getIsServiceRunning()) {
            Intent service = new Intent(this, MainService.class);
            startService(service);
        }
        MainService.getMySocket().addActivity(this);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(STATE_SELECTED_MODEL, selectedModel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bindAllCameraUseCase();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopProcessor();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopProcessor();
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        if (allPermissionsGranted())
            bindAllCameraUseCase();
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void bindAllCameraUseCase() {
        if(cameraProvider != null) {
            cameraProvider.unbindAll();
            bindPreviewUseCase();
            bindAnalysisUseCase();
        }
    }

    private void bindPreviewUseCase() {
        if(!PreferenceUtils.isCameraLiveViewportEnabled(this))
            return;
        if(cameraProvider == null)
            return;
        if(previewUseCase != null)
            cameraProvider.unbind(previewUseCase);

        Preview.Builder builder = new Preview.Builder();
        Size targetResolution = PreferenceUtils.getCameraXTargetResolution(this, lensFacing);
        if(targetResolution != null)
            builder.setTargetResolution(targetResolution);
        previewUseCase = builder.build();
        previewUseCase.setSurfaceProvider(previewView.getSurfaceProvider());
        cameraProvider.bindToLifecycle(this, cameraSelector, previewUseCase);
    }

    private void  bindAnalysisUseCase() {
        if (cameraProvider == null)
            return;
        if (analysisUseCase != null)
            cameraProvider.unbind(analysisUseCase);
        if (imageProcessor != null)
            imageProcessor.stop();
        if(selectedModel.equals(BARCODE_SCANNING))
            imageProcessor = new BarcodeScannerProcessor(this);

        ImageAnalysis.Builder builder = new ImageAnalysis.Builder();
        Size targetResolution = PreferenceUtils.getCameraXTargetResolution(this, lensFacing);
        if (targetResolution != null)
            builder.setTargetResolution(targetResolution);
        analysisUseCase = builder.build();

        needUpdateGraphicOverlay = true;
        analysisUseCase.setAnalyzer(
                ContextCompat.getMainExecutor(this),
                imageProxy -> {
                    if (needUpdateGraphicOverlay) {
                        int rotationDegrees = imageProxy.getImageInfo().getRotationDegrees();
                        if (rotationDegrees == 0 || rotationDegrees == 180) {
                            graphicOverlay.setImageSourceInfo(
                                    imageProxy.getWidth(), imageProxy.getHeight(), false);
                        } else {
                            graphicOverlay.setImageSourceInfo(
                                    imageProxy.getHeight(), imageProxy.getWidth(), false);
                        }
                        needUpdateGraphicOverlay = false;
                    }
                    try {
                        imageProcessor.processImageProxy(imageProxy, graphicOverlay);
                    } catch (MlKitException e) {
                        Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        cameraProvider.bindToLifecycle(this, cameraSelector, analysisUseCase);
    }

    private String[] getRequiredPermissions() {
        try {
            PackageInfo info =
                    this.getPackageManager()
                            .getPackageInfo(this.getPackageName(), PackageManager.GET_PERMISSIONS);
            String[] ps = info.requestedPermissions;
            if (ps != null && ps.length > 0)
                return ps;
            else
                return new String[0];
        } catch (Exception e) {
            return new String[0];
        }
    }

    private boolean allPermissionsGranted() {
        for (String permission : getRequiredPermissions()) {
            if (!isPermissionGranted(this, permission))
                return false;
        }
        return true;
    }

    private void getRuntimePermissions() {
        List<String> allNeededPermissions = new ArrayList<>();
        for (String permission : getRequiredPermissions()) {
            if (!isPermissionGranted(this, permission))
                allNeededPermissions.add(permission);
        }
        if (!allNeededPermissions.isEmpty())
            ActivityCompat.requestPermissions(
                    this, allNeededPermissions.toArray(new String[0]), 1);
    }

    private static boolean isPermissionGranted(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission)
                == PackageManager.PERMISSION_GRANTED;
    }

    private void displayRealTimeSettings() {
        previewView = findViewById(R.id.preview_view);
        graphicOverlay = findViewById(R.id.graphic_overlay);
        new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()))
                .get(CameraXViewModel.class)
                .getProcessCameraProvider()
                .observe(
                        this,
                        provider -> {
                            cameraProvider = provider;
                            if(allPermissionsGranted())
                                bindAllCameraUseCase();
                        }
                );
        ImageView settings = findViewById(R.id.settings_button);
        settings.setOnClickListener(
                v -> {
                    Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                    intent.putExtra(SettingsActivity.EXTRA_LAUNCH_SOURCE, SettingsActivity.LaunchSource.CAMERAX_LIVE_PREVIEW);
                    startActivity(intent);
                }
        );

        if(!allPermissionsGranted())
            getRuntimePermissions();
    }

    private void stopProcessor() {
        if(imageProcessor != null)
            imageProcessor.stop();
    }
}