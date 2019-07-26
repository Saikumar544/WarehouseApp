package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderTypeDao;
import com.app.model.OrderType;
@Repository
public class OrderTypeDaoImpl implements IOrderTypeDao {
	@Autowired
private HibernateTemplate ht;
	@Override
	public Integer saveOrderType(OrderType s) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(s);
	}

	@Override
	public void updateOrderType(OrderType s) {
		// TODO Auto-generated method stub
ht.update(s);
	}

	@Override
	public void deleteOrderType(Integer id) {
		// TODO Auto-generated method stub
ht.delete(new OrderType(id));
	}

	@Override
	public OrderType getOneOrderType(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(OrderType.class, id);
	}

	@Override
	public List<OrderType> getAllOrderTypes() {
		// TODO Auto-generated method stub
		return ht.loadAll(OrderType.class);
	}

	@Override
	public List<Object[]> getUserTypeCount() {
		// TODO Auto-generated method stub
		String hql="SELECT orderTypes,COUNT(orderTypes) FROM com.app.model.OrderType GROUP BY orderTypes";
		@SuppressWarnings("unchecked")
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}

	@Override
	public boolean isOrderCodeExist(String orderCode) {
long count=0;
String hql="select count(orderCode) from com.app.model.OrdeType where orderCode=?0";
List<Long> list=(List<Long>) ht.find(hql, orderCode);
if(list!=null && !list.isEmpty())
{
	count=list.get(0);
}
		return count!=0?true:false;
	}

}
