/**
 * Classe Controleur
 * Une instance de controleur permet de g&eacute;rer les r&egrave;gle du jeu de morpion.
 * @author Corentin MACHET
 * @version 13.03.2021
 */

public class Controleur
{
    /**
     * Tableau de caract&egrave;res
     * (ici toujours 3x3)
     * permet la gestion des r&egrave;gles du jeu de morpion.
     */
    private char[][] tab;

    /**
     * <i>Contructeur par d&eacute;faut</i> initialise le tableau 3x3.
     */
    public Controleur()
    {
        tab = new char[3][3];
        reset();
    }

    /**
     * V&eacute;rifie puis ajoute, si possible, un caract&egrave;re au
     * tableau.
     * @param a absisse de la case du tableau
     * @param o ordonn&eacute;e de la case du tableau
     * @param c caract&egrave;re ajout&eacute;
     * @throws ArrayIndexOutOfBoundsException retourne une exception si les coordonn&eacute;es ne sont pas valides
     */
    public void set(int a, int o, char c) throws ArrayIndexOutOfBoundsException
    {
        if(a < 0 || a > 2)
            throw new ArrayIndexOutOfBoundsException();
        if(o < 0 || o > 2)
            throw new ArrayIndexOutOfBoundsException();
        tab[a][o] = c;
    }

    /** 
     * V&eacute;rifie si une combinaison du morpion est valide, 
     * &agrave; la case pass&eacute;e en param&egrave;tre
     * @param a abscisse de la case
     * @param o ordonn&eacute;e de la case
     * @throws ArrayIndexOutOfBoundsException retourne une exception si les coordonn&eacute;es ne sont pas valides
     * @return <i>true </i>si une combinaison est v&eacute;rifi&eacute;e; <i>false </i>sinon
     */
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

    /**
     * Permet de remettre le controleur compl&eacute;tement &agrave; zero pour une nouvelle partie.
     */
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