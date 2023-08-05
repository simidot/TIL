package review1;

import java.util.Scanner;

public class RunKiosk {

	public static void main(String[] args) {
		// Scanner �޼ҵ� ���
		Scanner scanner = new Scanner(System.in);
		
		// Ű����ũ Ű �Է�
		System.out.println("Ű����ũ Ű�� �Է����ּ���. ");
		int key = scanner.nextInt();
		
		// Ű����ũ Ű�� ��ġ�ϸ� ���� �ܰ� ����
		if (key==Kiosk.key) {
			// ���� ����� �Է¹ޱ�
			System.out.println("���� ������� �Է����ּ���. ");
			int inventory = scanner.nextInt();
			
			Kiosk kiosk = new Kiosk(inventory);
			
			while(true) {
				// �޴��� ���� �Է¹ޱ�
				System.out.println("�޴��� ������ �Է����ּ���. ");
				String menuName = scanner.next();
			
				// ���� �Է¹����� �ٷ� ����(while�� ����������)
				if (menuName.equals("����")) {
					System.out.println("���α׷��� �����մϴ�. ");
					break;
				}
				// �޴� �Է� ���� �ÿ� ���� �Է¹����� �ٷ� while�� �����ؾ� �ϱ� ������ count scanner�� �� �ķ� ����.
				int count = scanner.nextInt();
				Order order = kiosk.initOrder(menuName, count);
				
				// order ��ȯ�� null�̸� ���� �ܰ� ����ġ��.
				if (order== null) {
						continue;
				}
				
				// �Ա� ���� �Է¹ޱ�
				int deposit = scanner.nextInt();
					
				// �Ա� ���� �� �޼ҵ� ���
				if (order.runOrder(deposit)) {
					// �Ա��� �� �Ǹ� true�̹Ƿ� �׶� ����� ����
					kiosk.subInventory(count);
				}
			}
		} // Ű����ũ Ű�� ��ġ���� ������ ���� �ܰ� ����X
		else {
			System.out.println("Ű����ũ Ű�� ���� �ʽ��ϴ�.");
		} scanner.close(); //��ĳ�� �ݱ�
		
		
		
	}
}
