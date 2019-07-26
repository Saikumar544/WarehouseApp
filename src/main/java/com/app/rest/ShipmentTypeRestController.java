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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@RestController
@RequestMapping("rest/shipment")
public class ShipmentTypeRestController {
	@Autowired
	private IShipmentTypeService service;

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> response = null;
		List<ShipmentType> list = service.getAllShipmentTypes();
		if (list != null && !list.isEmpty()) {
			response = new ResponseEntity<List<ShipmentType>>(list, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("your data is not found", HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("one/{id}") public ResponseEntity<?> getOne(@PathVariable Integer id) { 
		ResponseEntity<?> response=null;
		ShipmentType ship=service.getOneShipmentType(id); 
		if(ship!=null) { 
			response =new ResponseEntity<ShipmentType>(ship,HttpStatus.OK); 
			} else
			{
				response=new ResponseEntity<String>("data not found",HttpStatus.BAD_GATEWAY);
			}
		return response;
		}
	@DeleteMapping("delete/{id}")
public ResponseEntity<String> delete(@PathVariable Integer id)
{
	ResponseEntity<String> response =null;
	try {
		service.deleteShipmentType(id);
		response=new ResponseEntity<String>("record '"+id+"' deleted successfully",HttpStatus.OK);
	}catch (Exception e) {
		// TODO: handle exception
	response=new ResponseEntity<String>("record not found..", HttpStatus.BAD_REQUEST);
	}
	return response;
}
	@PostMapping(value="/insert",consumes= {"application/json","application/xml"})
	public ResponseEntity<String> saveData(@RequestBody ShipmentType shipmentType)
	{
		Integer id=service.saveShipmentType(shipmentType);
		ResponseEntity<String> response=new ResponseEntity<String>("saved with Id "+id,HttpStatus.OK);
		return response;
		
	}
	@PutMapping("/modify")
	public ResponseEntity<String> updateData(@RequestBody ShipmentType shipmentType)
	{
		ResponseEntity<String> response=null;
		try
		{
		service.updateShipmentType(shipmentType);
		response=new ResponseEntity<String>("data updated..",HttpStatus.OK);
		}catch(Exception e)
		{
		response=new ResponseEntity<String>("id not found",HttpStatus.BAD_REQUEST);	
		}
		return response;
	}
}
