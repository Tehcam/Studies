package collections_creator;

import collections.*;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Controleur du viewer fx.<br>
 * G&egrave;re les actions de viewer.fxml
 * @author Corentin Machet
 * @version 2021.05.01
 */
public class Viewer
{
    /**
     * Manager de l'interface fx
     * @see CreatorManager manager fx
     */
    private CreatorManager manager = null;

    /**
     * Constante associ&eacute;e &agrave; l'image suivante dans la liste des images &agrave; afficher
     * @see Controller.showNextOrPreviousImage() changement d'image
     */
    public static final int NEXT_IMAGE = 1;

    /**
     * Constante associ&eacute;e &agrave; l'image pr&acute;c&eacute;dente dans la liste des images &agrave; afficher
     * @see Controller.showNextOrPreviousImage() changement d'image
     */
    public static final int PREVIOUS_IMAGE = -1;

    /**
     * Objet fxml gardant la r&eacute;f&eacute;rence de la racine dans
     * l'arborescence xml
     */
    @FXML
    private BorderPane globalPane;

    /**
     * Conteneur de l'image &agrave; afficher dynamiquement
     */
    @FXML
    private ImageView imgContainer;

    /**
     * Constructeur par d&eacute;faut
     */
    public Viewer(){}

    /**
     * Ajout du manager de l'interface et initialise la propri&eacute;t&eacute; charg&eacute;e du changement d'image
     * @param manager le manager de l'interface
     */
    public void addManager(CreatorManager manager)
    {
        this.manager = manager;
        manager.setViewer(this);
        var ssp = new SimpleStringProperty();
        ssp.bind(manager.getController().getPathToImage());
        ssp.addListener(new MyListener<String>());
    }

    /**
     * Retourne la sc&egrave;ne &agrave; la racine de l'interface
     * g&eacute;r&eacute;e par ce controleur
     * @return la sc&egrave;ne &agrave; la racine
     */
    public javafx.scene.Scene getScene()
    {
        return globalPane.getScene();
    }

    /**
     * Override de la m&eacute;thode initialize de ce controleur fx
     */
    @FXML
    public void initialize(){}

    /**
     * Affiche l'image pr&eacute;c&eacute;dente dans la liste des images de la collection s&eacute;lectionn&eacute;e
     */
    @FXML
    public void prev()
    {
        manager.getController().showNextOrPreviousImage(PREVIOUS_IMAGE);
    }

    /**
     * Affiche l'image suivante dans la liste des images de la collection s&eacute;lectionn&eacute;e
     */
    @FXML
    public void next()
    {
        manager.getController().showNextOrPreviousImage(NEXT_IMAGE);
    }

    /**
     * Affiche le menu principal de la l'interface fx
     * @see Controller controleur principal de cette interface
     */
    @FXML
    public void back()
    {
        ((Stage)(this.getScene().getWindow())).setScene(manager.getController().getScene());
    }

    /**
     * Classe interne charg&eacute;e de l'&eacute;v&eacute;nementiel lorsque la property Controller.pathToImage change
     * @see Controller.pathToImage la propri&eacute;t&eacute; associ&eacute;e
     */
    private class MyListener<T> implements ChangeListener<T>
    {
        /**
         * Lorsque la property change de valeur, le viewer met automatiquement l'image affich&eacute;e &agrave; jour
         * @param observable valeur observ&eacute;e, ici la property
         * @param oldValue ancienne valeur de la property
         * @param newValue nouvelle valeur de la property
         */
        @Override
        public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue)
        {
            if(newValue instanceof String)
            {
                String str = (String)newValue;
                java.io.File f = new java.io.File(str);
                if(!f.isFile())
                    return;
                java.io.FileInputStream is = null;
                try
                {
                    is = new java.io.FileInputStream(f);
                    var img = new javafx.scene.image.Image(is);
                    imgContainer.setImage(img);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if(is != null)
                    {
                        try
                        {
                            is.close();
                        }
                        catch(Exception ex)
                        {
                            return;
                        }
                    }
                }
            }
        }
    }
}
