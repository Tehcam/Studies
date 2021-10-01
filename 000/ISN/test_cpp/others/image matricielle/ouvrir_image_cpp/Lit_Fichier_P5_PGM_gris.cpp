//*                 Programme C++               *
//              lecture fichier binaire         *
//            Lit fichier P5 .PGM gris          *
//                     2019-2020                *
//***********************************************
#include <iostream>
#include <fstream>   // librairie gérant les fichiers
#include <string>
#include <math.h>
#include <graphics.h>
#include <GraphicsISN.h>
using namespace std;

int main ()
{
//Déclarations
    int Largeur=600;			// valeur à renseigner
    int Hauteur=500;			// valeur à renseigner
    char Car,QUIT;
    int Dim =Largeur*Hauteur;
    char Blocmem[Dim];			// Tableau de caractères à 1 dimension
    unsigned char Dessin[Largeur][Hauteur];
    char NomF[12];
    int index;

    cout<<endl;
    cout <<"Lecture du fichier, donner son nom sous la forme nom.pgm : ";
    cin >>NomF;
    cout<<endl;


//	Lecture du fichier binaire à partir du disque
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

// Initialisation du tableau Dessin à partir du tableau Blocmem

//Passage de l'entète :

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
// Le dessin est rangé dans le tableau Dessin

// *************** A COMPLETER *******************







// Affichage de l'image à l'écran

    //Mise en mode graphique
    InitialiseFenetreGraphique(1);

// *************** A COMPLETER *******************
    // Affichage de l'image contenue dans le tableau Dessin




    while(!kbhit()){		// Attends tant que l'on n'a pas frappé une touche
        delay(50);			// Attente de 50 millisecondes
    }
     FermeFenetreGraphique();





    // Fin du programme
    QUIT = '\0';
    while (QUIT != 'q') 	// Tant que quit est différent de 'q' boucler
    {
        cout << "Press q to quit " << endl;
        cin >> QUIT;
    }

    return 0;
}
