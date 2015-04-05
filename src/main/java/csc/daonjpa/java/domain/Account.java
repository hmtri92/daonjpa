package csc.daonjpa.java.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity class for Account table. This is a simple POJO class with annotations
 * to define mapping with DB table
 * 
 * @author Minh Tri
 *
 */
@Entity
@Table(name = "Account")
@AttributeOverrides({ @AttributeOverride(name = "availableAmount", column = @Column(name = "availableAmount")) })
public class Account extends BaseInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	public List<TargetAccount> getAccountNumbers() {
		return accountNumbers;
	}

	public void setAccountNumbers(List<TargetAccount> accountNumbers) {
		this.accountNumbers = accountNumbers;
	}

	public List<TargetAccount> getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(List<TargetAccount> accountOwner) {
		this.accountOwner = accountOwner;
	}

	@NotEmpty
	@Column(name = "accountName")
	private String accountName;

	@NotEmpty
	@Column(name = "accountType")
	private String accountType;

	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "loginId")
	private Customer customer;


	@OneToMany(mappedBy = "receiveAccount")
	private List<LogTransaction> receiveAccount;

	@OneToMany(mappedBy = "sendAccount")
	private List<LogTransaction> sendAccount;
	
	@OneToMany (mappedBy = "accountNumber")
	private List<TargetAccount> accountNumbers;
	
	@OneToMany (mappedBy = "accountOwner")
	private List<TargetAccount> accountOwner;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(long id, Long availableAmount) {
		super(id, availableAmount);
		// TODO Auto-generated constructor stub
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return AccountName
	 */
	public String getAccountName() {
		return this.accountName;
	}

	/**
	 * Set accountName
	 * 
	 * @param accountName
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return AccountType
	 */
	public String getAccountType() {
		return this.accountType;
	}

	/**
	 * Set accountType
	 * 
	 * @param accountType
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public List<LogTransaction> getReceiveAccount() {
		return receiveAccount;
	}

	public void setReceiveAccount(List<LogTransaction> receiveAccount) {
		this.receiveAccount = receiveAccount;
	}

	public List<LogTransaction> getSendAccounts() {
		return sendAccount;
	}

	public void setSendAccount(List<LogTransaction> sendAccount) {
		this.sendAccount = sendAccount;
	}

	public List<LogTransaction> getSendAccount() {
		return sendAccount;
	}
	
}