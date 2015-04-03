package csc.daonjpa.java.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tagetAccount")
public class TagetAccount {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "id_taget")
	private long id_taget;
	
	@OneToOne
	@JoinColumn (name = "id_bank")
	private Bank bank;
	
	@OneToOne
	@JoinColumn (name = "id_branch")
	private Branch branch;
	
	@OneToOne
	@JoinColumn (name = "id_account")
	private Account account;

	public TagetAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TagetAccount(long id_taget, Bank bank, Branch branch, Account account) {
		super();
		this.id_taget = id_taget;
		this.bank = bank;
		this.branch = branch;
		this.account = account;
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

	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}

}
