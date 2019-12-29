package com.zensar.user.app.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9071449247769449891L;

	@NotNull(message = "Name should not null")
	@NotEmpty(message= "Name should not empty")
	private String userName;

	@NotNull(message = "Pin should not null")
	@NotEmpty(message = "Pin should not empty")
	@Pattern(regexp = "[\\d]{6}", message = "Pin should be 6 digit and only contain numbers")
	private String pin;

	@NotNull(message = "Email should not null")
	@NotEmpty(message = "Email should not empty")
	@Email
	private String email;

	@NotNull(message = "Mobile should not null")
	@NotEmpty(message = "Mobile should not empty")
	@Pattern(regexp = "[\\d]{10}", message = "Mobile number should be 10 digit")
	private String mobile;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "UserRequest [userName=" + userName + ", pin=" + pin + ", email=" + email + ", mobile=" + mobile + "]";
	}

}
