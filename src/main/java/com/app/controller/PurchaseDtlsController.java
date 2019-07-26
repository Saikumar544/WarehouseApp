package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Item;
import com.app.model.PurchaseDtls;
import com.app.service.IItemService;
import com.app.service.IPurchaseDtlsService;

@Controller
@RequestMapping("/purchasedtls")
public class PurchaseDtlsController {
	@Autowired
private IPurchaseDtlsService service;
	@Autowired
	private IItemService itemService;
	@RequestMapping("/reg")
	public String show(ModelMap map)
	{
		map.addAttribute("purchaseDtls",new PurchaseDtls());
		List<Item> list=itemService.getAllItems();
		map.addAttribute("list",list);
		return "PurchaseDtlsPage";	
	}
	@RequestMapping("/save")
	public String saveDtls(@ModelAttribute PurchaseDtls purchaseDtls,ModelMap map)
	{
		map.addAttribute("purchaseDtls",new PurchaseDtls());
	Integer id=service.savePurchaseDtls(purchaseDtls);
	map.addAttribute("message", "purchase saved with id '"+id+"' successfully..");
	List<Item> list=itemService.getAllItems();
	map.addAttribute("list",list);
	List<PurchaseDtls> list1=service.getAllPurchaseDtls();
	map.addAttribute("list1", list1);
	return "PurchaseDtlsPage";
	}
	@RequestMapping("/delete")
	public String deleteDtls(@RequestParam Integer id,ModelMap map)
	{
		map.addAttribute("purchaseDtls",new PurchaseDtls());
		service.deletePurchaseDtls(id);
		List<PurchaseDtls> list1=service.getAllPurchaseDtls();
		map.addAttribute("list1",list1);
		return "PurchaseDtlsPage";
	}
}
