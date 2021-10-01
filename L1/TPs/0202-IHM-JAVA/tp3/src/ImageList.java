import java.util.ArrayList;

public class ImageList
{
    public static ArrayList<Integer> getRandomImageIndexes(int n)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<n; i++)
        {
            boolean bool;
            int x;
            do
            {
                bool = false;
                x = (int) (Math.random() * 15) + 1;
                for (Integer k : list)
                {
                    if (x == k.intValue())
                        bool = true;
                }
            }while(bool);
            list.add(x);
        }
        return list;
    }

    public static void fillRandomMatrixOfLabels(ArrayList<Integer> arr, JLabelImage[] img)
    {
        if(img.length != (arr.size()*2))
            throw new IllegalArgumentException("img.length must equal arr.size()*2");
        for(int i=0; i<img.length; i++)
        {
            img[i] = null;
        }
        for(Integer k : arr)
        {
            for(int j=0; j<2; j++)
            {
                int i;
                do
                {
                    i = (int)(Math.random()*img.length);
                }while(img[i] != null);
                img[i] = new JLabelImage(k.intValue());
            }
        }
    }
}