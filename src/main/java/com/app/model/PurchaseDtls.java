package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="puchase_details")
public class PurchaseDtls {
@Id
@GeneratedValue
private Integer id;
private Integer orderCode;
private Double quantity;
@JoinColumn(name="item_code")
@ManyToOne
private Item item;
public PurchaseDtls() {
	super();
}
public PurchaseDtls(Integer id) {
	super();
	this.id = id;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getOrderCode() {
	return orderCode;
}
public Double getQuantity() {
	return quantity;
}
public void setQuantity(Double quantity) {
	this.quantity = quantity;
}
public Item getItem() {
	return item;
}
public void setItem(Item item) {
	this.item = item;
}
public void setOrderCode(Integer orderCode) {
	this.orderCode = orderCode;
}
@Override
public String toString() {
	return "PurchaseDtls [id=" + id + ", orderCode=" + orderCode + ", quantity=" + quantity + ", item=" + item + "]";
}



}
