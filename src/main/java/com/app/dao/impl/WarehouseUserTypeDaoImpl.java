package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWarehouseUserTypeDao;
import com.app.model.WarehouseUserType;

@Repository
public class WarehouseUserTypeDaoImpl implements IWarehouseUserTypeDao {
	@Autowired
	private HibernateTemplate t;

	@Override
	public Integer saveWarehouseUserType(WarehouseUserType s) {
		
		return (Integer) t.save(s);
	}

	@Override
	public void updateWarehouseUserType(WarehouseUserType s) {
		// TODO Auto-generated method stub
		t.update(s);
	}

	@Override
	public void deleteWarehouseUserType(Integer id) {
		// TODO Auto-generated method stub
		t.delete(new WarehouseUserType(id));
	}

	@Override
	public WarehouseUserType getOneWarehouseUserType(Integer id) {
		// TODO Auto-generated method stub
		return t.get(WarehouseUserType.class, id);
	}

	@Override
	public List<WarehouseUserType> getAllWarehouseUserTypes() {
		// TODO Auto-generated method stub
		return t.loadAll(WarehouseUserType.class);
	}

	@Override
	public List<Object[]> getAllUserTypes() {
		// TODO Auto-generated method stub
		String hql="SELECT uType,COUNT(uType) FROM com.app.model.WarehouseUserType GROUP by uType";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Object[]> list=(List<Object[]>) t.find(hql);
		return list;
	}

	@Override
	public List<WarehouseUserType> getWhUsersByUserType(String uType) {
		// TODO Auto-generated method stub
		String hql="from com.app.model.WarehouseUserType where uType=?0";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<WarehouseUserType> obs=(List<WarehouseUserType>) t.find(hql, uType);
		return obs;
	}

	@Override
	public boolean isEmailExists(String uMail) {
		long count=0;
		String hql="select count(uMail) from com.app.model.WarehouseUserType where uMail=?0";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Long> list=(List<Long>) t.find(hql, uMail);
		if(list!=null && !list.isEmpty())
		{
			count=list.get(0);
		}
	
		return count!=0?true:false;
	}

	@Override
	public boolean isContactExists(String uContact) {
		// TODO Auto-generated method stub
		long count=0;
		String hql="select count(uContact) from com.app.model.WarehouseUserType where uContact=?0";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Long> list=(List<Long>) t.find(hql, uContact);
		if(list!=null && !list.isEmpty())
		{
			count=list.get(0);
		}
		return count!=0?true:false;
	}

	}
