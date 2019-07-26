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

import com.app.model.WarehouseUserType;
import com.app.service.IWarehouseUserTypeService;

@RestController
@RequestMapping("rest/warehouse")
public class WarehouseTypeRestController {
	@Autowired
private IWarehouseUserTypeService service;
	@GetMapping("/all")
	public ResponseEntity<?> getAll()
	{
		List<WarehouseUserType> warehouse=service.getAllWarehouseUserTypes();
		ResponseEntity<?> response=null;
		if(warehouse!=null && !warehouse.isEmpty())
		{
			response=new ResponseEntity<List<WarehouseUserType>>(warehouse,HttpStatus.OK);
		}else
		{
			response=new ResponseEntity<String>("data not found ",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	@GetMapping("one/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id)
	{
		WarehouseUserType warehouse=service.getOneWarehouseUserType(id);
		ResponseEntity<?> response=null;
		if(warehouse!=null)
		{
			response=new ResponseEntity<WarehouseUserType>(warehouse,HttpStatus.OK);
		}else
		{
			response=new ResponseEntity<String>("data is not found",HttpStatus.BAD_REQUEST);
		}
			return response;
		}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id)
	{
		ResponseEntity<String> response=null;
		try
		{
		service.deleteWarehouseUserType(id);
		response=new ResponseEntity<String>("succesfully deleted '"+id+"' ",HttpStatus.OK);
		}catch(Exception e){
			response=new ResponseEntity<String>("data not found",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody WarehouseUserType warehouseUserType)
	{
		ResponseEntity<String> response=null;
		try
		{
		Integer id=service.saveWarehouseUserType(warehouseUserType);
		response=new ResponseEntity<String>("saved succesfully..",HttpStatus.OK);
		}catch(Exception e)
		{
			response=new ResponseEntity<String>("failed to update..",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody WarehouseUserType warehouseUserType)
	{
		ResponseEntity<String> response=null;
		try {
		service.updateWarehouseUserType(warehouseUserType);
		response=new ResponseEntity<String>("updated successfully..",HttpStatus.OK);
		}catch(Exception e)
		{
			response=new ResponseEntity<String>("failed to update..",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
