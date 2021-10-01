package etoilecraft;

public abstract class AUniteTerran implements IUnite
{
    private double ptsVie;
    private double ptsArmure;
    private double pwrSol;
    private double pwrAir;

    public AUniteTerran(double ptsVie, double ptsArmure, double pwrSol, double pwrAir)
    {
        if(ptsVie <= 0)
            throw new IllegalArgumentException("Les PVs doivent etre positifs.");
        if(ptsArmure <= 0)
            throw new IllegalArgumentException("Les points d'armure doivent etre positifs.");
        if(pwrSol < 0)
            throw new IllegalArgumentException("La puissance au sol doit etre positive ou nul.");
        if(pwrAir < 0)
            throw new IllegalArgumentException("La puissance dans les airs doit etre positive ou nul.");
        this.ptsVie = ptsVie;
        this.ptsArmure = ptsArmure;
        this.pwrSol = pwrSol;
        this.pwrAir = pwrAir;
    }

    public double getPointsDeVie()
    {
        return ptsVie;
    }

    public double getPointsArmure()
    {
        return ptsArmure;
    }

    public double getPuissanceTirSol()
    {
        return pwrSol;
    }

    public double getPuissanceTirAir()
    {
        return pwrAir;
    }

    public boolean subirAttaque(double degats)
    {
        ptsVie -= degats/ptsArmure;
        if(ptsVie <= 0)
            return true;
        return false;
    }

    public abstract boolean estVolante();

    public boolean attaquer(IUnite u)
    {
        double degats;
        if(u.estVolante())
            degats = Math.random()*pwrAir;
        else
            degats = Math.random()*pwrSol;
        return u.subirAttaque(degats);
    }

    @Override
    public String toString()
    {
        return getClass().getName() + " : reste " + ptsVie + " PV.";
    }

    public void afficher()
    {
        System.out.println(this);
    }
}