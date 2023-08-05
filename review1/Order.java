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
		System.out.println(orderPrice+"원입니다. ");
	}
	
	public int getOrderPrice(int price) {
		return this.orderPrice;
	}
	
	public boolean runOrder (int deposit) {
		// 입금 금액이 주문 금액보다 크면 잔돈 출력/ 적으면 금액 부족 출력
		if (deposit >= orderPrice) {
			int change = deposit - orderPrice;
			System.out.println("잔돈 "+change+"원과 "+menuName+" 나왔습니다. ");
			return true;
		} else {
			System.out.println("금액이 부족합니다. ");
			return false;
		}
	}



}
