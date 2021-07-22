package hw04;

class Product {
	private String pNum;  //제품번호
	private String pName; //제품이름
	private int price;    //가격
	private int stock;      //재고
	
	public Product(String Num, String Name, int p, int st){
		this.pNum = Num;
		this.pName = Name;
		this.price = p;
		this.stock = st;
	}
	
	@Override
	public String toString() {
		return "Product [제품번호 = " + pNum+ ", 제품명= " + pName + ", 가격= " + price+"원, 재고수량= " + stock + "]";
	}
}


