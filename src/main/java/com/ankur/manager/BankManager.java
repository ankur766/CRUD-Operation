package com.ankur.manager;

import java.util.List;

import com.ankur.pojo.BankName;

public interface BankManager {

	List<BankName> getBankName();

	BankName addBankName(BankName bankname);

	

}
