/**********************************************/
//		Sprod-CMachet
//		Test
//		Description
/**********************************************/

#include <convstr.h>

using namespace nba;


int main(){
	// INIT_ASCII_NS();
	string in("&");
	// cin >> in;
	cout << "result = " << toAscii(in) << endl << endl;
	helpAscii();

	char QUIT;
	cout << "press \\ to quit :" << endl;
	while(QUIT != toAscii("BACK_S")){
		cin >> QUIT;
	}

	return showAscii(in);
}
// end // Test