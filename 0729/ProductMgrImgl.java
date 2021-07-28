package hw07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductMgrImgl implements IProductMgr {
	private List<Product>products = new ArrayList<>(10); //상품을 ArrayList를 이용하여 관리

	private static IProductMgr instance = new ProductMgrImgl();
	private ProductMgrImgl() { }
	public static IProductMgr getInstance() {
		return instance;
	}
	
	private int findIndex(String pNum) {			//상품 번호가 동일하면 상품번호  저장된 index 리턴, 아니면 -1 리턴
		if(pNum != null) {
			for (int i = 0, size = products.size(); i< size; i++) {
				if(pNum.equals(products.get(i).getpNum())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public void add(Product product) {			//상품 등록
		if(product !=null) {					
			String pNum = product.getpNum();
			if(pNum != null) {
				int findex = findIndex(product.getpNum());
				if(findex==-1) {
						products.add(product);
				} else {
					System.err.println("이미 등록된 상품번호입니다.");
				}
			}else {
				System.err.println("상품 번호를 등록하세요.");
			}
		}else {
			System.err.println("상품정보 등록을 확인해주세요.");
		}
	}
	
	//상품정보 전체를 검색하는 기능
	public Product[] getList() { //배열 복사 , 원본 배열과 같은 타입의 복사된 새로운 배열을 반환 , 값에 의한 복사로 복사된 배열에서 값을 바꿔도 원본 배열 값 바뀌지 않음
		Product[] temp = new Product[products.size()];
		return products.toArray(temp);
	}
	
	//상품번호로 상품을 검색하는 기능
	public Product searchBypNum(String pNum) {
		int index = findIndex(pNum);		//상품번호 저장된 인덱스
		if(index == -1) {
			System.err.println(String.format("pnum %s번의 상품을 찾을 수 없습니다.", pNum));
			return null;
		} else {
			return products.get(index);		
		}
	}
	
	//상품명으로 상품을 검색하는 기능
	public Product[] searchBypName(String pName) {
		if(pName != null) {
			ArrayList<Product> temp = new ArrayList<Product>(10);
			pName = pName.toUpperCase();		//pname 문자열을 모두 대문자로 변환하여 저장
			for(Product product: products) {
				if(product.getpName().toUpperCase().contains(pName)) {		//문자열에 특정 문자열이 포함되어 있는지 확인
					temp.add(product);
				}
			}
			Product[] result = new Product[temp.size()];
			return temp.toArray(result);
		} else {													//pName이  null일때
			System.err.println(String.format("찾는 상품명이 없습니다. 다시 확인해주세요.", pName));
			return null;
		}
	}
	
	//TV정보만 검색
	public Product[] getTVs() {
		ArrayList<Product> temp = new ArrayList<>(10);
		for (Product product : products) {
			if(product instanceof TV) {		// instanceof를 이용하여 객체 타입 확인
				temp.add(product);
			}
		}
		TV[] result = new TV[temp.size()];
		return temp.toArray(result);
	}
	
	//Refrigerator만 검색
	public Product[] getFridge() {
		ArrayList<Product> temp = new ArrayList<>(10);
		for (Product product : products) {
			if(!(product instanceof TV)) {		//TV와 반대
				temp.add(product);
			}
		}
		Refrigerator[] result = new Refrigerator[temp.size()];
		return temp.toArray(result);
	}
	
	//400L이상의 Refrigerator 검색-------
	public Product[] getFridgeL() {
		ArrayList<Product> temp = new ArrayList<>(10);
		for (Product product : products) {
			if(!(product instanceof TV) && ((Refrigerator) product).getL()>= 500) {		//TV와 반대
				temp.add(product);
			}
		}
		Refrigerator[] result = new Refrigerator[temp.size()];
		return temp.toArray(result);
	}
	
	//50inch 이상의 티비를 검색-------
		public Product[] getTVinch() {
			ArrayList<Product> temp = new ArrayList<>(10);
			for (Product product : products) {
				if(product instanceof TV && ((TV) product).getInch()>= 50) {		// instanceof를 이용하여 객체 타입 확인
					temp.add(product);
				}
			}
			TV[] result = new TV[temp.size()];
			return temp.toArray(result);
		}
		/*//상품번호와 가격으로 가격변경하는 기능
	public void priceChange(String pNum, int p) {
		int findex = findIndex(pNum) ;
		if(findex == -1) {
			System.err.println("상품 번호를 찾을 수 없습니다. 다시 한번 확인해주세요.");
		} else {
			products.set(findex, p);
		}
	}
	*/
		
	//상품번호로 상품을 삭제하는 기능
	public void remove(String pNum) {
		int findex = findIndex(pNum);
		if(findex == -1) {
			System.err.println("삭제할 상품을 찾지 못했습니다.");
		} else {
			products.remove(findex);
		}
	}
	//전체 재고 상품 금액을 구하는 기능
	public int getTotalPrice() {
		int total =0;
		for (Product product : products) {
			total += product.getPrice();
		}
		return total;
	}
}
