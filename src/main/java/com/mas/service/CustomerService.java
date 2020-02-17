package com.mas.service;

import java.util.List;
import java.util.Optional;

import com.mas.domin.Contact;
import com.mas.entity.CustomerEntity;

public interface CustomerService {
	public Boolean saveCustomerDetails(Contact customerEntity);
	public List<Contact> getAllCustomerDetails();
	public  Contact editCustomerDetails(String customer_Id);
	public Integer delectCustomerDetails(String contact_id);
}
