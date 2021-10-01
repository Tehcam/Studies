class TestPoint
{
	public static void main(String[] args)
	{
		PointCartesien p1 = new PointCartesien();
		PointCartesien p2 = new PointCartesien(p1);

		System.out.println("Coord. de p1 : " + p1.getX() + "," + p1.getY());
		System.out.println("Coord. de p2 : " + p2.getX() + "," + p2.getY());
		p1.setX(5.2); p2.setY(4.3);
		p1.translation(1, 1);
		p1.afficher();
		p2.afficher();
		System.out.println(p1.distanceALOrigine());

		PointPolaire p3 = new PointPolaire();
		PointPolaire p4 = new PointPolaire(p3);

		System.out.println("Coord. de p3 : " + p3.getAbs() + "," + p3.getTeta());
		System.out.println("Coord. de p4 : " + p4.getAbs() + "," + p4.getTeta());
		p3.setAbs(4); p4.setTeta(90);
		p3.afficher();
		p4.afficher();
		p4.setTeta(370);
		p4.afficher();
		p4.setTeta(-90);
		p4.afficher();
		p3.translation(1, 1);
		p3.afficher();
		System.out.println(p3.distanceALOrigine());
	}
}