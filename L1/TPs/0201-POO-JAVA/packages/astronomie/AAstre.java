package astronomie;
import java.util.Vector;

public abstract class AAstre implements IAstre
{
    private String nom;
    private double masse;
    private double diametre;
    private double vitesseRotation;
    private Vector<Satellite> satellites;

    public AAstre(String nom, double masse, double diametre, double vitesseRotation)
    {
        if(masse <= 0)
            throw new IllegalArgumentException("Masse < 0");
        if(diametre <= 0)
            throw new IllegalArgumentException("Diametre < 0");
        if(vitesseRotation <= 0)
            throw new IllegalArgumentException("Vitesse de rotation < 0");
        this.nom = nom;
        this.masse = masse;
        this.diametre = diametre;
        this.vitesseRotation = vitesseRotation;
        satellites = new Vector<Satellite>();
    }

    public String getNom()
    {
        return nom;
    }

    public double getMasse()
    {
        return masse;
    }

    public double getDiametre()
    {
        return diametre;
    }

    public double getVitesseRotation()
    {
        return vitesseRotation;
    }

    public int getNombreSatellites()
    {
        return satellites.size();
    }

    public Satellite getSatellite(int n)
    {
        return satellites.get(n);
    }

    public void ajouterSatellite(Satellite s)
    {
        satellites.add(s);
    }

    @Override
    public String toString()
    {
        return nom;
    }

    public void afficher()
    {
        String str = "";
        str += "\nNom : " + nom;
        str += "\nMasse : " + masse + " kg";
        str += "\nDiametre : " + diametre + " km";
        str += "\nRotation : " + vitesseRotation + " j";
        System.out.println(str);
    }
}