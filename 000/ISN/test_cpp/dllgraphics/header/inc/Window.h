#ifndef WINDOW_H_
#define WINDOW_H_

#include <string>
#include <graphics.h>

int const _WHITE = COLOR(255, 255, 255);
int const _BLACK = COLOR(0, 0, 0);
int const _SIDE_SQUARE = 20;

// define class : Window
class Window
{
	public:
		Window(std::string const& title, int side, int defbgcolor); // constructor
		// ~Window(); // destructor
		int getm_color(int color) const;
		bool close();

	private:
		int m_side;
		int m_color;
		
}; // class end : Window

std::string errorstrmsg;
void operator<<(Window const& a, std::string& b);
int callmsg(); // to test the lib

#endif // end WINDOW_H_