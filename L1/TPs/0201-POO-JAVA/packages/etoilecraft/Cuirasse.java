package etoilecraft;

public class Cuirasse extends AUniteTerran
{
    private final boolean estVolante = true;

    public Cuirasse(double pwr)
    {
        super(85, 3, pwr, (pwr/2));
    }

    public boolean estVolante()
    {
        return estVolante;
    }
}