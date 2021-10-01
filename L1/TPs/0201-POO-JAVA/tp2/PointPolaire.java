/**
 * Classe <strong>PointPolaire</strong> qui impl&eacute;mente <i>IPoint</i>.
 * G&egrave;re les coordonn&eacute;es polaires d'un point dans l'espace.
 * @author Corentin MACHET
 * @version 1.0
 */

public class PointPolaire implements IPoint
{
	/**
	 * Les attributs abs et teta sont respectivement la distance &agrave; l'origine
	 * et l'angle en degr&egrave;s.
	 * @see getAbs() retourne abs.
	 * @see getTeta() retourne teta.
	 */
	private double abs, teta;

	/**
	 * Constructeur par <i>initialisation</i>.
	 * Cr&eacute;e un point de coordonn&eacute;es polaire abs, teta.
	 * @param abs distance &agrave; l'origine.
	 * @param teta angle.
	 */
	public PointPolaire(double abs, double teta)
	{
		this.abs = abs;
		this.teta = convertirTeta(teta);
	}

	/**
	 * Constructeur par <i>d&eacute;faut</i>.
	 * Cr&eacute;e le point de coordonn&eacute;es polaires (0,0).
	 */
	public PointPolaire()
	{
		this(0, 0);
	}

	/**
	 * Constructeur par <i>copie</i>.
	 * Attribut au point courant les coordonn&eacute;es du point pass&eacute;
	 * en param&egrave;tre.
	 * @param ref point polaire de r&eacute;f&eacute;rence.
	 */
	public PointPolaire(PointPolaire ref)
	{
		this.abs = ref.abs;
		this.teta = ref.teta;
	}

	/**
	 * Getter de l'attribut abs.
	 * @return la valeur de la distance &agrave; l'origine du point.
	 */
	public double getAbs()
	{
		return abs;
	}

	/**
	 * Getter de l'attribut teta.
	 * @return la mesure de l'angle (Ox, OM), pour le point courant M.
	 */
	public double getTeta()
	{
		return teta;
	}

	/**
	 * Setter de l'attribut abs.
	 * @param abs nouvelle valeur d'abs pass&eacute;e en param&egrave;tre.
	 */
	public void setAbs(double abs)
	{
		this.abs = abs;
	}

	/**
	 * Setter de l'attribut teta.
	 * @param teta nouvelle valeur de teta pass&eacute;e en param&egrave;tre.
	 */
	public void setTeta(double teta)
	{
		this.teta = convertirTeta(teta);
	}

	/**
	 * Routine qui, &agrave; toute valeur de teta, renvoie son &eacute;quivalent 
	 * dans l'intervalle [0, 360].
	 * @param val un angle quelconque.
	 * @return angle dans l'intervalle [0, 360].
	 */
	private double convertirTeta(double val)
	{
		val = val%360;
		val = (val<0) ? (360+val) : val;
		return val;
	}

	/**
	 * Retourne la distance &agrave; l'origine.
	 * @see getAbs() getter de l'attribut abs.
	 * @return distance du point &agrave; l'origine.
	 */
	public double distanceALOrigine()
	{
		return abs;
	}

	/**
	 * D&eacute;place le point selon les coordonn&eacute;es cart&eacute;siennes 
	 * pass&eacute;es en param&egrave;tre.
	 * @param dx abscisse du vecteur de d&eacute;placement.
	 * @param dy ordonn&eacute;e du vecteur de d&eacute;placement.
	 */
	public void translation(double dx, double dy)
	{
		double x = this.abs * Math.cos(this.teta);
		double y = this.abs * Math.sin(this.teta);
		PointCartesien p = new PointCartesien(x, y);
		p.translation(dx, dy);
		this.abs = p.distanceALOrigine();
		this.teta = (Math.asin(p.getY()/this.abs)>=0) ? Math.acos(p.getX()/this.abs) : -Math.acos(p.getX()/this.abs);
	}

	/**
	 * Fonction de conversion en chaine de caract&egrave;res.
	 * @return les coordonn&eacute;es polaires du point sous la forme du chaine de
	 * caract&egrave;res.
	 */
	public String toString()
	{
		return "Coordonnees : (" + abs + ", " + teta + ").";
	}

	/**
	 * Fonction d'affichage : affiche &agrave; la console la valeur du toString.
	 * @see toString() conversion en chaine de caract&egrave;res.
	 */
	public void afficher()
	{
		System.out.println(this);
	}
}