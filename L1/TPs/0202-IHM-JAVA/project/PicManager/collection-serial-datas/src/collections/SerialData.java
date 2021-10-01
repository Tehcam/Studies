package collections;

import java.util.HashMap;
import java.util.Set;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * L'instance de <b>SerialData</b> est l'objet de la s&eacute;rialisation entre les deux interfaces IHM de l'application <br>
 * Elle regroupe les informations n&eacute;cessaire &agrave; etre s&eacute;rialis&eacute; pour la bonne communication entre le creator et l'editor
 * @author Corentin Machet
 * @version 2021.04.26
 */
public class SerialData implements java.io.Serializable
{
    /**
     * Ensemble des collections
     */
    private HashMap<String, Collections> mycollections;

    /**
     * Time stamp auquel la derni&egrave;re &eacute;dition a &eacute;t&eacute; r&eacute;alis&eacute;e
     */
    private Timestamp lastEdit;

    /**
     * Valeur de controle de la s&eacute;rialisation
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructeur
     */
    public SerialData()
    {
        mycollections = new HashMap<String, Collections>();
        lastEdit = Timestamp.from(Instant.now());
    }

    /**
     * Ajout d'une nouvelle collection
     * @param c nouvelle collection
     * @throws Exception si cette nouvelle collection existe d&eacute;j&agrave;
     */
    public void add(Collections c) throws Exception
    {
        if(mycollections.containsKey(c.getName()))
            throw new Exception("Le nom de cette collection existe deja.");
        mycollections.put(c.getName(), c);
    }

    /**
     * Retourne la collection associ&eacute; &agrave; <i>name</i>. Retourne null sinon
     * @param name nom de la collection
     * @return la collection
     */
    public Collections get(String name)
    {
        return mycollections.get(name);
    }

    /**
     * Retourne l'ensemble des noms de collections contenues dans l'ensemble sous la forme d'un tableau de chaine de caract&egrave;res
     * @return l'ensemble des noms des collections
     */
    public String[] list()
    {
        String[] list = new String[mycollections.size()];
        Set<String> keys = mycollections.keySet();
        int i=0;
        try
        {
            for(String key : keys)
            {
                list[i] = key;
                i++;
            }
        }
        catch(ArrayIndexOutOfBoundsException iobe)
        {
            return null;
        }
        return list;
    }

    /**
     * Supprime la collection associ&eacute;e
     * @param name le nom de la collection &agrave; supprimer
     * @throws Exception si la collection en question n'existe pas
     * @return la collection supprim&eacute;e
     */
    public Collections delete(String name) throws Exception
    {
        if( !mycollections.containsKey(name) )
            throw new Exception("Cette collection n'existe pas.");
        return mycollections.remove(name);
    }

    /**
     * Retourne le time stamp auquel l'instance a &eacute;t&eacute; s&eacute;rialis&eacute; pour la derni&egrave;re fois
     * @return le time stamp de la derni&egrave;re s&eacute;rialisation
     */
    public Timestamp getLastEdit()
    {
        return lastEdit;
    }

    /**
     * Actualise le time stamp &agrave; l'instant pr&eacute;sent
     */
    public void setLastEdit()
    {
        lastEdit = Timestamp.from(Instant.now());
    }
}