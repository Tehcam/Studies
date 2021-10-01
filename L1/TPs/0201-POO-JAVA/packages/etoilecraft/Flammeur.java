package etoilecraft;

public class Flammeur extends AUniteTerran
{
    private final boolean estVolante = false;

    public Flammeur(double pwr)
    {
        super(100, 2, pwr, 0);
    }

    public boolean estVolante()
    {
        return estVolante;
    }
}