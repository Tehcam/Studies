package collections_editor;

/**
 * Classe Main de l'application collections_editor
 * @author Corentin Machet
 * @version 2021.05.01
 */
public class StartEditor
{
    /**
     * R&eacute;f&eacute;rence de la frame Editor
     * @see EditorLoader l'&eacute;diteur
     */
    private static EditorLoader editor;

    /**
     * R&eacute;f&eacute;rence de la frame Selector
     * @see Selector le selecteur
     */
    private static Selector selector;

    /**
     * Manager de l'application collections_editor
     * @see EditorManager le manager
     */
    private static EditorManager manager = new EditorManager();

    /**
     * Lance l'application en cr&eacute;ant les frames de l'&eacute;diteur et du s&eacute;lecteur
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args)
    {
        try
        {
            editor = new EditorLoader(manager);
            selector = new Selector(editor, manager);
        }
        catch(NullPointerException npe)
        {
            npe.printStackTrace();
            System.exit(0);
        }
    }
}