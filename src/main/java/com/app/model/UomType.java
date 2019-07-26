package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Uom_Tab")
@Data
public class UomType {
@Id
@GeneratedValue
@Column(name="uid")
private Integer id;
@Column(name="type")
private String userType;
@Column(name="model")
private String userModel;
@Column(name="note")
private String userNote;
public UomType() {
	super();
}
public UomType(Integer id) {
	super();
	this.id = id;
}



}
