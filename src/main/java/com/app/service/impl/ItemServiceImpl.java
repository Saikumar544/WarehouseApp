package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService {
	@Autowired
	private IItemDao dao;

	@Override
	@Transactional
	public Integer saveItem(Item s) {
		// TODO Auto-generated method stub
		return dao.saveItem(s);
	}

	@Override
	@Transactional
	public void updateItem(Item s) {
		// TODO Auto-generated method stub
		dao.updateItem(s);
	}

	@Override
	@Transactional
	public void deleteItem(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteItem(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Item getOneItem(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOneItem(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return dao.getAllItems();
	}

	@Override
	public boolean isItemCodeExists(String itemCode) {
		// TODO Auto-generated method stub
		return dao.isItemCodeExists(itemCode);
	}

	@Override
	public List<Item> getItemsByItemCode(String itemCode) {
		// TODO Auto-generated method stub
		return dao.getItemsByItemCode(itemCode);
	}

}
