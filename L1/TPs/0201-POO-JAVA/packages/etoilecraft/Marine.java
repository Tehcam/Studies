package etoilecraft;

public class Marine extends AUniteTerran
{
    private final boolean estVolante = false;

    public Marine(double pwr)
    {
        super(120, 1, pwr, pwr);
    }

    public boolean estVolante()
    {
        return estVolante;
    }
}