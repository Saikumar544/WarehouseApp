package com.app.service;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrderService {
Integer savePurchaseOrder(PurchaseOrder p);
void updatePurchaseOrder(PurchaseOrder p);
void deletePurchaseOrder(Integer id);
PurchaseOrder getOnePurchaseOrder(Integer id);
List<PurchaseOrder> getAllPurchaseOrder();
}
