/**
 * Classe <strong>Complexe</strong> qui impl&eacute;mente l'interface <i>IComplexe</i>.
 * @author Corentin MACHET
 * @version 1.0
 */

public class Complexe implements IComplexe, IAffiche
{
	/**
	 * Partie r&eacute;elle Re(z) du complexe courant.
	 */ 
	private double partieReelle;

	/** 
	 * Partie imaginaire Im(z) du complexe courant.
	 */
	private double partieImaginaire;

	/**
	 * Constructeur par <i>initialisation</i>.
	 * Cr&eacute;e un nombre complexe en &eacute;criture alg&eacute;brique.
	 * @param partieReelle partie r&eacute;elle Re(z)
	 * @param partieImaginaire partie imaginaire Im(z)
	 */
	public Complexe(double partieReelle, double partieImaginaire)
	{
		this.partieReelle = partieReelle;
		this.partieImaginaire = partieImaginaire;
	}

	/** 
	 * Constructeur par <i>d&eacute;faut</i>.
	 * Cr&eacute;e le nombre complexe 0.
	 */
	public Complexe()
	{
		this(0, 0);
	}

	/**
	 * Constructeur par <i>copie</i>.
	 * Cr&eacute;e un nombre complexe &eacute;gal &agrave; celui pass&eacute;
	 * en param&egrave;tre.
	 * @param ref le nombre complexe de r&eacute;f&eacute;rence.
	 */
	public Complexe(Complexe ref)
	{
		this.partieReelle = ref.partieReelle;
		this.partieImaginaire = ref.partieImaginaire;
	}

	/**
	 * Retourne la partie réelle du nombre complexe. 
	 * @return la partie réelle
	 */
	public double getPartieReelle()
	{
		return partieReelle;
	}

	/**
	 * Retourne la partie imaginaire du nombre complexe.
	 * @return la partie imaginaire
	 */
	public double getPartieImaginaire()
	{
		return partieImaginaire;
	}

	/**
	 * Modifie la partie réelle du nombre complexe. 
	 * @param partieReelle la nouvelle partie réelle 
	 */
	public void setPartieReelle(double partieReelle)
	{
		this.partieReelle = partieReelle;
	}

	/**
	 * Modifie la partie imaginaire du nombre complexe.
	 * @param partieImaginaire la nouvelle partie imaginaire 
	 */
	public void setPartieImaginaire(double partieImaginaire)
	{
		this.partieImaginaire = partieImaginaire;
	}

	/**
	 * Modifie les parties réelle et imaginaire du nombre complexe. 
	 * @param partieReelle la nouvelle partie réelle
	 * @param partieImaginaire la nouvelle partie imaginaire
	 */
	public void changerValeur(double partieReelle, double partieImaginaire)
	{
		this.partieReelle = partieReelle;
		this.partieImaginaire = partieImaginaire;
	}

	/**
	 * Renvoie le complexe sous forme de chaine de caract&egrave;res.
	 * @return le nombre complexe en chaine de caract&egrave;res.
	 */
	public String toString()
	{
		if(partieImaginaire == 0)
			return partieReelle + "";
		if(partieReelle == 0)
			return partieImaginaire + "i";
		if(partieImaginaire > 0)
			return partieReelle + " + " + partieImaginaire + "i";
		if(partieImaginaire < 0)
			return partieReelle + " " + partieImaginaire + "i";
		return "error";
	}

	/**
	 * Affiche l'objet à l'écran. 
	 */
	public void afficher()
	{
		System.out.println(this);
	}

	/**
	 * Teste l'égalité avec le nombre complexe passé en paramètre. 
	 * @param c le nombre complexe
	 * @return 'true' si les deux nombres complexes sont égaux
	 */
	public boolean egalA(Complexe c)
	{
		return (this.partieReelle == c.partieReelle && this.partieImaginaire == c.partieImaginaire);
	}

	/**
	 * Ajoute un nombre complexe. 
	 * @param r le nombre complexe 
	 */
	public void ajouter(Complexe r)
	{
		this.partieReelle += r.partieReelle;
		this.partieImaginaire += r.partieImaginaire;
	}

	public static Complexe somme(Complexe c1, Complexe c2)
	{
		Complexe c = new Complexe();
		c.setPartieReelle(c1.getPartieReelle() + c2.getPartieReelle());
		c.setPartieImaginaire(c1.getPartieImaginaire() + c2.getPartieImaginaire());
		return c;
	}
}