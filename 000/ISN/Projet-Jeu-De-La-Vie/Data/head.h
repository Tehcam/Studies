#ifndef HEAD_H_INCLUDED
#define HEAD_H_INCLUDED

#include <iostream>
using namespace std;

/* Variables */
const int Y = 15;   // en nb de cases
const int X = 15;   // en nb de cases
const int C = 30;   // en px
int H = Y*(C+1);    // en px
int L = X*(C+1);    // en px
int w;              // en px
int z;              // en px

char YES;
char NO;
char QUIT;
char AGAIN;
int NB_GEN;
char ENTER;
int Case_Loc_x; int Case_Loc_y;
const int NOIR = COLOR(0, 0, 0);

struct DeclarePresPoint
{
    int p[X][Y];
    void resetAll()
    {
        for(int i=0; i<Y; i++)
        {
            for(int j=0; j<X; j++)
            {
                p[j][i] = 0;
            }
        }
    }
};

DeclarePresPoint Pres_Point;

/* Conversions */
int xTOa(int x)
{
    int RETURNED = x/(C+1);
    return RETURNED;
}

int yTOb(int y)
{
    int RETURNED = y/(C+1);
    return RETURNED;
}

/* Règles du jeu */
void Regles()
{
    cout << endl << ">>> Comment jouer ?" << endl;
    cout << "Le JDV se base sur une grille de cases blanches dans laquelle varie une population de cases noires." << endl;
    cout << "Cette population s'accroit ou non selon les conditions de depart." << endl;
    cout << "Il vous est possible de les modifier, ou de jouer avec la version par defaut." << endl;
    cout << endl << ">>> Il est necessaire de definir un nombre entier positif de generations." << endl;
    cout << "Une grille devrait alors s'afficher : vous devez disposer la situation de depart." << endl;
    cout << "Pour cela, cliquez sur les cases que vous souhaitez." << endl;
    cout << endl << ">>> N'oubliez pas de presser <space> pour commencer le traitement !" << endl;
    cout << endl << "A vous de jouer..." << endl;
}

/* Déclarer l'objet 'Point' */
struct Point
{
    int x; int y;
    int presence;

    int compte(int N=0)
    {
        Point Voisin[4];
        int va = x+C+1;
        if(va<L)
        {
            Voisin[0].presence = Pres_Point.p[xTOa(va)][yTOb(y)];
        }else{Voisin[0].presence = 0;}
        int vb = y-C-1;
        if(vb>0)
        {
            Voisin[1].presence = Pres_Point.p[xTOa(x)][yTOb(vb)];
        }else{Voisin[1].presence = 0;}
        int vc = x-C-1;
        if(vc>0)
        {
            Voisin[2].presence = Pres_Point.p[xTOa(vc)][yTOb(y)];
        }else{Voisin[2].presence = 0;}
        int vd = y+C+1;
        if(vd<H)
        {
            Voisin[3].presence = Pres_Point.p[xTOa(x)][yTOb(vd)];
        }else{Voisin[3].presence = 0;}

        for(int i=0; i<4; i++)
        {
            N += Voisin[i].presence;
        }
        return N;
    }

    void colorier(int couleur=0)
    {
        for(int j=y; j<(y+C); j++)
        {
            for(int k=x; k<(x+C); k++)
            {
                putpixel(k, j, COLOR(couleur, couleur, couleur));
            }
        }
    }
};

#endif // HEAD_H_INCLUDED
