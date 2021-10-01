/**********************************************/
//		Sprod-CMachet
//		Main
//		from learn-dll
/**********************************************/

#include <iostream>
#include "header/Duree.h"

using namespace std;

int main(){
	Duree first(1, 0, 120), second(0, 62, 0);
	
	if(first >= second){
		cout << "plus grand ou egale que..." << endl;
	}else{
		cout << "plus petit ou egale que..." << endl;
	}

	return 0;
}
// end // Main