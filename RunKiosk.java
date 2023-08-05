package review1;

import java.util.Scanner;

public class RunKiosk {

	public static void main(String[] args) {
		// Scanner 메소드 사용
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			// 음료와 개수 입력받기
			System.out.println("음료와 개수 입력");
			String menu = scanner.next();
			
			// 종료 입력시에 while문 종료
			if (menu.equals("종료")) {
				System.out.println("프로그램 종료");
				break;
			}
			
			// 메뉴 가격 설정
			int price =0;
			if (menu.equals("딸기요거트")) {
				price = 4500;
			} else if (menu.equals("카페라떼")||menu.equals("밀크티")) {
				price = 3500;
			} else if (menu.equals("아메리카노")) {
				price = 2000; 
			} else {
				// 메뉴가 없을 때는 가격 0으로 설정
				price = 0;
				System.out.println("메뉴가 없습니다. ");
			}
			// 메뉴 입력 받을 시에 종료 입력받으면 바로 while문 종료해야 하기 때문에 count scanner는 그 후로 지정.	
			int count = scanner.nextInt();

		
			int orderPrice = 0;
			// 가격이 0이 아닐때 (메뉴가 있을 때) 총 가격 출력하기
			if (price!=0) {
				orderPrice = price * count;
				System.out.println("총 가격은 "+orderPrice+"원입니다.");
				// 입금 금액 입력받기
				int deposit = scanner.nextInt();
				// 입금 금액이 주문 금액보다 크면 잔돈 출력/ 적으면 금액 부족 출력
				if(deposit>=orderPrice) {
					int change = deposit - price;
					System.out.println("잔돈 "+change+"원입니다.");
					for (int i=0; i<count; i++) {
						System.out.println(menu+" 나왔습니다.");
					}
				} else {
					System.out.println("금액이 부족합니다. ");
				}
			} 
		}	
	}
}
