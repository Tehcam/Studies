package personne;

public class Vacataire extends Enseignant implements Cloneable
{
    private String entreprise;

    public Vacataire(String nom, String prenom, double salaire, String entreprise)
    {
        super(nom, prenom, salaire);
        this.entreprise = entreprise;
    }

    public Vacataire(Vacataire ref)
    {
        super(ref);
        this.entreprise = ref.entreprise;
    }

    public String getEntreprise()
    {
        return entreprise;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", entreprise " + entreprise;
    }

    @Override
    public Object clone()
    {
        return super.clone();
    }
}