package review1;

import java.util.Scanner;

public class RunKiosk {

	public static void main(String[] args) {
		// Scanner �޼ҵ� ���
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			// ����� ���� �Է¹ޱ�
			System.out.println("����� ���� �Է�");
			String menu = scanner.next();
			
			// ���� �Է½ÿ� while�� ����
			if (menu.equals("����")) {
				System.out.println("���α׷� ����");
				break;
			}
			
			// �޴� ���� ����
			int price =0;
			if (menu.equals("������Ʈ")) {
				price = 4500;
			} else if (menu.equals("ī���")||menu.equals("��ũƼ")) {
				price = 3500;
			} else if (menu.equals("�Ƹ޸�ī��")) {
				price = 2000; 
			} else {
				// �޴��� ���� ���� ���� 0���� ����
				price = 0;
				System.out.println("�޴��� �����ϴ�. ");
			}
			// �޴� �Է� ���� �ÿ� ���� �Է¹����� �ٷ� while�� �����ؾ� �ϱ� ������ count scanner�� �� �ķ� ����.	
			int count = scanner.nextInt();

		
			int orderPrice = 0;
			// ������ 0�� �ƴҶ� (�޴��� ���� ��) �� ���� ����ϱ�
			if (price!=0) {
				orderPrice = price * count;
				System.out.println("�� ������ "+orderPrice+"���Դϴ�.");
				// �Ա� �ݾ� �Է¹ޱ�
				int deposit = scanner.nextInt();
				// �Ա� �ݾ��� �ֹ� �ݾ׺��� ũ�� �ܵ� ���/ ������ �ݾ� ���� ���
				if(deposit>=orderPrice) {
					int change = deposit - price;
					System.out.println("�ܵ� "+change+"���Դϴ�.");
					for (int i=0; i<count; i++) {
						System.out.println(menu+" ���Խ��ϴ�.");
					}
				} else {
					System.out.println("�ݾ��� �����մϴ�. ");
				}
			} 
		}	
	}
}
