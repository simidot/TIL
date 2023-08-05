package review1;

public class HereOrder extends Order {
	int orderNum;

	public HereOrder(String menuName, int count, int price) {
		super(menuName, count, price);
	}
	
	void setOrderNum (int orderNum) {
		this.orderNum = orderNum;
	}

	@Override
	// 입금 금액 확인 메소드
	public boolean runOrder (int deposit) {
		// 입금 금액이 주문 금액보다 크면 잔돈 출력/ 적으면 금액 부족 출력
		if (deposit >= orderPrice) {
			int change = deposit - orderPrice;
			System.out.println("잔돈 "+change+"원입니다. ");
			System.out.println(orderNum+" 주문번호로 "+menuName+" 매장 주문이 완료되었습니다. ");
			return true;
		} else {
			System.out.println("금액이 부족합니다. ");
			return false;
		}
	}

}
