package com.app.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="docstb")
@Data
public class Document {
	@Id
	@GeneratedValue
	@Column(name="fileid")
private Integer fId;
	@Column(name="fileName")
	private String fName;
	@Lob
	@Column(name="fileData")
	private byte[] fData;
	public Document() {
		super();
	}
	public Integer getfId() {
		return fId;
	}
	public void setfId(Integer fId) {
		this.fId = fId;
	}
	
}
