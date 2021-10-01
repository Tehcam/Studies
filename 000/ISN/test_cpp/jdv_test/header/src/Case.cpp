/**********************************************/
//		Sprod-CMachet
//		Case
//		
/**********************************************/

#include "../include/Case.hpp"
#include <convstr.h> // A inclure dans le compilateur !
#include <iostream>
using namespace std;

Conditions setConditions()
{
	Conditions RETURNED;
	string M = "";

	cout << "ENTRER LES CONDITIONS DE L'EXECUTION :" << endl;
	cout << endl;
	cout << "Nombre de colonnes ?" << endl;
	cout << ">>> ";
	cin >> M;
	if(convint::strToInt(M)) RETURNED.X = convint::strToInt(M);
	else RETURNED.X = 1;
	M = "";
	cout << "Nombre de lignes ?" << endl;
	cout << ">>> ";
	cin >> M;
	if(convint::strToInt(M)) RETURNED.Y = convint::strToInt(M);
	else RETURNED.Y = 1;
	M = "";
	cout << "Nombre de generations ?" << endl;
	cout << ">>> ";
	cin >> M;
	if(convint::strToInt(M)) RETURNED.G = convint::strToInt(M);
	else RETURNED.G = 1;

	return RETURNED;
}

int xtoa(int x)
{
	int a = x / (C+1);
	return a;
}

int atox(int a)
{
    int x = a * (C+1);
    return x;
}

Case::Case(): m_pres = 0, m_color = _BLC
{
}

int Case::is_Pres(Case const& a) const
{
	// du code...
}

int Case::compte(const Case* ptr) const
{
    int n_one_x, n_one_y;
    int n_two_x, n_two_y;
    int n_three_x, n_three_y;
    int n_four_x, n_four_y;

    int N = 0;

    n_one_x = m_x;
    n_one_y = m_y - (C+1);
    if(n_one_y >= 0){
        N =+ *ptr[xtoa(n_one_x)][xtoa(n_one_y)].getPres();
    }

    n_two_x = m_x + (C+1);
    n_two_y = m_y;
    if(n_two_x < m_l){
        N =+ *ptr[xtoa(n_two_x)][xtoa(n_two_y)].getPres();
    }

    n_three_x = m_x;
    n_three_y = m_y + (C+1);
    if(n_three_x < m_h){
        N =+ *ptr[xtoa(n_three_x)][xtoa(n_three_y)].getPres();
    }

    n_four_x = m_x - (C+1);
    n_four_y = m_y;
    if(n_four_x >= 0){
        N =+ *ptr[xtoa(n_four_x)][xtoa(n_four_y)].getPres();
    }

    return N;
}

void Case::colorie(bool const& start) const
{
	// du code...
}

int Case::getPres() const
{
    return m_pres;
}

int Case::getColor() const
{
	return m_color;
}

int Case::getx_Pos() const
{
    return m_x;
}

int Case::gety_Pos() const
{
    return m_y;
}

int get_l() const
{
    return m_l;
}

int get_h() const
{
    return m_h;
}

void setLH(int const& l, int const& h)
{
    m_l = l;
    m_h = h;
}

void Case::setPres(int const& a)
{
	m_pres = a;
}

void Case::setColor(int const& c)
{
	m_color = c;
}

void Case::setPosition(int const& x, int const& y)
{
    m_x = x;
    m_y = y;
}

void JeuDeLaVie()
{
	Condition _SET = setConditions();
	int _L = (C+1) * _SET.X;
	int _H = (C+1) * _SET.Y;

	Case TabCase[_SET.X][_SET.Y];
    Case *TabRef(0);
    TabRef = &TabCase;
	initwindow(_L, _H, "Jeu de la Vie");
	setbkcolor(_BLC);

    /* Init TabCase */
    for(int k=0; k<_SET.Y; k++)
    {
        for(int j=0; j<_SET.X; j++)
        {
            TabCase[j][k].setPosition(atox(j), atox(k));
            TabCase[j][k].setLH(_L, _H);
        }
    }

    /* Afficher Colonnes */
    for(int j=0, k=C; j<_H; j++)
    {
        k=C;
        while(k<_L)
        {
            putpixel(k, j, _NOIR);
            k += C+1;
        }
    }

    /* Afficher Lignes */
    for(int k=0, j=C; k<_L; k++)
    {
        j=C;
        while(j<_H)
        {
            putpixel(k, j, _NOIR);
            j += C+1;
        }
    }

    /* Initialisation */
    char ENTER = 'a';
    int x, y, w, z;
    while(ENTER != ' ')
    {
        if(ismouseclick(WM_LBUTTONDOWN))
        {
            getmouseclick(WM_LBUTTONDOWN, w, z);
            x = w-(w%(C+1));
            y = z-(z%(C+1));

            if(TabCase[xtoa(x)][xtoa(y)].getColor == _BLC){
            	TabCase[xtoa(x)][xtoa(y)].setPres(1);
            	TabCase[xtoa(x)][xtoa(y)].setColor(_NOIR);
            	TabCase[xtoa(x)][xtoa(y)].colorie(true);
            }

            if(TabCase[xtoa(x)][xtoa(y)].getColor == _NOIR){
            	TabCase[xtoa(x)][xtoa(y)].setPres(0);
            	TabCase[xtoa(x)][xtoa(y)].setColor(_BLC);
            	TabCase[xtoa(x)][xtoa(y)].colorie(true);
            }
        }

        if(kbhit()){
            ENTER = getch();
        }
    }

    StartRender = true;
    int g=0;

    while(g<_SET.G)
    {
        // du code...
    }
}

