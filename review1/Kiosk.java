package review1;

import review1.DeliveryOrder.OnDelivery;
import review1.HereOrder.OnHere;
import review1.TakeoutOrder.OnTakeout;

public class Kiosk implements OnDelivery, OnTakeout, OnHere {
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
		}
		
		// 메뉴가 없을 때 null 반환
		if (price==0) {
			System.out.println("메뉴가 없습니다. ");
			return null;
		}
		
		if (isInventory(count)) {
			if (orderHow ==1) {
				DeliveryOrder order = new DeliveryOrder(menuName, count, price);
				((DeliveryOrder) order).setOnDelivery(this);
				return order;
			} else if (orderHow==2) {
				Order order = new TakeoutOrder(menuName, count, price);
				((TakeoutOrder) order).setOnTakeout(this);
				return order;
			} else if (orderHow==3) {
				Order order = new HereOrder(menuName, count, price);
				((HereOrder) order).setOnHere(this);
				return order;
			} else {
				return null;
			}
		} else {
			System.out.println("재고가 부족합니다. ");
			return null;
		}
	}
	
	@Override
	public void successDelivery(String locate, String menuName) {
		System.out.println(locate+" 주로소 "+menuName+" 배달 주문이 완료되었습니다. ");
	}
	
	@Override
	public void successTakeout(int time, String menuName) {
		System.out.println(time +"분 후 포장 주문이 완료되었습니다. ");

	}
	
	@Override
	public void successHere(int orderNum, String menuName) {
		System.out.println(orderNum+" 주문번호로 "+menuName+" 매장 주문이 완료되었습니다. ");
	}

	

	
}
