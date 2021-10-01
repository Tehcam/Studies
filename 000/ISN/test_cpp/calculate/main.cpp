/**********************************************/
//		Sprod-CMachet
//		Main
//		Créer une calculatrice
/**********************************************/

#include <iostream>
// #include <math.h>
// #include <string>
#include "header/main.h"

using namespace std;

char Blocmem[30];
char Nombre[30];
nb VAL[30];
int Result=0;

void initNombre(){
	int i=0;
	while(Nombre[i] != '\0'){
		Nombre[i] = 0;
		i++;
	}
}

int lengthOfNombre(){
	int i=0;
	while(Nombre[i] != '\0'){
		i++;
	}
	return i;
}

int lengthOfBlocmem(){
	int i=0;
	while(Blocmem[i] != '\0'){
		i++;
	}
	return i;
}

int verifNombre(){
	int RETURNED;
	RETURNED = 0;
	for(int j=0; j<lengthOfNombre(); j++){
		switch(Nombre[j]){
			case 'm':
				int a=0; int b=0;
				for(int k=0; k<j; k++){
					a << Nombre[k];
				}
				for(int k=(j+1); Nombre[k] != '\0'; k++){
					b << Nombre[k];
				}
				RETURNED = multiple(a, b);
				break;
		}
	}
	return RETURNED;	
}

int calculate(){
	int index_a = 0;
	cout << "Calculate :" << endl;
	cin >> Blocmem;
	for(int i=0; i<lengthOfBlocmem(); i++){
		if(Blocmem[i] == '('){
			initNombre();
			while(Blocmem[i] != ')'){
				int k=0;
				Nombre[k] = Blocmem[i];
				k++; i++;
				// if Blocmem[i] == '(' ?
			}
			VAL[index_a].value = verifNombre();
			index_a++;
		}
	}
	for(int i=0; i<index_a; i++){
		Result += VAL[i].value;
		// et si le calcul n'est pas une addition ?
	}

	return Result;
}

int main(){
	char AWNSER = 'n';
	do{
		cout << calculate() << endl << endl;
		cout << endl << "Again ? y/n" << endl;
		cin >> AWNSER;
	}while(AWNSER == 'y');

	char QUIT = 'a';
	cout << "Press q to quit" << endl;
	while(QUIT != 'q'){
		cin >> QUIT;
	}

	return 0;
}
// end // Main