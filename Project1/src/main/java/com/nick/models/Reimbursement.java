package com.nick.models;

import java.sql.Timestamp;
//import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ers_reimbursement")
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_id")
	private int id;
	
	@Column(name="reimb_amount", nullable = false)
	private double amount;
	
	@Column(name="reimb_submitted", nullable = false)
	private Timestamp submitDate;
	
	@Column(name="reimb_resolved")
	private Timestamp resolveDate;
	
	@Column(name="reimb_description")
	private String description;
	
	@Column(name="reimb_receipt")
	private String receipt; // string for now, change later?
	
	@ManyToOne
	@JoinColumn(name="reimb_author", nullable = false)
	private User author;
	
	@ManyToOne
	@JoinColumn(name="reimb_resolver")
	private User resolver;
	
	@ManyToOne
	@JoinColumn(name="reimb_status_id", nullable = false)
	private ReimbursementStatus status;
	
	@ManyToOne
	@JoinColumn(name="reimb_type_id", nullable = false)
	private ReimbursementType type;

	
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Reimbursement(int id, double amount, Timestamp submitDate, Timestamp resolveDate, String description,
			String receipt, User author, User resolver, ReimbursementStatus status, ReimbursementType type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitDate = submitDate;
		this.resolveDate = resolveDate;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}



	public Reimbursement(double amount, Timestamp submitDate, Timestamp resolveDate, String description, String receipt,
			User author, User resolver, ReimbursementStatus status, ReimbursementType type) {
		super();
		this.amount = amount;
		this.submitDate = submitDate;
		this.resolveDate = resolveDate;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}



	public Reimbursement(double amount, Timestamp submitDate, User author, ReimbursementStatus status,
			ReimbursementType type) {
		super();
		this.amount = amount;
		this.submitDate = submitDate;
		this.author = author;
		this.status = status;
		this.type = type;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public Timestamp getSubmitDate() {
		return submitDate;
	}



	public void setSubmitDate(Timestamp submitDate) {
		this.submitDate = submitDate;
	}



	public Timestamp getResolveDate() {
		return resolveDate;
	}



	public void setResolveDate(Timestamp resolveDate) {
		this.resolveDate = resolveDate;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getReceipt() {
		return receipt;
	}



	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}



	public User getAuthor() {
		return author;
	}



	public void setAuthor(User author) {
		this.author = author;
	}



	public User getResolver() {
		return resolver;
	}



	public void setResolver(User resolver) {
		this.resolver = resolver;
	}



	public ReimbursementStatus getStatus() {
		return status;
	}



	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}



	public ReimbursementType getType() {
		return type;
	}



	public void setType(ReimbursementType type) {
		this.type = type;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + ((resolveDate == null) ? 0 : resolveDate.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submitDate == null) ? 0 : submitDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		} else if (!receipt.equals(other.receipt))
			return false;
		if (resolveDate == null) {
			if (other.resolveDate != null)
				return false;
		} else if (!resolveDate.equals(other.resolveDate))
			return false;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitDate == null) {
			if (other.submitDate != null)
				return false;
		} else if (!submitDate.equals(other.submitDate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitDate=" + submitDate + ", resolveDate="
				+ resolveDate + ", description=" + description + ", receipt=" + receipt + ", author=" + author
				+ ", resolver=" + resolver + ", status=" + status + ", type=" + type + "]";
	}
	
}
