package csc.daonjpa.java.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "LogTransaction")
public class LogTransaction{

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "id_log")
	private long idlog;
	
	@Column (name = "amount")
	private long amount;
	
	@Column (name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToOne
	@JoinColumn (name = "sendAccount")
	private Account sendAccount;
	
	@ManyToOne
	@JoinColumn (name = "receiveAccount")
	private Account receiveAccount;
	
	@ManyToOne
	@JoinColumn (name = "id_branch")
	private Branch branch;

	public LogTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogTransaction(long idlog, long amount, Date date, Account sendAccount, Account receiveAccount) {
		super();
		this.idlog = idlog;
		this.amount = amount;
		this.date = date;
		this.sendAccount = sendAccount;
		this.receiveAccount = receiveAccount;
	}


	public long getIdlog() {
		return idlog;
	}

	public void setIdlog(long idlog) {
		this.idlog = idlog;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Account getSendAccount() {
		return sendAccount;
	}

	public void setSendAccount(Account sendAccount) {
		this.sendAccount = sendAccount;
	}

	public Account getReceiveAccount() {
		return receiveAccount;
	}

	public void setReceiveAccount(Account receiveAccount) {
		this.receiveAccount = receiveAccount;
	}
}
