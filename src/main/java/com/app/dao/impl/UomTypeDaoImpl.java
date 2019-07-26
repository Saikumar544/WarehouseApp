package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomTypeDao;
import com.app.model.UomType;

@Repository
public class UomTypeDaoImpl implements IUomTypeDao{
	@Autowired
private HibernateTemplate ht;
	@Override
	public Integer saveUomType(UomType u) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(u);
	}

	@Override
	public void updateUomType(UomType u) {
		// TODO Auto-generated method stub
		ht.update(u);
	}

	@Override
	public void deleteUomType(Integer id) {
		// TODO Auto-generated method stub
		UomType u=new UomType(id);
		ht.delete(u);
	}

	@Override
	public UomType getOneUomType(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(UomType.class, id);
	}

	@Override
	public List<UomType> getAllUomTypes() {
		// TODO Auto-generated method stub
		return ht.loadAll(UomType.class);
	}

	@Override
	public List<Object[]> getAllUomTypesCount() {
		// TODO Auto-generated method stub
		String hql="select userType,count(userType) from com.app.model.UomType group by userType";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}

	@Override
	public boolean isUomModelExist(String userModel) {
		// TODO Auto-generated method stub
		long count=0;
		String hql="select count(userModel) from com.app.model.UomType where userModel=?0";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Long> list=(List<Long>) ht.find(hql, userModel);
		if(list!=null &&!list.isEmpty())
		{
			count=list.get(0);
		}
		return count!=0?true:false;
	}

}
