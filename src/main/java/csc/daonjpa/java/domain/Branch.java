package csc.daonjpa.java.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Branch")
public class Branch {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "id_branch")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_bank")
	private Bank bank;
	
	@Column (name = "nameBranch")
	private String nameBranch;
	
	@OneToMany(mappedBy="branch")
	private List<LogTransaction> transaction;
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Branch(long id, Bank bank, String nameBranch) {
		super();
		this.id = id;
		this.bank = bank;
		this.nameBranch = nameBranch;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getNameBranch() {
		return nameBranch;
	}

	public void setNameBranch(String nameBranch) {
		this.nameBranch = nameBranch;
	}

}
