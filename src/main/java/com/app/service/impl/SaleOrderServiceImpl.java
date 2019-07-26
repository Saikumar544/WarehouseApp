package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ISaleOrderDao;
import com.app.model.SaleOrder;
import com.app.service.ISaleOrderService;
@Service
public class SaleOrderServiceImpl implements ISaleOrderService{
	@Autowired
private ISaleOrderDao dao;
	@Override
	@Transactional
	public Integer saveSale(SaleOrder saleOrder) {
		// TODO Auto-generated method stub
		return dao.saveSale(saleOrder);
	}

	@Override
	@Transactional
	public void updateSale(SaleOrder saleOrder) {
		// TODO Auto-generated method stub
		dao.updateSale(saleOrder);
	}

	@Override
	@Transactional
	public void deleteSale(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteSale(id);
	}

	@Override
	@Transactional(readOnly=true)
	public SaleOrder getOneSale(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOneSale(id);
	}

	@Override
	@Transactional
	public boolean issaleOrderCodeExists(String saleOrderCode) {
		// TODO Auto-generated method stub
		return dao.issaleOrderCodeExists(saleOrderCode);
	}

	@Override
	public List<SaleOrder> getAllSales() {
		// TODO Auto-generated method stub
		return dao.getAllSales();
	}

}
