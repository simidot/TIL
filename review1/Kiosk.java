package review1;

public class Kiosk {
	static final int key = 3;
	int inventory; 
	int deposit;

	
	public Kiosk (int inventory) {
		this.inventory = inventory;
	}
	
	public boolean isInventory(int count) {
		if (inventory>=count) {
			return true;
		} else {
			System.out.println("재고가 부족합니다. ");
			return false;
		}
	}
	
	public void subInventory(int count) {
		inventory -= count;
	}
	
	// Order 타입으로 반환하여 주문으로 들어갈 수 있도록 함.(리턴 타입이 있으므로 무조건 return something 해야함)
	public Order initOrder(String menuName, int count) {
		// 메뉴의 가격 설정
		int price = 0;
		
		if (menuName.equals("딸기요거트")) {
			price = 4500;
		} else if (menuName.equals("카페라떼")||menuName.equals("밀크티")) {
			price = 3500;
		} else if (menuName.equals("아메리카노")) {
			price = 2000;
		} else {
			price = 0;
			System.out.println("메뉴가 없습니다. ");
		}
		
		// 메뉴가 없을 때 null 반환
		if (price==0) {
			return null;
		}
		
		// 재고가 있으면 Order인스턴스 생성 & 총가격 출력 & 재고개수 변경
		// 재고 없으면 재고부족 메시지 출력 & null반환
		if (isInventory(count)) {
			Order order = new Order(menuName, count, price);
			return order;
		} else {
			return null;
		}
	}
	
	

}
