package exercise12_map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class RunKiosk {

	public static void main(String[] args) throws KioskException {
		Scanner scanner = new Scanner(System.in);
		
		// 키오스크에 재고 입력
		System.out.println("재고개수를 입력해주세요. ");
		int inventory = scanner.nextInt();
		
		// 키오스크 인스턴스 생성
		Kiosk kiosk = new Kiosk(inventory);
		Queue<Order> waitL = new LinkedList<Order>();
		
		System.out.println(kiosk.minventoryMap.toString());
		
		while(true) {
			// 주문 방식 입력 
			System.out.println("1. 배달 2. 포장 3. 매장 4. 종료 주문방식 번호를 입력해주세요.");
			int howToOrder = scanner.nextInt();
			// 종료 설정
			if (howToOrder==4 ) {
				System.out.println("프로그램을 종료합니다. ");
				break;
			}
			
			// 메뉴 타입의 메뉴 리스트 초기화
			List<Menu> menuL = new ArrayList<Menu>();

			try {
				for (int i=0; i<10; i++) {
					// 메뉴 또는 주문 입력
					System.out.println("<메뉴 개수> 또는 <주문>을 입력해주세요. ");
				
					// 메뉴와 개수 입력받기
					String menuName = scanner.next();
					
					
					
					// 주문 입력하면 주문 생성
					if (menuName.equals("주문")) {
						break;
					}	
					int count = scanner.nextInt();
					
					//initMenu 메소드를 통해 Menu클래스의 인스턴스 만들고 반환.
					menuL.add(kiosk.initMenu(menuName, count));
				} 
				
				Order order = null;
				order = kiosk.initOrder(menuL, howToOrder);
				if (order == null ) {
					continue;
				}
			
				int deposit = scanner.nextInt();

					// 주문방식에 따라 주문 인스턴스 생성
					if (howToOrder == 1) {
						System.out.println("주소를 입력해주세요. ");
						String locate = scanner.next();
						((DeliveryOrder) order).setLocate(locate);
					} else if (howToOrder == 2) {
						System.out.println("포장시간을 입력해주세요.");
						int time = scanner.nextInt();
						((TakeoutOrder) order).setTime(time);
					} else if (howToOrder == 3) {
						System.out.println("주문번호를 입력해주세요. ");
						int orderNum = scanner.nextInt();
						((HereOrder) order).setOrderNum(orderNum);
					}
				
					if (order.runOrder(deposit, menuL, waitL)) {
						kiosk.subInventory(menuL);
						waitL.offer(order);

						if (waitL.size() >=3) {
							Order order1 = waitL.poll();
							order1.orderwaiting(menuL, waitL);
						}
					}
				
			} catch (KioskException e) {
				System.out.println(e.getMessage());
				System.out.println("error code: "+e.code);
			}
		}
		scanner.close();
	} 
}

