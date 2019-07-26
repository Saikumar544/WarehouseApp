package com.app.dao;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOderDao {
	public Integer savePurchaseOrder(PurchaseOrder p);
	public void updatePurchaseOrder(PurchaseOrder p);
	void deletePurchaseOrder(Integer id);
	PurchaseOrder getOnePurchaseOrder(Integer id);
	List<PurchaseOrder> getAllPurchaseOrders();
	
	

}
