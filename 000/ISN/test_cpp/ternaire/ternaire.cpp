/**********************************************/
//		Sprod-CMachet
//		Ternaire
//		Description
/**********************************************/

#include <iostream>
// #include <math.h>
#include <string>
#include <typeinfo>
#include <regex>
#include <sstream>

using namespace std;

int error(){
	cout << "undefined";
	return 0;
}

int strToInt(const string e){
	istringstream convert(e);
	int N;
	convert >> N;
	return N;
}

int main(){
	int majeur(15);
	string verif_maj;
	regex test("([0-9]*)");

	cout << "age : ";
	cin >> verif_maj;

	if(!(regex_match(verif_maj, test))){return error();}
	majeur = strToInt(verif_maj);

	// if(typeid(ptr).name() != typeid(int).name()){return error();}

	if((majeur<0)||(majeur>150)){return error();}
	string rep = "tu es ";
	rep += (majeur >= 18) ? "majeur" : "mineur";
	cout << rep;

	return 0;
}
// end // Ternaire