package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.SaleOrder;
import com.app.service.ISaleOrderService;
@Component
public class SaleOrderValidator implements Validator {
	@Autowired
private ISaleOrderService service;
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return SaleOrder.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		SaleOrder saleOrder=(SaleOrder)target;
		if(service.issaleOrderCodeExists(saleOrder.getSaleOrderCode()))
		{
			errors.rejectValue("saleOrderCode", null, saleOrder.getSaleOrderCode()+"already exists");
		}
	}

}
