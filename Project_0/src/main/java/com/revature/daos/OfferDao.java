package com.revature.daos;

import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Offer;

public interface OfferDao {
	public abstract Offer getOfferById(int id);
	public abstract List<Offer> getOffers();
	public abstract List<Offer> getCustomerOffers(Customer customer);
	public abstract int addOffer(Offer offer);
	public abstract int deleteOffer(int id);
}
