package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WarehouseUserType;
import com.app.service.IWarehouseUserTypeService;
@Component
public class WarehouseValidator implements Validator {
	@Autowired
private IWarehouseUserTypeService service;
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return WarehouseUserType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
WarehouseUserType warehouseUserType=(WarehouseUserType)target;
if(service.isContactExists(warehouseUserType.getuContact()))
{
	errors.rejectValue("uContact", null, warehouseUserType.getuContact()+"already exists");

}
if(service.isEmailExists(warehouseUserType.getuMail()))
{
	errors.rejectValue("uMail", null, warehouseUserType.getuMail()+"already exists");
}

	}

}
