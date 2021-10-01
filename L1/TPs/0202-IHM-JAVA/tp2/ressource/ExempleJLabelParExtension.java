import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExempleJLabelParExtension extends JFrame
{
    public ExempleJLabelParExtension()
    {
    	JLabel component = new MyJLabel("Hello World !!!");
	
	    getContentPane().add(component);
	
	    setSize(400,200);
	    setLocationRelativeTo(null);
	    setTitle("Exemple de "+component.getClass().getName());
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
    }

    public static void main(String[] args)
    {
	    new ExempleJLabelParExtension();
    }
}