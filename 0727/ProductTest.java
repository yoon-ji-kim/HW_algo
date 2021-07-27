package hw05;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgr mgr = new ProductMgr();
		
		mgr.add(new TV("TV123", "Neo QLED 8K", 18000000, 6, 84, "QLED"));
		mgr.add(new TV("TV456", "Neo LED", 8000000, 3, 55, "LED"));
		mgr.add(new Refrigerator("freeze12", "BESPOKE", 4490000, 3,850));
		mgr.add(new Refrigerator("freeze34", "BESPOKE", 4490000, 1,850));
	
		System.out.println("상품 전체 정보 ");
		for(Product product: mgr.getList()) {
			System.out.println(product);
		}
		System.out.println("상품 번호로 상품 검색");
		System.out.println(mgr.searchBypNum("TV123"));
		System.out.println("상품명으로 상품 검색");
		for(Product product: mgr.searchBypName("Neo")) {
			System.out.println(product);
		}
		System.out.println("TV 정보만 검색");
		for(Product product: mgr.getTVs()) {
			System.out.println(product);
		}
		System.out.println("Refrigerator 정보 만 검색");
		for(Product product: mgr.getFridge()) {
			System.out.println(product);
		}
		System.out.println("freeze34 삭제 전 가격 합계");
		System.out.println(mgr.getTotalPrice());
		mgr.remove("freeze34");
		System.out.println("상품 전체 정보 ");
		for(Product product: mgr.getList()) {
			System.out.println(product);
		}
		System.out.println("freeze34 삭제 후 가격 합계");
		System.out.println(mgr.getTotalPrice());
		
	}
}
