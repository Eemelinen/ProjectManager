package hh.palvelinohjelmointi.ProjectList.model;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SignUpForm {
		
	@NotEmpty
	@Size(min=4, max=15)
	private String username;
	
	@NotEmpty
	private String role = "user";
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String phoneNumber;
	
	@NotEmpty
	private String description;
	
	@NotEmpty
	@Size(min=5, max=25)
	private String password;
	
	@NotEmpty
	@Size(min=5, max=25)
	private String passwordCheck;
	
	private List<Membership> memberships = null;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public List<Membership> getMemberships() {
		return memberships;
	}

	public void setMemberships(List<Membership> memberships) {
		this.memberships = memberships;
	}

	@Override
	public String toString() {
		return "SignUpForm [username=" + username + ", role=" + role + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", description=" + description
				+ ", password=" + password + ", passwordCheck=" + passwordCheck + ", memberships=" + memberships + "]";
	}
}
