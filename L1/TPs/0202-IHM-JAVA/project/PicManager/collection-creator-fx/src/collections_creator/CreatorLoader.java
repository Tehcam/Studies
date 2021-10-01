package collections_creator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * Loader de l'application collections_creator<br>
 * Cr&eacute;e puis affiche les sc&egrave;ne de creator.fxml et viewer.fxml
 * @author Corentin Machet
 * @version 2021.05.01
 */
public class CreatorLoader extends Application
{
    /**
     * Unique manager associ&eacute; &grave; la fois au Controller et au Viewer
     * @see CreatorManager le manager de l'application
     */
    private static CreatorManager manager = new CreatorManager();

    /**
     * Override de la m&eacute;thode start() de l'application fx
     * @param primaryStage stage de l'application dans laquelle sont charg&eacute;es les sc&egrave;nes
     * @throws Exception si la cr&eacute;ation de la fenetre &eacute;choue
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("creator.fxml"));
        Scene mainScene = new Scene(mainLoader.load());
        Controller mainController = mainLoader.getController();
        mainController.addManager(manager);

        FXMLLoader viewerLoader = new FXMLLoader(getClass().getResource("viewer.fxml"));
        Scene viewerScene = new Scene(viewerLoader.load());
        Viewer viewerController = viewerLoader.getController();
        viewerController.addManager(manager);

        primaryStage.setTitle("PicManager - Creator");
        primaryStage.setScene(mainScene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}