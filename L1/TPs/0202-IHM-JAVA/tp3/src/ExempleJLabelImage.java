import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import java.util.ArrayList;

public class ExempleJLabelImage extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel component;
	private int hauteurMemory;
	private int largeurMemory;
	private double hauteurFenetre = 400;
	private double largeurFenetre = 700;
	private int nbPaires = 0;
	private ArrayList<Integer> list;

	private JLabelImage oldImg;
	private boolean hasOldImg = false;

	private Configuration config;

    public ExempleJLabelImage(Difficulte diff, Configuration config)
    {
		super();
		this.config = config;

		switch(diff)
		{
			case FACILE : 
				hauteurMemory = 2;
				largeurMemory = 5;
				hauteurFenetre *= 1.3;
				break;
			case MOYEN :
				hauteurMemory = 4;
				largeurMemory = 4;
				hauteurFenetre *= 1.5;
				largeurFenetre *= 1.5;
				break;
			case DIFFICILE :
				hauteurMemory = 4;
				largeurMemory = 6;
				hauteurFenetre *= 1.8;
				largeurFenetre *= 1.8;
		}
		component = new JPanel();
		component.setLayout(new java.awt.GridLayout(largeurMemory, hauteurMemory));

		list = ImageList.getRandomImageIndexes((largeurMemory * hauteurMemory / 2));
		JLabelImage[] labels = new JLabelImage[(largeurMemory * hauteurMemory)];
		ImageList.fillRandomMatrixOfLabels(list, labels);

		for(int i=0; i<(largeurMemory * hauteurMemory); i++)
		{
			labels[i].addMouseListener(new FlipImage());
			component.add(labels[i]);
		}

		/*
		try
		{
			component = new JLabelImage(cpt);
			component.addMouseListener(new FlipImage());
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			System.out.println("---------------------");
			System.out.println(e.getMessage());
			return;
		}

		suivant = new JButton("Suivant");
		suivant.addActionListener(new OnClick());
		
		getContentPane().add(suivant, java.awt.BorderLayout.SOUTH);
		*/

		getContentPane().add(component);
		setSize((int)largeurFenetre, (int)hauteurFenetre);
		setLocationRelativeTo(null);
		setTitle("Exemple de "+component.getClass().getName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
    }

	/*
	private class OnClick implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				((JLabelImage)component).setImage(cpt);
			}
			catch(RuntimeException ev)
			{
				ev.printStackTrace();
				System.out.println("---------------------");
				System.out.println(ev.getMessage());
				return;
			}
		}
	}
	*/

	private void verifiy()
	{
		try
		{
			switch(JOptionPane.showConfirmDialog(this, "Bravo ! Vous avez gagne !\nRejouer ?"))
			{
				case 0 :
					config.setVisible(true);
					this.setVisible(false);
					break;
				default:
					System.exit(0);
			}
		}
		catch (java.awt.HeadlessException ev)
		{
			System.out.println(ev.getMessage());
			System.out.println("Fin du programme...");
			System.exit(0);
		}
	}

	private class FlipImage implements MouseListener
	{
		private java.awt.Component[] allImg;

		@Override
		public void mouseClicked(MouseEvent e)
		{
			JLabelImage ref = (JLabelImage)e.getSource();
			if(!ref.isEnabled())
			{
				// si l'image n'est pas retournable alors ne rien faire
				return;
			}
			ref.flip();
			ref.setImage();
			ref.setEnabled(false);
			if(!hasOldImg)
			{
				// si l'image retournée est la premiere de la paire, 
				// alors la referencer dans oldImg uniquement
				oldImg = ref;
				hasOldImg = !hasOldImg;
			}
			else
			{
				// sinon comparer les images
				if(oldImg.egalA(ref))
				{
					oldImg.find();
					ref.find();
					nbPaires++;
					hasOldImg = !hasOldImg;
					if(nbPaires == (largeurMemory * hauteurMemory / 2))
					{
						verifiy();
					}
				}
				else
				{
					allImg = component.getComponents();
					for(int i=0; i<allImg.length; i++)
					{
						allImg[i].setEnabled(false);
					}
					var timer = new javax.swing.Timer(2000, ev ->
					{
						oldImg.flip();
						oldImg.setImage();
						ref.flip();
						ref.setImage();
						hasOldImg = !hasOldImg;
						for (int i = 0; i < allImg.length; i++)
						{
							if(!((JLabelImage)allImg[i]).isFound())
								allImg[i].setEnabled(true);
						}
					});
					timer.setRepeats(false);
					timer.start();
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
