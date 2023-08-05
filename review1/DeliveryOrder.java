package review1;

public class DeliveryOrder extends Order {
	String locate;

	public DeliveryOrder(String menuName, int count, int price) {
		super(menuName, count, price);
	}
	
	@Override
	protected void setOrderPrice(int price) {
		orderPrice = price * count;
		orderPrice = orderPrice + 3000;
		System.out.println("��޺� 3000�� �߰��Ǿ� "+orderPrice+"���Դϴ�. ");
		System.out.println("��� �ֹ��� ��Ȯ�� �ݾ��� �������ּ���. ");
	}
	
	void setLocate(String locate) {
		this.locate = locate;
	}
	
	@Override
	// �Ա� �ݾ� Ȯ�� �޼ҵ�
	public boolean runOrder (int deposit) {
		// �Ա� �ݾ��� �ֹ� �ݾ׺��� ũ�� �ܵ� ���/ ������ �ݾ� ���� ���
		if (deposit == orderPrice) {
			System.out.println(locate+" �ַμ� "+menuName+" ��� �ֹ��� �Ϸ�Ǿ����ϴ�. ");
			return true;
		} else {
			System.out.println("��Ȯ�� �ݾ��� �������ּ���. ");
			return false;
		}
	}	
	



}
