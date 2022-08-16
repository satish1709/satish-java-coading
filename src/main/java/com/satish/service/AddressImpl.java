package com.satish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satish.madel.Address;
import com.satish.repository.AddressRepository;

@Service
public class AddressImpl implements AddressService {

	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

}
