package com.ankur.dao;

import java.util.List;

import com.ankur.pojo.BankName;

public interface BankDAO {

	List<BankName> getBankName();

	BankName addBankName(BankName bankname);

}
