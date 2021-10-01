/********************************************
TEST LIB GRAPHICS
CORENTIN
05/04/2020
********************************************/

#include <iostream>
#include <string>
#include <graphics.h>
// #include <winbgim.h>
using namespace std;

char QUIT='a';

int main()
{
    initwindow(400, 400, "First Sample");
    setbkcolor(COLOR(0, 100, 250));
    setcolor(COLOR(250, 250, 250));
    circle(100, 50, 30);
    cout << "ceci est un cercle";
    cout << "press q to quit" << endl;
    while (QUIT != 'q')
    {
        cin >> QUIT;
    }
    return 0;
}
