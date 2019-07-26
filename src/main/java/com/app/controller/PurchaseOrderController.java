package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.model.WarehouseUserType;
import com.app.service.IPurchaseOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWarehouseUserTypeService;
@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {
	@Autowired
private IPurchaseOrderService service;
	@Autowired
	private IShipmentTypeService shipservice;
	@Autowired
	private IWarehouseUserTypeService warehouseService;
	@RequestMapping("/show")
	public String show(ModelMap map)
	{
		List<WarehouseUserType> wuser=warehouseService.getAllWarehouseUserTypes();
		map.addAttribute("wuser",wuser);
		map.addAttribute("purchaseOrder",new PurchaseOrder());
		List<ShipmentType> ship=shipservice.getAllShipmentTypes();
		map.addAttribute("ships",ship);
		return "Purchase";
	}
	@RequestMapping("/save")
	public String savePurchase(@ModelAttribute PurchaseOrder purchaseOrder,ModelMap map)
	{
		map.addAttribute("puchaseOrder",new PurchaseOrder());
		Integer id=service.savePurchaseOrder(purchaseOrder);
		map.addAttribute("msg","form with '"+id+"' id saved succesfully");
		List<ShipmentType> ship=shipservice.getAllShipmentTypes();
		map.addAttribute("ships",ship);
		List<WarehouseUserType> wuser=warehouseService.getAllWarehouseUserTypes();
		map.addAttribute("wuser",wuser);
		return "Purchase";
	}
	@RequestMapping("/all")
	public String getAll(ModelMap map)
	{
	List<PurchaseOrder> order=service.getAllPurchaseOrder();
	map.addAttribute("list", order);
	return "PurchaseData";
	}
	 
	@RequestMapping("/edit")
	public String editData(@RequestParam Integer id,ModelMap map)
	{
		PurchaseOrder orders=service.getOnePurchaseOrder(id);
//		service.updatePurchaseOrder(order);
		map.addAttribute("purchaseOrder",orders);
		List<ShipmentType> ship=shipservice.getAllShipmentTypes();
		map.addAttribute("ships",ship);
		List<WarehouseUserType> wuser=warehouseService.getAllWarehouseUserTypes();
		map.addAttribute("wuser",wuser);
		return "PurchaseEdit";
	}
	@RequestMapping("/update")
	public String updateData(@ModelAttribute PurchaseOrder purchaseOrder,ModelMap map)
	{
		service.updatePurchaseOrder(purchaseOrder);
		List<PurchaseOrder> order=service.getAllPurchaseOrder();
		map.addAttribute("list",order);
		return "PurchaseData";
	}
	
	@RequestMapping("/one")
	public String viewOne(@RequestParam Integer id,ModelMap map)
	{
		PurchaseOrder p=service.getOnePurchaseOrder(id);
		map.addAttribute("list",p);
		return "PurchaseViewOne";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id,ModelMap map)
	{
		service.deletePurchaseOrder(id);
		List<PurchaseOrder> order=service.getAllPurchaseOrder();
		map.addAttribute("list",order);
		return "PurchaseData";
	}
}
