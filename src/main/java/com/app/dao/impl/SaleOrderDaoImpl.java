package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ISaleOrderDao;
import com.app.model.SaleOrder;
@Repository
public class SaleOrderDaoImpl implements ISaleOrderDao{
	@Autowired
private HibernateTemplate ht;
	@Override
	public Integer saveSale(SaleOrder saleOrder) {
		return (Integer) ht.save(saleOrder);
	}

	@Override
	public void updateSale(SaleOrder saleOrder) {
		ht.update(saleOrder);
	}

	@Override
	public void deleteSale(Integer id) {
		ht.delete(new SaleOrder(id));
	}

	@Override
	public SaleOrder getOneSale(Integer id) {
		return ht.get(SaleOrder.class, id);
	}
	@Override
	public List<SaleOrder> getAllSales() {
		return ht.loadAll(SaleOrder.class);
	}

	@Override
	public boolean issaleOrderCodeExists(String saleOrderCode) {
long count=0;
String hql="select count(saleOrderCode) from com.app.model.SaleOrder where saleOrderCode=?0";
@SuppressWarnings({ "deprecation", "unchecked" })
List<Long> list=(List<Long>) ht.find(hql, saleOrderCode);
if(list!=null && !list.isEmpty())
{
	count=list.get(0);
}
		return count!=0?true:false;
	}


}
