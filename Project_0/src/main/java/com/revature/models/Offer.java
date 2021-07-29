package com.revature.models;

public class Offer {
	
	public Customer customer;

	public Item item;
	
	public double offerAmount;

	public Offer(Customer customer, Item item, double offerAmount) {
		super();
		this.customer = customer;
		this.item = item;
		this.offerAmount = offerAmount;
	}

	public Offer(Offer offer) {
		// TODO Auto-generated constructor stub
	}

	public Offer() {
		// TODO Auto-generated constructor stub
	}



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(double offerAmount) {
		this.offerAmount = offerAmount;
	}

	@Override
	public String toString() {
		return "Offer [customer=" + customer + ", item=" + item + ", offerAmount=" + offerAmount + "]";
	}
	
	
}
