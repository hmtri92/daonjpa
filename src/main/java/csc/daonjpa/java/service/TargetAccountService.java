package csc.daonjpa.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csc.daonjpa.java.dao.TargetAccountDAO;
import csc.daonjpa.java.domain.TargetAccount;

@Service
public class TargetAccountService {

	@Autowired
	TargetAccountDAO targetAccountDao;
	
	public boolean addNewTarget(String accountOwner, String accountNumber, String nameTarget,
			int bank, int branch) {
		return targetAccountDao.addNewTarget(accountOwner, accountNumber, nameTarget, bank, branch);
	}

	public List<TargetAccount> getTargetByAccount(long accountOwner) {
		return targetAccountDao.getTargetByAccount(accountOwner);
	}

	public TargetAccount getAccountNumber(long recentAccount) {
		return targetAccountDao.getAccountNumber(recentAccount);
	}

}
