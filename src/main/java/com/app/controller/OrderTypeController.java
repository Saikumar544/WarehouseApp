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

import com.app.model.OrderType;
import com.app.service.IOrderTypeService;
import com.app.util.OrderTypeUtil;
import com.app.validator.OrderValidator;
import com.app.view.OrderTypeExcelView;
import com.app.view.OrderTypePdfView;

@Controller
@RequestMapping("/order")
public class OrderTypeController {
	@Autowired
	private IOrderTypeService service;
	@Autowired
	private OrderTypeUtil util;
	@Autowired
	private ServletContext context;
	@Autowired
	private OrderValidator validator;
	@RequestMapping("/show")
public String show( @ModelAttribute OrderType order,ModelMap map)
{
		map.addAttribute("orderType",new OrderType());
	return "OrderType";
}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveOrderType(@ModelAttribute OrderType order,ModelMap map,Errors errors)
	{
	map.addAttribute("orderType",new OrderType());
//		call validator
		validator.validate(order, errors);
		if(!errors.hasErrors())
		{
			Integer id=service.saveOrderType(order);
			String message="saved succesfully..'"+id+"'..thanks for using my website";
			map.addAttribute("msg",message);
		}
		else
		{
			map.addAttribute("msg","please check all errors");
		}
		return "OrderType";
	}
	@RequestMapping("/all")
	public String getAllOrderTypes(ModelMap map)
	{
		List<OrderType> list=service.getAllOrderTypes();
		map.addAttribute("list",list);
		return "OrderTypeData";
	}
	@RequestMapping("/edit")
	public String editOne(@RequestParam  Integer id , ModelMap map)
	{
	OrderType s=service.getOneOrderType(id);
map.addAttribute("orderType",s);
		return "OrderTypeEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute OrderType order,ModelMap map)
	{
		service.updateOrderType(order);
		List<OrderType> list=service.getAllOrderTypes();
		map.addAttribute("list",list);
		map.addAttribute("msg","Order '"+order.getId()+"' updated successfully..");
		return "OrderTypeData";
	}
	@RequestMapping("/delete")
	public String deleteOrderType(@RequestParam Integer id,ModelMap map)
	{
		service.deleteOrderType(id);
		List<OrderType> order=service.getAllOrderTypes();
		map.addAttribute("list",order);
		return "OrderTypeData";
	}
	@RequestMapping("/view")
	public String viewOneOrderTyep(@RequestParam Integer id,ModelMap map)
	{
		OrderType o=service.getOneOrderType(id);
		map.addAttribute("ob",o);
		return "OrderTypeView";
	}
	@RequestMapping("/excel")
	public ModelAndView excelExport()
	{
		ModelAndView m=new ModelAndView();
		List<OrderType> order=service.getAllOrderTypes();
		m.addObject("list",order);
		m.setView(new OrderTypeExcelView());
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView pdfExport()
	{
		ModelAndView m=new ModelAndView();
		List<OrderType> list=service.getAllOrderTypes();
		m.setView(new OrderTypePdfView());
		m.addObject("list",list);
		return m;
	}
	@RequestMapping("/charts")
public String getUserTypeCount()
{
String path=context.getRealPath("/");
List<Object[]>list=service.getUserTypeCount();
util.generatePieChart(path,list);
util.generateBarChart(path,list);
return "OrderTypeCharts";
}
}
