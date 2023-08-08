package exercise12_map;

import java.util.List;
import java.util.Queue;

public class DeliveryOrder extends Order {
	String locate;
	OnDelivery onDelivery;
	
	public interface OnDelivery {
		abstract public void successDelivery(String locate, List<Menu> menuL);
		abstract public void waitingDelivery(String locate, List<Menu> menuL);
	}
	
	public DeliveryOrder (List<Menu> menuL) {
		super(menuL);
	}
	
	public void setOnDelivery (OnDelivery onDelivery) {
		this.onDelivery = onDelivery;
	}
	
	public void setLocate(String locate) {
		this.locate = locate;
	}
	
	@Override
	public void setOrderPrice(List<Menu> menuL) {
		super.setOrderPrice(menuL);
		orderPrice = orderPrice + 3000;
		System.out.println("배달비 3000원 추가되어 "+orderPrice+"원 입니다.");
		System.out.println("배달 주문은 정확한 금액을 결제해주세요.");
	}

	@Override
	public boolean runOrder (int deposit, List<Menu> menuL, Queue<Order> waitL) {
		if (deposit == orderPrice) {
			onDelivery.successDelivery(locate, menuL);
			return true;
		} else {
			System.out.println("정확한 금액을 결제해주세요. ");
			return false;
		}
	}
	
	@Override
	public void orderwaiting(List<Menu> menuL, Queue<Order> waitL) {
		onDelivery.waitingDelivery(locate, menuL);
	}

	

}
