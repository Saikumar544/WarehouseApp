package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.OrderType;
import com.app.model.UomType;
import com.app.service.IOrderTypeService;

@RestController
@RequestMapping("/rest/order")
public class OrderTypeRestController {
	@Autowired
private IOrderTypeService service;
	@GetMapping("/all")
	public ResponseEntity<?> getAll()
	{
		ResponseEntity<?> response=null;
		List<OrderType> order=service.getAllOrderTypes();
		if(order!=null && !order.isEmpty())
		{
			response=new ResponseEntity<List<OrderType>>(order,HttpStatus.OK);
		}else
		{
			response=new ResponseEntity<String>("no data found",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	@GetMapping("one/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id)
	{
		OrderType order=service.getOneOrderType(id);
		ResponseEntity<?> response=null;
		if(order!=null)
		{
			response=new ResponseEntity<OrderType>(order,HttpStatus.OK);
		}
		else
		{
			response=new ResponseEntity<String>("data not found",HttpStatus.BAD_REQUEST);
		}
		return response;	
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id)
	{
		ResponseEntity<String> response=null;
		try
		{
			service.deleteOrderType(id);
			response=new ResponseEntity<String>("order "+id+" successfully deleted",HttpStatus.OK);
		}catch(Exception e)
		{
			response=new ResponseEntity<String>("data  not found",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	@PostMapping("/insert")
	public ResponseEntity<String> saveData(@RequestBody OrderType orderType)
	{
		ResponseEntity<String> response=null;
		try
		{
		Integer id=service.saveOrderType(orderType);
		response=new ResponseEntity<String>("saved successfully",HttpStatus.OK);
		}catch(Exception e)
		{
			response=new ResponseEntity<String>("failed to update",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	@PutMapping("/modify")
	public ResponseEntity<String> update(@RequestBody OrderType orderType)
	{
		ResponseEntity<String> response=null;
		try
		{
			service.updateOrderType(orderType);
			response=new ResponseEntity<>("updated successfully..",HttpStatus.OK);
		}catch(Exception e)
		{
			response=new ResponseEntity<String>("id not found",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
