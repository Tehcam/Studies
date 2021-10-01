import astronomie.*;

public class Test
{
    public static void main(String[] args)
    {
        Etoile soleil = new Etoile("Soleil", 500000, 300000, 50, 45000000);
        Planete terre = new Planete("Terre", 30000, 36052, 24, soleil, 45112656, 365, "tellurique");
        Satellite lune = new Satellite("Lune", 32165, 54472, 27, terre, 541614, 50);

        System.out.println(soleil);
        System.out.println(terre);
        System.out.println(lune);
        System.out.println();
        soleil.afficher();
        terre.afficher();
        lune.afficher();
        System.out.println(soleil.getNombreSatellites());
        System.out.println(lune.getAstreReference());
        System.out.println(terre.getSatellite(0));
    }
}