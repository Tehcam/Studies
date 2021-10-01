package astronomie;

public class Etoile extends AAstre implements IEtoile
{
    private double age;
    
    public Etoile(String nom, double masse, double diametre, double vitesseRotation, double age)
    {
        super(nom, masse, diametre, vitesseRotation);
        if(age < 0)
            throw new IllegalArgumentException("Age < 0");
        this.age = age;
    }
    
    public double getAge()
    {
        return age;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", etoile";
    }
}