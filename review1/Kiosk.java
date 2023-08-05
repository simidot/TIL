package review1;

public class Kiosk {
	// 필드 생성 
	static final int key = 3;
	int inventory; 

	// 생성자 생성
	public Kiosk (int inventory) {
		this.inventory = inventory;
	}
	
	// 재고확인 메소드
	public boolean isInventory(int count) {
		if (inventory>=count) {
			return true;
		} else {
			System.out.println("재고가 부족합니다. ");
			return false;
		}
	}
	
	// 재고 개수 변경 메소드
	public void subInventory(int count) {
		inventory -= count;
	}
	
	
	// 주문 메소드
	// Order 타입으로 반환하여 주문으로 들어갈 수 있도록 함.(리턴 타입이 있으므로 무조건 return something 해야함)
	public Order initOrder(String menuName, int count, int orderHow) {
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
		
		if (isInventory(count)) {
			if (orderHow ==1) {
				Order order = new DeliveryOrder(menuName, count, price);
			return order;
			} else if (orderHow==2) {
				Order order = new TakeoutOrder(menuName, count, price);
				return order;
			} else if (orderHow==3) {
				Order order = new HereOrder(menuName, count, price);
				return order;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
