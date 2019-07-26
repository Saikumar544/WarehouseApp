package com.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="order_table")
@Data
public class OrderType {
@Id
@GeneratedValue
@Column(name="oid")
private Integer id;
@Column(name="omode")
private String orderMode;
@Column(name="ocode")
private String orderCode;
@Column(name="otype")
private String orderTypes;
@Column(name="omaccpt")
@ElementCollection(fetch=FetchType.EAGER)
private List<String> accept;
@Column(name="notes")
private String description;
public OrderType() {
	super();
}
public OrderType(Integer id) {
	super();
	this.id = id;
}

}
