package astronomie;

public class Planete extends Satellite implements IPlanete
{
    private String type;

    public Planete(String nom, double masse, double diametre, double vitesseRotation, AAstre astre, double distance, double vitesseRevolution, String type)
    {
        super(nom, masse, diametre, vitesseRotation, astre, distance, vitesseRevolution);
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return getNom() + ", planete autour de " + getAstreReference().getNom();
    }
}