package collections;

import java.util.ArrayList;
import java.io.File;

/**
 * Classe <b>Colletions</b> permet de cr&eacute;er des ensembles d'images en concervant uniquement les chemins vers celles-ci.
 * @author Corentin Machet
 * @version 2021.04.26
 */
public class Collections implements java.io.Serializable
{
    /**
     * Nom de la collection
     */
    private String name;

    /**
     * Liste de path vers les images de la collections
     */
    private ArrayList<String> images;

    /**
     * Valeur de controle de la s&eacute;rialisation
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructeur
     */
    public Collections()
    {
        name = "Nouvelle Collection";
        images = new ArrayList<String>();
    }

    /**
     * Retourne tous les paths des images gard&eacute;es en m&eacute;moire
     * @return liste des paths
     */
    public ArrayList<String> getImages()
    {
        return images;
    }

    /**
     * Retourne le nom de la collection
     * @return nom de la collection
     */
    public String getName()
    {
        return name;
    }

    /**
     * Edite le nom de la collection
     * @param str le nouveau nom de la collection
     */
    public void setName(String str)
    {
        name = str;
    }

    /**
     * Ajout d'un nouveau path &agrave; la liste
     * @param path le chemin &agrave; ajouter vers la nouvelle image
     * @return true si l'ajout ne rencontre pas d'erreur, false sinon
     */
    public boolean add(String path)
    {
        File f = new File(path);
        if(f.exists() && f.isFile())
        {
            String[] extensions = {".jpg", ".jpeg", ".png"};
            for(String extension : extensions)
            {
                if(path.endsWith(extension))
                {
                    images.add(path);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Ajout des path de toutes les images contenues dans le dossier dont le chemin est pass&eacute; en param&egrave;tre
     * @param path chemin vers le dossier contenant les images 
     * @return true si l'ajout ne rencontre pas d'erreur, false sinon
     */
    public boolean addAll(String path)
    {
        File f = new File(path);
        if(f.exists() && f.isDirectory())
        {
            String[] files = f.list();
            String[] extensions = { ".jpg", ".jpeg", ".png" };
            for(String file : files)
            {
                if( (new File(file)).isFile() )
                {
                    for(String extension : extensions)
                    {
                        if(file.endsWith(extension))
                        {
                            images.add(file);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Supprime une image de la collection
     * @param index l'indice de l'image &agrave; supprimer
     * @return true si la suppression ne rencontre pas d'erreur, false sinon
     */
    public boolean delete(int index)
    {
        try
        {
            images.remove(index);
            return true;
        }
        catch(ArrayIndexOutOfBoundsException iobe)
        {
            return false;
        }
    }

    /**
     * Supprime toutes les images de la collection
     */
    public void deleteAll()
    {
        images.clear();
    }
}