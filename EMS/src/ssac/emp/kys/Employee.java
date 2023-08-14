package ssac.emp.kys;

import java.util.Map;
import java.util.TreeMap;

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



}
