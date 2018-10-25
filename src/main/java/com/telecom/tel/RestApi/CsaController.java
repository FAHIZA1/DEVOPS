package com.telecom.tel.RestApi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.tel.Model.CustomerSupportAgent;
import com.telecom.tel.Service.CsaService;

@RestController
@RequestMapping("/csa")
@CrossOrigin
public class CsaController {
	
	@Autowired
	CsaService csaService;

	@GetMapping
	public ResponseEntity<List<CustomerSupportAgent>> getAllCustomerSupportAgent(){
		return new ResponseEntity<>(csaService.getAllCustomerSupportAgent(),HttpStatus.OK);
	}
	
	@PostMapping
	public void addCustomerSupportAgent(@RequestBody CustomerSupportAgent csa) {
		csaService.addCustomerSupportAgent(csa);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCustomerSupportAgent(@PathVariable("id") int id) {
		csaService.deleteCustomerSupportAgent(id);
	}
	
	@PutMapping("/edit")
	public void editCustomerSupportAgent(@RequestBody CustomerSupportAgent csa) {
		csaService.editCustomerSupportAgent(csa);
		
	}
	
	@GetMapping("/getAll/{location}")
	public List<CustomerSupportAgent> getCsaLocation(@PathVariable("location") String location){
		return csaService.findAllByLocation(location);
	}
	
	@GetMapping("/getOne/{id}")
	public Optional<CustomerSupportAgent> getCustomerSupportAgent(@PathVariable("id") int id){
		return csaService.getCustomerSupportAgent(id);
	}
	
}
