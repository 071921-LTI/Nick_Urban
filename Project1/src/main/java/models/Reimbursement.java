package models;

import java.sql.Timestamp;

public class Reimbursement {
	
	private int id;
	private double amount;
	private Timestamp submitDate;
	private Timestamp resolveDate;
	private String description;
	private String receipt; // string for now, change later?
	private int authorId;
	private int resolverId;
	private int statusId;
	private int typeId;
	
	
	// Constructors
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(double amount, Timestamp submitDate, Timestamp resolveDate, String description, String receipt,
			int authorId, int resolverId, int statusId, int typeId) {
		super();
		this.amount = amount;
		this.submitDate = submitDate;
		this.resolveDate = resolveDate;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public Reimbursement(int id, double amount, Timestamp submitDate, Timestamp resolveDate, String description,
			String receipt, int authorId, int resolverId, int statusId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitDate = submitDate;
		this.resolveDate = resolveDate;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public Reimbursement(int id, double amount, Timestamp submitDate, int authorId, int statusId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitDate = submitDate;
		this.authorId = authorId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	
	// Getters and setters
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

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	
	// Equals and Hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + authorId;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + ((resolveDate == null) ? 0 : resolveDate.hashCode());
		result = prime * result + resolverId;
		result = prime * result + statusId;
		result = prime * result + ((submitDate == null) ? 0 : submitDate.hashCode());
		result = prime * result + typeId;
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
		if (authorId != other.authorId)
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
		if (resolverId != other.resolverId)
			return false;
		if (statusId != other.statusId)
			return false;
		if (submitDate == null) {
			if (other.submitDate != null)
				return false;
		} else if (!submitDate.equals(other.submitDate))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}

	
	// To string
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitDate=" + submitDate + ", resolveDate="
				+ resolveDate + ", description=" + description + ", receipt=" + receipt + ", authorId=" + authorId
				+ ", resolverId=" + resolverId + ", statusId=" + statusId + ", typeId=" + typeId + "]";
	}
}
