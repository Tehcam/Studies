package pack;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

import java.util.ArrayList;

public class Game
{
	@FXML
	private VBox globalContainer;
	@FXML
	private Label points;
	@FXML
	private Pane grille;

	private Configuration configController;
	private Manager rgm = new Manager();
	private ArrayList<ImageView> img = new ArrayList<ImageView>();

	public Game(){}

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

	public void addConfigController(Configuration c)
	{
		configController = c;
	}

	@FXML
	public void backToMenu()
	{
		getStage().setScene(configController.getScene());
		configController.getStage().centerOnScreen();
	}

	public javafx.scene.Scene getScene()
	{
		return globalContainer.getScene();
	}

	public void restart(Level lvl)
	{
		if(rgm.init(lvl))
		{
			GridPane gridpane = new GridPane();
			for(int i=0; i<rgm.getRow().intValue(); i++)
			{
				gridpane.addRow(0, new Region());
			}
			for(int i=0; i<rgm.getCol().intValue()-1; i++)
			{
				gridpane.addColumn(0, new Region());
			}

			// System.out.println("Nombre de lignes : " + gridpane.getColumnCount());
			// System.out.println("Nombre de colonnes : " + gridpane.getRowCount());

			int[][] tab = rgm.getEp();
			for(int i=0; i<tab.length; i++)
			{
				for(int j=0; j<tab[i].length; j++)
				{
					String rad = tab[i][j]>9 ? ("FF_"+tab[i][j]) : ("FF_0"+tab[i][j]);
					var view = new ImageView("image" + java.io.File.separator + rad + ".jpg");
					img.add(view);
					gridpane.add(view, i, j);
				}
			}
			grille.getChildren().add(gridpane);
		}
	}

	public void fitImg()
	{
		for(ImageView i : img)
		{
			i.setFitHeight((grille.getHeight() / rgm.getCol().intValue()));
			i.setFitWidth((grille.getWidth() / rgm.getRow().intValue()));
		}
	}
}