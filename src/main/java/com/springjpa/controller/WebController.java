package com.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.model.Customer;
import com.springjpa.repo.CustomerRepository;

@RestController
public class WebController {
@Autowired
CustomerRepository repository;
@RequestMapping("/save")
public String proccess()
{
repository.save(new Customer("Jack","Smith"));
repository.save(new Customer("Kim","Smith"));
repository.save(new Customer("Adam","Johnson"));
repository.save(new Customer("David","Williams"));
return "Done";
}
@RequestMapping("/findall")
public String findAll() {
	String result="<html>";
	for(Customer cust:repository.findAll()) {
		result+="<div>"+cust.toString()+"</div>";
				}
	return result+"</html>";
}
@RequestMapping("/findbyid")
public String findById(@RequestParam("id") long id) {
	String result="";
	  
		result=repository.findById(id).toString();
				
	return result;
}

@RequestMapping("/findbylastname")
public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
	String result="<html>";
	for(Customer cust:repository.findByLastName(lastName)) {
		result+="<div>"+cust.toString()+"</div>";
				}
	return result+"</html>";
}

}
