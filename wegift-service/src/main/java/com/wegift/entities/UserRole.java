package com.wegift.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "WG_USER_ROLES")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 844565949738990984L;

	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(generator = "incregen")
	@GenericGenerator(name = "incregen", strategy = "increment")
	protected int roleId;
	@Column(name = "ROLE_CODE")
	protected String roleCode;
	@Column(name = "DESCRIPTION")
	protected String description;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
