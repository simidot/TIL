package exercise12_map;

import java.util.List;
import java.util.Queue;

public class HereOrder extends Order {
	int orderNum;
	OnHere onHere;
	
	// �������̽� ����
	public interface OnHere {
		abstract public void successHere(int orderNum, List<Menu> menuL);
		abstract public void waitingHere (int orderNum, List<Menu> menuL);
	}
	
	// ������ ����
	public HereOrder (List<Menu> menuL) {
		super(menuL);
	}
	
	public void setOnHere (OnHere onHere) {
		this.onHere = onHere;
	}
	
	// �ֹ���ȣ �޼ҵ� ����
	public void setOrderNum (int orderNum) {
		this.orderNum = orderNum;
		System.out.println(orderNum+" �ֹ���ȣ�� �ֹ� �Ϸ� �Ǿ����ϴ�. ");
	}
	
	public void setOrderPrice(List<Menu> menuL) {
		super.setOrderPrice(menuL);
		System.out.println(orderPrice+"�� �Դϴ�.");
	}

	@Override
	public boolean runOrder (int deposit, List<Menu> menuL, Queue<Order> waitL) {
		if (deposit >= orderPrice) {
			onHere.successHere(orderNum, menuL);
			return true;
		} else {
			System.out.println("�ݾ��� �����մϴ�. ");
			return false;
		}
	}
	
	@Override
	public void orderwaiting(List<Menu> menuL, Queue<Order> waitL) {
		onHere.waitingHere(orderNum, menuL);
	}

	
	
	
	
}
