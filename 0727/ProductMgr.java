package hw05;

import java.util.Arrays;

public class ProductMgr {
	private Product[] products;  //상품을 배열로 관리
	private final int MAX= 15;
	private int index;
	public ProductMgr () {
		products = new Product[MAX];
	}
	
	private int Index(String pNum) {			//상품 번호가 동일하면 상품번호  저장된 index 리턴, 아니면 -1 리턴
		if(pNum != null) {
			for (int i = 0; i < index; i++) {
				if(pNum.equals(products[i].getpNum())) {
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
				int findex = Index(product.getpNum());
				if(findex==-1) {
					if(index>=products.length) {
						System.err.println("더이상 저장할 공간이 없습니다. ");
					}else {
						products[index++] = product;
					}
				}
			}else {
				System.err.println("상품 번호를 등록하세요.");
			}
		}else {
			System.err.println("상품정보 등록을 확인해주세요.");
		}
	}
	
	//상품정보 전체를 검색하는 기능
	public Product[] getList() { 						//배열 복사 , 원본 배열과 같은 타입의 복사된 새로운 배열을 반환 , 값에 의한 복사로 복사된 배열에서 값을 바꿔도 원본 배열 값 바뀌지 않음
		return Arrays.copyOfRange(products, 0, index);
	}
	
	//상품번호로 상품을 검색하는 기능
	public Product searchBypNum(String pNum) {
		int index = Index(pNum);		//상품번호 저장된 인덱스
		if(index == -1) {
			System.err.println(String.format("pnum %s번의 상품을 찾을 수 없습니다.", pNum));
			return null;
		} else {
			return products[index];		
		}
	}
	
	//상품명으로 상품을 검색하는 기능
	public Product[] searchBypName(String pName) {
		if(pName != null) {
			Product[] findProduct = new Product[index];	
			int findex =0;
			pName = pName.toUpperCase();		//pname 문자열을 모두 대문자로 변환하여 저장
			for(int i=0; i<index; i++) {
				if(products[i].getpName().toUpperCase().contains(pName)) {		//문자열에 특정 문자열이 포함되어 있는지 확인
					findProduct[findex++] = products[i];
				}
			}
			return Arrays.copyOfRange(findProduct, 0, findex);
		} else {													//pName이  null일때
			System.err.println(String.format("찾는 상품명이 없습니다. 다시 확인해주세요.", pName));
			return null;
		}
	}
	
	//TV정보만 검색
	public Product[] getTVs() {
		Product[] TVs = new Product[index];
		int gIndex =0;
		for (int i = 0; i < index; i++) {
			if(products[i] instanceof TV) {		// instanceof를 이용하여 객체 타입 확인
				TVs[gIndex++] = products[i];
			}
		}
		return Arrays.copyOfRange(TVs, 0, gIndex);
	}
	//Refrigerator만 검색
	public Product[] getFridge() {
		Product[] fridge = new Product[index];
		int gIndex =0;
		for (int i = 0; i < index; i++) {
			if(!(products[i] instanceof TV)) {		//TV와 반대
				fridge[gIndex++] = products[i];
			}
		}
		return Arrays.copyOfRange(fridge, 0, gIndex);
	}
	//상품번호로 상품을 삭제하는 기능
	public void remove(String pNum) {
		int pindex = Index(pNum);
		if(pindex == -1) {
			System.err.println("삭제할 상품을 찾지 못했습니다.");
		} else {
			products[pindex] = products[--pindex];
		}
	}
	//전체 재고 상품 금액을 구하는 기능
	public int getTotalPrice() {
		int total =0;
		for (int i = 0; i < index; i++) {
			total += products[i].getPrice();
		}
		return total;
	}
}
