package exercise12_map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class RunKiosk {

	public static void main(String[] args) throws KioskException {
		Scanner scanner = new Scanner(System.in);
		
		// Ű����ũ�� ��� �Է�
		System.out.println("������� �Է����ּ���. ");
		int inventory = scanner.nextInt();
		
		// Ű����ũ �ν��Ͻ� ����
		Kiosk kiosk = new Kiosk(inventory);
		Queue<Order> waitL = new LinkedList<Order>();
		
		System.out.println(kiosk.minventoryMap.toString());
		
		while(true) {
			// �ֹ� ��� �Է� 
			System.out.println("1. ��� 2. ���� 3. ���� 4. ���� �ֹ���� ��ȣ�� �Է����ּ���.");
			int howToOrder = scanner.nextInt();
			// ���� ����
			if (howToOrder==4 ) {
				System.out.println("���α׷��� �����մϴ�. ");
				break;
			}
			
			// �޴� Ÿ���� �޴� ����Ʈ �ʱ�ȭ
			List<Menu> menuL = new ArrayList<Menu>();

			try {
				for (int i=0; i<10; i++) {
					// �޴� �Ǵ� �ֹ� �Է�
					System.out.println("<�޴� ����> �Ǵ� <�ֹ�>�� �Է����ּ���. ");
				
					// �޴��� ���� �Է¹ޱ�
					String menuName = scanner.next();
					
					
					
					// �ֹ� �Է��ϸ� �ֹ� ����
					if (menuName.equals("�ֹ�")) {
						break;
					}	
					int count = scanner.nextInt();
					
					//initMenu �޼ҵ带 ���� MenuŬ������ �ν��Ͻ� ����� ��ȯ.
					menuL.add(kiosk.initMenu(menuName, count));
				} 
				
				Order order = null;
				order = kiosk.initOrder(menuL, howToOrder);
				if (order == null ) {
					continue;
				}
			
				int deposit = scanner.nextInt();

					// �ֹ���Ŀ� ���� �ֹ� �ν��Ͻ� ����
					if (howToOrder == 1) {
						System.out.println("�ּҸ� �Է����ּ���. ");
						String locate = scanner.next();
						((DeliveryOrder) order).setLocate(locate);
					} else if (howToOrder == 2) {
						System.out.println("����ð��� �Է����ּ���.");
						int time = scanner.nextInt();
						((TakeoutOrder) order).setTime(time);
					} else if (howToOrder == 3) {
						System.out.println("�ֹ���ȣ�� �Է����ּ���. ");
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

