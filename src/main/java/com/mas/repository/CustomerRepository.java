package com.mas.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mas.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, String> {
	@Query(value = "SELECT * from CUS WHERE ACTIVE_FALG= :active_Falg", nativeQuery = true)
	public List<CustomerEntity> findByActive_Falg(Character active_Falg);

	@Modifying
	@Transactional
	//@Query(value = "UPDATE CUS SET ACTIVE_FALG ='n' WHERE CUSTOMER_ID = :i")
	@Query(value = "UPDATE CUS SET ACTIVE_FALG = 'n' WHERE CUSTOMER_ID = :i", nativeQuery = true)
	public Integer softDelect(String i);
}
