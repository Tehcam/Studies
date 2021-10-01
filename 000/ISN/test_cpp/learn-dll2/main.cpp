/**********************************************/
//		Sprod-CMachet
//		Main
//		from learn-dll
/**********************************************/

#include <iostream>
#include <fstream>
#include "Duree.h"

using namespace std;



int main(){
	try{
		ifstream DureeClass_DLL;
		DureeClass_DLL.open("Duree.dll", ios::binary);
		if(!DureeClass_DLL.is_open()){
			throw false;
		}
		cout << "la dll est ouverte !" << endl;
/* Erreur de compilation
		Duree first(1, 0, 120), second(1, 2, 0);
		cout << (first == second) ? "Equal" : "Not Equal";
*/
		DureeClass_DLL.close();
	}

	catch (bool const& e){
		if(e == false){
			cout << "Duree.dll can not be opened." << endl;
			return endOfProg();
		}
	}

	return endOfProg();
}
// end // Main