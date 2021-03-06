package com.example.mid.Service;

import com.example.mid.model.Address;
import com.example.mid.model.User;
import com.example.mid.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void createAddress(Address address) {

        Address newAddress = new Address();
        newAddress.setStreet(address.getStreet());
        newAddress.setBuildingNo(address.getBuildingNo());
        newAddress.setUserId(null);
        addressRepository.saveAndFlush(newAddress);

    }

    public void updateUserId(Long id, Long userId){

        Address address = addressRepository.findById(id).get();
        address.setUserId(userId);
        addressRepository.saveAndFlush(address);

    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }




}


