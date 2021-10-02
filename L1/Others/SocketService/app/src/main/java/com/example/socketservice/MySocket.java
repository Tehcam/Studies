package com.example.socketservice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.google.mlkit.vision.barcode.Barcode;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MySocket {
    private static final int port = 1234;
    private static SSLServerSocket server;
    private final Context context;
    private MyBarcodeProperty property;
    private SSLSocket socket;
    private Activity activity;

    public MySocket(Context context) {
        this.context = context;
    }

    public MyBarcodeProperty getProperty() {
        return property;
    }

    private SSLSocket getSocket() {
        return socket;
    }

    public void addActivity(Activity activity) {
        this.activity = activity;
    }

    private Activity getActivity() {
        return activity;
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void startServer() {
        try {
            server = (SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(port);
            while (true) {
                property = new MyBarcodeProperty(null);
                property.addOnChangeListener(new OnMyBarCodePropertyChangeListener());
                socket = (SSLSocket) server.accept();

                Intent activity = new Intent(context, MainActivity.class);
                context.startActivity(activity);
            }
        } catch (IOException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public class MyBarcodeProperty {
        private MyBarcode barcode;
        private MyBarcode previousMyBarcode;
        private OnMyBarCodePropertyChangeListener listener = null;

        public MyBarcodeProperty(Barcode barcode) {
            this.barcode = new MyBarcode(barcode);
            this.previousMyBarcode = new MyBarcode(this.barcode);
        }

        public void addOnChangeListener(OnMyBarCodePropertyChangeListener listener) {
            this.listener = listener;
            this.listener.addProperty(this);
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void setBarcode(Barcode barcode) {
            this.barcode = new MyBarcode(barcode);
            listener.verify();
            this.previousMyBarcode = new MyBarcode(this.barcode);
        }

        public MyBarcode getBarcode() {
            return barcode;
        }

        public MyBarcode getPreviousMyBarcode() {
            return previousMyBarcode;
        }
    }

    public class OnMyBarCodePropertyChangeListener {
        private MyBarcodeProperty property;

        public OnMyBarCodePropertyChangeListener() {}

        public void addProperty(MyBarcodeProperty property) {
            this.property = property;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void verify() {
            final String VERB = "GET";
            final String PATH = "/";
            final String PROTO = "HTTP/1.1";
            final String REQUEST_TYPE = "barcode";
            final String TOKEN = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };

            try{
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            } catch (NoSuchAlgorithmException | KeyManagementException e) {
                e.printStackTrace();
            }

            Looper.prepare();

            try {
                if(!property.getBarcode().equals(property.getPreviousMyBarcode())) {
                    getActivity().finish();

                    BufferedReader in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
                    PrintStream out = new PrintStream(getSocket().getOutputStream());
                    String request;
                    if(!getSocket().isClosed()) {
                        request = in.readLine();
                    } else {
                        request = null;
                    }
                    if(request != null) {
                        Scanner scanner = new Scanner(request).useDelimiter("\\r\\n\\r\\n");
                        String header = scanner.next();
                        try {
                            throw new Exception(header);
//                            Matcher matcher = Pattern.compile("Sec-WebSocket-Key: (.*)").matcher(header);
//                            if(!matcher.find()) {
//                                throw new IllegalArgumentException("Cannot find out the websocket's key");
//                            }
//                            Matcher matcher1 = Pattern.compile("Origin: (.*)").matcher(header);
//                            if(!matcher1.find()) {
//                                throw new IllegalArgumentException("Cannot find out the origin");
//                            }
//
//                            String res = "HTTP/1.1 101 Switching Protocols\r\n"
//                                    + "Access-Control-Allow-Origin: *\r\n"
//                                    + "Connection: Upgrade\r\n"
//                                    + "Upgrade: websocket\r\n"
//                                    + "Sec-WebSocket-Origin: "
//                                    + matcher1.group(1) + "\r\n"
//                                    + "Sec-WebSocket-Accept: "
//                                    + Arrays.toString(Base64.getEncoder().encode(
//                                        MessageDigest.getInstance("SHA-1").digest((matcher.group(1) + TOKEN).getBytes(StandardCharsets.UTF_8))
//                                    ))
//                                    + "\r\n\r\n";
//                            out.println(res);
//                            out.flush();
//
//                            // SUCCESS
//                            JSONObject json = new JSONObject();
//                            json.put(REQUEST_TYPE, property.getBarcode().getValue());
//                            out.println(json.toString());

                        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                            // ERROR_400
                            exceptions(e);
                            out.println("HTTP/1.1 400 Bad request\r\nAccess-Control-Allow-Origin: *\r\n\r\n");
                        } catch (JSONException | NoSuchAlgorithmException e) {
                            // ERROR_500
                            exceptions(e);
                            out.println("HTTP/1.1 500 Server failed at generating the response\r\nAccess-Control-Allow-Origin: *\r\n\r\n");
                        } catch (Exception e) {
                            exceptions(e);
                        }
                    } else {
                        // ERROR_NETWORK_RESET
                        throw new IOException("ERROR_NETWORK_EXCEPTION");
                    }
                    out.flush();
                    getSocket().close();
                }
            } catch (IOException e) {
                exceptions(e);
            } finally {
                Looper.loop();
                Looper.myLooper().quitSafely();
            }
        }

        private void exceptions(Exception e) {
            IOExceptionTypes type = setLogs(e);
            Toast.makeText(context, type.displayMessage(), Toast.LENGTH_LONG).show();
        }

        private IOExceptionTypes setLogs(Exception e) {
            try {
                File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
                File file;
                if(dir.isDirectory()) {
                    file = new File(dir.getPath() + File.separator + "socket_service.txt");
                    if(!file.exists()) {
                        if(!file.createNewFile()) {
                            return IOExceptionTypes.CANNOT_CREATE_FILE;
                        }
                    }
                } else {
                    throw new Exception();
                }
                if(file.isFile()) {
                    if(!file.canWrite()) {
                        if(!file.setWritable(true)) {
                            return IOExceptionTypes.FILE_IS_NOT_WRITABLE;
                        }
                    }
                    FileOutputStream out = new FileOutputStream(file);
                    PrintWriter writer = new PrintWriter(out);
                    e.printStackTrace(writer);
                    writer.flush();
                    writer.close();
                } else {
                    return IOExceptionTypes.FILE_IS_NULL_OR_NOT_A_FILE;
                }
                return IOExceptionTypes.NO_EXCEPTION;
            } catch (IOException ioe) {
                return IOExceptionTypes.CAUGHT_EXCEPTION;
            } catch (Exception ex) {
                return IOExceptionTypes.DIRECTORY_ERROR;
            }
        }
    }

    private static class MyBarcode {
        private long value = -1;

        public MyBarcode(Barcode barcode) {
            if(barcode != null && barcode.getDisplayValue() != null)
                value = Long.parseLong(barcode.getDisplayValue());
        }

        public MyBarcode(MyBarcode barcode) {
            this.value = barcode.value;
        }

        public long getValue() {
            return value;
        }

        @Override
        public boolean equals(Object object) {
            if(!(object instanceof MyBarcode))
                return false;
            MyBarcode comparedBarcode = (MyBarcode) object;
            return value == comparedBarcode.value;
        }
    }
}
