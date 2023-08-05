package review1;

import java.util.Scanner;

public class RunKiosk {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("음료 메뉴 입력");
		String menu = scanner.next();
		int price =0;

		if (menu.equals("딸기요거트")) {
			price = 4500;
		} else if (menu.equals("카페라떼")||menu.equals("밀크티")) {
			price = 3500;
		} else if (menu.equals("아메리카노")) {
			price = 2000;
		} else {
			price = 0;
			System.out.println("메뉴가 없습니다. ");
		}
		
		System.out.println(menu+"는 "+price+"원입니다.");
		int deposit = scanner.nextInt();
		
		if(deposit>=price) {
			int change = deposit - price;
			System.out.println("잔돈 "+change+"원입니다.");
		} else {
			System.out.println("금액이 부족합니다. ");
		}
		
	}

}
