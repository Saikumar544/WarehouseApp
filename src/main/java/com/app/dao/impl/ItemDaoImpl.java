package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;
@Repository
public class ItemDaoImpl implements IItemDao{
	@Autowired
private HibernateTemplate ht;
	@Override
	public Integer saveItem(Item s) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(s);
	}

	@Override
	public void updateItem(Item s) {
		// TODO Auto-generated method stub
		ht.update(s);
	}

	@Override
	public void deleteItem(Integer id) {
		// TODO Auto-generated method stub
		ht.delete(new Item(id));
	}

	@Override
	public Item getOneItem(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(Item.class, id);
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return ht.loadAll(Item.class);
	}

	@Override
	public boolean isItemCodeExists(String itemCode) {
		long count=0;
		String hql="select count(itemCode) from com.app.model.Item where itemCode=?0";
		List<Long> list=(List<Long>) ht.find(hql, itemCode);
		if(list!=null && !list.isEmpty())
		{
			count=list.get(0);
		}
		return count!=0?true:false;
	}
	
	public List<Item> getItemsByItemCode(String itemCode) {
		String hql="from com.app.Item where itemCode=?0";
		List<Item> itemCodes=(List<Item>) ht.find(hql, "itemCode");

				return itemCodes;
			}
	
}
