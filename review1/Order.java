package review1;

public abstract class Order {
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
	public abstract boolean runOrder (int deposit);




}
