package collections_editor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;

/**
 * Loader de la frame Selector<br>
 * Cette frame s&eacute;lectionne la collection courante que l'&eacute;diteur permet ensuite de modifier
 * @author Corentin Machet
 * @version 2021.05.02
 */
public class Selector extends JFrame
{
    /**
     * R&eacute;f&eacute;rence du panneau global de la frame
     */
    private JPanel globalPane;

    /**
     * R&eacute;f&eacute;rence du bouton 'Edit'
     */
    private javax.swing.JButton button;

    /**
     * R&eacute;f&eacute;rence du panneau affichant dynamiquement les noms des collections qu'il est possible de s&eacute;lectionner
     */
    private JScrollPane listScroller;

    /**
     * Liste des collections affich&eacute;es dynamiquement dans 'listScroller'
     */
    private JList<String> collectionsName;

    /**
     * R&eacute;f&eacute;rence du label affichant le nom de la collection actuellement s&eacute;lectionn&eacute;e
     */
    private JLabel state;

    /**
     * R&eacute;f&eacute;rence de l'item 'Close' de la barre de menu
     */
    private JMenuItem close;

    /**
     * R&eacute;f&eacute;rence de l'item 'Fetch Edits' de la barre de menu
     */
    private JMenuItem fetch;

    /**
     * R&eacute;f&eacute;rence de la frame de l'&eacute;diteur
     */
    private EditorLoader editor;

    /**
     * R&eacute;f&eacute;rence du manager de cette interface
     */
    private EditorManager manager;

    /**
     * Constructeur par d&eacute;faut
     * @param editor l'&eacute;diteur
     * @param manager le manager
     * @throws NullPointerException si editor est null
     */
    public Selector(EditorLoader editor, EditorManager manager) throws NullPointerException
    {
        super();
        if(editor == null)
            throw new NullPointerException();
        this.editor = editor;
        editor.setSelector(this);
        this.manager = manager;

        // construction du panneau global
        globalPane = new JPanel();
        globalPane.setLayout(new javax.swing.BoxLayout(globalPane, javax.swing.BoxLayout.PAGE_AXIS));

        listScroller = new JScrollPane();
        init();
        listScroller.setPreferredSize(new java.awt.Dimension(250, 100));
        listScroller.setAlignmentX(LEFT_ALIGNMENT);
        globalPane.add(new JLabel("Choose a collection :", javax.swing.SwingConstants.CENTER));
        globalPane.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 5)));
        globalPane.add(listScroller);
        state = new JLabel("No collection selected", javax.swing.SwingConstants.CENTER);
        globalPane.add(state);
        globalPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // construction du bouton 'Edit'
        button = new javax.swing.JButton("Edit");
        button.setEnabled(false);
        button.addActionListener(new ChangeWindow());

        // construction de la barre de menu
        JMenuBar menuBar = new JMenuBar();
        close = new JMenuItem("Close");
        close.addActionListener(new OnClose());
        fetch = new JMenuItem("Fetch Edits");
        fetch.addActionListener(new OnFetch());
        JMenu menu = new JMenu("File");
        menu.add(fetch);
        menu.add(close);
        menuBar.add(menu);
        
        // construction de la fenetre
        getContentPane().add(menuBar, java.awt.BorderLayout.NORTH);
        getContentPane().add(button, java.awt.BorderLayout.SOUTH);
        getContentPane().add(globalPane);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setTitle("PicManager - Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Initialise la liste des noms de collection et les affiche dynamiquement
     */
    public void init()
    {
        if (manager.getNbCollections() == 0)
        {
            String[] img = {"No collection found..."};
            collectionsName = new JList<String>(img);
        }
        else
        {
            collectionsName = new JList<String>(manager.getList());
            collectionsName.addMouseListener(new Selection());
        }
        if(listScroller != null)
            listScroller.getViewport().setView(collectionsName);
    }

    /**
     * Affiche l'&eacute;diteur
     */
    private void changeWindow()
    {
        editor.init();
        editor.setVisible(true);
        this.setVisible(false);
    }

    /**
     * Listener on close<br> s'execute lorsque l'utilisateur clique sur l'item 'close'
     */
    private class OnClose implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }

    /**
     * Listener on fetch<br> s'execute lorsque l'utilisateur clique sur l'item 'fetch'
     */
    private class OnFetch implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            manager.fetchSerialDatas();
            init();
            globalPane.repaint();
        }
    }

    /**
     * Listener on change window<br> s'execute lorsque l'utilisateur clique sur le bouton 'Edit'
     */
    private class ChangeWindow implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            changeWindow();
        }
    }

    /**
     * Listener selection<br> s'execute lorsque l'utilisateur clique sur un &eacute;l&eacute;ment de la liste de noms de collections
     */
    private class Selection implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if(e.getSource() == collectionsName)
            {
                String item = collectionsName.getSelectedValue();
                if(item == null || item.equals(""))
                return;
                manager.setCurrentCollection(item);
                state.setText(item);
                button.setEnabled(true);
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
    }
}