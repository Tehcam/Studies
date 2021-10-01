import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MorpionIHM extends JFrame
{
    private int tour;

    private String j1;
    private String j2;
    private String titre;

    private JPanel panel;
    private JPanel panelCentral;

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton reset;

    private Controleur control;

    public MorpionIHM(String j1, String j2, String titre)
    {
        super();
        this.tour = 1;
        this.j1 = j1;
        this.j2 = j2;
        this.titre = titre;
        this.control = new Controleur();

        panel = new JPanel();
        panelCentral = new JPanel();
        var jeu = new Jouer();

        label1 = new JLabel("Tour de " + j1, SwingConstants.CENTER);
        label2 = new JLabel(j2);
        label3 = new JLabel(j1);
        reset = new JButton("Reset");

        panelCentral.setLayout(new GridLayout(3, 3));
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                var b = new MyButton(i, j);
                b.addActionListener(jeu);
                panelCentral.add(b);
            }
        }

        reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                java.awt.Component[] comp = panelCentral.getComponents();
                for(int i=0; i<comp.length; i++)
                {
                    ((JButton)comp[i]).setText("");
                    comp[i].setEnabled(true);
                }
                tour = 1;
                label1.setText("Tour de "+j1);
                control.reset();
            }
        });

        panel.setLayout(new BorderLayout());
        panel.add(label1, BorderLayout.NORTH);
        panel.add(label2, BorderLayout.EAST);
        panel.add(label3, BorderLayout.WEST);
        panel.add(reset, BorderLayout.SOUTH);
        panel.add(panelCentral);

        getContentPane().add(panel);

        setTitle(titre);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public String toString()
    {
        return "Je suis " + titre + " et mes 2 joueurs sont " + j1 + " et " + j2;
    }

    private void unenabledAll(java.awt.Component[] c)
    {
        for(int i=0; i<c.length; i++)
        {
            c[i].setEnabled(false);
        }
    }

    private class Jouer implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String sym = "O";
            if(tour%2 != 0)
                sym = "X";
            MyButton bouton = (MyButton) e.getSource();
            bouton.setText(sym);
            bouton.setEnabled(false);
            boolean isWon = false;
            try
            {
                control.set(bouton.getAbs(), bouton.getOrd(), sym.charAt(0));
                isWon = control.verify(bouton.getAbs(), bouton.getOrd());
            }
            catch(ArrayIndexOutOfBoundsException ev)
            {
                System.out.println("Les coordonnees de la case ne sont pas valide. Fin du programme...");
                System.exit(0);
            }
            if(isWon)
            {
                if(tour%2 != 0)
                    label1.setText(j1+" gagne !");
                else
                    label1.setText(j2+" gagne !");
                unenabledAll(panelCentral.getComponents());
            }
            else if(tour>=9)
            {
                label1.setText("Match nul !");
                unenabledAll(panelCentral.getComponents());
            }
            else
            {
                tour++;
                if(tour%2 != 0)
                    label1.setText("Tour de "+j1);
                else
                    label1.setText("Tour de "+j2);
            }
        }
    }

    private class Controleur
    {
        private char[][] tab;

        public Controleur()
        {
            tab = new char[3][3];
            reset();
        }

        public void set(int a, int o, char c) throws ArrayIndexOutOfBoundsException
        {
            if(a < 0 || a > 2)
                throw new ArrayIndexOutOfBoundsException();
            if(o < 0 || o > 2)
                throw new ArrayIndexOutOfBoundsException();
            tab[a][o] = c;
        }

        public boolean verify(int a, int o) throws ArrayIndexOutOfBoundsException
        {
            if(a < 0 || a > 2)
                throw new ArrayIndexOutOfBoundsException();
            if(o < 0 || o > 2)
                throw new ArrayIndexOutOfBoundsException();
            // gestion des lignes
            if(tab[0][o]==tab[a][o] && tab[1][o]==tab[a][o] && tab[2][o]==tab[a][o])
            {
                return true;
            }
            // gestion des colonnes
            if(tab[a][0]==tab[a][o] && tab[a][1]==tab[a][o] && tab[a][2]==tab[a][o])
            {
                return true;
            }
            // gestion des diagonales
            if(a == o)
            {
                if(tab[0][0]==tab[a][o] && tab[1][1]==tab[a][o] && tab[2][2]==tab[a][o])
                {
                    return true;
                }
            }
            if((a%2 == 0 && o%2 == 0) || (a == 1 && o == 1))
            {
                if(tab[0][2]==tab[a][o] && tab[1][1]==tab[a][o] && tab[2][0]==tab[a][o])
                {
                    return true;
                }
            }
            // fin
            return false;
        }

        public void reset()
        {
            for(int i=0; i<3; i++)
            {
                for(int j=0; j<3; j++)
                {
                    tab[i][j] = ' ';
                }
            }
        }
    }
}


