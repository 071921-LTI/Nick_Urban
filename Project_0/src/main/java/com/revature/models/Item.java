package com.revature.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;

public class Item  { 
	
	private int id;
	
	private String description = "";
	
	private double askingPrice;
	
	private double soldPrice;
	
	private double weeklyPayments;
	
	private double remainingBalance;
	
	private double paymentAmount;
	
	private boolean isOwned = false;
	
	private Customer owner = new Customer();
	

	public Item(int id, String description, double askingPrice, double soldPrice, double weeklyPayments,
			double remainingBalance, double paymentAmount, boolean isOwned) {
		super();
		this.id = id;
		this.description = description;
		this.askingPrice = askingPrice;
		this.soldPrice = soldPrice;
		this.weeklyPayments = weeklyPayments;
		this.remainingBalance = remainingBalance;
		this.paymentAmount = paymentAmount;
		this.isOwned = isOwned;
	}

	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
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
		
	public double getSoldPrice() {
		return soldPrice;
	}
	
	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}
	
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
	
	public double getWeeklyPayments() {
		return weeklyPayments;
	}
	
	public boolean getIsOwned() {
		return isOwned;
	}
	
	public Customer getOwner() {
		return owner;
	}
	
	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	
	public Item() {
		
	}

	public void setWeeklyPayments(double weeklyPayments) {
		this.weeklyPayments = weeklyPayments;
	}

	
	@Override
	public String toString() {
		return "Item [id=" + id + ", description=" + description + ", askingPrice=" + askingPrice + ", soldPrice="
				+ soldPrice + ", weeklyPayments=" + weeklyPayments + ", remainingBalance=" + remainingBalance
				+ ", paymentAmount=" + paymentAmount + ", isOwned=" + isOwned + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(askingPrice, description, id, isOwned, paymentAmount, remainingBalance, soldPrice,
				weeklyPayments);
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
		return Double.doubleToLongBits(askingPrice) == Double.doubleToLongBits(other.askingPrice)
				&& Objects.equals(description, other.description) && id == other.id && isOwned == other.isOwned
				&& Double.doubleToLongBits(paymentAmount) == Double.doubleToLongBits(other.paymentAmount)
				&& Double.doubleToLongBits(remainingBalance) == Double.doubleToLongBits(other.remainingBalance)
				&& Double.doubleToLongBits(soldPrice) == Double.doubleToLongBits(other.soldPrice)
				&& Double.doubleToLongBits(weeklyPayments) == Double.doubleToLongBits(other.weeklyPayments);
	}
	
}
