package csc.daonjpa.java.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csc.daonjpa.java.dao.AccountDAO;
import csc.daonjpa.java.dao.TransferDAO;
import csc.daonjpa.java.domain.Account;
import csc.daonjpa.java.domain.Bank;
import csc.daonjpa.java.domain.Branch;

@Service("transferService")
public class TransferService {
	
	@Autowired
	TransferDAO transferDAO;
	
	@Autowired
	AccountDAO accountDAO;
	
	public List<Bank> getListBank()
	{
		return transferDAO.getBank();
	}
	
	public List<Branch> getBracnchByBank(int id)
	{
		return transferDAO.getBranchByBank(id);
	}
	
	public int insertTransaction(long amount,Date date,long id_branch,long id_receiveaccount,long id_sendaccount)
	{
		return transferDAO.insertTransaction(amount, date, id_branch, id_receiveaccount, id_sendaccount);
	}
	
	public Account checkAccount(String accountName)
	{
		return accountDAO.checkAccount(accountName);
	}

	public boolean sendAmount(long sendAccount_id, long rece_id, long amount, int banch_id) {
		return transferDAO.sendAmount(sendAccount_id, rece_id, amount, banch_id );
		
	}

}
