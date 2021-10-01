package collections_editor;

import collections.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.JOptionPane;

import java.io.File;
import java.util.ArrayList;

/**
 * Loader de la frame principale de l'application collections_editor
 * @author Corentin Machet
 * @version 2021.05.02
 */
public class EditorLoader extends JFrame
{
    /**
     * R&eacute;f&eacute;rence du panneau principal de la frame
     */
    private JPanel globalPane;

    /**
     * R&eacute;f&eacute;rence du label affichant le nom de la collection s&eacute;lectionn&eacute;e
     */
    private JLabel currentCollectionName;

    /**
     * R&eacute;f&eacute;rence de la barre de menu
     */
    private JMenuBar menuBar;

    /**
     * R&eacute;f&eacute;rence de l'item 'Puh Edits' de la barre de menu
     * @see OnPushEdits listener on push edits
     */
    private JMenuItem push;

    /**
     * R&eacute;f&eacute;rence de l'item 'Remove collection' de la barre de menu
     * @see OnRemove listener on remove
     */
    private JMenuItem remove;

    /**
     * R&eacute;f&eacute;rence de l'item 'Rename collection' de la barre de menu
     * @see OnRename listener on rename
     */
    private JMenuItem rename;

    /**
     * R&eacute;f&eacute;rence de l'item 'About this Collection' de la barre de menu
     * @see ShowCollectionInformations listener on show collection informations
     */
    private JMenuItem aboutCollection;

    /**
     * R&eacute;f&eacute;rence de l'item 'Reset Collection' de la barre de menu
     * @see OnReset listener on reset
     */
    private JMenuItem reset;

    /**
     * R&eacute;f&eacute;rence du bouton 'Import files'
     * @see OnImportFile listener on import file
     */
    private JButton fileButton;

    /**
     * R&eacute;f&eacute;rence du bouton 'Import folder'
     * @see OnImportFolder listener on import folder
     */
    private JButton folderButton;

    /**
     * R&eacute;f&eacute;rence de la liste d'&eacute;l&eacute;ments contenus dans la collection s&eacute;lectionn&eacute;e<br>
     * Cette liste est affich&eacute;e dynamiquement en fonction des &eacute;l&eacute;ments trouv&eacute;s
     */
    private JScrollPane listScroller;

    /**
     * Liste des noms d'&eacute;l&eacute;ments contenus dans la collections affich&eacute;s dynamiquement dans listScroller
     */
    private javax.swing.JList<String> imagesName;

    /**
     * R&eacute;f&eacute;rence vers l'objet Selector
     * @see Selector selector
     */
    private Selector selector;

    /**
     * R&eacute;f&eacute;rence vers le manager de cette interface
     * @see EditorManager manager
     */
    private EditorManager manager;

    /**
     * Nouvelle collection concerv&eacute;e en m&eacute;moire avec toutes les modifications faites par l'utilisateur<br>
     * Les modifications sur cette collection temporaire sont ensuite push d&eacute;finitivement sur la collection originale
     */
    private static Collections commit = new Collections();

    /**
     * Constructeur de la frame
     * @param manager le manager de l'interface
     */
    public EditorLoader(EditorManager manager)
    {
        super();
        this.manager = manager;

        // création des boutons Import File et Import Folder
        var buttonPane = new JPanel();
        buttonPane.setLayout(new javax.swing.BoxLayout(buttonPane, javax.swing.BoxLayout.LINE_AXIS));
        buttonPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPane.add(javax.swing.Box.createHorizontalGlue());
        fileButton = new JButton("Import File");
        fileButton.addActionListener(new OnImportFile());
        buttonPane.add(fileButton);
        buttonPane.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(10, 0)));
        folderButton = new JButton("Import Folder");
        folderButton.addActionListener(new OnImportFolder());
        buttonPane.add(folderButton);
        
        //création du panneau global
        globalPane = new JPanel();
        globalPane.setLayout(new javax.swing.BoxLayout(globalPane, javax.swing.BoxLayout.PAGE_AXIS));
        listScroller = new JScrollPane();
        init();
        listScroller.setPreferredSize(new java.awt.Dimension(250, 100));
        listScroller.setAlignmentX(LEFT_ALIGNMENT);
        currentCollectionName = new JLabel("", javax.swing.SwingConstants.CENTER);
        globalPane.add(currentCollectionName);
        globalPane.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 5)));
        globalPane.add(listScroller);
        globalPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 15, 15, 15));

        // creation du menu
        menuBar = new JMenuBar();
        push = new JMenuItem("Push Edits");
        push.addActionListener(new OnPushEdits());
        remove = new JMenuItem("Remove Collection");
        remove.addActionListener(new OnRemove());
        rename = new JMenuItem("Rename Collection");
        rename.addActionListener(new OnRename());
        var file = new JMenu("File");
        file.add(push);
        file.add(remove);
        file.add(rename);
        menuBar.add(file);
        aboutCollection = new JMenuItem("About this collection");
        aboutCollection.addActionListener(new ShowCollectionInformations());
        reset = new JMenuItem("Reset Collection");
        reset.addActionListener(new OnReset());
        var collection = new JMenu("Collection");
        collection.add(aboutCollection);
        collection.add(reset);
        menuBar.add(collection);
        
        // creation de la fenetre
        getContentPane().add(menuBar, BorderLayout.NORTH);
        getContentPane().add(globalPane);
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        setSize(400, 450);
        setLocationRelativeTo(null);
        setTitle("PicManager - Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
    }

    /**
     * Initialise la liste d'&eacute;l&eacute;ments et l'affiche dynamiquement
     */
    public void init()
    {
        if(manager.getCurrentCollection() != null)
        {
            currentCollectionName.setText(manager.getCurrentCollection().getName());
            commit.deleteAll();
            String[] img = new String[manager.getCurrentCollection().getImages().size()];
            for(int i=0; i<img.length; i++)
            {
                img[i] = manager.getCurrentCollection().getImages().get(i);
                commit.add(img[i]);
            }
            imagesName = new javax.swing.JList<String>(img);
            imagesName.addMouseListener(new Selection());
            if (listScroller != null)
                listScroller.getViewport().setView(imagesName);
        }
    }

    /**
     * Actualise la liste initialis&eacute;e par la m&eacute;thode init()
     * @see init() init
     */
    private void actualize()
    {
        String[] img = new String[commit.getImages().size()];
        for(int i=0; i<img.length; i++)
        {
            img[i] = commit.getImages().get(i);
        }
        imagesName = new javax.swing.JList<String>(img);
        imagesName.addMouseListener(new Selection());
        if(listScroller != null)
            listScroller.getViewport().setView(imagesName);
        globalPane.repaint();
    }

    /**
     * R&eacute;f&eacute;rence le selector associ&eacute;
     * @param selector le selecteur
     */
    public void setSelector(Selector selector)
    {
        this.selector = selector;
    }

    /**
     * Routine qui envoie les modifications faites par l'utilisateur et rend de nouveau visible le selecteur
     */
    private void changeWindow()
    {
        pushEdits();
        selector.init();
        selector.setVisible(true);
        this.setVisible(false);
    }

    /**
     * Routine charg&eacute;e d'envoyer les modifications faites par l'utilisateur<br>
     * Cette m&eacute;thode est notamment appel&eacute;e par changeWindow()
     * @see changeWindow() afficher le selecteur
     */
    private void pushEdits()
    {
        manager.getCurrentCollection().deleteAll();
        for(String c : commit.getImages())
        {
            manager.getCurrentCollection().add(c);
        }
        try
        {
            Collections tmp = manager.getCurrentDatas().delete(manager.getCurrentCollection().getName());
            tmp.setName(currentCollectionName.getText());
            manager.getCurrentDatas().add(tmp);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "An error occurred so that the specified action might failed.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        manager.pushSerialDatas();
    }

    /**
     * Listener on push edits<br> s'execute lorsque l'utilisateur clique sur l'item 'push'
     */
    private class OnPushEdits implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            changeWindow();
        }
    }

    /**
     * Listener on remove<br> s'execute lorsque l'utilisateur clique sur l'item 'remove'
     */
    private class OnRemove implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int val = JOptionPane.showConfirmDialog(EditorLoader.this,
                    "You just clicked on the 'remove' button. This will delete the whole collection and its content. Do you want to continue ?");
            if (val == JOptionPane.YES_OPTION)
            {
                try
                {
                    manager.getCurrentDatas().delete(manager.getCurrentCollection().getName());
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred so that the specified collection could not be deleted successfully.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                finally
                {
                    manager.pushSerialDatas();
                    selector.init();
                    selector.setVisible(true);
                    EditorLoader.this.setVisible(false);
                }
            }
        }
    }

    /**
     * Listener on rename<br> s'execute lorsque l'utilisateur clique sur l'item 'rename'
     */
    private class OnRename implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String str = JOptionPane.showInputDialog(EditorLoader.this, "Enter the new name :", "Rename", JOptionPane.QUESTION_MESSAGE);
            if(str != null)
            {
                currentCollectionName.setText(str);
            }
        }
    }

    /**
     * Listener on show collection informations<br> s'execute lorsque l'utilisateur clique sur l'item 'aboutCollection'
     */
    private class ShowCollectionInformations implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(EditorLoader.this, 
                "Collection: " + currentCollectionName.getText() + "\nImages: " + manager.getCurrentCollection().getImages().size(), 
                "Informations", 
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    /**
     * Listener on reset<br> s'execute lorsque l'utilisateur clique sur l'item 'reset'
     */
    private class OnReset implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int val = JOptionPane.showConfirmDialog(EditorLoader.this,
                "You just clicked on the 'reset' button. This will delete all current images saved in the collection. Do you want to continue ?");
            if(val == JOptionPane.YES_OPTION)
            {
                commit.deleteAll();
                changeWindow();
            }
        }
    }

    /**
     * File filter : s&eacute;lectionne uniquement les fichiers JPG JPEG et PNG, ainsi que les dossiers
     */
    private class MyFileFilter extends FileFilter
    {
        @Override
        public boolean accept(File f)
        {
            if(f.isDirectory())
            {
                return true;
            }
            if(f.isFile())
            {
                String str = f.getAbsolutePath();
                String[] extensions = { ".jpg", ".jpeg", ".png" };
                for (String extension : extensions)
                {
                    if (str.endsWith(extension))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public String getDescription()
        {
            return null;
        }
    }

    /**
     * Listener on import file<br> s'execute lorsque l'utilisateur clique sur le bouton 'fileButton'
     */
    private class OnImportFile implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser fc = new JFileChooser();
            fc.addChoosableFileFilter(new MyFileFilter());
            fc.setAcceptAllFileFilterUsed(false);
            fc.setCurrentDirectory(new File(File.separator));
            fc.setDialogTitle("Choose an image");
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.setMultiSelectionEnabled(false);
            int val = fc.showOpenDialog(EditorLoader.this);
            if(val == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                if( !file.isFile() || !commit.add(file.getAbsolutePath()) )
                {
                    JOptionPane.showMessageDialog(EditorLoader.this,
                            "The selected file cannot be added to the current collection.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                actualize();
            }
        }
    }

    /**
     * File filter : s&eacute;lectionne uniquement les dossiers
     */
    private class MyFolderFilter extends FileFilter
    {
        @Override
        public boolean accept(File f)
        {
            if(f.isDirectory())
                return true;
            return false;
        }

        @Override
        public String getDescription()
        {
            return null;
        }
    }

    /**
     * Listener on import folder<br> s'execute lorsque l'utilisateur clique sur le bouton 'folderButton'
     */
    private class OnImportFolder implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser fc = new JFileChooser();
            fc.addChoosableFileFilter(new MyFolderFilter());
            fc.setAcceptAllFileFilterUsed(false);
            fc.setCurrentDirectory(new File(File.separator));
            fc.setDialogTitle("Choose a folder");
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fc.setMultiSelectionEnabled(false);
            int val = fc.showOpenDialog(EditorLoader.this);
            if(val == JFileChooser.APPROVE_OPTION)
            {
                File dir = fc.getSelectedFile();
                if(!dir.isDirectory())
                {
                    JOptionPane.showMessageDialog(EditorLoader.this,
                            "The selection is not a directory.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                String[] files = dir.list();
                for(String file : files)
                {
                    var f = new File(dir.getAbsolutePath() + File.separator + file);
                    if(f.isFile())
                    {
                        commit.add(f.getAbsolutePath());
                    }
                }
            }
            actualize();
        }
    }

    /**
     * Listener selection<br> s'execute lorsqu'un &eacute;l&eacute;ment du listScroller est cliqu&eacute;
     */
    private class Selection implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if(e.getSource() == imagesName)
            {
                String str = imagesName.getSelectedValue();
                String[] options = {"Edit selection", "Delete from collection", "Cancel"};
                JOptionPane op = new JOptionPane("Warning: by editing collection's values, PicManager might not be able to find out specified pictures.");
                op.setInputValue(str);
                op.setOptions(options);
                op.createDialog(null, "Choose what you want to do :").setVisible(true);
                if(op.getValue().equals("Edit selection"))
                {
                    commit.getImages().remove(str);
                    (new OnImportFile()).actionPerformed(null);
                }
                else if(op.getValue().equals("Delete from collection"))
                {
                    commit.getImages().remove(str);
                    actualize();
                }
                else
                {
                    return;
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e){}
        @Override
        public void mouseExited(MouseEvent e){}
        @Override
        public void mousePressed(MouseEvent e){}
        @Override
        public void mouseReleased(MouseEvent e){}
    }
}