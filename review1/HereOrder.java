package review1;

public class HereOrder extends Order {
	int orderNum;

	public HereOrder(String menuName, int count, int price) {
		super(menuName, count, price);
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
			System.out.println(orderNum+" �ֹ���ȣ�� "+menuName+" ���� �ֹ��� �Ϸ�Ǿ����ϴ�. ");
			return true;
		} else {
			System.out.println("�ݾ��� �����մϴ�. ");
			return false;
		}
	}

}
