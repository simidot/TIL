package review1;

import java.util.Scanner;

public class RunKiosk {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� �޴� �Է�");
		String menu = scanner.next();
		int price =0;

		if (menu.equals("������Ʈ")) {
			price = 4500;
		} else if (menu.equals("ī���")||menu.equals("��ũƼ")) {
			price = 3500;
		} else if (menu.equals("�Ƹ޸�ī��")) {
			price = 2000;
		} else {
			price = 0;
			System.out.println("�޴��� �����ϴ�. ");
		}
		
		System.out.println(menu+"�� "+price+"���Դϴ�.");
		int deposit = scanner.nextInt();
		
		if(deposit>=price) {
			int change = deposit - price;
			System.out.println("�ܵ� "+change+"���Դϴ�.");
		} else {
			System.out.println("�ݾ��� �����մϴ�. ");
		}
		
	}

}
