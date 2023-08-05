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
				// 메뉴와 개수 입력받기
				System.out.println("메뉴와 개수를 입력해주세요. ");
				String menuName = scanner.next();
			
				// 종료 입력받으면 바로 종료(while문 빠져나오기)
				if (menuName.equals("종료")) {
					System.out.println("프로그램을 종료합니다. ");
					break;
				}
				// 메뉴 입력 받을 시에 종료 입력받으면 바로 while문 종료해야 하기 때문에 count scanner는 그 후로 지정.
				int count = scanner.nextInt();
				Order order = kiosk.initOrder(menuName, count);
				
				// order 반환이 null이면 다음 단계 지나치기.
				if (order== null) {
						continue;
				}
				
				// 입금 가격 입력받기
				int deposit = scanner.nextInt();
					
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
