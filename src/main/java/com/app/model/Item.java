package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;

@Entity
@Table(name="item_table")
@Data
public class Item {
	@Id
	@GeneratedValue
	@Column(name="itemId")
private Integer id;
	@Column(name="itemCode")
private String itemCode;
	@Column(name="wth")
private double width;
	@Column(name="l")
private double length;
	@Column(name="h")
private double height;
	@Column(name="basecost")
	private double baseCost;
	@Column(name="currencies")
	private String baseCurrency;
	@ManyToOne
	@JoinColumn(name="ItemUomFk")
	private UomType uom;
	@ManyToOne
	@JoinColumn(name="itemOrderFK")
	private OrderType order;
public Item() {
	super();
}
public Item(Integer id) {
	super();
	this.id = id;
}


}
