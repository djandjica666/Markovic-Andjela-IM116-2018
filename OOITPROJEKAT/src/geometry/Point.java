package geometry;

public class Point {
	// OBELEZJA
	private int x;
	private int y; 
	private boolean selected;
	
	// KONSTRUKTORI - metode koje se nazivaju isto kao i klase, sluze za kreiranje objekata te klase u zavisnosti od parametara koje mi prosledimo
	public Point () {
		
	}
	public Point (int x , int y) { 
		this.x = x;
		this.y = y;
	}
	public Point (int x , int y , boolean selected) {
		this.x = x;
		this.y = y;
		this.selected = selected;
	}
	
	// METODE koje su karakteristicne za ovu klasu
	public double distance (int x , int y) {
		int dx = this.x - x;
		int dy = this.y - y;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
	}
	
	// OVERRIDE toString - "pregaziti" metode koje se nalaze u klasi object kako bismo u konzoli dobili ispis koji nam odgovara bez hashtagova
	@Override
	public String toString () {
		return "(" + x + "," + y + ")";
	}
	// EQUALS - poredjenje vrednosti dva objekta
	@Override 
	public boolean equals (Object obj) {
		if (obj instanceof Point) {
			Point temp = (Point) obj;
			if (x == temp.x && y == temp.y) {
				return true;
			}
		}
		return false;
	}
	
	//GETTERI & SETTERI - metode koje se koriste za dobijanje vrednosti obelezja , odnosno za njihovo setovanje tj. postavljanje
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
