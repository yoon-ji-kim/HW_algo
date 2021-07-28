package hw07;

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
		
	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [제품번호 = " + pNum+ ", 제품명= " + pName + ", 가격= " + price+"원, 재고수량= " + stock + "]";
	}
}


