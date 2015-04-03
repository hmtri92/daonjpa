package csc.daonjpa.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csc.daonjpa.java.dao.BankDAO;
import csc.daonjpa.java.domain.Bank;

@Service
public class BankService {

	@Autowired
	BankDAO bankDAO;
	
	public List<Bank> getListBank()
	{
		return bankDAO.getBank();
	}
}
