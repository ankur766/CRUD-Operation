package com.ankur.managerImpl;

import java.util.List;

import com.ankur.dao.BankDAO;

import com.ankur.manager.BankManager;
import com.ankur.pojo.BankName;

public class BankManagerImpl implements BankManager {
	BankDAO bankDao;
	
	

	public BankDAO getBankDao() {
		return bankDao;
	}



	public void setBankDao(BankDAO bankDao) {
		this.bankDao = bankDao;
	}



	@Override
	public List<BankName> getBankName() {
		// TODO Auto-generated method stub
		return   bankDao.getBankName();
	}



	@Override
	public BankName addBankName(BankName bankname) {
		// TODO Auto-generated method stub
		return bankDao.addBankName(bankname);
	}
	

}
