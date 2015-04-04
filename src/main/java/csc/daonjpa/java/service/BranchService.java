package csc.daonjpa.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csc.daonjpa.java.dao.BranchDAO;
import csc.daonjpa.java.domain.Branch;

@Service
public class BranchService {
	
	@Autowired
	BranchDAO branchDao;

	public List<Branch> getBranchBy(int bankId) {
		
		return branchDao.getBranchBy(bankId);
	}
}
