package com.qa.repository.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "users")
public class Users {
	@Id
    private String username;

    private String password;
    
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean enabled;
    
    private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", enabled=" + enabled + ", role=" + role
				+ "]";
	}
    
}
