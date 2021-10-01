import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Configuration extends JFrame
{
    private static final long serialVersionUID = 1L;
    private JFrame game;

    public Configuration()
    {
        var pane = new javax.swing.JPanel();
        pane.add(new MyButton("Facile", Difficulte.FACILE));
        pane.add(new MyButton("Moyen", Difficulte.MOYEN));
        pane.add(new MyButton("Difficile", Difficulte.DIFFICILE));
        java.awt.Component[] comp = pane.getComponents();
        for(java.awt.Component c : comp)
        {
            ((MyButton)c).addActionListener(new NewGame());
        }
        getContentPane().add(new javax.swing.JLabel("Choisissez le niveau de difficulte :", javax.swing.SwingConstants.CENTER), java.awt.BorderLayout.NORTH);
        getContentPane().add(pane);

        setSize(350, 120);
        setLocationRelativeTo(null);
        setTitle("Onglet de configuration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void startGame(Difficulte d)
    {
        setVisible(false);
        game = new ExempleJLabelImage(d, this);
    }

    private class MyButton extends JButton
    {
        private static final long serialVersionUID = 1L;
        private Difficulte d;

        private MyButton(String str, Difficulte d)
        {
            super(str);
            this.d = d;
        }

        private Difficulte getD()
        {
            return d;
        }
    }

    private class NewGame implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            var ref = (MyButton)e.getSource();
            startGame(ref.getD());
        }
        
    }
}