/**********************************************/
//		Sprod-CMachet
//		Main
//		Description
/**********************************************/

#include "header/inc/Window.h"
#include <iostream>
#include <fstream>
using namespace std;

int endOfProg(){
	char _QUIT;
	cout << "Press 'q' to quit" << endl;
	while(_QUIT != 'q'){
		cout << ">>> ";
		cin >> _QUIT;
	}
	return 0;
}

int main(){
	ifstream WindowClass_DLL("libwin.dll", ios::app|ios::binary|ios::ate);
	if(!WindowClass_DLL.is_open()){return 0;}
	cout << "la dll est ouverte !" << endl;

	// Il faut la mettre en memoire !
	int size = WindowClass_DLL.tellg();
    char* blocmem = new char [size];
    WindowClass_DLL.seekg(0, ios::beg);
    WindowClass_DLL.read(blocmem, size);
    // Il faut fermer les obj du stream
    WindowClass_DLL.close();
	cout << "la dll est fermee !" << endl;
	cout << "la dll est en memoire dans blocmem" << endl;
	
	// callmsg(); // function from libwin.dll in blocmem
	delete[] blocmem;

	return endOfProg();
}
// end // Main