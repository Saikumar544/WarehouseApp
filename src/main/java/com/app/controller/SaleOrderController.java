package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.SaleOrder;
import com.app.model.ShipmentType;
import com.app.service.ISaleOrderService;
import com.app.service.IShipmentTypeService;
import com.app.validator.SaleOrderValidator;
@Controller
@RequestMapping("/sale")
public class SaleOrderController {
	@Autowired
private ISaleOrderService service;
	@Autowired
	private IShipmentTypeService shipService;
	@Autowired
	private SaleOrderValidator validator;
	@RequestMapping("/reg")
	public String show(ModelMap map)
	{
		map.addAttribute("saleOrder",new SaleOrder());
	List<ShipmentType> ships=shipService.getAllShipmentTypes();
	map.addAttribute("ships",ships);
		return "SaleOrder";
	}
	@RequestMapping("/save")
	public String save(@ModelAttribute SaleOrder saleOrder,ModelMap map,Errors errors)
	{
		validator.validate(saleOrder, errors);
		if(!errors.hasErrors())
		{
		Integer id=service.saveSale(saleOrder);
		map.addAttribute("saleOrder",new SaleOrder());
		map.addAttribute("msg","saved successfully with" +id);
		}
		else
		{
			map.addAttribute("msg","please check all errors..");
		}
		List<ShipmentType> ships=shipService.getAllShipmentTypes();
		map.addAttribute("ships",ships);
		return "SaleOrder";
	}
	@RequestMapping("/all")
	public String getAll(ModelMap map)
	{
		List<SaleOrder> list=service.getAllSales();
		map.addAttribute("list",list);
		return "SaleOrderData";
	}
}
