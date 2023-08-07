package review1;

import review1.DeliveryOrder.OnDelivery;
import review1.HereOrder.OnHere;
import review1.TakeoutOrder.OnTakeout;

public class Kiosk implements OnDelivery, OnTakeout, OnHere {
	// �ʵ� ���� 
	static final int key = 3;
	int inventory; 

	// ������ ����
	public Kiosk (int inventory) {
		this.inventory = inventory;
	}
	
	// ���Ȯ�� �޼ҵ�
	public boolean isInventory(int count) {
		if (inventory>=count) {
			return true;
		} else {
			return false;
		}
	}
	
	// ��� ���� ���� �޼ҵ�
	public void subInventory(int count) {
		inventory -= count;
	}
	
	
	// �ֹ� �޼ҵ�
	// Order Ÿ������ ��ȯ�Ͽ� �ֹ����� �� �� �ֵ��� ��.(���� Ÿ���� �����Ƿ� ������ return something �ؾ���)
	public Order initOrder(String menuName, int count, int orderHow) {
		// �޴��� ���� ����
		int price = 0;
		
		if (menuName.equals("������Ʈ")) {
			price = 4500;
		} else if (menuName.equals("ī���")||menuName.equals("��ũƼ")) {
			price = 3500;
		} else if (menuName.equals("�Ƹ޸�ī��")) {
			price = 2000;
		} else {
			price = 0;
		}
		
		// �޴��� ���� �� null ��ȯ
		if (price==0) {
			System.out.println("�޴��� �����ϴ�. ");
			return null;
		}
		
		if (isInventory(count)) {
			if (orderHow ==1) {
				DeliveryOrder order = new DeliveryOrder(menuName, count, price);
				((DeliveryOrder) order).setOnDelivery(this);
				return order;
			} else if (orderHow==2) {
				Order order = new TakeoutOrder(menuName, count, price);
				((TakeoutOrder) order).setOnTakeout(this);
				return order;
			} else if (orderHow==3) {
				Order order = new HereOrder(menuName, count, price);
				((HereOrder) order).setOnHere(this);
				return order;
			} else {
				return null;
			}
		} else {
			System.out.println("��� �����մϴ�. ");
			return null;
		}
	}
	
	@Override
	public void successDelivery(String locate, String menuName) {
		System.out.println(locate+" �ַμ� "+menuName+" ��� �ֹ��� �Ϸ�Ǿ����ϴ�. ");
	}
	
	@Override
	public void successTakeout(int time, String menuName) {
		System.out.println(time +"�� �� ���� �ֹ��� �Ϸ�Ǿ����ϴ�. ");

	}
	
	@Override
	public void successHere(int orderNum, String menuName) {
		System.out.println(orderNum+" �ֹ���ȣ�� "+menuName+" ���� �ֹ��� �Ϸ�Ǿ����ϴ�. ");
	}

	

	
}
