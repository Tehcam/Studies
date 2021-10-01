import javax.swing.JLabel;
import javax.swing.BorderFactory;

import java.awt.Color;

public class MyJLabel extends JLabel
{
    public MyJLabel(String text)
    {
	super(text);
	setHorizontalAlignment(JLabel.CENTER);
	setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}