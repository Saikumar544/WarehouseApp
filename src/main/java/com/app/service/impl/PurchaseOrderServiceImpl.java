package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseOderDao;
import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;
@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService{
	@Autowired
private IPurchaseOderDao dao;
	@Override
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder p) {
		// TODO Auto-generated method stub
		return dao.savePurchaseOrder(p);
	}

	@Override
	@Transactional
	public void updatePurchaseOrder(PurchaseOrder p) {
		// TODO Auto-generated method stub
		dao.updatePurchaseOrder(p);
	}

	@Override
	@Transactional
	public void deletePurchaseOrder(Integer id) {
		// TODO Auto-generated method stub
		dao.deletePurchaseOrder(id);
	}

	@Override
	@Transactional(readOnly=true)
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOnePurchaseOrder(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PurchaseOrder> getAllPurchaseOrder() {
		// TODO Auto-generated method stub
		return dao.getAllPurchaseOrders();
	}

}
