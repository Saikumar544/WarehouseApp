package com.app.dao;

import java.util.List;

import com.app.model.SaleOrder;

public interface ISaleOrderDao {
 Integer saveSale(SaleOrder saleOrder);
 void updateSale(SaleOrder saleOrder);
 void deleteSale(Integer id);
 SaleOrder getOneSale(Integer id);
 List<SaleOrder> getAllSales();
 boolean issaleOrderCodeExists(String saleOrderCode);
}
