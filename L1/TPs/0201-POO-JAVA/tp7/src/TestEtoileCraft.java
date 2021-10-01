import etoilecraft.Marine;
import etoilecraft.Cuirasse;
import etoilecraft.AUniteTerran;

public class TestEtoileCraft
{
    public static void main(String[] args)
    {
        etoilecraft.IUnite marine = new Marine(4);
        etoilecraft.IUnite cuirasse = new Cuirasse(5);
        do
        {
            marine.attaquer(cuirasse);
            if(cuirasse.getPointsDeVie() > 0)
                cuirasse.attaquer(marine);
            ((Marine)marine).afficher();
            ((Cuirasse)cuirasse).afficher();
        }while(marine.getPointsDeVie() > 0 && cuirasse.getPointsDeVie() > 0);

        if(cuirasse.getPointsDeVie() <= 0)
            System.out.println("Le cuirasse a ete abattu");
        if(marine.getPointsDeVie() <= 0)
            System.out.println("Le marine a ete abattu");

        AUniteTerran ref1 = new Marine(4);
        
        // ex 3 qu 1
        etoilecraft.IUnite ref2 = ref1;
        // ex 3 qu 2
        AUniteTerran ref3 = ref1;
        // ex 3 qu 3
        Marine ref4 = (Marine)ref1;
    }
}