package com.satish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satish.madel.Address;
import com.satish.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/saveAddress")
	public ResponseEntity<Address> saveAddress(@RequestBody Address address){
		Address saveAddress = addressService.saveAddress(address);
		return new ResponseEntity<Address>(saveAddress,HttpStatus.CREATED);
		
	}
}
