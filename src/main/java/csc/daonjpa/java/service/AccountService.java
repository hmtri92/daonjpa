package csc.daonjpa.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csc.daonjpa.java.dao.AccountDAO;
import csc.daonjpa.java.domain.Account;

@Service("accountService")
public class AccountService {

	@Autowired
	AccountDAO accountDAO;
	
	public Account checkAccount(String accountName)
	{
		return accountDAO.checkAccount(accountName);
	}
}
