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
				// �ֹ���� �Է¹ޱ�
				System.out.println("1. ��� 2. ���� 3. ���� 4. ���� �ֹ���� ��ȣ�� �Է����ּ���. ");
				int orderHow = scanner.nextInt();
				
				// ���� �Է¹����� �ٷ� ����(while�� ����������)
				if (orderHow==4) {
					System.out.println("���α׷��� �����մϴ�. ");
					break;
				}		
				
				// �޴��� ���� �Է¹ޱ�
				System.out.println("�޴��� ������ �Է����ּ���. ");
				String menuName = scanner.next();
				int count = scanner.nextInt();
				
				Order order = kiosk.initOrder(menuName, count, orderHow);
				
				// order ��ȯ�� null�̸� ���� �ܰ� ����ġ��.
				if (order== null) {
					continue;
				}
				
				// �Ա� ���� �Է¹ޱ�
				int deposit = scanner.nextInt();
				
				// �ֹ���� �Է¿� ���� �ٸ� �Է°� �ޱ�/ �޼ҵ� ���
				if (orderHow==1) {
					System.out.println("�ּҸ� �Է����ּ���. ");
					String locate = scanner.next();
					((DeliveryOrder) order).setLocate(locate);
				} else if (orderHow==2) {
					System.out.println("����ð��� �Է����ּ���. ");
					int time = scanner.nextInt();
					((TakeoutOrder) order).setTime(time);
				} else if (orderHow==3) {
					System.out.println("�ֹ���ȣ�� �Է����ּ���. ");
					int orderNum = scanner.nextInt();
					((HereOrder) order).setOrderNum(orderNum);
				} else {
					System.out.println("�ֹ������ Ȯ�����ּ���.");
				}
				
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
