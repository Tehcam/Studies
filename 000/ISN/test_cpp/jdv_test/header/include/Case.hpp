#ifndef CASE_CLASS_H_
#define CASE_CLASS_H_

#include <graphics.h>
#include <string>

/* CLASS DEFINITION */
class Case
{
	public:
		Case(); // constructor
		int is_Pres(Case const& a) const;
		int compte(const Case* ptr) const;
		void colorie(bool const& start) const;

		int getPres() const;
		int getColor() const;
		int getx_Pos() const;
		int gety_Pos() const;

		int get_l() const;
		int get_h() const;
		void setLH(int const& l, int const& h);

		void setPres(int const& a);
		void setColor(int const& c);
		void setPosition(int const& x, int const& y);

	private:
		int m_x, m_y;
		int m_l, m_h;
		int m_pres;
		int m_color;

}; // Case

struct Conditions
{
	int X, Y;
	int G;
}; // Conditions

/* FUNCTION DEFINITIONS */
void JeuDeLaVie();
Conditions setConditions();
int xtoa(int x);
int atox(int a);

/* VARIABLES */
bool StartRender;
int const _NOIR = COLOR(0, 0, 0);
int const _BLC = COLOR(255, 255, 255);
int const C = 20;

#endif // CASE_CLASS_H_