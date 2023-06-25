package com.ScrumTool.User;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users_Table")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_Id")
	private long userId;
	@Column(name = "User_First_Name")
	private String userFirstName;

	@Column(name = " User_Last_Name")
	private String userlastName;

	@Column(name = "EmailId")
	private String emailId;
	
	@Column(name  = "Email_Confirmed")
	private Boolean emailConfirmed;
	
	@Column(name = "Confirmation_Token")
	private String confirmationToken;

	@Column(name = "Password")
	private String password;

	@Column(name = "Contact_Number")
	private String contactNumber;

	@Column(name = "Company_Name")
	private String companyName;

	@Column(name = "Country_Code")
	private String countrycode;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserlastName() {
		return userlastName;
	}

	public void setUserlastName(String userlastName) {
		this.userlastName = userlastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Boolean getEmailConfirmed() {
		return emailConfirmed;
	}

	public void setEmailConfirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long userId, String userFirstName, String userlastName, String emailId, Boolean emailConfirmed,
			String confirmationToken, String password, String contactNumber, String companyName, String countrycode) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userlastName = userlastName;
		this.emailId = emailId;
		this.emailConfirmed = emailConfirmed;
		this.confirmationToken = confirmationToken;
		this.password = password;
		this.contactNumber = contactNumber;
		this.companyName = companyName;
		this.countrycode = countrycode;
	}
}

	