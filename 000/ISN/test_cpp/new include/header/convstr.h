/***********************************************/
//		Sprod-CMachet							/
//		Author : Corentin MACHET				/
//		FR - on Windows							/
//		Conversion functions					/
//		All rights reserved						/
/***********************************************/

/* using include's files from MinGW complier */

/************************************************

//	HOW TO USE IT ?

//	Usualy have to use namespace 'nba',
//	contains 'convint', 'convdouble' and 'ascii'.

//	Please, respect this work !

//	# 1

//	convinfo::infoStr()
//	get and show size, length and char from str
//	could delete a string var.

//	# 2

//	convint::intToStr()
//	conversion from int to string.

//	convint::strToInt()
//	conversion from string to int

//	convdouble::dblToStr()
//	conversion from double to string

//	convdouble::strToDbl()
//	conversion from string to double

//	Those 4 functions allow simple int and double
//	They all exist for long int and double
// 	Please, see at namespace 'convlong'

//	convlong::longIntToStr()
//	convlong::strToLongInt()
//	convlong::longDblToStr()
//	convlong::strToLongDbl()

//	# 3

//	using namespace convnb
//	for int and double only

//	using namespace convall
//	for all functions

//	# 4

//	In namespace 'ascii' :
//

************************************************/

#ifndef CONVSTR_H
#define CONVSTR_H

#include <string>
#include <regex>
#include <sstream>
// #include <vector>
// #include <typeinfo>

#include <iostream>
using namespace std;

int errorReturned(string err){
	cout << "\'undefined\' : " << err << endl;
	return 0;
}

namespace convinfo{
	// informations from string
	int infoStr(const string str, const unsigned int x = 0){
		string endinfo = "INFO END";

		cout << "INFO FROM STR from \'" << str << "\'" << endl;
		int size = str.size();
		cout << "size : " << size << endl;
		int length = str.length();
		cout << "length : " << length << endl;
		if(str[x]){
			cout << "char at " << x << " : " << str[x] << endl;
		}
		cout << "clear it ? y/n" << endl;
		cout << ">>> ";
		string in;
		cin >> in;
		if(in.size() == 1){
			if(in[0] != 'y'){
				return errorReturned(endinfo);
			}
			in.clear();
			cout << "Had been cleared successfully." << endl;
			cout << endinfo;
			return 0;
		}
		return errorReturned(endinfo);
	}
}

namespace convint{
	// conversion string -> int
	int strToInt(const string str){
		if(!(regex_match(str, regex("([0-9])*")))){
			return errorReturned(str);
		}
		istringstream awn(str);
		int N(0);
		awn >> N;
		return N;
	}

	// conversion int -> string
	string intToStr(const int x){
		ostringstream awn;
		awn << x;
		string N = awn.str();
		return N;
	}
}

namespace convdouble{
	// conversion string -> double
	double strToDbl(const string str){
		if(!(regex_match(str, regex("([0-9])*.([0-9])*")))){
			return errorReturned(str);
		}
		istringstream awn(str);
		double N(0);
		awn >> N;
		return N;
	}

	// conversion double -> string
	string dblToStr(const double x){
		ostringstream awn;
		awn << x;
		string N = awn.str();
		return N;
	}
}

namespace convlong{
	// conversion string -> long int
	long int strToLongInt(const string str){
		if(!(regex_match(str, regex("([0-9])*")))){
			return errorReturned(str);
		}
		istringstream awn(str);
		int N(0);
		awn >> N;
		return N;
	}

	// conversion long int -> string
	string longIntToStr(const long int x){
		ostringstream awn;
		awn << x;
		string N = awn.str();
		return N;
	}

	// conversion string -> long double
	long double strToLongDbl(const string str){
		if(!(regex_match(str, regex("([0-9])*.([0-9])*")))){
			return errorReturned(str);
		}
		istringstream awn(str);
		double N(0);
		awn >> N;
		return N;
	}

	// conversion long double -> string
	string longDblToStr(const long double x){
		ostringstream awn;
		awn << x;
		string N = awn.str();
		return N;
	}
}

namespace ascii{
	// no function yet here...
}

namespace convnb{
	using namespace convint;
	using namespace convdouble;
}

namespace nba{
	using namespace convnb;
	using namespace ascii;
}

namespace convall{
	using namespace convinfo;
	using namespace convint;
	using namespace convdouble;
	using namespace convlong;
	using namespace ascii;
}

#endif // end CONVSTR_H