package ssac.emp.kys;

import java.util.Scanner;

public class TestEMS {

	public static void main(String[] args) throws EMSException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("EMS 프로그램입니다.");
		EmployeeMGR mgr = new EmployeeMGR();

		while(true) {
			try {
				System.out.println("\n------------------------------------------------------------------");
				System.out.println("원하시는 기능을 선택해주세요.");
				System.out.println("1. 등록  2. 목록  3. 상세  4. 수정  5. 삭제");
				int function = scanner.nextInt();
		
				if (function==1) {
					System.out.println("------------------------------------------------------------------");
					System.out.println("이름을 입력하세요.");
					String name = scanner.next();
					System.out.println("사번을 입력하세요.");
					String sabun = scanner.next();
					System.out.println("휴대폰 번호를 입력하세요.");
					String phone = scanner.next();
					System.out.println("주소를 입력하세요.");
					String addr = scanner.next();
					System.out.println("이름 "+name+", 사번 "+sabun+", 번호 "+phone+", 주소 "+addr+"로 등록하시겠습니까? \n>>> 예/아니오");
					String answer = scanner.next();
					if (answer.equals("예")) {
						mgr.insert(name, sabun, phone, addr);
					} else if (answer.equals("아니오")) {
						System.out.println("등록이 종료됩니다. ");
						continue;
					}	
				} 
				if (function==2) {
					if (mgr.db.isEmpty()) {
						throw new EMSException("데이터베이스 정보가 없습니다.", 101);
					} else {
						mgr.selectAll();
					}
				} 
				if (function==3) {
					System.out.println("상세정보를 알고싶은 사원의 이름을 검색하세요.");
					String searchName = scanner.next();
					mgr.select(searchName);
				} 
				if (function==4) {
					System.out.println("정보를 수정하고자 하는 사원의 이름을 입력하세요. ");
					String updateName = scanner.next();
					if(mgr.db.containsKey(updateName)) {
						mgr.update(updateName);
					} else {
						throw new EMSException("EMS 프로그램에 존재하지 않는 사원입니다.", 102);
					}
				} 
				if (function==5) {
					System.out.println("정보를 삭제하고자 하는 사원의 이름을 입력하세요. ");
					String deleteName = scanner.next();
					mgr.delete(deleteName);
				}
			} catch (EMSException e) {
		    	System.out.println(e.getMessage()+"\nerror code: "+e.code);
			}
		}
	}
}
