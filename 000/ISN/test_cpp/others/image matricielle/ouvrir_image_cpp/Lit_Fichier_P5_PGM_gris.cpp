//*                 Programme C++               *
//              lecture fichier binaire         *
//            Lit fichier P5 .PGM gris          *
//                     2019-2020                *
//***********************************************
#include <iostream>
#include <fstream>   // librairie g�rant les fichiers
#include <string>
#include <math.h>
#include <graphics.h>
#include <GraphicsISN.h>
using namespace std;

int main ()
{
//D�clarations
    int Largeur=600;			// valeur � renseigner
    int Hauteur=500;			// valeur � renseigner
    char Car,QUIT;
    int Dim =Largeur*Hauteur;
    char Blocmem[Dim];			// Tableau de caract�res � 1 dimension
    unsigned char Dessin[Largeur][Hauteur];
    char NomF[12];
    int index;

    cout<<endl;
    cout <<"Lecture du fichier, donner son nom sous la forme nom.pgm : ";
    cin >>NomF;
    cout<<endl;


//	Lecture du fichier binaire � partir du disque
//  On a seulement besoin du nom complet du fichier sur le disque

    ifstream TonFichier (NomF, ios::in|ios::binary|ios::ate);
    if (TonFichier.is_open())
    {
         Dim = TonFichier.tellg();
         TonFichier.seekg (0, ios::beg);
         TonFichier.read (Blocmem, Dim);
         TonFichier.close();

         cout << "Le fichier complet est en memoire dans Blocmem "<<endl;;
     }
     else cout<<"Impossible d'ouvrir le fichier";

//  Fin gestion des fichiers ***********************************

// Initialisation du tableau Dessin � partir du tableau Blocmem

//Passage de l'ent�te :

// *************** A COMPLETER *******************


    int i=0; int k=0;
    string Def = 0;
    string Col = 0;
    string Lig = 0;
    string Blc = 0;

    for (i; i<4; i++){ // gestion de l'entete
        while (Blocmem[k] != '0a'){
            switch (i){
                case '2' :
                    Def[k] = Blocmem[k];
                case '3' :
                    Blc[k] = Blocmem[k];
            }
            k++;
        }
        k++;
    }






// On pointe sur le premier octet du dessin
// Le dessin est rang� dans le tableau Dessin

// *************** A COMPLETER *******************







// Affichage de l'image � l'�cran

    //Mise en mode graphique
    InitialiseFenetreGraphique(1);

// *************** A COMPLETER *******************
    // Affichage de l'image contenue dans le tableau Dessin




    while(!kbhit()){		// Attends tant que l'on n'a pas frapp� une touche
        delay(50);			// Attente de 50 millisecondes
    }
     FermeFenetreGraphique();





    // Fin du programme
    QUIT = '\0';
    while (QUIT != 'q') 	// Tant que quit est diff�rent de 'q' boucler
    {
        cout << "Press q to quit " << endl;
        cin >> QUIT;
    }

    return 0;
}
