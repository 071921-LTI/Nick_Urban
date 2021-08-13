package com.nick.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ers_user_roles")
public class UserRoles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ers_user_role_id")
	private int id;
	
	@Column(name="user_role", nullable = false)
	private String userRole;
	
	
	// Constructors
	public UserRoles() {
		super();
		// TODO Auto-generated constructor stub
	}


	// Constructors
	public UserRoles(String userRole) {
		super();
		this.userRole = userRole;
	}


	public UserRoles(int id, String userRole) {
		super();
		this.id = id;
		this.userRole = userRole;
	}


	// Getters and setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	// Equals and Hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
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
		UserRoles other = (UserRoles) obj;
		if (id != other.id)
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		return true;
	}


	// To string
	@Override
	public String toString() {
		return "UserRoles [id=" + id + ", userRole=" + userRole + "]";
	}
}
