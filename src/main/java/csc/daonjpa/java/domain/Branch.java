package csc.daonjpa.java.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table (name = "Branch")
public class Branch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "id_branch")
	private int id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_bank")
	private Bank bank;
	
	@Column (name = "nameBranch")
	private String nameBranch;
	
	@OneToMany(mappedBy="branch")
	private List<LogTransaction> transaction;
	
	@OneToMany (mappedBy = "branch")
	private List<TargetAccount> targetAccounts;
	
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Branch(int id, Bank bank, String nameBranch) {
		super();
		this.id = id;
		this.bank = bank;
		this.nameBranch = nameBranch;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
