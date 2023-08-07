package review1;

public class TakeoutOrder extends Order {
	int time;
	OnTakeout onTakeout;

	public TakeoutOrder(String menuName, int count, int price) {
		super(menuName, count, price);
	}
	
	public interface OnTakeout {
		public void successTakeout (int time, String menuName);
	}
	
	public void setOnTakeout (OnTakeout onTakeout) {
		this.onTakeout = onTakeout;
	}
	
	@Override
	protected void setOrderPrice(int price) {
		orderPrice = price * count;
		orderPrice = orderPrice - 500;
		System.out.println("테이크 아웃은 500원 할인되어 "+orderPrice+"원입니다. ");
	}
	
	void setTime (int time) {
		this.time = time;
	}

	@Override
	// 입금 금액 확인 메소드
	public boolean runOrder (int deposit) {
		// 입금 금액이 주문 금액보다 크면 잔돈 출력/ 적으면 금액 부족 출력
		if (deposit >= orderPrice) {
			int change = deposit - orderPrice;
			System.out.println("잔돈 "+change+"원입니다. ");
			onTakeout.successTakeout(time, menuName);
			return true;
		} else {
			System.out.println("금액이 부족합니다. ");
			return false;
		}
	}	

}
