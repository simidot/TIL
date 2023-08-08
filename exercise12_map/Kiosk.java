package exercise12_map;

import java.util.List;
import java.util.TreeMap;

import exercise12_map.DeliveryOrder.OnDelivery;
import exercise12_map.HereOrder.OnHere;
import exercise12_map.TakeoutOrder.OnTakeout;

public class Kiosk implements OnDelivery, OnHere, OnTakeout {
	int inventory;
	
	static TreeMap<String, Integer> mpriceMap;
	TreeMap<String, Integer> minventoryMap;
	
	
	// Ű����ũ ������ ����
	public Kiosk (int inventory) {
		this.inventory = inventory;
		// �޴��̸�-���� Map
		mpriceMap = new TreeMap<String, Integer>();
		mpriceMap.put("������Ʈ", 4500);
		mpriceMap.put("ī���", 3500);
		mpriceMap.put("��ũƼ", 3500);
		mpriceMap.put("�Ƹ޸�ī��", 2000);

		// �޴��̸�-����� Map
		minventoryMap = new TreeMap<String, Integer>();
		minventoryMap.put("������Ʈ", inventory);
		minventoryMap.put("ī���", inventory);
		minventoryMap.put("��ũƼ", inventory);
		minventoryMap.put("�Ƹ޸�ī��", inventory);
	}
	
	
	public Menu initMenu (String menuName, int count) throws KioskException {
		if (mpriceMap.containsKey(menuName)) {
			int price = mpriceMap.get(menuName);
			Menu menu = new Menu(menuName, count, price);
			return menu;
		} else {
			throw new KioskException("�޴��� �����ϴ�.", 102);
		}
		
	}
	
	
	// initOrder �޼ҵ� ����
	public Order initOrder (List<Menu> menuL, int howToOrder) throws KioskException {
		// ��� ���� �� �ֹ���Ŀ� ���� �ٸ��� �ν��Ͻ� ����.
		if(isInventory(menuL)) {
			if (howToOrder == 1) {
				DeliveryOrder order = new DeliveryOrder(menuL);
				order.setOnDelivery(this);
				return order;
			} else if (howToOrder==2) {
				TakeoutOrder order = new TakeoutOrder(menuL);
				order.setOnTakeout(this);
				return order;
			} else if (howToOrder==3) {
				HereOrder order = new HereOrder(menuL);
				order.setOnHere(this);
				return order;
			} else {
				throw new KioskException("�ֹ� ����� �ùٸ��� �ʽ��ϴ�. ", 103);
			}
		} else {
			throw new KioskException("��� �����ϴ�.", 101);
		}
	}
	
	// ���Ȯ�� �޼ҵ� ����
	public boolean isInventory (List<Menu> menuL) {
		for (Menu i : menuL) {
			if (minventoryMap.get(i.menuName)>=i.count) {
			return true;
			} else {return false;}
		} return true;
	}
	
	// ��� ���� �޼ҵ� ����
	public void subInventory (List<Menu> menuL) {
		for (Menu i : menuL) {
				minventoryMap.replace(i.menuName, (minventoryMap.get(i.menuName) - i.count));
		}
		System.out.println("���� ����Ȳ: "+minventoryMap.toString());
	}
	
	// �ֹ��Ϸ� 
	@Override
	public void successDelivery(String locate, List<Menu> menuL) {
		System.out.println("�ֹ� ����------------------");
		for (Menu m : menuL) {
			System.out.println(m.menuName +" "+ m.count+"��");
		}
		System.out.println("-----------------------");
	}

	@Override
	public void waitingDelivery (String locate, List<Menu> menuL) {
		System.out.println("----------------------");
		System.out.println("�ֹ��Ͻ� "+menuL.size()+"�� �޴�");
		System.out.println(locate+" �ּҷ� ����� ���۵Ǿ����ϴ�.");
		System.out.println("----------------------");	
	}
	

	@Override
	public void successHere(int orderNum, List<Menu> menuL) {
		System.out.println("�ֹ� ����------------------");
		for (Menu m : menuL) {
			System.out.println(m.menuName +" "+ m.count+"��");
		}
		System.out.println("-----------------------");
	}
	
	public void waitingHere (int orderNum, List<Menu> menuL) {
		System.out.println("----------------------");
		System.out.println("�ֹ��Ͻ� "+menuL.size()+"�� �޴�");
		System.out.println(orderNum+" ��ȣ �ֹ� �޴� ���Խ��ϴ�. ");	
	}
	
	@Override
	public void successTakeout(int time, List<Menu> menuL ) {
		System.out.println("�ֹ� ����------------------");
		for (Menu m : menuL) {
			System.out.println(m.menuName +" "+ m.count+"��");
		}
		System.out.println("-----------------------");
	}
	
	public void waitingTakeout (int time, List<Menu> menuL) {
		System.out.println("----------------------");
		System.out.println("�ֹ��Ͻ� "+menuL.size()+"�� �޴�");
		System.out.println(time+"�� ���� ���� �ֹ� ���Խ��ϴ�. ");	
	}




}