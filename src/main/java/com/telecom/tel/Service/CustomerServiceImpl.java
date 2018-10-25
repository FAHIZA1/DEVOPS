package com.telecom.tel.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.tel.Dao.CustomerDao;
import com.telecom.tel.Model.Customer;
import com.telecom.tel.Model.CustomerSupportAgent;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	public CustomerDao custDao;
	
	@Override
	public List<Customer> getAllCustomers() {
		return custDao.findAll(); 
	}

	@Override
	public void addCustomer(Customer cust) {
		 custDao.save(cust);
	}

	@Override
	public void deleteCustomer(int id) {
		custDao.deleteById(id);
	}

	@Override
	public void editCustomer(Customer cust) {
	     custDao.save(cust);
	}

	@Override
	public Optional<Customer> getCustomer(int id) {
		return custDao.findById(id);
	}

	@Override
	public boolean existsByGovId(int govId) {
		return custDao.existsById(govId);
	}

	@Override
	public Customer getCustomerByGgovtID(int ggovtID) {
		Customer customer = null;
		
		Optional<Customer> optCust = custDao.findById(ggovtID);
		if(optCust.isPresent()) {
			customer = optCust.get();
		}
		return customer;
	}

	
	@Override
	public List<Customer> findAllByTelecomCircle(String telecomCircle) {
		return custDao.findAllByTelecomCircle(telecomCircle);
	}
}
