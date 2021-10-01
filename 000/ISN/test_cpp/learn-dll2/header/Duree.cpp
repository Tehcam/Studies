#include "Duree.h"

Duree::Duree(int hour, int min, int sec):m_hour(hour), m_min(min), m_sec(sec)
{
	if(m_sec >= 60){
		int rest_sec = m_sec % 60;
		m_min += (m_sec - rest_sec)/60;
		m_sec = rest_sec;
	}

	if(m_min >= 60){
		int rest_min = m_min % 60;
		m_hour += (m_min - rest_min)/60;
		m_min = rest_min;
	}
}

bool Duree::equial(Duree const& b) const
{
	return (m_hour == b.m_hour and m_min == b.m_min and m_sec == b.m_sec);
}

bool operator==(Duree const& a, Duree const& b)
{
	return a.equial(b);
}

bool operator!=(Duree const& a, Duree const& b)
{
	return !(a == b);
}

bool Duree::smaller(Duree const& b) const
{
	if(m_hour < b.m_hour){
		return true;
	}else if(m_hour == b.m_hour){
		if(m_min < b.m_min){
			return true;
		}else if(m_min == b.m_min){
			if(m_sec < b.m_sec){
				return true;
			}
			return false;
		}else{
			return false;
		}
	}else{
		return false;
	}
}

bool operator<(Duree const& a, Duree const& b)
{
	return a.smaller(b);
}

bool operator<=(Duree const& a, Duree const& b)
{
	if(a == b or a < b){
		return true;
	}
	return false;
}

bool operator>(Duree const& a, Duree const& b)
{
	if(!(a <= b)){
		return true;
	}
	return false;
}

bool operator>=(Duree const& a, Duree const& b)
{
	if(a == b or a > b){
		return true;
	}
	return false;
}