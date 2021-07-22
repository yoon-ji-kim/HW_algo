package hw04;

public class ProductTest {

	public static void main(String[] args) {
		/* 공통 정보로는 제품번호, 제품명, 가격 정보, 재고수량이 있으며
		 * 추가 정보로 TV는 인치, 디스플레이 타입 정보를 냉장고는 용량 정보를 가지고 있다
		 * - Constructor, Encapsulation, toString() 적용
		 * - 각 기능들을 테스트 할 수 있는 Test 클래스
		 */
		TV tv = new TV("TV123", "Neo QLED 8K", 18000000, 6, 84, "QLED");
		Refrigerator fridge = new Refrigerator("freeze12", "BESPOKE", 4490000, 3,850);
		
		System.out.println(tv.toString());
		System.out.println(fridge.toString());
	}

}
