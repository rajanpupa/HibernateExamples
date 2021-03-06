package org.javabrains.kaushik.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
/**
 * 
 * @author Rajan
 * Some class names could not be mapped as table name in db.(keywords)
 * 
 * Annotations could also be put in the getters, in which case hibernate picks value from getter.
 * 
 */

@Entity(name="USER_DETAILS")
//@Table(name="USER_DETAILS")
public class UserDetails {
	
	// @EmbeddedId // if multiple fields primary key is required. combination has to be unique
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="USER_ID")
	int userId;
	@Column(name="USER_NAME")
	String userName;
	@Basic(fetch=FetchType.LAZY, optional=true)
	String fullName;
	@Transient //don't save it in db
	boolean flag;
	@Temporal(TemporalType.DATE)
	Date joinedDate;
	@Lob // large object
	String description;
	
	//@Embedded // columns are created in this table itself
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="Home_street_name")),
		@AttributeOverride(name="city",column=@Column(name="Home_city_name")),
	    @AttributeOverride(name="state",column=@Column(name="Home_state_name")),
	    @AttributeOverride(name="zip",column=@Column(name="Home_zip_name"))
	})
	Address homeAddress;
	
	Address officeAddress;
	
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
