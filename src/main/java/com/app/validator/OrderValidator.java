package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderType;
import com.app.service.IOrderTypeService;

@Component
public class OrderValidator implements Validator {
	@Autowired
private IOrderTypeService orderService;
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return OrderType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		OrderType orderType=(OrderType)target;
		if(orderService.isOrderCodeExist(orderType.getOrderCode()))
		{
			errors.rejectValue("orderCode", null, orderType.getOrderCode()+"already exist");
			
		}
	}

}
