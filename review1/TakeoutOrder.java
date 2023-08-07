package review1;

public class TakeoutOrder extends Order {
	int time;
	OnTakeout onTakeout;

	public TakeoutOrder(String menuName, int count, int price) {
		super(menuName, count, price);
	}
	
	public interface OnTakeout {
		public void successTakeout (int time, String menuName);
	}
	
	public void setOnTakeout (OnTakeout onTakeout) {
		this.onTakeout = onTakeout;
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
			onTakeout.successTakeout(time, menuName);
			return true;
		} else {
			System.out.println("�ݾ��� �����մϴ�. ");
			return false;
		}
	}	

}
