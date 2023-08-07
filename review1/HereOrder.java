package review1;

public class HereOrder extends Order {
	int orderNum;
	OnHere onHere;

	public HereOrder(String menuName, int count, int price) {
		super(menuName, count, price);
	}
	
	public interface OnHere {
		public void successHere (int orderNum, String menuName);
	}
	
	public void setOnHere (OnHere onHere) {
		this.onHere = onHere;
	}
	
	void setOrderNum (int orderNum) {
		this.orderNum = orderNum;
	}

	@Override
	// �Ա� �ݾ� Ȯ�� �޼ҵ�
	public boolean runOrder (int deposit) {
		// �Ա� �ݾ��� �ֹ� �ݾ׺��� ũ�� �ܵ� ���/ ������ �ݾ� ���� ���
		if (deposit >= orderPrice) {
			int change = deposit - orderPrice;
			System.out.println("�ܵ� "+change+"���Դϴ�. ");
			onHere.successHere(orderNum, menuName);
			return true;
		} else {
			System.out.println("�ݾ��� �����մϴ�. ");
			return false;
		}
	}

}
