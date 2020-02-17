package com.mas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
@Entity
@Table(name = "cus")
public class CustomerEntity {
	@Id
	@GenericGenerator(strategy = "com.mas.customgenrater.CustomGenrater", name = "mas_seq")
	@GeneratedValue(generator = "mas_seq")
	private String customer_id;
	private String customer_Name;
	private String customer_Email;
	private Integer mobile;
	@Column(name = "ACTIVE_FALG")
	private Character active_Falg;
	@CreationTimestamp
	private Date created_Date;
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date update_Date;
	private String created_By;
	private String update_By;

}
