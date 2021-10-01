package collections_editor;

import collections.*;

/**
 * Manager de l'interface swing collections_creator
 * @author Corentin Machet
 * @version 2021.05.02
 */
public class EditorManager extends MyManager
{
    /**
     * Liste des noms des collections contenues dans les serial datas
     */
    private String[] list;

    /**
     * R&eacute;f&eacute;rence de la collection s&eacute;lectionn&eacute;e
     */
    private Collections currentCollection;

    /**
     * Constructeur par d&eacute;faut
     */
    public EditorManager()
    {
        super();
        actualizeList();
    }

    /**
     * R&eacute;ccup&egrave;re les noms des collections et les r&eacute;f&eacute;rence dans 'list'
     */
    public void actualizeList()
    {
        this.list = getCurrentDatas().list();
    }

    /**
     * Retourne le nombre de noms contenus dans 'list'
     * @return le nombre de noms
     */
    public int getNbCollections()
    {
        actualizeList();
        if(list == null)
            return 0;
        else
            return list.length;
    }

    /**
     * Retourne la liste de noms des collections
     * @return la liste des noms des collections
     */
    public String[] getList()
    {
        actualizeList();
        return list;
    }

    /**
     * Changer la collection actuellement s&eacute;lectionn&eacute;e
     * @param name le nom de la nouvelle collection courante
     */
    public void setCurrentCollection(String name)
    {
        currentCollection = getCurrentDatas().get(name);
    }

    /**
     * Retourne la collection s&eacute;lectionn&eacute;e
     * @return la collection s&eacute;lectionn&eacute;e
     */
    public Collections getCurrentCollection()
    {
        return currentCollection;
    }
}