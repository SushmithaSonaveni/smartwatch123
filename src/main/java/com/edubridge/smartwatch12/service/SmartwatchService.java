package com.edubridge.smartwatch12.service;

import java.util.List;

import com.edubridge.smartwatch12.dao.SmartwatchDao;
import com.edubridge.smartwatch12.model.Smartwatch;

public class SmartwatchService implements SmartwatchServiceI{
private SmartwatchDao dao;
 public SmartwatchService() {
     dao = new SmartwatchDao();
 }
@Override
public int addSmartwatch(Smartwatch s) {
	return dao.addSmartwatch(s);
}
@Override
public List<Smartwatch> getAllSmartwatches() {
	return dao.getAllSmartwatches(); 
}
@Override
public Smartwatch getSmartwatchByName(String name) {
	return dao.getSmartwatchByName(name);
}
@Override
public int updateSmartwatch(Smartwatch s) {
	return dao.updateSmartwatch(s);
}
@Override
public void deleteSmartwatch(String name) {
 dao.deleteSmartwatch(name);
 }	
public void deleteAllSmartwatches() {
     return;
    }
@Override
public void searchSmartwatch(String name) {
 return;
	}	
}
