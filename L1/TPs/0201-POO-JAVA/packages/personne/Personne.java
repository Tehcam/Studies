package personne;

/**
 * Classe représentant une personne.
 * @author Cyril Rabat
 * @version 18/04/2016
 */
public class Personne implements Cloneable {
    
    private String nom;
    private String prenom;
    
    /**
     * Constructeur par initialisation.
     * @param nom le nom de la personne
     * @param prenom le prénom de la personne
     */
    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personne(Personne ref)
    {
        this.nom = ref.nom;
        this.prenom = ref.prenom;
    }
    
    /**
     * Retourne le nom de la personne.
     * @return le nom de la personne
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le prénom de la personne.
     * @return le prénom de la personne
     */    
    public String getPrenom() {
        return prenom;
    }
    
    @Override
    public String toString()
    {
        return nom + " " + prenom;
    }

    @Override
    public Object clone()
    {
        try
        {
            return super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean equals(Object object)
    {
        if(!(object instanceof Personne))
            return false;
        var o = (Personne)object;
        return nom.equals(o.nom) && prenom.equals(o.prenom);
    }
}