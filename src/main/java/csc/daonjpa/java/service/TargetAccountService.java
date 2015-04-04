package csc.daonjpa.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csc.daonjpa.java.dao.TargetAccountDAO;

@Service
public class TargetAccountService {

	@Autowired
	TargetAccountDAO targetAccountDao;
	
	public boolean addNewTarget(String accountOwner, String accountNumber,
			int bank, int branch) {
		return targetAccountDao.addNewTarget(accountOwner, accountNumber, bank, branch);
	}

}
