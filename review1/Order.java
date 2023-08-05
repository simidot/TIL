package review1;

public class Order {
	String menuName;
	int count;
	int orderPrice;
	
	// Order ������
	public Order (String menuName, int count, int price) {
		this.menuName=menuName;
		this.count=count;
		setOrderPrice(price);
	}

	protected void setOrderPrice(int price) {
		orderPrice = price * count;
		System.out.println(orderPrice+"���Դϴ�. ");
	}
	
	public int getOrderPrice(int price) {
		return this.orderPrice;
	}
	
	// �Ա� �ݾ� Ȯ�� �޼ҵ�
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
