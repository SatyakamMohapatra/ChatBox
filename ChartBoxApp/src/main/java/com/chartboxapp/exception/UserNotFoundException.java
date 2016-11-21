
package com.chartboxapp.exception;

public class UserNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userID ;
	
	public UserNotFoundException(int userID) {
		this.userID=userID;
	}
	
	@Override
	public String toString() {
		return "userID "+userID+" doesnot exist";
	}

}
