package review1;

public class TakeoutOrder extends Order {
	int time;

	public TakeoutOrder(String menuName, int count, int price) {
		super(menuName, count, price);
	}
	
	@Override
	protected void setOrderPrice(int price) {
		orderPrice = price * count;
		orderPrice = orderPrice - 500;
		System.out.println("����ũ �ƿ��� 500�� ���εǾ� "+orderPrice+"���Դϴ�. ");
	}
	
	void setTime (int time) {
		this.time = time;
	}

	@Override
	// �Ա� �ݾ� Ȯ�� �޼ҵ�
	public boolean runOrder (int deposit) {
		// �Ա� �ݾ��� �ֹ� �ݾ׺��� ũ�� �ܵ� ���/ ������ �ݾ� ���� ���
		if (deposit >= orderPrice) {
			int change = deposit - orderPrice;
			System.out.println("�ܵ� "+change+"���Դϴ�. ");
			System.out.println(time+" �е� "+menuName+" ���� �ֹ��� �Ϸ�Ǿ����ϴ�. ");
			return true;
		} else {
			System.out.println("�ݾ��� �����մϴ�. ");
			return false;
		}
	}	

}
