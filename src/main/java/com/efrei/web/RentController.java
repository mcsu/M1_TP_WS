package com.efrei.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.efrei.domain.Vehicule;
import com.efrei.service.RentService;
@RestController

public class RentController {
	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)  
	@ResponseBody
	public List<Vehicule> listOfCars(){
		RentService rs = new RentService();
		return rs.getVehicules();
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)  
	@ResponseBody
	public String test(){
		return "测试";
	}
	
	/*@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)  
	@ResponseStatus(HttpStatus.OK)  
	@ResponseBody  
	public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{  }*/
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void getBack(@PathVariable("plateNumber") String plateNumber) throws Exception{  }
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)  
	@ResponseStatus(HttpStatus.OK)
	public void rent(@PathVariable("plateNumber") String plateNumber) throws Exception{
		RentService rs = new RentService();
		rs.rent(plateNumber);
			
	}
	
	@RequestMapping(value = "/carst/{plateNumber}", method = RequestMethod.GET)  
	@ResponseStatus(HttpStatus.OK)
	public String tt(@PathVariable("plateNumber") String plateNumber) throws Exception{
		return plateNumber;
			
	}
	
	@RequestMapping(value = "/voiture/{plateNumber}", method = RequestMethod.PUT)  
	@ResponseStatus(HttpStatus.OK)
	public void rentAndGetBack(@PathVariable("plateNumber") String plateNumber, @RequestParam(value="rent", required = true)boolean rent) throws Exception{  } 
}
