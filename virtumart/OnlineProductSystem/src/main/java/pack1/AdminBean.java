package pack1;

import java.io.Serializable;

/*bean class rules-(binding the data in to a single unit)
 * 1-it should be implement the serializable interface
 * 2-private fields
 * 3-default constructor
 * 4-getters and setters*/ 

public class AdminBean implements Serializable {
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String address;
	private String mailid;
	private long phno;
	
	

	public AdminBean() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

}
