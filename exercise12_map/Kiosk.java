package exercise12_map;

import java.util.List;
import java.util.TreeMap;

import exercise12_map.DeliveryOrder.OnDelivery;
import exercise12_map.HereOrder.OnHere;
import exercise12_map.TakeoutOrder.OnTakeout;

public class Kiosk implements OnDelivery, OnHere, OnTakeout {
	int inventory;
	
	static TreeMap<String, Integer> mpriceMap;
	TreeMap<String, Integer> minventoryMap;
	
	
	// 키오스크 생성자 생성
	public Kiosk (int inventory) {
		this.inventory = inventory;
		// 메뉴이름-가격 Map
		mpriceMap = new TreeMap<String, Integer>();
		mpriceMap.put("딸기요거트", 4500);
		mpriceMap.put("카페라떼", 3500);
		mpriceMap.put("밀크티", 3500);
		mpriceMap.put("아메리카노", 2000);

		// 메뉴이름-재고개수 Map
		minventoryMap = new TreeMap<String, Integer>();
		minventoryMap.put("딸기요거트", inventory);
		minventoryMap.put("카페라떼", inventory);
		minventoryMap.put("밀크티", inventory);
		minventoryMap.put("아메리카노", inventory);
	}
	
	
	public Menu initMenu (String menuName, int count) throws KioskException {
		if (mpriceMap.containsKey(menuName)) {
			int price = mpriceMap.get(menuName);
			Menu menu = new Menu(menuName, count, price);
			return menu;
		} else {
			throw new KioskException("메뉴가 없습니다.", 102);
		}
		
	}
	
	
	// initOrder 메소드 생성
	public Order initOrder (List<Menu> menuL, int howToOrder) throws KioskException {
		// 재고 있을 시 주문방식에 따라 다르게 인스턴스 생성.
		if(isInventory(menuL)) {
			if (howToOrder == 1) {
				DeliveryOrder order = new DeliveryOrder(menuL);
				order.setOnDelivery(this);
				return order;
			} else if (howToOrder==2) {
				TakeoutOrder order = new TakeoutOrder(menuL);
				order.setOnTakeout(this);
				return order;
			} else if (howToOrder==3) {
				HereOrder order = new HereOrder(menuL);
				order.setOnHere(this);
				return order;
			} else {
				throw new KioskException("주문 방식이 올바르지 않습니다. ", 103);
			}
		} else {
			throw new KioskException("재고가 없습니다.", 101);
		}
	}
	
	// 재고확인 메소드 생성
	public boolean isInventory (List<Menu> menuL) {
		for (Menu i : menuL) {
			if (minventoryMap.get(i.menuName)>=i.count) {
			return true;
			} else {return false;}
		} return true;
	}
	
	// 재고 수정 메소드 생성
	public void subInventory (List<Menu> menuL) {
		for (Menu i : menuL) {
				minventoryMap.replace(i.menuName, (minventoryMap.get(i.menuName) - i.count));
		}
		System.out.println("현재 재고상황: "+minventoryMap.toString());
	}
	
	// 주문완료 
	@Override
	public void successDelivery(String locate, List<Menu> menuL) {
		System.out.println("주문 내역------------------");
		for (Menu m : menuL) {
			System.out.println(m.menuName +" "+ m.count+"개");
		}
		System.out.println("-----------------------");
	}

	@Override
	public void waitingDelivery (String locate, List<Menu> menuL) {
		System.out.println("----------------------");
		System.out.println("주문하신 "+menuL.size()+"개 메뉴");
		System.out.println(locate+" 주소로 배달이 시작되었습니다.");
		System.out.println("----------------------");	
	}
	

	@Override
	public void successHere(int orderNum, List<Menu> menuL) {
		System.out.println("주문 내역------------------");
		for (Menu m : menuL) {
			System.out.println(m.menuName +" "+ m.count+"개");
		}
		System.out.println("-----------------------");
	}
	
	public void waitingHere (int orderNum, List<Menu> menuL) {
		System.out.println("----------------------");
		System.out.println("주문하신 "+menuL.size()+"개 메뉴");
		System.out.println(orderNum+" 번호 주문 메뉴 나왔습니다. ");	
	}
	
	@Override
	public void successTakeout(int time, List<Menu> menuL ) {
		System.out.println("주문 내역------------------");
		for (Menu m : menuL) {
			System.out.println(m.menuName +" "+ m.count+"개");
		}
		System.out.println("-----------------------");
	}
	
	public void waitingTakeout (int time, List<Menu> menuL) {
		System.out.println("----------------------");
		System.out.println("주문하신 "+menuL.size()+"개 메뉴");
		System.out.println(time+"분 지나 포장 주문 나왔습니다. ");	
	}




}