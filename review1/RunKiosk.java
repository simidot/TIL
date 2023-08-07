package review1;

import java.util.Scanner;

public class RunKiosk {

	public static void main(String[] args) {
		// Scanner 메소드 사용
		Scanner scanner = new Scanner(System.in);
		
		// 키오스크 키 입력
		System.out.println("키오스크 키를 입력해주세요. ");
		int key = scanner.nextInt();
		
		// 키오스크 키가 일치하면 다음 단계 진행
		if (key==Kiosk.key) {	
			// 매장 재고개수 입력받기
			System.out.println("매장 재고개수를 입력해주세요. ");
			int inventory = scanner.nextInt();
			
			Kiosk kiosk = new Kiosk(inventory);

			while(true) {
				// 주문방식 입력받기
				System.out.println("1. 배달 2. 포장 3. 매장 4. 종료 주문방식 번호를 입력해주세요. ");
				int orderHow = scanner.nextInt();
				
				// 종료 입력받으면 바로 종료(while문 빠져나오기)
				if (orderHow==4) {
					System.out.println("프로그램을 종료합니다. ");
					break;
				}		
				
				// 메뉴와 개수 입력받기
				System.out.println("메뉴와 개수를 입력해주세요. ");
				String menuName = scanner.next();
				int count = scanner.nextInt();
				
				Order order = kiosk.initOrder(menuName, count, orderHow);
				
				// order 반환이 null이면 다음 단계 지나치기.
				if (order== null) {
					continue;
				}
				
				// 입금 가격 입력받기
				int deposit = scanner.nextInt();
				
				// 주문방식 입력에 따라 다른 입력값 받기/ 메소드 사용
				if (orderHow==1) {
					System.out.println("주소를 입력해주세요. ");
					String locate = scanner.next();
					((DeliveryOrder) order).setLocate(locate);
				} else if (orderHow==2) {
					System.out.println("포장시간을 입력해주세요. ");
					int time = scanner.nextInt();
					((TakeoutOrder) order).setTime(time);
				} else if (orderHow==3) {
					System.out.println("주문번호를 입력해주세요. ");
					int orderNum = scanner.nextInt();
					((HereOrder) order).setOrderNum(orderNum);
				} else {
					System.out.println("주문방식을 확인해주세요.");
				}
				
				// 입금 가격 비교 메소드 사용
				if (order.runOrder(deposit)) {
					// 입금이 잘 되면 true이므로 그때 재고개수 변경
					kiosk.subInventory(count);
				}
			}
		} // 키오스크 키가 일치하지 않으면 다음 단계 진행X
		else {
			System.out.println("키오스크 키가 맞지 않습니다.");
		} scanner.close(); //스캐너 닫기
		
		
		
	}
}
