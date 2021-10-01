/**
  * Classe <strong>PointCartesien</strong>, impl&eacute;mente l'interface IPoint.
  * Elle g&egrave;re les coordonn&eacute;es cart&eacute;siennes d'un point dans l'espace.
  * @author Corentin Machet
  * @version 1.0
  */

public class PointCartesien implements IPoint
{
	/**
	  * Les attributs x et y sont respectivement l'abscisse et l'ordonn&eacute;e du point.
	  * @see getX()
	  * @see getY()
	  */
	private double x, y;

	/**
	  * Constructeur <i>par initialisation</i>.
	  * Les param&egrave;tres sont des r&eacute;els quelconques.
	  * @param x Abscisse.
	  * @param y Ordonn&eacute;.
	  */
	public PointCartesien(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	  * Constructeur <i>par d&eacute;faut</i>.
	  * Le point est automatiquement initialis&eacute; &agrave; (0,0).
	  */
	public PointCartesien()
	{
		this(0, 0);
	}

	/**
	  * Constructeur <i>par copie</i>.
	  * Les coordonn&eacute;es du point pass&eacute; en param&egrave;tre sont copi&eacute;es dans l'objet courant.
	  * @param ref Point &agrave; copier.
	  */
	public PointCartesien(PointCartesien ref)
	{
		this.x = ref.x;
		this.y = ref.y;
	}

	/**
	  * Getter. 
	  * @return x : l'abscisse du point courant.
	  */
	public double getX()
	{
		return x;
	}

	/**
	  * Getter.
	  * @return y : l'ordonn&eacute;e du point courant.
	  */
	public double getY()
	{
		return y;
	}

	/**
	  * Setter. Modifie la valeur de l'abscisse.
	  * @param x Nouvelle valeur de l'abscisse.
	  */
	public void setX(double x)
	{
		this.x = x;
	}

	/**
	  * Setter. Modifie la valeur de l'ordonn&eacute;e.
	  * @param y Nouvelle valeur de l'ordonn&eacute;e.
	  */
	public void setY(double y)
	{
		this.y = y;
	}

	/**
	  * Calcule la distance entre l'origine et le point courant.
	  * @return distance &agrave; l'origine.
	  */
	public double distanceALOrigine()
	{
		return (Math.sqrt(x*x + y*y));
	}

	/**
	  * D&eacute;place le point courant dans le rep&egrave;re selon les coordonn&eacute;es vectorielles
	  * pass&eacute;es en param&egrave;tre.
	  * @param dx Abscisse vectorielle.
	  * @param dy Ordonn&eacute;e vectorielle.
	  */
	public void translation(double dx, double dy)
	{
		this.x += dx;
		this.y += dy;
	}

	/**
	  * Descriptif du point courant.
	  * @return Coordonn&eacute;es du point.
	  */
	public String toString()
	{
		return "Coordonnees : (" + x + ", " + y + ").";
	}

	/**
	  * Affiche &agrave; l'&eacute;cran le retour de la description.
	  * @see toString()
	  */
	public void afficher()
	{
		System.out.println(this);
	}
}