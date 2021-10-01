package astronomie;

public class Satellite extends AAstre implements ISatellite
{
    private AAstre astre;
    private double distance;
    private double vitesseRevolution;

    public Satellite(String nom, double masse, double diametre, double vitesseRotation, AAstre astre, double distance, double vitesseRevolution)
    {
        super(nom, masse, diametre, vitesseRotation);
        if(distance <= 0)
            throw new IllegalArgumentException("Distance < 0");
        if(vitesseRevolution <= 0)
            throw new IllegalArgumentException("Vitesse de revolution < 0");
        if(astre == null)
            throw new NullPointerException("Astre cannot be null");
        this.astre = astre;
        astre.ajouterSatellite(this);
        this.distance = distance;
        this.vitesseRevolution = vitesseRevolution;
    }

    public AAstre getAstreReference()
    {
        return astre;
    }

    public double getDistance()
    {
        return distance;
    }

    public double getVitesseRevolution()
    {
        return vitesseRevolution;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + " satellite de " + astre.toString();
    }
}