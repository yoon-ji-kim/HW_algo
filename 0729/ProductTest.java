package hw07;

public class ProductTest {

	public static void main(String[] args) {
		IProductMgr productMgr = ProductMgrImgl.getInstance();
		
		productMgr.add(new TV("TV123", "Neo QLED 8K", 18000000, 6, 84, "QLED"));
		productMgr.add(new TV("TV456", "Neo LED", 8000000, 3, 55, "LED"));
		productMgr.add(new Refrigerator("freeze12", "BESPOKE", 4490000, 3,850));
		productMgr.add(new Refrigerator("freeze34", "BESPOKE", 4490000, 1,350));
		
		System.out.println("**********************상품 전체 정보**********************");
		for(Product p: productMgr.getList()) {
			System.out.println(p);
		}
		System.out.println("**********************상품 번호로 상품 검색**********************");
		for(Product p: productMgr.searchBypName("TV456")) {
			System.out.println(p);
		}
		System.out.println("**********************상품명로 상품 검색**********************");
		for(Product product: productMgr.searchBypName("Neo")) {
			System.out.println(product);
		}
		System.out.println("**********************TV 정보만 검색**********************");
		for(Product product: productMgr.getTVs()) {
			System.out.println(product);
		}
		System.out.println("**********************Refrigerator 정보 만 검색**********************");
		for(Product product: productMgr.getFridge()) {
			System.out.println(product);
		}
		System.out.println("**********************400L 이상Refrigerator 정보 만 검색**********************");
		for(Product p: productMgr.getFridgeL()) {
			System.out.println(p);
		}
		System.out.println("**********************50inch 이상 TV 정보 만 검색**********************");
		for(Product p: productMgr.getTVinch()) {
			System.out.println(p);
		}

		//System.out.println("**********************상품번호와 가격으로 가격을 변경**********************");
		//productMgr.priceChange("freeze34", 2000000);
		
		System.out.println("**********************TV123 삭제 전 가격 합계**********************");
		System.out.println(productMgr.getTotalPrice());
		productMgr.remove("TV123");
		
		System.out.println("**********************상품 전체 정보**********************");
		for(Product p: productMgr.getList()) {
			System.out.println(p);
		}
		System.out.println("**********************TV123 삭제 후 가격 합계**********************");
		System.out.println(productMgr.getTotalPrice());
	}
}
