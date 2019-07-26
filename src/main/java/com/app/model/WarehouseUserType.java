package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;


@Entity
@Table(name="warehouse_user")
public class WarehouseUserType {
	@Id
	@GeneratedValue
	@Column(name="ukey")
	private Integer id;
	@Column(name="u_type")
	private String uType;
	@Column(name="ucode")
	private String uCode;
	@Column(name="ufor")
	private String userFor;
	@NonNull
	@Column(name="umail")
	private String uMail;
	@Column(name="ucontact")
	@NonNull
	private String uContact;
	@Column(name="uidtype")
	private  String uIdType;
	@Column(name="warenumber")	
	private String idNumber;

	public WarehouseUserType() {
		super();
	}
	public WarehouseUserType(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getuType() {
		return uType;
	}
	public void setuType(String uType) {
		this.uType = uType;
	}
	public String getuCode() {
		return uCode;
	}
	public void setuCode(String uCode) {
		this.uCode = uCode;
	}
	public String getUserFor() {
		return userFor;
	}
	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}
	public String getuMail() {
		return uMail;
	}
	public void setuMail(String uMail) {
		this.uMail = uMail;
	}
	public String getuContact() {
		return uContact;
	}
	public void setuContact(String uContact) {
		this.uContact = uContact;
	}
	public String getuIdType() {
		return uIdType;
	}
	public void setuIdType(String uIdType) {
		this.uIdType = uIdType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	@Override
	public String toString() {
		return "WarehouseUserType [id=" + id + ", uType=" + uType + ", uCode=" + uCode + ", userFor=" + userFor
				+ ", uMail=" + uMail + ", uContact=" + uContact + ", uIdType=" + uIdType + ", idNumber=" + idNumber
				+ "]";
	}
	
	
}
