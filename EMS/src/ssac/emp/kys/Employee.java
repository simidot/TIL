package ssac.emp.kys;

public class Employee {
	private String name;
	private String sabun;
	private String phone;
	private String addr;


	public Employee() {
		super();
	}

	public Employee(String name, String sabun, String phone, String addr) {
		super();
		setName(name);
		setSabun(sabun);
		setPhone(phone);
		setAddr(addr);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSabun() {
		return sabun;
	}

	public void setSabun(String sabun) {
		this.sabun = sabun;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String toString(String name) {
		return "이름-"+getName()
				+" 사번-"+getSabun()
				+" 휴대폰 번호-"+getPhone()
				+" 주소-"+getAddr();
	}



}
