import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.Scanner;

public class ListeMots
{
    private String path;
    private Vector<String> mots;

    public ListeMots(String path) throws IOException
    {
        this.path = path;
        File f = new File(this.path);
        mots = new Vector<String>();

        if(f.isFile())
        {
            Scanner reader = new Scanner(f);
            while(reader.hasNext())
                mots.add(reader.nextLine());
            reader.close();
        }
    }

    public String motAleatoire()
    {
        int k = (int)(Math.random()*mots.size());
        return mots.indexOf(k);
    }

    public void ajouterMot(String m)
    {
        
    }
}