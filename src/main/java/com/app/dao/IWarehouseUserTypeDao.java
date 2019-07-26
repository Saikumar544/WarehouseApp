package com.app.dao;

import java.util.List;

import com.app.model.WarehouseUserType;

public interface IWarehouseUserTypeDao {
	public Integer saveWarehouseUserType(WarehouseUserType s);
	public void updateWarehouseUserType(WarehouseUserType s);
	public void deleteWarehouseUserType(Integer id);
	public WarehouseUserType getOneWarehouseUserType(Integer id);
	public List<WarehouseUserType> getAllWarehouseUserTypes();
	public List<Object[]> getAllUserTypes();
	List<WarehouseUserType> getWhUsersByUserType(String uType);
	boolean isEmailExists(String uMail);
	boolean isContactExists(String uContact);
	
}
