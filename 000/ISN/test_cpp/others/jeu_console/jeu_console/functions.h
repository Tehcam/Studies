#ifndef FUNCTIONS_H_INCLUDED
#define FUNCTIONS_H_INCLUDED

#include<iostream>
#include<sstream>
#include<string>
#include<typeinfo>
using namespace std;

    char ans_a = 0;
    char ans_b = 0;
    string Rand = 0;
    string N_str = 0;
    string nbToStr(int nombre){
        ostringstream a;
        a << nombre;
        N_str = a.str();
        return N_str;
    }

void Notice(){
    // ici les regles du jeu
    cout << "Vous pouvez choisir entre 3 niveaux differents" << endl;
    cout << "Pour chacun des niveaux, vous disposez de 10 essais pour trouver une combinaison de caracteres." << endl;
    cout << "Au niveau D, il vous faut trouver 5 chiffres;" << endl << "au niveau A, le dernier des 5 caracteres sera une lettre du mot AZERTY;" << endl << "au niveau P, 2 des 5 caracteres seront une lettre du mot AZERTY" << endl;
    cout << "Pour vous aider, la console vous renvoie apres chaque essaie une combinaison de 5 chiffres," << endl << "correspondants aux 5 caracteres que vous venez de proposer :" << endl;
    cout << "0: le caractere n'est pas present dans la combinaison a decouvrir" << endl;
    cout << "1: le caractere est present mais pas place correctement" << endl;
    cout << "2: le caractere est present et correctement place" << endl << endl;
    cout << "Attention, un caractere peut etre present plusieurs fois !!" << endl << "Bon courage !" << endl << endl;
    cout << "Remarque, si vous entrez plus de 5 caracteres, la console ne prend en compte que les 5 derniers." << endl;
    cout << "S'il manque des caracteres, ceux-ci seront remplaces par des 0." << endl;
    cout << "Si vous avez besoin de relire les regles, vous pouvez demander cette notice a la console en entrant la lettre h." << endl<< endl;

}

int Debutant(){
// Creer un tableau vide pour recuperer la combinaison finale
    char sch_nb[6];
    int i;
    for(i=0; i<5; i++){
        sch_nb[i] = 0;
    }

// Initialiser les variables
    int N = 0;
    int j, k;
    char A = ans_a;
    j = k = 0;
    while(Rand[k] != '\0'){
        if (typeid(Rand[k]) == typeid(int)){
            N += Rand[k];
        }else{
            N += 0;
        }
        k++;
    }

// Modifier la valeur de N pour que la combinaison ne soit pas "devinée"
    switch(A){
        case 'Y':
            N = (N*31)+135;
            break;
        case 'N':
            N = (N*12)+162;
            break;
    }
    // Convertir N en chaine de caracteres
    if (N == 0){
        cout << "error" << endl;
        return 0;
    }else if(N != 0){
        nbToStr(N);
    }

// Attribuer les 5 dernieres valeur de N au tableau vide
// Ce sont les 5 caracteres avec lesquels nous allons jouer
    i=0;
    while(N_str[i] != '\0'){
        i++;
    }
    for(j=0; j<5; j++){
        i--;
        sch_nb[j] = N_str[i];
        cout << sch_nb[j]; // la reponse a trouver : suppr avant de jouer !!
    }
    cout << endl;

// Commencer le jeu
    return 0;
}

#endif // FUNCTIONS_H_INCLUDED
