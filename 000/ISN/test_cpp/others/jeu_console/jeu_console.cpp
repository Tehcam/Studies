/*

MINI PROJET 2 - ISN
Créer un jeu consôle en langage C++

Beck Robin et Machet Corentin

*/

#include<iostream>
#include "E:\Terminale\ISN\T7S\jeu_console\jeu_console\functions.h"
using namespace std;

    char quit = 0;
    char next = 0;

void Default(){
    cout << "Vous ne repondez pas a la question." << endl << endl;
    cout << "Press q to quit" << endl;
    while(quit != 'q'){
        cin >> quit;
    }
    next = 0;

}

int main(){
    // char ans_a, ans_b;
    // ans_a = ans_b = 0;

    cout << "MASTERMIND" << endl << endl;
    cout << "Bienvenue dans notre jeu console !" << endl;
    cout << "Le but du jeu est simple : trouver la bonne combinaison de chiffres et/ou de lettres." << endl << endl;
    cout << "Savez vous deja jouer ?   Y ou N" << endl << endl;
    cin >> ans_a;
    char A = ans_a;

    switch(A){
    case 'Y' :
        cout << "Parfait !" << endl << endl;
        next = 1;
        break;
    case 'N' :
        cout << "Alors voici les regles du jeu :" << endl << endl;
        Notice();
        next = 1;
        break;
    default :
        Default();
        return 0;
    }

    if(next == 1){
        cout << "Avant de commencer, entrer un nombre entier aleatoire a 3 chiffres dans la console :" << endl;
        cin >> Rand;
        cout << endl << "Choisir un niveau de difficulte :" << endl << "D: debutant" << endl << "A: amateur" << endl << "P: pro" << endl << endl;
        cout << "D, A ou P ?" << endl;
        cin >> ans_b;
        char B = ans_b;
        switch(B){
        case 'D':
            cout << "C'est parti !" << endl << endl;
            Debutant();
            break;
        case 'A':
            cout << "C'est parti !" << endl << endl;
            //Amateur();
            break;
        case 'P':
            cout << "C'est parti !" << endl << endl;
            //Pro();
            break;
        default:
            Default();
            return 0;
        }

    }else if(next == 0){
        cout << "error" << endl << endl;
    }

    cout << "Press q to quit" << endl;
    while(quit != 'q'){
        cin >> quit;
    }
    return 0;

}
