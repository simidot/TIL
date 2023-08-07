package review1;

public class DeliveryOrder extends Order {
	String locate;
	OnDelivery onDelivery;

	public DeliveryOrder(String menuName, int count, int price) {
		super(menuName, count, price);
	}
	
	public interface OnDelivery {
		public void successDelivery(String locate, String menuName);
	}
	
	public void setOnDelivery (OnDelivery onDelivery) {
		this.onDelivery = onDelivery;
	}
	
	
	@Override
	protected void setOrderPrice(int price) {
		orderPrice = price * count;
		orderPrice = orderPrice + 3000;
		System.out.println("배달비 3000원 추가되어 "+orderPrice+"원입니다. ");
		System.out.println("배달 주문은 정확한 금액을 결제해주세요. ");
	}
	
	void setLocate(String locate) {
		this.locate = locate;
	}
	
	@Override
	// 입금 금액 확인 메소드
	public boolean runOrder (int deposit) {
		// 입금 금액이 주문 금액보다 크면 잔돈 출력/ 적으면 금액 부족 출력
		if (deposit == orderPrice) {
			onDelivery.successDelivery(locate, menuName);
			return true;
		} else {
			System.out.println("정확한 금액을 결제해주세요. ");
			return false;
		}
	}	

}
