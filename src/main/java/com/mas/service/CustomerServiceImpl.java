package com.mas.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mas.domin.Contact;
import com.mas.entity.CustomerEntity;
import com.mas.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Boolean saveCustomerDetails(Contact contect) {
		contect.setActive_Falg('y');
		CustomerEntity customerEntity = new CustomerEntity();
		BeanUtils.copyProperties(contect, customerEntity);
		customerEntity.setCreated_By("masood");
		customerEntity.setUpdate_By("masood");
		CustomerEntity save = customerRepository.save(customerEntity);
		return save != null;
	}

	@Override
	public List<Contact> getAllCustomerDetails() {
		Character cha = 'y';
		List<Contact> contactList = new ArrayList<Contact>();
		List<CustomerEntity> findByActive_Falg = customerRepository.findByActive_Falg(cha);
		for (CustomerEntity customerEntity : findByActive_Falg) {
			Contact contact = new Contact();
			BeanUtils.copyProperties(customerEntity, contact);
			contactList.add(contact);
		}
		return contactList;
	}

	@Override
	public Contact editCustomerDetails(String customer_Id) {
		Contact contact = new Contact(); 
		Optional<CustomerEntity> findById = customerRepository.findById(customer_Id);
		if(findById.isPresent()) {
			CustomerEntity customerEntity =findById.get();
			BeanUtils.copyProperties(customerEntity, contact);
		}
		return contact;
	}

	public Integer delectCustomerDetails(String contact_id) {
	 Integer softDelect = customerRepository.softDelect(contact_id);
		return softDelect;
	}

}
