package review1;

public abstract class Order {
	String menuName;
	int count;
	int orderPrice;
	
	// Order 생성자
	public Order (String menuName, int count, int price) {
		this.menuName=menuName;
		this.count=count;
		setOrderPrice(price);
	}

	protected void setOrderPrice(int price) {
		orderPrice = price * count;
		System.out.println(orderPrice+"원입니다. ");
	}
	
	public int getOrderPrice(int price) {
		return this.orderPrice;
	}
	
	// 입금 금액 확인 메소드
	public abstract boolean runOrder (int deposit);




}
