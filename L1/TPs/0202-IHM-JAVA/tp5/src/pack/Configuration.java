package pack;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Configuration
{
	@FXML
	private VBox globalContainer;

	private Game gameController;
	
	public Configuration(){}

	@FXML
	public void initialize(){}

	public Stage getStage()
	{
		Stage stage = null;
		try
		{
			stage = (Stage)(globalContainer.getScene().getWindow());
		}
		catch(Exception e)
		{
			stage = null;
		}
		finally
		{
			return stage;
		}
	}

	public void addGameController(Game c)
	{
		gameController = c;
	}

	@FXML
	public void exit()
	{
		System.exit(0);
	}

	private void newGame(Level lvl)
	{
		gameController.restart(lvl);
		getStage().setScene(gameController.getScene());
		gameController.getStage().centerOnScreen();
		gameController.fitImg();
	}

	@FXML
	public void facile()
	{
		newGame(Level.FACILE);
	}

	@FXML
	public void moyen()
	{
		newGame(Level.MOYEN);
	}

	@FXML
	public void difficile()
	{
		newGame(Level.DIFFICILE);
	}

	public javafx.scene.Scene getScene()
	{
		return globalContainer.getScene();
	}
}