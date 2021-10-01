package pack;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class MemoryFX extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		FXMLLoader configLoader = new FXMLLoader(getClass().getResource("fxml" + File.separator + "Config.fxml"));
		FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("fxml" + File.separator + "MemoryFX.fxml"));

		Scene configScene = new Scene(configLoader.load());
		Scene gameScene = new Scene(gameLoader.load());
		Configuration configController = configLoader.getController();
		Game gameController = gameLoader.getController();

		configController.addGameController(gameController);
		gameController.addConfigController(configController);

		primaryStage.setTitle("MemoryFX");
		primaryStage.setScene(configScene);
		primaryStage.centerOnScreen();

		primaryStage.show();
	}
}