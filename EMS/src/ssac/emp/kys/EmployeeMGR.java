package ssac.emp.kys;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EmployeeMGR {
	Employee e; 
	Map<String, Employee> db;
	Scanner scanner = new Scanner(System.in);
	
	public EmployeeMGR() {
		e = new Employee();
		db = new TreeMap<>();
	}
	
	// 등록 기능
	void insert(String name, String sabun, String phone, String addr) {
		e.setName(name);
		e.setSabun(sabun);
		e.setPhone(phone);
		e.setAddr(addr);
		db.put(name, e);
		System.out.println(name+" 사원의 정보가 등록되었습니다. ");
	}
	
	// 삭제 기능 
	void delete(String deleteName) throws EMSException {
		if (db.containsKey(deleteName)) {
			System.out.println("정말 "+deleteName+" 사원의 정보를 삭제하시겠습니까? \n>>> 예/아니오");
			String deleteOp = scanner.next();
			if(deleteOp.equals("예")) {
				db.remove(deleteName);
				System.out.println(deleteName+" 사원의 정보를 삭제하였습니다.");
			} else {
				System.out.println("삭제를 취소합니다. ");
			}
		} else {
			throw new EMSException("EMS 프로그램에 존재하지 않는 사원입니다.", 102);
		}
	}
	
	// 수정 기능
	void update(String updateName) throws EMSException {
		if (db.containsKey(updateName)) {
			System.out.println("이름-"+updateName
					+" 사번-"+e.getSabun()
					+" 휴대폰 번호-"+e.getPhone()
					+" 주소-"+e.getAddr());
			while(true) {
				System.out.println("------------------------------------------------------------------");
				System.out.println("수정하고자 하는 정보를 입력하세요. (이름, 사번, 번호, 주소)");
				String updatePart = scanner.next();
				
				if (updatePart.equals("이름")||
						updatePart.equals("사번")||
						updatePart.equals("번호")||
						updatePart.equals("주소")) {
					System.out.println("어떻게 수정할까요? ");
					String updateDetails = scanner.next();
					Employee dbUpdate = db.get(updateName);

					if (updatePart.equals("이름")) {
						dbUpdate.setName(updateDetails);
						db.put(updateDetails, dbUpdate);
						db.remove(updateName);
					} else if (updatePart.equals("사번")) {
						dbUpdate.setSabun(updateDetails);
						db.put(updateName, dbUpdate);
					} else if (updatePart.equals("번호")) {
						dbUpdate.setPhone(updateDetails);
						db.put(updateName, dbUpdate);
					} else if (updatePart.equals("주소")) {
						dbUpdate.setAddr(updateDetails);
						db.put(updateName, dbUpdate);
					} 
					
					System.out.println("\n------------------------------------------------------------------");
					e.toString();		
					System.out.println("수정이 완료되었습니다. ");
					break;
				} else {
					System.out.println("수정하고자 하는 정보를 정확히 입력해주세요. ");
					continue;
				}
			}
		} 	

	}
	
	// 상세 기능
	void select(String searchName) throws EMSException {
		if (db.containsKey(searchName)) {
			System.out.println(searchName+"님의 상세정보입니다. ");
			System.out.println("\n------------------------------------------------------------------");
			System.out.println("사원 이름: "+searchName);
			System.out.println("사번: "+e.getSabun());
			System.out.println("휴대폰 번호: "+e.getPhone());
			System.out.println("주소: "+e.getAddr());
		} else {
			throw new EMSException("EMS 프로그램에 존재하지 않는 사원입니다.", 102);
		}
	}
	
	// 목록 기능
	void selectAll() {	
		System.out.println("전체 사원의 정보입니다. ");
		for(String s: db.keySet()) {
			System.out.println("\n------------------------------------------------------------------");
			System.out.println("사원 이름: "+s);
			System.out.println("사번: "+e.getSabun());
			System.out.println("휴대폰 번호: "+e.getPhone());
			System.out.println("주소: "+e.getAddr());
		}	
	}
}
