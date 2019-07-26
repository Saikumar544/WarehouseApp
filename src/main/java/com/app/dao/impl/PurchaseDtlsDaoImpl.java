package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseDtlsDao;
import com.app.model.Item;
import com.app.model.PurchaseDtls;
@Repository
public class PurchaseDtlsDaoImpl implements IPurchaseDtlsDao {
	@Autowired
private HibernateTemplate ht;
	@Override
	public Integer savePurchaseDtls(PurchaseDtls pdls) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(pdls);
	}

	@Override
	public void updatePurchaseDtls(PurchaseDtls pdls) {
		// TODO Auto-generated method stub
ht.update(pdls);
	}

	@Override
	public void deletePurchaseDtls(Integer id) {
		// TODO Auto-generated method stub
ht.delete(new PurchaseDtls(id));
	}

	@Override
	public List<PurchaseDtls> getAllPurchaseDtls() {
		// TODO Auto-generated method stub
		return ht.loadAll(PurchaseDtls.class);
	}

	

}
