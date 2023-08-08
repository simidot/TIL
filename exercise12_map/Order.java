package exercise12_map;

import java.util.List;
import java.util.Queue;

public abstract class Order {
	String menuName;
	int orderPrice;
	
	// 생성자 생성
	public Order (List<Menu> menuL) {
		setOrderPrice(menuL);
	}
	
	// runOrder abstract로 설정
	public abstract boolean runOrder(int deposit, List<Menu> menuL, Queue<Order> waitL);
	
	
	// 가격설정 메소드 생성
	public void setOrderPrice(List<Menu> menuL) {
		for (Menu m: menuL) {
			if (m!=null) 
				orderPrice += m.price;
		}
	}
	
	public abstract void orderwaiting (List<Menu> menuL, Queue<Order> waitL);

	
	
}
