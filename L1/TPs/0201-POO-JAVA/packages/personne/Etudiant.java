package personne;

/**
 * Classe représentant un étudiant.
 * @author Cyril Rabat
 * @version 18/04/2016
 */
public class Etudiant extends Personne implements Cloneable {
    
    private int numeroEtudiant;
    
    /**
     * Constructeur par initialisation.
     * @param nom le nom de l'étudiant
     * @param prenom le prénom de l'étudiant
     * @param numero le numéro d'étudiant
     */
    public Etudiant(String nom, String prenom, int numero) {
        super(nom, prenom);
        this.numeroEtudiant = numero;
    }

    public Etudiant(Etudiant ref)
    {
        super(ref);
        this.numeroEtudiant = ref.numeroEtudiant;
    }
    
     /**
     * Retourne le numéro d'étudiant de l'étudiant.
     * @return le numéro d'étudiant
     */
    public int getNumeroEtudiant() {
        return numeroEtudiant;
    } 
 
    @Override
    public String toString()
    {
        return "Etudiant : " + super.toString() + ", numero " + numeroEtudiant;
    }

    @Override
    public Object clone()
    {
        return super.clone();
    }

    @Override
    public boolean equals(Object object)
    {
        if(!(object instanceof Etudiant))
        {
            if(object.getClass().getName().equals("personne.Personne"))
            {

            }
            else
            {
                
            }
        }
    }
}