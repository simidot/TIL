package review1;

public class Kiosk {
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
			System.out.println("��� �����մϴ�. ");
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
			System.out.println("�޴��� �����ϴ�. ");
		}
		
		// �޴��� ���� �� null ��ȯ
		if (price==0) {
			return null;
		}
		
		if (isInventory(count)) {
			if (orderHow ==1) {
				Order order = new DeliveryOrder(menuName, count, price);
			return order;
			} else if (orderHow==2) {
				Order order = new TakeoutOrder(menuName, count, price);
				return order;
			} else if (orderHow==3) {
				Order order = new HereOrder(menuName, count, price);
				return order;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
