package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="sale_order")
public class SaleOrder {
	@Id
	@GeneratedValue
	@Column(name="sale_order_id")
private Integer id;
	@Column(name="sale_order_code")
	private String saleOrderCode;
	@ManyToOne
	@JoinColumn(name="shipmentCode")
	private ShipmentType shipmentType;
	@Column(name="refnumber")
	private String refNumber;
	@Column(name="stock_mode")
	private String stockMode;
	@Column(name="stock_source")
	private String stockSource;
	@Column(name="default_status")
	private String status;
	@Column(name="description")
	private String description;
	public SaleOrder(Integer id) {
		super();
		this.id = id;
	}
	public SaleOrder() {
		// TODO Auto-generated constructor stub
	}
	
	
}
