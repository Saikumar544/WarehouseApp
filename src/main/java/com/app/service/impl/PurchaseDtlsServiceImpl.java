package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseDtlsDao;
import com.app.model.Item;
import com.app.model.PurchaseDtls;
import com.app.service.IPurchaseDtlsService;
@Service
public class PurchaseDtlsServiceImpl implements IPurchaseDtlsService {
	@Autowired
private IPurchaseDtlsDao dao;
	@Override
	@Transactional
	public Integer savePurchaseDtls(PurchaseDtls pdls) {
		// TODO Auto-generated method stub
		return dao.savePurchaseDtls(pdls);
	}
@Transactional
	@Override
	public void updatePurchaseDtls(PurchaseDtls pdls) {
		// TODO Auto-generated method stub
dao.updatePurchaseDtls(pdls);
	}
@Transactional
	@Override
	public void deletePurchaseDtls(Integer id) {
		// TODO Auto-generated method stub
dao.deletePurchaseDtls(id);
	}
@Transactional(readOnly=true)
	@Override
	public List<PurchaseDtls> getAllPurchaseDtls() {
		// TODO Auto-generated method stub
		return dao.getAllPurchaseDtls();
	}
}


