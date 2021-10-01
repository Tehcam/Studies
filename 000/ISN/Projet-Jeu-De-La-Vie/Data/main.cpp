/************************************************/
/**  ISN 2020 - Projet de fin d'année          **/
/**  JEU DE LA VIE                             **/
/**  Corentin MACHET     Robin BECK            **/
/************************************************/

#include <iostream>
#include <graphics.h>
// #include <string>
// #include <math.h>
#include "head.h"

using namespace std;

int main()
{
    while(YES != 'y')
    {
        cout << endl << "Le jeu de la vie va commencer :" << endl;
        cout << "Suivant ? y/n" << endl << ">>> ";
        cin >> YES;
        if(YES == 'n')
        {
            cout << endl << "Sur(e) de vouloir quitter la partie ? y/n" << endl << ">>> ";
            cin >> QUIT;
            if(QUIT == 'y')
            {
                return 0;
            }
        }
    }

    cout << endl << "Souhaitez vous lire les regles du jeu ? y/n" << endl << ">>> ";
    cin >> NO;
    if(NO == 'y')
    {
        Regles();
    }

    AGAIN = 'a';

while(AGAIN != 'n')
{
    /* Initialisation */
    YES = 'a';
    NO = 'a';
    QUIT = 'a';
    NB_GEN = 1;

    cout << endl << "Les dimensions de la grille sont fixees a 15x15." << endl;

    cout << endl << "Pour commencer, entrer le nombre de generation a executer (superieur a 0):" << endl << ">>> ";
    cin >> NB_GEN;
    if(NB_GEN <= 0) // erreur si nb de generations inf ou egal a 0
    {
        NB_GEN = 1;
    }
    int G = NB_GEN;

    /* Déclarer un tableau de Point */
    Point Tab_Point[X][Y];
    for(int b=0; b<Y; b++)
    {
        for(int a=0; a<X; a++)
        {
            Tab_Point[a][b].x = a*(C+1);
            Tab_Point[a][b].y = b*(C+1);
        }
    }

    /* Affiche une fenêtre graphique */
    initwindow(L, H, "Test Grille", 100, 100);
    for(int o=0; o<H; o++)
    {
        for(int p=0; p<L; p++)
        {
            putpixel(p, o, COLOR(255, 255, 255));
        }
    }

    /* Afficher Colones */
    for(int j=0, k=C; j<H; j++)
    {
        k=C;
        while(k<L)
        {
            putpixel(k, j, NOIR);
            k += C+1;
        }
    }

    /* Afficher Lignes */
    for(int k=0, j=C; k<L; k++)
    {
        j=C;
        while(j<H)
        {
            putpixel(k, j, NOIR);
            j += C+1;
        }
    }

    /* Sélectionner les cases de départ */
    ENTER = 'a';
    while(ENTER != ' ')
    {
        if(ismouseclick(WM_LBUTTONDOWN))
        {
            getmouseclick(WM_LBUTTONDOWN, w, z);
            Case_Loc_x = w-(w%(C+1));
            Case_Loc_y = z-(z%(C+1));
            Tab_Point[xTOa(Case_Loc_x)][yTOb(Case_Loc_y)].colorier();
            Pres_Point.p[xTOa(Case_Loc_x)][yTOb(Case_Loc_y)] = 1;
        }
        // clearmouseclick(WM_LBUTTONDOWN);
        if(kbhit())
        {
            ENTER = getch();
        }
    }

    /* Execution */
    for(int g=0; g<G; g++)
    {
        /* Traitement de la couleur des cases */
        for(int b=0; b<Y; b++)
        {
            for(int a=0; a<X; a++)
            {
                if(Tab_Point[a][b].compte() == 2)
                {
                    Tab_Point[a][b].colorier();
                }else{
                    Tab_Point[a][b].colorier(255);
                }
            }
        }

        /* Traitement de la présence des cases */
        for(int a=0, b=0, k=0, j=0; ((a<X) or (b<Y)); )
        {
            while(j<H)
            {
                k=0; a=0;
                while(k<L)
                {
                    if(getpixel(k, j) == NOIR)
                    {
                        Pres_Point.p[a][b] = 1;
                    }else{
                        Pres_Point.p[a][b] = 0;
                    }
                    k += C+1;
                    a++;
                }
                j += C+1;
                b++;
            }
            /* Traitement des erreurs */
            if((a>X) or (b>Y)){
                outtextxy(60, 60, "ERROR !");
                delay(1200);
                closegraph();
                return 0;
            }
        }
        delay(200);
    } // g=G le nombre de génération est atteint

    /* Réinitialisation des variables de la fenetre graphique */
    Pres_Point.resetAll();

    /* Fin du programme */
    delay(500);
    outtextxy(60, 60, "Press any key to exit...");
    getch();
    closegraph();
    cout << endl << "Voulez vous recommencer ? y/n" << endl << ">>> ";
    cin >> AGAIN;

} // fin boule while AGAIN

cout << endl << "Merci d'avoir joue !" << endl;
cout << "Press q to quit..." << endl << ">>> ";
cin >> QUIT;
return 0;

}

