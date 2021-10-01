class Personne
{
	private String nom, prenom, civilite;
	private int age;
	private double taille, poids;

	public Personne(String civilite, String nom, String prenom, int age, double taille, double poids)
	{
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.age = 0;
		if(age > 0 && age < 150) this.age = age;
		this.taille = 0.30;
		if(taille > 0.30 && taille <= 2.50) this.taille = taille;
		this.poids = 1;
		if(poids > 1 && poids <= 130) this.poids = poids;
	}

	public Personne()
	{
		this("Indefini", "", "", 0, 0.3, 1);
	}

	public String getNom()
	{
		return nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public String getCivilite()
	{
		return civilite;
	}

	public int getAge()
	{
		return age;
	}

	public double getTaille()
	{
		return taille;
	}

	public double getPoids()
	{
		return poids;
	}

	public void setTaille(double taille)
	{
		if(taille > 0.30 && taille <= 2.50) this.taille = taille;
	}

	public void setPoids(double poids)
	{
		if(poids > 1 && poids <= 130) this.poids = poids;
	}

	public void vieillir()
	{
		age++;
	}

	public double IMC()
	{
		return poids / (taille*taille);
	}

	public void interpreter()
	{
		String rep;
		double imc = IMC();
		if(imc <= 16.5) rep = "denutrition";
		else if(imc > 16.5 && imc <= 18.5) rep = "maigreur";
		else if (imc > 18.5 && imc <= 25) rep = "corpulence normale";
		else if(imc > 25 && imc <= 30) rep = "surpoids";
		else if(imc > 30 && imc <= 35) rep = "obesite moderee";
		else if(imc > 35 && imc <= 40) rep = "obesite severe";
		else rep = "obesite morbide";
		System.out.println(rep);
	}

	public String toString()
	{
		return civilite + " " + prenom + " " + nom + " : " + age + " an(s), " + taille + "m, " + poids + "kg.";
	}

	public void afficher()
	{
		System.out.println(this);
	}
}