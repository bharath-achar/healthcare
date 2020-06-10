package com.capgemini.healthcare.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DiagnoseCenter")
public class DiagnoseCenter {

	@Id
	@Column(name = "CenterId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer centerId;

	@Column(name = "CenterName")
	private String centerName;

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

}
