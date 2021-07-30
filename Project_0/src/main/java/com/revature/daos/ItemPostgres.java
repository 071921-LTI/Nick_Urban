package com.revature.daos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Item;
import com.revature.util.ConnectionUtil;

public class ItemPostgres implements ItemDao {

	@Override
	public Item getItemById(int id) {
		String sql = "select * from employees where id = ?;";
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
				
				itm = new Item(ownerId, description, askingPrice, soldPrice, weeklyPayments, remainingBalance, paymentAmount, isOwned);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return itm;
	}

	@Override
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
				
				Item itm = new Item(ownerId, description, askingPrice, soldPrice, weeklyPayments, remainingBalance, paymentAmount, isOwned);
				items.add(itm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addItem(Item item) {
		int id = -1;
		String sql = "insert into items (description, asking_price, sold_price, weekly_payments, remaining_balance, payment_amount, is_owned, owner_id) values (?,?,?,?,?,?,?,?) returning id;";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item.getDescription());
			ps.setDouble(2, item.getAskingPrice());
			ps.setDouble(3, item.getSoldPrice());
			ps.setDouble(4, item.getWeeklyPayments());
			ps.setDouble(5, item.getRemainingBalance());
			ps.setDouble(6, item.getPaymentAmount());
			ps.setBoolean(7, item.getIsOwned());
			ps.setInt(8, 0); // FIGURE THIS OUT
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public boolean updateItem(Item item) {
		// TODO Auto-generated method stub
		return false;
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
