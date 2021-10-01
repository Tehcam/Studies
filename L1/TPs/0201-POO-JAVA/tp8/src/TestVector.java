import etoilecraft.*;
import java.util.Vector;

public class TestVector
{
    public static void main(String[] args)
    {
        Vector<IUnite> unites = new Vector<IUnite>();
        unites.add(new Marine(10));
        unites.add(new Flammeur(10));
        unites.add(new Cuirasse(10));
        for(IUnite u : unites)
        {
            System.out.println(u);
        }
        unites.remove(1);
        System.out.println();
        for (IUnite u : unites)
        {
            System.out.println(u);
        }
        System.out.println("\n" + unites.get(1));
    }
}