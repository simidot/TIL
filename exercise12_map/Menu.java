package exercise12_map;


public class Menu {
	public String menuName;
	public int price;
	public int count;
	public int inventory;

	
	public Menu(String menuName, int count, int price) throws KioskException {
		this.menuName = menuName;
		this.count = count;
		this.price = price*count;
	}
	
//	public int getPrice () {
//		this.price = Kiosk.mpriceMap.get(menuName);
//		this.price = price * count;
//		return price;
//	}
		
//		if (menu.equals("������Ʈ")) {
//			price = 4500;
//		} else if (menu.equals("ī���")||menu.equals("��ũƼ")) {
//			price = 3500;
//		} else if (menu.equals("�Ƹ޸�ī��")) {
//			price = 2000;
//		}  else if (menu.equals("�ֹ�")) {
//			
//		}else {
//			price = 0;
//			if (price == 0) {
//				throw new KioskException("�޴��� �����ϴ�.", 102);
//			}
//		}	
//	}

//	public String getName() {
//		return menu;
//	}
//	
//	public void show() {
//		System.out.println(getName());
//		for (Menu mn : waitL) {
//			System.out.print(mn.getName()+" ");
//		} 
//	}


	
	

}