package com.guestroom.application.service;


import com.guestroom.application.model.entity.CustomerEntity;
import com.guestroom.application.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    /** Save **/
    public CustomerEntity save(CustomerEntity customerEntity) {
        customerRepository.save(customerEntity);
        return  customerEntity;
    }

    /** Update **/
    public String update(String customerName, CustomerEntity customerEntity) {
        if(customerRepository.existsById(customerName)){
            CustomerEntity entity = customerRepository.findById(customerName).get();
            BeanUtils.copyProperties(customerEntity,entity);
            customerRepository.save(entity);
            return "Updated Successfully......";
        }
        return "Updated Failed && CustomerName Not Available......";
    }

    /** Delete **/
    public String delete(String customerName) {
        if(customerRepository.existsById(customerName)){
            customerRepository.deleteById(customerName);
            return  "Deleted Successfully.....";
        }
        return "Deleted Failed......";
    }

    /** Get **/

    public CustomerEntity findById(String customerName) {
        if(customerRepository.existsById(customerName)){
            return customerRepository.findById(customerName).get();
        }
        return null;
    }
}
