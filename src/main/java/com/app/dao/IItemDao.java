package com.app.dao;

import java.util.List;

import com.app.model.Item;
public interface IItemDao {
		public Integer saveItem(Item s);
		public void updateItem(Item s);
		public void deleteItem(Integer id);
		public Item getOneItem(Integer id);
		public List<Item> getAllItems();
		boolean isItemCodeExists(String itemCode);
		List<Item> getItemsByItemCode(String itemCode);
}
