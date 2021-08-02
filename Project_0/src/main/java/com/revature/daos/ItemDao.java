package com.revature.daos;

import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Item;

public interface ItemDao {
	public abstract Item getItemById(int id);
	public abstract List<Item> getItems();
	public abstract List<Item> getAvailableItems();
	public abstract List<Item> getCustomerOwnedItems(Customer customer);
	public abstract int addItem(Item item);
	public abstract int updateItem(Item item);
	public abstract int deleteItem(int id);
	public abstract Item getItemByDescription(String description);	
}
