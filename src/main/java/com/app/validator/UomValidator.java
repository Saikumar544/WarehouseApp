package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.UomType;
import com.app.service.IUomTypeService;

@Component
public class UomValidator implements Validator {
	@Autowired
private IUomTypeService service;
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UomType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UomType uoms=(UomType)target;
		if(service.isUomModelExist(uoms.getUserModel()))
		{
			errors.reject("uomModel",null,uoms.getUserModel()+"already exist..");
		}
	}

}
