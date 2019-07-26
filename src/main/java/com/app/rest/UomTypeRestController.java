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

import com.app.model.UomType;
import com.app.service.IUomTypeService;

@RestController
@RequestMapping("/rest/uom")
public class UomTypeRestController {
	@Autowired
private IUomTypeService service;
	@GetMapping("/all")
	public ResponseEntity<?> getAll()
	{
		ResponseEntity<?> response=null;
		List<UomType> uom=service.getAllUomTypes();
		if(uom!=null && !uom.isEmpty())
		{
			response=new ResponseEntity<List<UomType>>(uom,HttpStatus.OK);
		}else
		{
			response=new ResponseEntity<String>("data not found..",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	@GetMapping("one/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id)
	{
		ResponseEntity<?> response=null;
		UomType uom=service.getOneUomType(id);
		if(uom!=null)
		{
			response=new ResponseEntity<UomType>(uom,HttpStatus.OK);
			
		}else
		{
			response=new ResponseEntity<String>("data not found..",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id)
	{
		ResponseEntity<String> response=null;
		try
		{
		service.deleteUomType(id);
		response=new ResponseEntity<String>("data deleted successfully..",HttpStatus.OK);
		}catch(Exception e)
		{
			response=new ResponseEntity<String>("data is not found..",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	@PostMapping(value="/insert",consumes={"application/json","application/xml"})
	public ResponseEntity<String> saveData(@RequestBody UomType uomType)
	{
		Integer id=service.saveUomType(uomType);
		ResponseEntity<String> response=new ResponseEntity<String>("data inserted succesfully",HttpStatus.OK);
		return response;
	}
	@PutMapping("/modify")
	public ResponseEntity<String> update(@RequestBody UomType uomType)
	{
		ResponseEntity<String> response=null;
		try
		{
		service.updateUomType(uomType);
		response=new ResponseEntity<String>("data modified successfully..",HttpStatus.OK);
		}catch(Exception e)
		{
			response=new ResponseEntity<String>("id not found",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
