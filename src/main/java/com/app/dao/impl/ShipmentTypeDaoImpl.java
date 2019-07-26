package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao{
	@Autowired
	private HibernateTemplate ht;
	public Integer saveShipmentType(ShipmentType s) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(s);
	}

	public void updateShipmentType(ShipmentType s) {
		// TODO Auto-generated method stub
		ht.update(s);
	}

	public void deleteShipmentType(Integer id) {
		// TODO Auto-generated method stub
		ShipmentType a=new ShipmentType(id);
		ht.delete(a);
	}

	public ShipmentType getOneShipmentType(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(ShipmentType.class, id);
	}

	public List<ShipmentType> getAllShipmentTypes() {
		// TODO Auto-generated method stub
		return ht.loadAll(ShipmentType.class);
	}

	public List<Object[]> getShipmentsModeCount()
	{
		DetachedCriteria dc=DetachedCriteria.forClass(ShipmentType.class).setProjection(Projections.projectionList()
				.add(Projections.groupProperty("sMode"))
				.add(Projections.count("sMode"))
				);
		@SuppressWarnings("unchecked")
		List<Object[]> list=(List<Object[]>) ht.findByCriteria(dc);
		return list;
	}
	public List<Object[]> getShipmentsModeCountBKP() {
		// TODO Auto-generated method stub
		String hql="SELECT sMode,COUNT(sMode) FROM com.app.model.ShipmentType GROUP by sMode";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}
	
}
