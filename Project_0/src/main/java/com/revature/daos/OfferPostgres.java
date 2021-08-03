package com.revature.daos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.revature.models.Customer;
import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.util.ConnectionUtil;

public class OfferPostgres implements OfferDao {

	@Override
	public Offer getOfferById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offer> getOffers() {
		List<Offer> offers = new CopyOnWriteArrayList<>();

		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			String sql = "select * from offers;";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				int custId = rs.getInt("cust_id");
				int itemId = rs.getInt("item_id");
				double offerAmt = rs.getDouble("offer_amount");

				CustomerPostgres cp = new CustomerPostgres();
				Customer cust = cp.getCustomerById(custId);
				ItemPostgres ip = new ItemPostgres();
				Item item = ip.getItemById(itemId);


				Offer offer = new Offer(id, cust, item, offerAmt); 
				offers.add(offer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return offers;
	}

	@Override
	public List<Offer> getCustomerOffers(Customer customer) {
		List<Offer> offers = new CopyOnWriteArrayList<Offer>();
		int custId = customer.getId();

		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			String sql = "select * from offers where cust_id = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, custId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				//int custId = rs.getInt("cust_id");
				int itemId = rs.getInt("item_id");
				double offerAmt = rs.getDouble("offer_amount");

				CustomerPostgres cp = new CustomerPostgres();
				//Customer cust = cp.getCustomerById(custId);
				ItemPostgres ip = new ItemPostgres();
				Item item = ip.getItemById(itemId);

				Offer offer = new Offer(customer, item, offerAmt);
				offers.add(offer);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return offers;
	}

	@Override
	public int addOffer(Offer offer)  {
		int id = -1;
		String sql = "insert into offers (cust_id, item_id, offer_amount) values (?,?,?) returning id;";

		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, offer.getCustomer().getId());
			ps.setInt(2, offer.getItem().getId());
			ps.setDouble(3, offer.getOfferAmount());

			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}

	@Override
	public int deleteOffer(int id) {
		int rowsChanged = -1;
		String sql = "delete from offers where id = ?;";
		
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
	
	public int deleteAllOffersForItem(int itemId) {
		int rowsChanged = -1;
		String sql = "delete from offers where item_id = ?;";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			
			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowsChanged;
	}
}

