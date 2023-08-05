package review1;

public class Order {
	String menuName;
	int count;
	int orderPrice;
	
	public Order (String menuName, int count, int price) {
		this.menuName=menuName;
		this.count=count;
		setOrderPrice(price);
	}

	private void setOrderPrice(int price) {
		orderPrice = price * count;
		System.out.println(orderPrice+"���Դϴ�. ");
	}
	
	public int getOrderPrice(int price) {
		return this.orderPrice;
	}
	
	public boolean runOrder (int deposit) {
		// �Ա� �ݾ��� �ֹ� �ݾ׺��� ũ�� �ܵ� ���/ ������ �ݾ� ���� ���
		if (deposit >= orderPrice) {
			int change = deposit - orderPrice;
			System.out.println("�ܵ� "+change+"���� "+menuName+" ���Խ��ϴ�. ");
			return true;
		} else {
			System.out.println("�ݾ��� �����մϴ�. ");
			return false;
		}
	}



}
