package com.telecom.tel.Service;

import java.util.List;
import java.util.Optional;

import com.telecom.tel.Model.CustomerSupportAgent;

public interface CsaService {

	List<CustomerSupportAgent> getAllCustomerSupportAgent();
	void addCustomerSupportAgent(CustomerSupportAgent csa);
	void deleteCustomerSupportAgent(int id);
	void editCustomerSupportAgent(CustomerSupportAgent csa);
	Optional<CustomerSupportAgent> getCustomerSupportAgent(int id);

	
	boolean existsById(int id);
	List<CustomerSupportAgent> findAllByLocation(String location);
}
