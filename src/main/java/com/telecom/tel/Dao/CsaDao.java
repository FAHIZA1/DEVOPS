package com.telecom.tel.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.tel.Model.CustomerSupportAgent;

@Repository
public interface CsaDao extends JpaRepository<CustomerSupportAgent,Integer>{

	List<CustomerSupportAgent> findAllByLocation(String location);

}
