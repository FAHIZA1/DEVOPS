package com.telecom.tel.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.tel.Dao.CsaDao;

import com.telecom.tel.Model.CustomerSupportAgent;

@Service
public class CsaServiceImpl implements CsaService{

	@Autowired
	CsaDao csaDao;

	@Override
	public List<CustomerSupportAgent> getAllCustomerSupportAgent() {
		return csaDao.findAll(); 
	}

	@Override
	public void addCustomerSupportAgent(CustomerSupportAgent csa) {
		csaDao.save(csa);
		
	}

	@Override
	public void deleteCustomerSupportAgent(int id) {
		csaDao.deleteById(id);
		
	}

	@Override
	public void editCustomerSupportAgent(CustomerSupportAgent csa) {
		csaDao.save(csa);
		
	}

	@Override
	public Optional<CustomerSupportAgent> getCustomerSupportAgent(int id) {
		return csaDao.findById(id);
	}
	
	@Override
	public boolean existsById(int id) {
		return csaDao.existsById(id);
	}

	@Override
	public List<CustomerSupportAgent> findAllByLocation(String location) {
		return csaDao.findAllByLocation(location);
	}
		
}

	

