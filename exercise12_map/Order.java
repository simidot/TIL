package exercise12_map;

import java.util.List;
import java.util.Queue;

public abstract class Order {
	String menuName;
	int orderPrice;
	
	// ������ ����
	public Order (List<Menu> menuL) {
		setOrderPrice(menuL);
	}
	
	// runOrder abstract�� ����
	public abstract boolean runOrder(int deposit, List<Menu> menuL, Queue<Order> waitL);
	
	
	// ���ݼ��� �޼ҵ� ����
	public void setOrderPrice(List<Menu> menuL) {
		for (Menu m: menuL) {
			if (m!=null) 
				orderPrice += m.price;
		}
	}
	
	public abstract void orderwaiting (List<Menu> menuL, Queue<Order> waitL);

	
	
}
