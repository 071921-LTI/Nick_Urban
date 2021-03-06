package com.revature.daos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.util.ConnectionUtil;

public class ItemPostgres implements ItemDao {

	@Override
	public Item getItemById(int id) {
		String sql = "select * from items where id = ?;";
		Item itm = null;
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				int iId = rs.getInt("id");
				String description = rs.getString("description");
				double askingPrice = rs.getDouble("asking_price");
				double soldPrice = rs.getDouble("sold_price");
				double weeklyPayments = rs.getDouble("weekly_payments");
				double remainingBalance = rs.getDouble("remaining_balance");
				double paymentAmount = rs.getDouble("payment_amount");
				boolean isOwned = rs.getBoolean("is_owned");
				int ownerId = rs.getInt("owner_id");
				
				itm = new Item(iId, description, askingPrice, soldPrice, weeklyPayments, remainingBalance, paymentAmount, isOwned, ownerId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return itm;
	}

	@Override
	public List<Item> getAvailableItems() {
		List<Item> items = new ArrayList<Item>();
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			String sql = "select * from items where is_owned = false;";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int iId = rs.getInt("id");
				String description = rs.getString("description");
				double askingPrice = rs.getDouble("asking_price");
				double soldPrice = rs.getDouble("sold_price");
				double weeklyPayments = rs.getDouble("weekly_payments");
				double remainingBalance = rs.getDouble("remaining_balance");
				double paymentAmount = rs.getDouble("payment_amount");
				boolean isOwned = rs.getBoolean("is_owned");
				int ownerId = rs.getInt("owner_id");
				
				Item itm = new Item(iId, description, askingPrice, soldPrice, weeklyPayments, remainingBalance, paymentAmount, isOwned, ownerId);
				items.add(itm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}
	
	@Override
	public List<Item> getCustomerOwnedItems(Customer customer) {
		List<Item> items = new ArrayList<Item>();
		int custId = customer.getId();
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			String sql = "select * from items where owner_id = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, custId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int iId = rs.getInt("id");
				String description = rs.getString("description");
				double askingPrice = rs.getDouble("asking_price");
				double soldPrice = rs.getDouble("sold_price");
				double weeklyPayments = rs.getDouble("weekly_payments");
				double remainingBalance = rs.getDouble("remaining_balance");
				double paymentAmount = rs.getDouble("payment_amount");
				boolean isOwned = rs.getBoolean("is_owned");
				int ownerId = rs.getInt("owner_id");
				
				Item itm = new Item(iId, description, askingPrice, soldPrice, weeklyPayments, remainingBalance, paymentAmount, isOwned, ownerId);
				items.add(itm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}

	
	public List<Item> getItems() {
		List<Item> items = new ArrayList<Item>();
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			String sql = "select * from items;";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int iId = rs.getInt("id");
				String description = rs.getString("description");
				double askingPrice = rs.getDouble("asking_price");
				double soldPrice = rs.getDouble("sold_price");
				double weeklyPayments = rs.getDouble("weekly_payments");
				double remainingBalance = rs.getDouble("remaining_balance");
				double paymentAmount = rs.getDouble("payment_amount");
				boolean isOwned = rs.getBoolean("is_owned");
				int ownerId = rs.getInt("owner_id");
				
				Item itm = new Item(iId, description, askingPrice, soldPrice, weeklyPayments, remainingBalance, paymentAmount, isOwned, ownerId);
				items.add(itm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}
	
	@Override
	public int addItem(Item item) {
		int id = -1;
		String sql = "insert into items "
				+ "(description, "
				+ "asking_price, "
				+ "sold_price, "
				+ "weekly_payments, "
				+ "remaining_balance, "
				+ "payment_amount, "
				+ "is_owned, "
				+ "owner_id) "
				+ "values (?,?,?,?,?,?,?,?) " // removed last "?" here
				+ "returning id;";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item.getDescription());
			ps.setDouble(2, item.getAskingPrice());
			ps.setDouble(3, item.getSoldPrice());
			ps.setDouble(4, item.getWeeklyPayments());
			ps.setDouble(5, item.getRemainingBalance());
			ps.setDouble(6, item.getPaymentAmount());
			ps.setBoolean(7, item.getIsOwned());
			ps.setNull(8, 0); // works but not sure if its right
			
			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public int updateItem(Item item) {
		int rowsChanged = -1;
		String sql = "update items set "
				+ "description = ?, "
				+ "asking_price  = ?, "
				+ "sold_price  = ?, "
				+ "weekly_payments  = ?, "
				+ "remaining_balance  = ?, "
				+ "payment_amount  = ?, "
				+ "is_owned  = ?, "
				+ "owner_id  = ? "
				+ "where id = ?";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item.getDescription());
			ps.setDouble(2, item.getAskingPrice());
			ps.setDouble(3, item.getSoldPrice());
			ps.setDouble(4, item.getWeeklyPayments());
			ps.setDouble(5, item.getRemainingBalance());
			ps.setDouble(6, item.getPaymentAmount());
			ps.setBoolean(7, item.getIsOwned());
			ps.setInt(8, item.getOwnerId());
			ps.setInt(9, item.getId());

			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rowsChanged;
	}
	
	public int updateItemSold(Item item, Offer offer) {
		int rowsChanged = -1;
		String sql = "update items set "
				+ "description = ?, "
				+ "asking_price  = ?, "
				+ "sold_price  = ?, "
				+ "weekly_payments  = ?, "
				+ "remaining_balance  = ?, "
				+ "payment_amount  = ?, "
				+ "is_owned  = ?, "
				+ "owner_id  = ? "
				+ "where id = ?";
		
		Customer customer = offer.getCustomer();
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item.getDescription());
			ps.setDouble(2, item.getAskingPrice());
			ps.setDouble(3, offer.getOfferAmount());
			ps.setDouble(4, offer.getOfferAmount() / 12); //item.getWeeklyPayments());
			ps.setDouble(5, offer.getOfferAmount()); //item.getRemainingBalance());
			ps.setDouble(6, item.getPaymentAmount());
			ps.setBoolean(7, true);
			ps.setInt(8, customer.getId());
			ps.setInt(9, item.getId());

			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rowsChanged;
	}

	@Override
	public int deleteItem(int id) {
		int rowsChanged = -1;
		String sql = "delete from items where id = ?;";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rowsChanged;
	}

	@Override
	public Item getItemByDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}

}
