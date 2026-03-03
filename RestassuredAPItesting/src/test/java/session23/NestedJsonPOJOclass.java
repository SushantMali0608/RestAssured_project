package session23;

import java.util.List;

import session22.EmployeePOJOClass;

public class NestedJsonPOJOclass {

	
	private String CompanyName;
	private String city;
	private String state;
	private int pincode;
	private List<String> bankacccount;
	private List <EmployeePOJOClass> Empinfo;
	
	//generating getters and setters
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public List<String> getBankacccount() {
		return bankacccount;
	}
	public void setBankacccount(List<String> bankacccount) {
		this.bankacccount = bankacccount;
	}
	public List<EmployeePOJOClass> getEmpinfo() {
		return Empinfo;
	}
	public void setEmpinfo(List<EmployeePOJOClass> empinfo) {
		Empinfo = empinfo;
	}
	
	
	
}
