package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseOderDao;
import com.app.model.PurchaseOrder;
@Repository
public class PurchaseOrderDaoImpl implements IPurchaseOderDao{
	@Autowired
private HibernateTemplate ht;
	@Override
	public Integer savePurchaseOrder(PurchaseOrder p) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(p);
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder p) {
		// TODO Auto-generated method stub
		ht.update(p);
	}

	@Override
	public void deletePurchaseOrder(Integer id) {
		// TODO Auto-generated method stub
		ht.delete(new PurchaseOrder(id));
	}

	@Override
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(PurchaseOrder.class, id);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		// TODO Auto-generated method stub
		return ht.loadAll(PurchaseOrder.class);
	}

}
