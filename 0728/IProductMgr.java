package hw07;

public interface IProductMgr {
	void add(Product product);
	Product[] getList();
	Product searchBypNum(String pNum);
	Product[] searchBypName(String pName);
	Product[] getTVs();
	Product[] getFridge();
	Product[] getFridgeL();
	Product[] getTVinch();
	//상품번호와 가격을 입력 받아 상품 가격 변경
	void remove(String pNum);
	int getTotalPrice();
	void priceChange(String pNum, int p);
}
