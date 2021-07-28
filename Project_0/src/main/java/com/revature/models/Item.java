package com.revature.models;

import java.util.ArrayList;
import java.util.TreeMap;

public class Item  { //implements Comparable<Item> { 
	
	private int serialNum;
	
	private double askingPrice;
	
	private double soldPrice;
	
	private double remainingBalance;
	
	private double paymentAmount;
	
	private String description = "";
	
	private boolean isOwned = false;
	
	//public ArrayList<Customer> offers = new ArrayList<Customer>();

	
	public Item() {
		
	}
	

	public Item(int serialNum, double askingPrice, double soldPrice, double remainingBalance, double paymentAmount,
			String description) {
		super();
		this.serialNum = serialNum;
		this.askingPrice = askingPrice;
		this.soldPrice = soldPrice;
		this.remainingBalance = remainingBalance;
		this.paymentAmount = paymentAmount;
		this.description = description;
	}


	public int getSerialNum() {
		return serialNum;
	}
	
	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}
	
	public double getRemainingBalance() {
		return remainingBalance;
	}
	
	public void setRemainingBalance(double remainingBalance) {
		this.remainingBalance = remainingBalance;
	}
	
	public double getPaymentAmount() {
		return paymentAmount;
	}
	
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
//	public void setOffers(ArrayList<Customer> offers) {
//		this.offers = offers;
//	}
		
	public double getSoldPrice() {
		return soldPrice;
	}
	
	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}
	
//	public ArrayList<Customer> getOffers() {
//		return offers;
//	}

	public boolean isOwned() {
		return isOwned;
	}

	public void setOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}

	public double getAskingPrice() {
		return askingPrice;
	}

	public void setAskingPrice(double askingPrice) {
		this.askingPrice = askingPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	// add interface for stuff below?:
	public void addOffer(Customer cust, double offer) {
		
		if (isOwned == false) { 
			cust.makeOffer(this, offer);
			//offers.add(cust); // fix this !!
		}
	}
	
	@Override
	public String toString() {
		return "Item [serialNum=" + serialNum + ", askingPrice=" + askingPrice + ", soldPrice=" + soldPrice
				+ ", remainingBalance=" + remainingBalance + ", paymentAmount=" + paymentAmount + ", description="
				+ description + ", isOwned=" + isOwned + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(askingPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (isOwned ? 1231 : 1237);
		temp = Double.doubleToLongBits(paymentAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(remainingBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + serialNum;
		temp = Double.doubleToLongBits(soldPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (Double.doubleToLongBits(askingPrice) != Double.doubleToLongBits(other.askingPrice))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (isOwned != other.isOwned)
			return false;
		if (Double.doubleToLongBits(paymentAmount) != Double.doubleToLongBits(other.paymentAmount))
			return false;
		if (Double.doubleToLongBits(remainingBalance) != Double.doubleToLongBits(other.remainingBalance))
			return false;
		if (serialNum != other.serialNum)
			return false;
		if (Double.doubleToLongBits(soldPrice) != Double.doubleToLongBits(other.soldPrice))
			return false;
		return true;
	}

//	public int compareTo(Item i) {
//		// TODO Auto-generated method stub
//		Integer s1 = this.getSerialNum();
//		Integer s2 = i.getSerialNum();
//		
//		return s1.compareTo(s2);
//		//srlNm = this.getSerialNum().compareTo(i.getSerialNum());  
//	}
	
	
}
