import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe ExMyJLabel <b>h&eacute;rite de JFrame</b> 
 * G&egrave;re le d&eacute;roulement du jeu de morpion 
 * @author Corentin MACHET
 * @version 13.03.2021
 */

public class ExMyJLabel extends JFrame
{
	// private MyJLabel label;
	/**
	 * Panel contenant l'enti&egrave;ret&eacute; des composants graphiques
	 */
	private JPanel globalPane;
	/**
	 * Penal contenant les cases du jeu
	 */
	private JPanel centralPane;
	/** 
	 * Label indiquant l'avancement du jeu
	 */
	private JLabel stateGame;
	/**
	 * Bouton de remise &agrave; zero
	 */
	private JButton reset;
	/**
	 * Compteur du nombre de tours
	 */
	private int tour = 1;
	/**
	 * Noms des joueurs
	 */
	private String j1, j2;
	/** 
	 * Controleur du jeu de morpion
	 * @see Controleur controleur
	 */
	private Controleur control = new Controleur();

	/**
	 * <i>Constructeur par initialisation </i>
	 * cr&eacute;ation du jeu
	 * @param j1 nom du joueur 1
	 * @param j2 nom du joueur 2
	 */
	public ExMyJLabel(String j1, String j2)
	{
		/*
		label = new MyJLabel();
		label.addMouseListener(new ClicDeSouris());
		getContentPane().add(label);
		*/

		this.j1 = j1;
		this.j2 = j2;
		globalPane = new JPanel();
		globalPane.setLayout(new BorderLayout());
		stateGame = new JLabel("Tour de "+j1, javax.swing.SwingConstants.CENTER);
		globalPane.add(stateGame, BorderLayout.NORTH);
		globalPane.add(new JLabel(j1), BorderLayout.WEST);
		globalPane.add(new JLabel(j2), BorderLayout.EAST);
		reset = new JButton("Reset");
		reset.addActionListener(new Reset());
		globalPane.add(reset, BorderLayout.SOUTH);

		centralPane = new JPanel();
		centralPane.setLayout(new GridLayout(3,3));
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				var lab = new MyJLabel(i, j);
				lab.addMouseListener(new ClicDeSouris());
				centralPane.add(lab);
			}
		}
		globalPane.add(centralPane);

		getContentPane().add(globalPane);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setTitle(getClass().getName() + "");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Rend tous les labels de la grille inutilisables
	 */
	private void unenableAll()
	{
		java.awt.Component[] comp = centralPane.getComponents();
		for(int i=0; i<comp.length; i++)
		{
			if(comp[i] instanceof MyJLabel)
			{
				comp[i].setEnabled(false);
			}
		}
	}

	/**
	 * Classe ClicDeSouris 
	 * G&egrave;re le MouseListener des labels de la grille
	 * @see MouseListener interface MouseListener
	 */
	private class ClicDeSouris implements MouseListener
	{
		/**
		 * G&egrave;re le clique de la souris
		 * @param e r&eacute;f&eacute;rence vers l'&eacute;v&eacute;nement
		 */
		public void mouseClicked(MouseEvent e)
		{
			/*
			System.out.println("click " + e.getButton());
			if(e.getButton() == MouseEvent.BUTTON1)
			{
				((MyJLabel)e.getSource()).dessiner(Etats.X);
			}
				
			else if(e.getButton() == MouseEvent.BUTTON3)
			{
				((MyJLabel)e.getSource()).dessiner(Etats.O);
			}
			*/

			MyJLabel ref = (MyJLabel)e.getSource();

			if(!ref.isEnabled())
				return;

			if(tour%2 != 0)
			{
				ref.dessiner(Etats.X);
				try
				{
					control.set(ref.getAbs(), ref.getOrd(), 'X');
					if(control.verify(ref.getAbs(), ref.getOrd()))
					{
						// en cas de victoire 
						unenableAll();
						stateGame.setText(j1 + " gagne !");
					}
					else if(tour > 8)
					{
						// en cas de match nul
						unenableAll();
						stateGame.setText("Match nul...");
					}
					else
					{
						// sinon la partie continue
						stateGame.setText("Tour de " + j2);
					}
				}
				catch(ArrayIndexOutOfBoundsException ev)
				{
					unenableAll();
					stateGame.setText("Une erreur est survenue dans le controleur.");
				}
			}
			else
			{
				ref.dessiner(Etats.O);
				try
				{
					control.set(ref.getAbs(), ref.getOrd(), 'O');
					if(control.verify(ref.getAbs(), ref.getOrd()))
					{
						// en cas de victoire 
						unenableAll();
						stateGame.setText(j2 + " gagne !");
					}
					else if(tour > 8)
					{
						// en cas de match nul
						unenableAll();
						stateGame.setText("Match nul...");
					}
					else
					{
						// sinon la partie continue
						stateGame.setText("Tour de " + j1);
					}
				}
				catch(ArrayIndexOutOfBoundsException ev)
				{
					unenableAll();
					stateGame.setText("Une erreur est survenue dans le controleur.");
				}
			}
			tour++;
			ref.setEnabled(false);
		}

		public void mouseEntered(MouseEvent e){/* System.out.println("enter"); */}
		public void mouseExited(MouseEvent e){/* System.out.println("exit"); */}
		public void mousePressed(MouseEvent e){/* System.out.println("press"); */}
		public void mouseReleased(MouseEvent e){/* System.out.println("release"); */}
	}

	/** 
	 * Classe Reset
	 * G&egrave;re l'&eacute;v&eacute;nemeciel du bouton reset
	 * @see ActionListener interface ActionListener
	 */
	private class Reset implements ActionListener
	{
		/**
		 * Gestion du clique du le bouton rest
		 * @param e r&eacute;f&eacute;rence vers l'&eacute;v&eacute;nement
		 */
		public void actionPerformed(ActionEvent e)
		{
			java.awt.Component[] comp = centralPane.getComponents();
			for(int i=0; i<comp.length; i++)
			{
				if(comp[i] instanceof MyJLabel)
				{
					((MyJLabel)comp[i]).dessiner(Etats.VIDE);
					((MyJLabel)comp[i]).setEnabled(true);
				}
			}
			tour = 1;
			control.reset();
			stateGame.setText("Tour de " + j1);
		}
	}

	public static void main(String[] args)
	{
		new ExMyJLabel("Joueur 1", "Joueur 2");
	}
}