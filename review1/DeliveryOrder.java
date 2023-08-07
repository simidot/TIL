package review1;

public class DeliveryOrder extends Order {
	String locate;
	OnDelivery onDelivery;

	public DeliveryOrder(String menuName, int count, int price) {
		super(menuName, count, price);
	}
	
	public interface OnDelivery {
		public void successDelivery(String locate, String menuName);
	}
	
	public void setOnDelivery (OnDelivery onDelivery) {
		this.onDelivery = onDelivery;
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
			onDelivery.successDelivery(locate, menuName);
			return true;
		} else {
			System.out.println("��Ȯ�� �ݾ��� �������ּ���. ");
			return false;
		}
	}	

}
