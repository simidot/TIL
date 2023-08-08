package exercise12_map;

import java.util.List;
import java.util.Queue;

public class TakeoutOrder extends Order {
	int time;
	OnTakeout onTakeout;
	
	// OnTakeout �������̽� ����
	public interface OnTakeout {
		abstract public void successTakeout(int time, List<Menu> menuL);
		abstract public void waitingTakeout(int time, List<Menu> menuL);

	}
	
	// ������ ����
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
			System.out.println("�ܵ� "+(deposit-orderPrice)+"�� �Դϴ�.");
			onTakeout.successTakeout(time, menuL);
			return true;
		} else {
			System.out.println("�ݾ��� �����մϴ�. ");
			return false;
		}
	}
	
	// setTime() void
	public void setTime(int time) {
		this.time = time;
		System.out.println(time+"�� �� �����ֹ� �Ϸ�Ǿ����ϴ�. ");
	}
	
	// setOrderPrice() void
	@Override
	public void setOrderPrice(List<Menu> menuL) {
		super.setOrderPrice(menuL);
		orderPrice = orderPrice -500;
		System.out.println("����ũ �ƿ��� 500�� ���εǾ� "+orderPrice+"�� �Դϴ�.");
	}


	@Override
	public void orderwaiting(List<Menu> menuL, Queue<Order> waitL) {
		onTakeout.waitingTakeout(time, menuL);
	}

}
