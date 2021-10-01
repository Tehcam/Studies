#include "../inc/Window.h"
// #include <graphics.h>
#include <iostream>
using namespace std;

Window::Window(string const& title, int side = 10, int defbgcolor = _WHITE): m_side(side * _SIDE_SQUARE), m_color(_BLACK)
{
	if(!initwindow(m_side, m_side, title.c_str())){
		errorstrmsg = "can not open a graphic window.";
		throw errorstrmsg;
	}
	setbkcolor(defbgcolor);
}

void operator<<(Window const& a, string& b)
{
	char outchar[b.size()];
	for(int i=0; i<b.size(); i++){
		outchar[i] = b[i];
	}
	outtext(outchar);
}

int Window::getm_color(int color = 0) const
{
	if(color == 0){return m_color;}
	else{return color;}
}

bool Window::close()
{
	delay(1500);
	closegraph();
	return true;
}

int callmsg()
{
	try{
		string shw("Hello world !"), winname("MYWIN");
		Window myWin(winname);
		setcolor(myWin.getm_color());
		myWin << shw;
		errorstrmsg = "can not close the window.";
		if(myWin.close()){return 0;}
		else{throw errorstrmsg;}
	}

	catch(string const& msg){
		std::cout << msg << endl;
		std::cout << "program ends." << endl;
		return 0;
	}
}

