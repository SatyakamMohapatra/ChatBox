package com.chartboxapp.dto;

import java.util.Date;
import com.chartboxapp.domain.RegisterBO;

public class RegisterDTO{
	
	private int userID;
	private String userName;
	private String userEmail;
	private String userPassword;
	private Date userCreateDate;
	private RegisterBO registerBO;
	
	public Date getUserCreateDate() {
		return userCreateDate;
	}
	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	@Override
	public String toString() {
		return "RegisterDto [userID=" + userID + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + "]";
	}	
	
	
	
}
