package collections_creator;

import collections.*;
import javax.swing.JOptionPane;

/**
 * Manager de l'application collections_creator
 * @author Corentin Machet
 * @version 2021.05.01
 */
public class CreatorManager extends MyManager
{
    /**
     * Ensemble des nouvelles collections en m&eacute;moire pretes &agrave; etre s&eacute;rialis&eacute;es
     */
    private java.util.ArrayList<Collections> commit = new java.util.ArrayList<Collections>();

    /**
     * R&eacute;f&eacute;rence vers le controleur de creator.fxml
     */
    private Controller controller;

    /**
     * R&eacute;f&eacute;rence vers le controleur de viewer.fxml
     */
    private Viewer viewer;

    /**
     * Construteur par d&eacute;faut
     */
    public CreatorManager()
    {
        super();
    }

    /**
     * R&eacute;f&eacute;rence l'objet controller
     * @see controller controleur de creator.fxml
     * @param control l'instance du controleur
     */
    public void setController(Controller control)
    {
        controller = control;
    }

    /**
     * Retourne l'instance du controleur de creator.fxml
     * @return l'instance de controller
     */
    public Controller getController()
    {
        return controller;
    }

    /**
     * R&eacute;f&eacute;rence l'objet viewer
     * @see viewer controleur de viewer.fxml
     * @param control l'instance du controleur
     */
    public void setViewer(Viewer control)
    {
        viewer = control;
    }

    /**
     * Retourne l'instance du controleur de viewer.fxml
     * @return l'instance de viewer
     */
    public Viewer getViewer()
    {
        return viewer;
    }

    /**
     * Ajoute une nouvelle collection &agrave; la liste des commits
     * @param c la nouvelle collection
     */
    public void addToCommit(Collections c)
    {
        commit.add(c);
    }

    /**
     * S&eacute;rialise les collections gard&eacute;es en m&eacute;moire dans la liste des commits
     */
    public void pushCommit()
    {
        fetchSerialDatas();
        for(Collections c : commit)
        {
            try
            {
                getCurrentDatas().add(c);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Cannot commit '" + c.getName() + "' because this collection already exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        pushSerialDatas();
        commit.clear();
    }
}