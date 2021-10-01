class Date
{
	private int day;
	private int month;
	private int year;

	public Date()
	{
		this.day = 1;
		this.month = 1;
		this.year = 2021;
	}

	public Date(int day, int month, int year)
	{
		this.day = day;
		this.month	= month;
		this.year = year;
		if(!estValide()) corrige();
	}

	public int getDay()
	{
		return day;
	}

	public int getMonth()
	{
		return month;
	}

	public int getYear()
	{
		return year;
	}

	public void setDay(int day)
	{
		this.day = day;
		if(!estValide()) corrige();
	}

	public void setMonth(int month)
	{
		this.month = month;
		if(!estValide()) corrige();
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public boolean estBissextile()
	{
		return (this.year%4 == 0 && this.year%100 != 0) || (this.year%400 == 0);
	}

	public int nbJours()
	{
		int n;
		if(this.month != 2)
		{
			if(this.month < 8)
			{
				if(this.month%2 == 0) n = 30;
				else n = 31;
			}
			else
			{
				if(this.month%2 == 0) n = 31;
				else n = 30;
			}
		}
		else
		{
			if(estBissextile()) n = 29;
			else n = 28;
		}
		return n;
	}

	public boolean estValide()
	{
		return (this.month > 0 && this.month <= 12) && (this.day > 0 && this.day <= nbJours());
	}

	// corrige() est une méthode privée car ce n'est pas à l'utilisateur
	// de corriger une date qu'il a lui même entrée : cela doit être 
	// automatique.
	private void corrige()
	{
		if(this.month < 1 || this.month > 12) this.month = 1;
		if(this.day < 1 || this.day > nbJours()) this.day = 1;
	}

	public String toString()
	{
		return day + "/" + month + "/" + year;
	}

	public void afficher()
	{
		System.out.println(this);
	}
}