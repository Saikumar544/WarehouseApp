package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Item;
import com.app.model.OrderType;
import com.app.model.UomType;
import com.app.service.IItemService;
import com.app.service.IOrderTypeService;
import com.app.service.IUomTypeService;
import com.app.validator.ItemValidator;
@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
private ItemValidator validator;
		@Autowired
		private IItemService service;
		@Autowired
		private IUomTypeService uomservice;
		@Autowired
		private IOrderTypeService orderservice;
		
		@RequestMapping("/show")
	public String show( @ModelAttribute Item item,ModelMap map)
	{
			map.addAttribute("Item",new Item());
			List<UomType> uom=uomservice.getAllUomTypes();
			map.addAttribute("uoms",uom);
			List<OrderType> orders=orderservice.getAllOrderTypes();
			map.addAttribute("orders",orders);
		return "Item";
	}
		@RequestMapping(value="/save",method=RequestMethod.POST)
		public String saveItem(@ModelAttribute Item item,ModelMap map,Errors errors)
		{
			map.addAttribute("Item",new Item());
			validator.validate(item, errors);
			if(!errors.hasErrors())
			{
			Integer id=service.saveItem(item);
			String message="saved succesfully..'"+id+"'..thanks for using my website";
			map.addAttribute("msg",message);
			}
			else
			{
				map.addAttribute("msg","please check all the errors..");
			}
			map.addAttribute("Item",new Item());
			List<OrderType> orders=orderservice.getAllOrderTypes();
			map.addAttribute("orders",orders);
			List<UomType> uom=uomservice.getAllUomTypes();
			map.addAttribute("uoms",uom);
			
			return "Item";
		}
		@RequestMapping("/all")
		public String getAllItems(ModelMap map)
		{
			List<Item> obs=service.getAllItems();
			map.addAttribute("list",obs);
			return "ItemData";
		}
		@RequestMapping("/edit")
		public String editOne(@RequestParam  Integer id , ModelMap map)
		{
		Item s=service.getOneItem(id);
	map.addAttribute("item",s);
	List<OrderType> orders=orderservice.getAllOrderTypes();
	map.addAttribute("orders",orders);
	List<UomType> uom=uomservice.getAllUomTypes();
	map.addAttribute("uoms",uom);
			return "ItemEdit";
		}
		@RequestMapping(value="/update",method=RequestMethod.POST)
		public String update(@ModelAttribute Item item,ModelMap map)
		{
			service.updateItem(item);
			List<Item> list=service.getAllItems();
			map.addAttribute("list",list);
			map.addAttribute("msg","item '"+item.getId()+"' updated successfully..");
			return "ItemData";
		}
		@RequestMapping("/delete")
		public String deleteItem(@RequestParam Integer id,ModelMap map)
		{
			service.deleteItem(id);
			List<Item> item=service.getAllItems();
			map.addAttribute("list",item);
			return "ItemData";
		}
		@RequestMapping("/view")
		public String viewOneItemTyep(@RequestParam Integer id,ModelMap map)
		{
			Item o=service.getOneItem(id);
			map.addAttribute("ob",o);
			return "ItemView";
		}
		
	}


