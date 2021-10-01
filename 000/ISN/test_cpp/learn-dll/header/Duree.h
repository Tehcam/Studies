#ifndef DUREE_H
#define DUREE_H

// define class : Duree
class Duree
{
	public:
		Duree(int hour = 0, int min = 0, int sec = 0); // constructor
		// ~Duree(); // destructor
		bool equial(Duree const& b) const;
		bool smaller(Duree const& b) const;

	private:
		int m_hour;
		int m_min;
		int m_sec;

}; // class end : Duree

bool operator==(Duree const& a, Duree const& b);
bool operator!=(Duree const& a, Duree const& b);
bool operator<(Duree const& a, Duree const& b);
bool operator<=(Duree const& a, Duree const& b);
bool operator>(Duree const& a, Duree const& b);
bool operator>=(Duree const& a, Duree const& b);

#endif // end DUREE_H