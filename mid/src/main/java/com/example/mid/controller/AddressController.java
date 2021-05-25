package com.example.mid.controller;

import com.example.mid.Service.AddressService;
import com.example.mid.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;


    @PostMapping()
    public void createAddress(@RequestBody Address address){
        addressService.createAddress(address);
    }

    @PatchMapping("/{id}")
    public void updateUserId(@PathVariable Long id, @RequestParam Long userId){
        addressService.updateUserId(id, userId);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@RequestParam Long id){
        addressService.deleteAddress(id);
    }

}
