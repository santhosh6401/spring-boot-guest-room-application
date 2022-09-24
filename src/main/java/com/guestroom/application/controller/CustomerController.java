package com.guestroom.application.controller;


import com.guestroom.application.model.entity.CustomerEntity;
import com.guestroom.application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public CustomerEntity create(@RequestBody CustomerEntity customerEntity) {
        return customerService.save(customerEntity);
    }

    @PutMapping("/edit/{customerName}")
    public String update(@PathVariable("customerName") String customerName, @RequestBody CustomerEntity customerEntity) {
        return customerService.update(customerName,customerEntity);
    }

    @DeleteMapping("/delete/{customerName}")
    public String delete(@PathVariable("customerName") String customerName) {
        return customerService.delete(customerName);
    }

    @GetMapping("/get/{customerName}")
    public CustomerEntity findById(@PathVariable String customerName){
        return customerService.findById(customerName);
    }

}
