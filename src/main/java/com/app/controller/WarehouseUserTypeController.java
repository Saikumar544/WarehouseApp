package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.WarehouseUserType;
import com.app.service.IWarehouseUserTypeService;
import com.app.util.WarehouseTypeUtil;
import com.app.validator.WarehouseValidator;
import com.app.view.WarehouseTypeExcelView;
import com.app.view.WarehouseTypePdfView;

@Controller
@RequestMapping("/warehouse")
public class WarehouseUserTypeController {
	@Autowired
	private IWarehouseUserTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private WarehouseTypeUtil util;
	@Autowired
	private WarehouseValidator warehouseValidator;

	@RequestMapping("/show")
	public String showWarehouse(ModelMap map) {
		map.addAttribute("warehouseUserType", new WarehouseUserType());
		return "WarehouseUserType";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveWarehouseUserType(@ModelAttribute WarehouseUserType warehouseUserType, ModelMap map,Errors errors) {
		
			map.addAttribute("warehouseUserType",new WarehouseUserType());
		
		warehouseValidator.validate(warehouseUserType, errors);
		if(!errors.hasErrors())
		{
			Integer id = service.saveWarehouseUserType(warehouseUserType);
			String message = "user details '" + id + "'saved successfully";
			map.addAttribute("msg", message);
		}
		else
		{
			map.addAttribute("msg","please check all errors..");
		}
		return "WarehouseUserType";
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getAllWarehouseUserTypes(ModelMap map) {

		List<WarehouseUserType> li = service.getAllWarehouseUserTypes();
		map.addAttribute("list", li);
		String message = "user details are retrieved...";
		map.addAttribute("msg", message);
		return "WarehouseUserTypeData";
	}
	@RequestMapping("/delete")
	public String deleteShipment(@RequestParam Integer id,ModelMap map)
	{
//		delete row
		service.deleteWarehouseUserType(id);
//		fetch new data
		List<WarehouseUserType> obs=service.getAllWarehouseUserTypes();
//		send data to ui
		map.addAttribute("list",obs);
		map.addAttribute("msg","shipment Type '"+id+"' deleted successfully..");
		return "WarehouseUserTypeData";
	}
	
	@RequestMapping("/edit")
	public String ShowEdit(@RequestParam Integer id,ModelMap map)
	{
		WarehouseUserType s=service.getOneWarehouseUserType(id);
		map.addAttribute("warehouseUserType",s);
		return "WarehouseUserTypeEdit";
	}
	
	@RequestMapping("/update")
	public String doUpdate(@ModelAttribute WarehouseUserType warehouse,ModelMap map)
	{
		service.updateWarehouseUserType(warehouse);
		List<WarehouseUserType> s=service.getAllWarehouseUserTypes();
		map.addAttribute("list",s);
		map.addAttribute("msg","user'"+warehouse.getId()+"' updated..");
		return "WarehouseUserTypeData";
	}
	@RequestMapping("/view")
	public String viewOne(@RequestParam Integer id,ModelMap map)
	{
		WarehouseUserType w=service.getOneWarehouseUserType(id);
		map.addAttribute("ob",w);
		return "WarehouseTypeViewOne";
	}
	@RequestMapping("/excel")
	public ModelAndView getExcel()
	{
		ModelAndView m=new ModelAndView();
		List<WarehouseUserType> list=service.getAllWarehouseUserTypes();
		m.setView(new WarehouseTypeExcelView());
		m.addObject("list",list);
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView getPdf()
	{
		ModelAndView m=new ModelAndView();
		List<WarehouseUserType> list=service.getAllWarehouseUserTypes();
		m.setView(new WarehouseTypePdfView());
		m.addObject("list",list);
		return m;
	}
	@RequestMapping("/charts")
	public String getAllUserTypes()
	{
		String path=context.getRealPath("/");
		
		List<Object[]> list=service.getAllUserTypes();
		util.generatePie(path,list);
		util.generateBar(path,list);
		return "WarehouseTypeCharts";
		
	}

}
