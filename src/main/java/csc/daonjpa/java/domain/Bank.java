package csc.daonjpa.java.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name = "bank")
public class Bank implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "id_bank")
	private int id_bank;
	
	@NotEmpty
	@Column (name = "name")
	private String name;
	
	@OneToMany (mappedBy = "bank")
	private List<Branch> branchs;
	
	@OneToMany (mappedBy = "bank")
	private List<TargetAccount> targetAccounts;
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(int id_bank, String name, List<Branch> branchs) {
		super();
		this.id_bank = id_bank;
		this.name = name;
		this.branchs = branchs;
	}

	public int getId_bank() {
		return id_bank;
	}

	public void setId_bank(int id_bank) {
		this.id_bank = id_bank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Branch> getBranchs() {
		return branchs;
	}

	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}

	
}
