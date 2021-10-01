package collections_creator;

import collections.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.beans.property.SimpleStringProperty;

/**
 * Controleur principal de l'interface fx.<br>
 * G&egrave;re les actions de creator.fxml
 * @author Corentin Machet
 * @version 2021.05.01
 */
public class Controller
{
    /**
     * Manager de l'interface fx
     * @see CreatorManager manager fx
     */
    private CreatorManager manager = null;

    /**
     * R&eacute;f&eacute;rence vers la collection s&eacute;lectionn&eacute;e. Null si aucune collection s&eacute;lectionn&eacute;e
     */
    private Collections selectedCollection = null;

    /**
     * Nombre de nouvelle(s) collection(s) en m&eacute;moire (en attente d'un push vers les serial datas)
     */
    private int nbCommits = 0;
    
    /**
     * Propri&eacute;t&eacute; gardant la valeur de l'image courante sous la forme d'une chaine de caract&egrave;res
     * @see showNextOrPreviousImage() changer d'image
     */
    private static SimpleStringProperty pathToImage = new SimpleStringProperty();

    /**
     * Objet fxml gardant la r&eacute;f&eacute;rence de la racine dans l'arborescence xml
     */
    @FXML
    private BorderPane globalPane;

    /**
     * Objet fxml gardant la r&eacute;f&eacute;rence de la zone de recherche
     */
    @FXML
    private TextField searchInputText;

    /**
     * Objet fxml gardant la r&eacute;f&eacute;rence de la zone dans laquelle les listes de collections et d'images sont charg&eacute;es dynamiquement dans l'arborescence xml
     */
    @FXML
    private SplitPane listViewContainer;

    /**
     * Objet fxml gardant la r&eacute;f&eacute;rence du bouton en charge de l'affichage du viewer
     */
    @FXML
    private Button open;

    /**
     * Objet fxml gardant la r&eacute;f&eacute;rence du label indiquant le nombre de commit(s)
     */
    @FXML
    private Label mylabel;

    /**
     * Liste de collections charg&eacute;e dynamiquement dans l'arborescence
     */
    private ListView<String> listView;

    /**
     * Liste d'images de la collection s&eacute;lectionn&eacute;e charg&eacute;e
     * dynamiquement dans l'arborescence
     */
    private ListView<String> imgInListView;

    /**
     * Constructeur par d&eacute;faut
     */
    public Controller(){}

    /**
     * R&eacute;f&eacute;rence le manager de l'interface et initialise le controleur
     * @param manager le nouveau manager
     */
    public void addManager(CreatorManager manager)
    {
        this.manager = manager;
        manager.setController(this);
        init();
    }

    /**
     * Retourne la sc&egrave;ne &agrave; la racine de l'interface g&eacute;r&eacute;e par ce controleur
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
    public void initialize()
    {
        open.setDisable(true);
        listView = new ListView<String>();
        listView.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, ev -> {
            var tg = (ListView)ev.getSource();
            String str = (String)(tg.getSelectionModel().getSelectedItems().get(0));
            displayCollection(str);
        });
        imgInListView = new ListView<String>();
        imgInListView.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, ev -> {
            var tg = (ListView)ev.getSource();
            String str = (String)(tg.getSelectionModel().getSelectedItems().get(0));
            if(str != null && !str.equals("Empty Collection..."))
            {
                pathToImage.setValue(str);
                open.setDisable(false);
            }
        });
        listViewContainer.getItems().addAll(listView, imgInListView);
    }

    /**
     * Retourne la propri&eacute;t&eacute; associ&eacute;e &agrave; l'image courante sous forme d'une chaine de caract&eacute;res
     * @return la propri&eacute;t&eacute; associ&eacute;e &agrave; l'image courante
     */
    public SimpleStringProperty getPathToImage()
    {
        return pathToImage;
    }

    /**
     * Modifie la valeur de la propri&eacute;t&eacute; pathToImage tel que la nouvelle image courante ait pour indice celui de l'image pr&eacute;c&eacute;dente plus ou moins la valeur de n dans la liste d'image de la collection s&eacute;lectionn&eacute;e
     * @param n valeur de changement d'indice 
     */
    public void showNextOrPreviousImage(int n)
    {
        java.util.ArrayList<String> arr = selectedCollection.getImages();
        int currentIndex = arr.indexOf(pathToImage.getValue());
        currentIndex += n;
        if(currentIndex >= arr.size())
            currentIndex = 0;
        else if(currentIndex < 0)
            currentIndex = (arr.size() - 1);
        pathToImage.setValue(arr.get(currentIndex));
    }

    /**
     * Routine affichant dynamiquement les &eacute;l&eacute;ments de la liste d'images d'une collection
     * @param str nom de la collection &agrave; afficher
     */
    private void displayCollection(String str)
    {
        if(manager == null)
            return;
        selectedCollection = manager.getCurrentDatas().get(str);
        if(selectedCollection == null)
            return;
        java.util.List<String> mylist = selectedCollection.getImages();
        if(mylist.isEmpty())
        {
            mylist = new java.util.ArrayList<String>();
            mylist.add("Empty Collection...");
        }
        imgInListView.setItems(FXCollections.observableList(mylist));
    }

    /**
     * Ajoute une nouvelle collection &agrave; la liste des commits, selon le nom entr&eacute; 
     */
    @FXML
    public void createNewCollection()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Rename...");
        dialog.setHeaderText("Name the new collection :");
        dialog.initOwner(globalPane.getScene().getWindow());
        var str = dialog.showAndWait();
        str.ifPresent(res -> {
            String name = str.get();
            var c = new Collections();
            c.setName(name);
            manager.addToCommit(c);
            nbCommits++;
            mylabel.setText(nbCommits + " new collection(s) ready to be pushed !");
        });
    }

    /**
     * Envoi des collections en m&eacute;moire dans les commits
     */
    @FXML
    public void push()
    {
        manager.pushCommit();
        mylabel.setText("");
        nbCommits = 0;
        init();
    }

    /**
     * Mise &agrave; jour de l'interface selon les informations contenues dans les serial datas
     */
    @FXML
    public void fetch()
    {
        manager.fetchSerialDatas();
        init();
    }

    /**
     * Push les nouvelles collections puis ferme l'interface
     */
    @FXML
    public void close()
    {
        manager.pushCommit();
        System.exit(0);
    }

    /**
     * Recherche une collections dans la liste des collections sauvegard&eacute;es. La collection est affich&eacute;e si elle appartient &agrave; la liste
     */
    @FXML
    public void search()
    {
        java.util.List<String> mylist = new java.util.ArrayList<String>();
        String str = searchInputText.getCharacters().toString();
        if(str.equals(""))
        {
            fetch();
            return;
        }
        String[] lists = manager.getCurrentDatas().list();
        for (String list : lists)
        {
            if(list.equals(str))
            {
                mylist.add(str);
                listView.setItems(FXCollections.observableList(mylist));
                return;
            }
        }
        mylist.add("No collection found...");
        listView.setItems(FXCollections.observableList(mylist));
    }

    /**
     * Affiche le viewer
     */
    @FXML
    public void onOpen()
    {
        ((Stage)(this.getScene().getWindow())).setScene(manager.getViewer().getScene());
    }

    /**
     * Initialise (ou r&eacute;initialise) la liste des collections affich&eacute;es
     */
    public void init()
    {
        java.util.List<String> mylist = new java.util.ArrayList<String>();
        String[] lists = manager.getCurrentDatas().list();
        for(String list : lists)
        {
            mylist.add(list);
        }
        listView.setItems(FXCollections.observableList(mylist));
    }
}