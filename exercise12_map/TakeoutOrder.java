package exercise12_map;

import java.util.List;
import java.util.Queue;

public class TakeoutOrder extends Order {
	int time;
	OnTakeout onTakeout;
	
	// OnTakeout 인터페이스 생성
	public interface OnTakeout {
		abstract public void successTakeout(int time, List<Menu> menuL);
		abstract public void waitingTakeout(int time, List<Menu> menuL);

	}
	
	// 생성자 생성
	public TakeoutOrder (List<Menu> menuL) {
		super(menuL);
	}
	
	
	public void setOnTakeout (OnTakeout onTakeout) {
		this.onTakeout = onTakeout;
	}
	
	// runOrder() boolean
	@Override
	public boolean runOrder (int deposit, List<Menu> menuL, Queue<Order> waitL) {
		if (deposit >= orderPrice) {
			System.out.println("잔돈 "+(deposit-orderPrice)+"원 입니다.");
			onTakeout.successTakeout(time, menuL);
			return true;
		} else {
			System.out.println("금액이 부족합니다. ");
			return false;
		}
	}
	
	// setTime() void
	public void setTime(int time) {
		this.time = time;
		System.out.println(time+"분 뒤 포장주문 완료되었습니다. ");
	}
	
	// setOrderPrice() void
	@Override
	public void setOrderPrice(List<Menu> menuL) {
		super.setOrderPrice(menuL);
		orderPrice = orderPrice -500;
		System.out.println("테이크 아웃은 500원 할인되어 "+orderPrice+"원 입니다.");
	}


	@Override
	public void orderwaiting(List<Menu> menuL, Queue<Order> waitL) {
		onTakeout.waitingTakeout(time, menuL);
	}

}
