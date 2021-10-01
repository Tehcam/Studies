import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Classe MyJLabel <b>h&eacute;rite de JLabel</b>
 * Label permettant de dessiner une croix ou un rond selon la valeur de son attribut d'Etat.
 * @author Corentin MACHET
 * @version 13.03.2021
 */

public class MyJLabel extends JLabel
{
	/**
	 * Etat courant du label
	 */
	private Etats currentstate;

	/**
	 * Abscisse du label dans la grille
	 */
	private int x;

	/**
	 * Ordonn&eacute;e du label dans la grille
	 */
	private int y;

	/**
	 * <i>Contructeur par initialisation </i>affecte des valeurs &agrave; l'abscisse et l'ordonn&eacute;e, initialise l'&eacute;tat courant &agrave; VIDE et affiche des bordures au label.
	 * @param x abscisse pass&eacute;e en param&egrave;tre
	 * @param y ordonn&eacute;e pass&eacute;e en param&egrave;tre
	 */
	public MyJLabel(int x, int y)
	{
		super();
		// setHorizontalAlignment(JLabel.CENTER);
		setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
		currentstate = Etats.VIDE;
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter de x
	 * @return la valeur de l'abscisse
	 */
	public int getAbs()
	{
		return x;
	}

	/** 
	 * Getter de y
	 * @return la valeur de l'ordonn&eacute;e
	 */
	public int getOrd()
	{
		return y;
	}

	/** 
	 * Dessine le contenu du label
	 * @param g le contenu du label 
	 */
	@Override
	public void paint(Graphics g)
	{
		int l = (int)getSize().getWidth();
		int h = (int)getSize().getHeight();

		if(currentstate == Etats.X)
		{
			g.setColor(Color.RED);
			g.drawLine(10, 10, l-10, h-10);
			g.drawLine(l-10, 10, 10, h-10);
		}
		if(currentstate == Etats.O)
		{
			g.setColor(Color.BLUE);
			g.drawOval(10, 10, l-20, h-20);
		}
		if(currentstate == Etats.VIDE)
		{
			g.setColor(Color.GRAY);
			g.fillRect(10, 10, l-20, h-20);
		}
		super.paint(g);
	}

	/** 
	 * Actualise l'&eacute;tat courant pass&eacute; en param&egrave;tre puis appelle repaint()
	 * @param e Nouvel &eacute;tat du label
	 * @see repaint() appel forc&eacute; &agrave; paint()
	 */
	public void dessiner(Etats e)
	{
		currentstate = e;
		repaint();
	}
}