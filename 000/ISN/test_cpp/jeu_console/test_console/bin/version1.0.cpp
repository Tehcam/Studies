// test d'ouverture de fenetre graphique
// et jeu à systeme de compteurs

// 23/01/20

#ifndef SOURCE_INCLUDED
#define SOURCE_INCLUDED

#include "head.h"

#endif // SOURCE_INCLUDED

int main(){

    string NomF = FILE_TEST_1;
    string Dim = NULL;
    string Blocmem = NULL;

//Méthode d'ouverture 1

    void open(const char* NomF, ios_base::openmode mode = ios_base::in);

//Méthode d'ouverture 2
/*
    ifstream TonFichier(NomF, ios::in); // ios::binary||ios::ate

    if (TonFichier.is_open())
    {
         Dim = TonFichier.tellg();
         TonFichier.seekg (0, ios::beg);
         TonFichier.read (Blocmem, Dim);
         TonFichier.close();

         cout << "Le fichier complet est en memoire dans Blocmem "<<endl;;
     }
     else cout<<"Impossible d'ouvrir le fichier";
*/

//Méthode d'ouverture 3
/*
    IMAGE_TEST_1();
*/


    return 0;

}
