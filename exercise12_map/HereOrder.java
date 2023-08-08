package exercise12_map;

import java.util.List;
import java.util.Queue;

public class HereOrder extends Order {
	int orderNum;
	OnHere onHere;
	
	// 인터페이스 생성
	public interface OnHere {
		abstract public void successHere(int orderNum, List<Menu> menuL);
		abstract public void waitingHere (int orderNum, List<Menu> menuL);
	}
	
	// 생성자 생성
	public HereOrder (List<Menu> menuL) {
		super(menuL);
	}
	
	public void setOnHere (OnHere onHere) {
		this.onHere = onHere;
	}
	
	// 주문번호 메소드 생성
	public void setOrderNum (int orderNum) {
		this.orderNum = orderNum;
		System.out.println(orderNum+" 주문번호로 주문 완료 되었습니다. ");
	}
	
	public void setOrderPrice(List<Menu> menuL) {
		super.setOrderPrice(menuL);
		System.out.println(orderPrice+"원 입니다.");
	}

	@Override
	public boolean runOrder (int deposit, List<Menu> menuL, Queue<Order> waitL) {
		if (deposit >= orderPrice) {
			onHere.successHere(orderNum, menuL);
			return true;
		} else {
			System.out.println("금액이 부족합니다. ");
			return false;
		}
	}
	
	@Override
	public void orderwaiting(List<Menu> menuL, Queue<Order> waitL) {
		onHere.waitingHere(orderNum, menuL);
	}

	
	
	
	
}
