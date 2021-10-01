import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.io.File;
import java.awt.image.BufferedImage;

public class JLabelImage extends JLabel
{
	private static final long serialVersionUID = 1L;
	private File f;
	private BufferedImage image;
	private String imgPath;
	private boolean isVisible = false;
	private boolean isFound = false;

    public JLabelImage(int n)
    {
		// cette instruction n'est pas utile mais on
        // l'a met pour ne pas oublier qu'il faudrait la mettre en cas
        // de constructeur non vide dans la classe mere
        super();
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setImage(n);
    }

    @Override
    public void paint(java.awt.Graphics g)
    {
    	int l = (int)getSize().getWidth();
    	int h = (int)getSize().getHeight();

		if(isVisible)
		{
			java.awt.Graphics2D g2 = (java.awt.Graphics2D)g;
			g2.drawImage(image, 0, 0, l, h, null);
		}
		else
		{
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, l, h);
			setBorder(BorderFactory.createLineBorder(Color.WHITE));
		}
		
    	super.paint(g);
    }

	public void setImage(int n)
	{
		generatePath(n);
		f = new File(imgPath);
		if (!f.isFile())
			throw new RuntimeException("Ce fichier n'existe pas.");
		try
		{
			image = javax.imageio.ImageIO.read(f);
		}
		catch (java.io.IOException e)
		{
			throw new RuntimeException("Ce fichier n'a pas pu etre chargee.");
		}
		repaint();
	}

	public void setImage()
	{
		repaint();
	}

	private void generatePath(int n)
	{
		imgPath = "../images/FF_";
		if(n>9)
			imgPath += n + ".jpg";
		else
			imgPath += "0" + n + ".jpg";
	}

	public void flip()
	{
		isVisible = !isVisible;
	}

	public void find()
	{
		isFound = !isFound;
	}

	public boolean egalA(JLabelImage ref)
	{
		return this.imgPath.equals(ref.imgPath);
	}

	public boolean isFound()
	{
		return isFound;
	}
}
