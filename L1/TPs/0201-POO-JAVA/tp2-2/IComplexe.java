/**
 * Interface <b>IComplexe</b> qui doit être implémentée par la classe <b>Complexe</b>.
 * @author Cyril Rabat
 * @author Jessica Jonquet
 * @version 28/01/2021
 */
public interface IComplexe {
	/**
	 * Retourne la partie réelle du nombre complexe. 
	 * @return la partie réelle
	 */
	public double getPartieReelle();
	/**
	 * Retourne la partie imaginaire du nombre complexe.
	 * @return la partie imaginaire
	 */
	public double getPartieImaginaire();
	/**
	 * Modifie la partie réelle du nombre complexe. 
	 * @param partieReelle la nouvelle partie réelle 
	 */
	public void setPartieReelle(double partieReelle);
	/**
	 * Modifie la partie imaginaire du nombre complexe.
	 * @param partieImaginaire la nouvelle partie imaginaire 
	 */
	public void setPartieImaginaire(double partieImaginaire);
	/**
	 * Modifie les parties réelle et imaginaire du nombre complexe. 
	 * @param partieReelle la nouvelle partie réelle
	 * @param partieImaginaire la nouvelle partie imaginaire
	 */
	public void changerValeur(double partieReelle, double partieImaginaire);
	/**
	 * Affiche l'objet à l'écran. 
	 */
	public void afficher();
	/**
	 * Teste l'égalité avec le nombre complexe passé en paramètre. 
	 * @param c le nombre complexe
	 * @return 'true' si les deux nombres complexes sont égaux
	 */
	public boolean egalA(Complexe c);
	/**
	 * Ajoute un nombre complexe. 
	 * @param r le nombre complexe 
	 */
	public void ajouter(Complexe r);
}