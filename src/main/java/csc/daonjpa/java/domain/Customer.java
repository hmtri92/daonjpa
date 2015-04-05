package csc.daonjpa.java.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table( name = "customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Transient
	private String newPassword;
	
	@Transient
	private String confirmPassword;

	@Id
	@Column(name = "loginId")
	private String loginId;
	
	@NotEmpty
	@Column(name = "password", length = 45)
	private String password;
	
	@NotEmpty
	@Column(name = "firstName", length = 45)
	private String firstName;
	
	@NotEmpty
	@Column(name = "lastName", length = 45)
	private String lastName;
	
	@NotEmpty
	@Column(name = "address", length = 45)
	private String address;
	
	@NotEmpty
	@Column(name = "phone", length = 45)
	private String phone;
	
	@OneToMany(mappedBy="customer")
	private List<Account> accounts;// = new ArrayList<Account>();
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Card> cards;// = new ArrayList<Card>();
	
	
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String loginId, String password, String firstName,
			String lastName, String address, String phone,
			List<Account> accounts, List<Card> cards){
		super();
		this.loginId = loginId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.accounts = accounts;
		this.cards = cards;
	}
}
