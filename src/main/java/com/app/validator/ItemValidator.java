package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;
import com.app.service.IItemService;

@Component
public class ItemValidator implements Validator {
	@Autowired
private IItemService service;
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
Item item=(Item)target;
if(service.isItemCodeExists(item.getItemCode()))
{
	errors.rejectValue("itemCode", null, item.getItemCode()+"already exists");
}
	}

}
