package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWarehouseUserTypeDao;
import com.app.model.WarehouseUserType;
import com.app.service.IWarehouseUserTypeService;
@Service
public class WarehouseUserTypeServiceImpl implements IWarehouseUserTypeService {
	@Autowired
	private IWarehouseUserTypeDao dao;
	@Override
	@Transactional
	public Integer saveWarehouseUserType(WarehouseUserType s) {
		// TODO Auto-generated method stub
		return dao.saveWarehouseUserType(s);
	}

	@Transactional
	@Override
	public void updateWarehouseUserType(WarehouseUserType s) {
		// TODO Auto-generated method stub
		dao.updateWarehouseUserType(s);
	}

	@Override
	@Transactional
	public void deleteWarehouseUserType(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteWarehouseUserType(id);
	}

	@Override
	@Transactional(readOnly=true)
	public WarehouseUserType getOneWarehouseUserType(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOneWarehouseUserType(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<WarehouseUserType> getAllWarehouseUserTypes() {
		// TODO Auto-generated method stub
		return dao.getAllWarehouseUserTypes();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getAllUserTypes() {
		// TODO Auto-generated method stub
		return dao.getAllUserTypes();
	}

	@Override
	public List<WarehouseUserType> getWhUsersByUserType(String uType) {
		// TODO Auto-generated method stub
		return dao.getWhUsersByUserType(uType);
	}

	@Override
	@Transactional
	public boolean isEmailExists(String uMail) {
		// TODO Auto-generated method stub
		return dao.isEmailExists(uMail);
	}

	@Override
	@Transactional
	public boolean isContactExists(String uContact) {
		// TODO Auto-generated method stub
		return dao.isContactExists(uContact);
	}



}
