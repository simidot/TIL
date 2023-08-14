package ssac.emp.kys;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EmployeeMGR {
	Employee employee = new Employee();
	Map<String, Map<String, Object>> db;
	Map<String, Object> dbDetails;
	Scanner scanner = new Scanner(System.in);
	
	public EmployeeMGR() {
		db = new TreeMap<>();
	}
	
	// 등록 기능
	void insert(String name, String sabun, String phone, String addr) {
		dbDetails = new TreeMap<String, Object>();
		dbDetails.put("sabun", sabun);
		dbDetails.put("phone", phone);
		dbDetails.put("addr", addr);
		db.put(name, dbDetails);
		// System.out.println(db.toString());
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
					+" 사번-"+db.get(updateName).get("sabun")
					+" 휴대폰 번호-"+db.get(updateName).get("phone")
					+" 주소-"+db.get(updateName).get("addr"));
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
					Map<String, Object> dbUpdate = db.get(updateName);

					if (updatePart.equals("이름")) {
						db.put(updateDetails, dbUpdate);
						db.remove(updateName);
						updateName = updateDetails;
					} else if (updatePart.equals("사번")) {
						dbUpdate.replace("sabun", updateDetails);
						db.replace(updateName, dbUpdate);
					} else if (updatePart.equals("번호")) {
						dbUpdate.replace("phone", updateDetails);
						db.replace(updateName, dbUpdate);
					} else if (updatePart.equals("주소")) {
						dbUpdate.replace("addr", updateDetails);
						db.replace(updateName, dbUpdate);
					} 
					
					System.out.println("\n------------------------------------------------------------------");
					System.out.println("이름-"+updateName
							+" 사번-"+db.get(updateName).get("sabun")
							+" 휴대폰 번호-"+db.get(updateName).get("phone")
							+" 주소-"+db.get(updateName).get("addr"));					
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
			System.out.println("사번: "+db.get(searchName).get("sabun"));
			System.out.println("휴대폰 번호: "+db.get(searchName).get("phone"));
			System.out.println("주소: "+db.get(searchName).get("addr"));
		} else {
			throw new EMSException("EMS 프로그램에 존재하지 않는 사원입니다.", 102);
		}
	}
	
	// 목록 기능
	void selectAll() {	
		for(String s: db.keySet()) {
			System.out.println("전체 사원의 정보입니다. ");
			System.out.println("\n------------------------------------------------------------------");
			System.out.println("사원 이름: "+s);
			System.out.println("사번: "+db.get(s).get("sabun"));
			System.out.println("휴대폰 번호: "+db.get(s).get("phone"));
			System.out.println("주소: "+db.get(s).get("addr"));
		}	
	}
}
