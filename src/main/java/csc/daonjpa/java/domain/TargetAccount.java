package csc.daonjpa.java.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name = "tagetAccount")
public class TargetAccount {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "id_taget")
	private long id_taget;
	
	@NotEmpty
	@ManyToOne
	@JoinColumn (name = "id_bank")
	private Bank bank;
	
	@NotEmpty
	@ManyToOne
	@JoinColumn (name = "id_branch")
	private Branch branch;
	
	@NotEmpty
	@ManyToOne
	@JoinColumn (name = "accountNumber")
	private Account accountNumber;
	
	@NotEmpty
	@ManyToOne
	@JoinColumn (name = "accountOwner")
	private Account accountOwner;

	public TargetAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TargetAccount(long id_taget, Bank bank, Branch branch,
			Account accountNumber, Account accountOwner) {
		super();
		this.id_taget = id_taget;
		this.bank = bank;
		this.branch = branch;
		this.accountNumber = accountNumber;
		this.accountOwner = accountOwner;
	}



	public long getId_taget() {
		return id_taget;
	}

	public void setId_taget(long id_taget) {
		this.id_taget = id_taget;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Account getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Account accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Account getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(Account accountOwner) {
		this.accountOwner = accountOwner;
	}
}
