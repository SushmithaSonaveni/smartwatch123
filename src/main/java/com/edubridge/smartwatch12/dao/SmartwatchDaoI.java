package com.edubridge.smartwatch12.dao;

import java.util.List;

import com.edubridge.smartwatch12.model.Smartwatch;

public interface SmartwatchDaoI {
	int addSmartwatch(Smartwatch s);
	List<Smartwatch> getAllSmartwatches();
	Smartwatch getSmartwatchByName(String name);
	int updateSmartwatch(Smartwatch s);
	void deleteSmartwatch(String name);
	void deleteAllSmartwatches();
	void searchSmartwatch(String name);
	}





