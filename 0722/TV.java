package hw04;

public class TV extends Product {
	private double inch;
	private String type;
	
	public TV(String num, String name, int p, int st,double inch, String type) {
		super(num, name, p, st);
		
		this.inch = inch;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return super.toString() + " TV [인치= " + inch + "인치, 디스플레이 타입 =" + type + "]";
	}
	
}