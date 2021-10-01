package personne;

/**
 * Classe représentant un enseignant.
 * @author Cyril Rabat
 * @version 18/04/2016
 */
public class Enseignant extends Personne implements Cloneable {
    
    private double salaire;
    
    /**
     * Constructeur par initialisation.
     * @param nom le nom de l'enseignant
     * @param prenom le prénom de l'enseignant
     * @param salaire le salaire de l'enseignant
     */
    public Enseignant(String nom, String prenom, double salaire) {
        super(nom, prenom);
        this.salaire = salaire;
    }

    public Enseignant(Enseignant ref)
    {
        super(ref);
        this.salaire = ref.salaire;
    }
   
    /**
     * Retourne le salaire de l'enseignant
     * @return le salaire de l'enseignant
     */
    public double getSalaire() {
        return salaire;
    } 
 
    @Override
    public String toString()
    {
        return getClass().getName() + " : " + super.toString() + ", salaire " + salaire + "eur";
    }

    @Override
    public Object clone()
    {
        return super.clone();
    }
}