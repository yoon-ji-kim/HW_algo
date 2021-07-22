package hw04;

public class Refrigerator extends Product {
	private int L;
	
	public Refrigerator(String Num, String Name, int p, int st, int L) {
		super(Num, Name, p, st);
		this.L = L;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Refrigerator [용량 = " + L + "]";
	}
}
