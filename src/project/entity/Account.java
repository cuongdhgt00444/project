/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.entity;

/**
 *
 * @author Cuong
 */
public class Account {
    private int id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dob;
    private boolean receiveDailyEmail;
    private int role;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the receiveDailyEmail
	 */
	public boolean isReceiveDailyEmail() {
		return receiveDailyEmail;
	}
	/**
	 * @param receiveDailyEmail the receiveDailyEmail to set
	 */
	public void setReceiveDailyEmail(boolean receiveDailyEmail) {
		this.receiveDailyEmail = receiveDailyEmail;
	}
	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}
    
}
