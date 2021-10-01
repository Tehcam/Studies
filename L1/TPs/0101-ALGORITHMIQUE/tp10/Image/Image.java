class Image
{
	public static void main(String[] args)
	{
		boolean[][] image = {
            { false, false, false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, true, true, true, true, false, false, false, false },
            { false, false, false, true, false, false, false, false, true, false, false, false },
            { false, false, true, false, true, false, false, true, false, true, false, false },
            { false, false, true, false, false, false, false, false, false, true, false, false },
            { false, false, true, false, true, false, false, true, false, true, false, false },
            { false, false, true, false, false, true, true, false, false, true, false, false },
            { false, false, false, true, false, false, false, false, true, false, false, false },
            { false, false, false, false, true, true, true, true, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false, false, false }
        };
        afficheImg(image);
        inverse(image, cadre(image));
        ligne(image, 0);
        ligne(image, 9);
        for(int i=0; i<image.length; i++)
        {
        	setPixel(image, 0, i);
        	setPixel(image, 11, i);
        }
        afficheImg(image);
        System.out.println();
        boolean[][] image2 = creerImg(5, 5);
        inverse(image2, cadre(image2));
        afficheImg(image2);
	}

	private static void effaceImg(boolean[][] img)
	{
		for(int i=0; i<img.length; i++)
		{
			for(int j=0; j<img[i].length; j++)
			{
				img[i][j] = false;
			}
		}
	}

	private static boolean[][] creerImg(int h, int w)
	{
		boolean[][] img;
		if(h>0 && w>0)
		{
			img = new boolean[h][w];
			effaceImg(img);
		}else{
			img = null;
		}
		return img;
	}

	private static void afficheImg(boolean[][] img)
	{
		for(int i=0; i<img.length; i++)
		{
			for(int j=0; j<img[i].length; j++)
			{
				if(img[i][j])
					System.out.print("X");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

	private static void setPixel(boolean[][] img, int x, int y)
	{
		try
		{
			if((y<0 || y >= img.length) || (x<0 || x >= img[y].length))
				throw new Error("Coordonnees au point inexistants.");
			img[y][x] = true;
		}
		catch(Error e)
		{
			System.out.println(e.getMessage());
		}
	}

	private static void ligne(boolean[][] img, int x)
	{
		if(x>=0 && x<img.length)
		{
			for(int i=0; i<img[x].length; i++)
			{
				setPixel(img, i, x);
			}
		}else{
			System.out.println("Coordonnees a la ligne inexistants.");
		}
	}

	private static int firstRow(boolean[][] img)
	{
		int i=0, j;
		boolean bool = false;
		while(i<img.length && !bool)
		{
			j=0;
			while(j<img[i].length && !bool)
			{
				if(img[i][j])
					bool = true;
				j++;
			}
			if(!bool)
				i++;
		}
		if(!bool)
			i=0;
		return i;
	}

	private static int firstColumn(boolean[][] img)
	{
		int i=0, j=0;
		boolean bool = false;
		while(j<img[i].length && !bool)
		{
			i=0;
			while(i<img.length-1 && !bool)
			{
				if(img[i][j])
					bool = true;
				i++;
			}
			if(img[i][j])
				bool = true;
			if(!bool)
				j++;
		}
		if(!bool)
			j=0;
		return j;
	}

	private static int lastRow(boolean[][] img)
	{
		int i=img.length-1, j;
		boolean bool = false;
		while(i>=0 && !bool)
		{
			j=img[i].length-1;
			while(j>=0 && !bool)
			{
				if(img[i][j])
					bool = true;
				j--;
			}
			if(!bool)
				i--;
		}
		if(!bool)
			i = img.length-1;
		return i;
	}

	private static int lastColumn(boolean[][] img)
	{
		int i=img.length-1, j=img[i].length-1;
		boolean bool = false;
		while(j>=0 && j<img[i].length && !bool)
		{
			i=img.length-1;
			while(i>0 && !bool)
			{
				if(img[i][j])
					bool = true;
				i--;
			}
			if(img[i][j])
				bool = true;
			if(!bool)
				j--;
		}
		if(!bool)
			j = img[img.length-1].length - 1;
		return j;
	}

	private static int[][] cadre(boolean[][] img)
	{
		int[][] coords = new int[2][2];
		coords[0][0] = firstColumn(img);
		coords[0][1] = firstRow(img);
		coords[1][0] = lastColumn(img);
		coords[1][1] = lastRow(img);
		return coords;
	}

	private static void inverse(boolean[][] img, int[][] coords)
	{
		if(coords[0][0] >= 0 && coords[0][1] >= 0 && coords[1][0] >= 0 && coords[1][1] >= 0)
		{
			if(coords[0][1] < img.length && coords[0][0] < img[coords[0][1]].length && coords[1][1] < img.length && coords[1][0] < img[coords[1][1]].length)
			{
				if(coords[1][1] >= coords[0][1] && coords[1][0] >= coords[0][0])
				{
					for(int i=coords[0][1]; i<=coords[1][1]; i++)
					{
						for(int j=coords[0][0]; j<=coords[1][0]; j++)
						{
							img[i][j] = !img[i][j];
						}
					}
				}
			}
		}			
	}
}