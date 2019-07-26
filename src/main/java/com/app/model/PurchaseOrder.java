package com.app.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "purchase_table")
@Data
@ToString
public class PurchaseOrder {
	@Id
	@GeneratedValue
	@Column(name = "pid")
	private Integer id;
	@Column(name = "pcode")
	private String orderCode;
	@Column(name = "refNumber")
	private String referenceNumber;
	@Column(name = "qCheck")
	private String qualityCheck;
	@Column(name = "dStatus")
	private String defaultStatus;
	@Column(name = "notes")
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "order_Ship")
	@Getter @Setter private ShipmentType shipmentType;
	@ManyToOne
	@JoinColumn(name="order_whType")
	private WarehouseUserType warehouseType;
	public PurchaseOrder(Integer id) {
		super();
		this.id = id;
	}
	public PurchaseOrder() {
		super();
	}
	

}
