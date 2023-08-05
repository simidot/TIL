package review1;

public class Kiosk {
	static final int key = 3;
	int inventory; 
	int deposit;

	
	public Kiosk (int inventory) {
		this.inventory = inventory;
	}
	
	public boolean isInventory(int count) {
		if (inventory>=count) {
			return true;
		} else {
			System.out.println("��� �����մϴ�. ");
			return false;
		}
	}
	
	public void subInventory(int count) {
		inventory -= count;
	}
	
	// Order Ÿ������ ��ȯ�Ͽ� �ֹ����� �� �� �ֵ��� ��.(���� Ÿ���� �����Ƿ� ������ return something �ؾ���)
	public Order initOrder(String menuName, int count) {
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
		
		// ��� ������ Order�ν��Ͻ� ���� & �Ѱ��� ��� & ����� ����
		// ��� ������ ������ �޽��� ��� & null��ȯ
		if (isInventory(count)) {
			Order order = new Order(menuName, count, price);
			return order;
		} else {
			return null;
		}
	}
	
	

}
