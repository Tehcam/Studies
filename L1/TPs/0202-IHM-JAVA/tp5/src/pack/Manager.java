package pack;

import java.util.ArrayList;
import javafx.beans.property.*;

public class Manager
{
	private Level level;
	private IntegerProperty row = new SimpleIntegerProperty();
	private IntegerProperty col = new SimpleIntegerProperty();
	private IntegerProperty score = new SimpleIntegerProperty();
	private int[][] ep;

	public boolean init(Level level)
	{
		try
		{
			this.level = level;
			score.setValue(0);
			switch(level)
			{
				case FACILE:
					row.setValue(2);
					col.setValue(5);
					break;
				case MOYEN:
					row.setValue(4);
					col.setValue(4);
					break;
				case DIFFICILE:
					row.setValue(4);
					col.setValue(6);
			}
			fillRandomMatrixOfImage();
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

	public ReadOnlyIntegerProperty getRow()
	{
		return row;
	}

	public ReadOnlyIntegerProperty getCol()
	{
		return col;
	}

	public Level getCurrentLevel()
	{
		return level;
	}

	public int[][] getEp()
	{
		return ep;
	}

	public ReadOnlyIntegerProperty getScore()
	{
		return score;
	}

    private ArrayList<Integer> getRandomImageIndexes()
    {
    	int n = row.intValue()*col.intValue()/2;
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

    private void fillRandomMatrixOfImage()
    {
        final int r = row.intValue();
        final int c = col.intValue();
        ep = new int[r][c];
        ArrayList<Integer> arr = getRandomImageIndexes();

        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
            	ep[i][j] = -1;
            }
        }

        for(Integer k : arr)
        {
            for(int l=0; l<2; l++)
            {
                int i, j;
                do
                {
                    i = (int)(Math.random()*ep.length);
                    j = (int)(Math.random()*ep[i].length);
                }while(ep[i][j] != -1);
                ep[i][j] = k.intValue();
            }
        }
    }
}