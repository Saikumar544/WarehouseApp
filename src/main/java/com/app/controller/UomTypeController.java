package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.UomType;
import com.app.service.IUomTypeService;
import com.app.util.UomTypeUtil;
import com.app.validator.UomValidator;
import com.app.view.UomTypeExcelView;

@Controller
@RequestMapping("/U")
public class UomTypeController {
	@Autowired
	private IUomTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private UomTypeUtil util;
	@Autowired
	private UomValidator validate;

	@RequestMapping("/show")
	public String showUom(Model model) {
		model.addAttribute("uomType", new UomType());
		return "UomTypeCreate";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUomType(@ModelAttribute UomType uomType, ModelMap map,Errors errors) {
		
		validate.validate(uomType, errors);
		if(!errors.hasErrors())
		{
		Integer id = service.saveUomType(uomType);
		map.addAttribute("uomType", new UomType());
		String message = "Uom'" + id + "'saved successfully";
		map.addAttribute("msg", message);
		map.addAttribute("uomType",new UomType());
		}
		else
			map.addAttribute("msg","please check all errors..");
		
		return "UomTypeCreate";
	}

	@RequestMapping("/all")
	public String getAllUom(ModelMap map) {
		List<UomType> uom = service.getAllUomTypes();
		map.addAttribute("list", uom);
		return "UomTypeData";
	}

	@RequestMapping("/delete")
	public String deleteUoms(@RequestParam Integer id, ModelMap map) {
		service.deleteUomType(id);
		List<UomType> lo = service.getAllUomTypes();
		map.addAttribute("list", lo);
		map.addAttribute("msg", "deleted '" + id + "' successfully...");
		return "UomTypeData";
	}


	// edit page
	@RequestMapping(value="/edit")
	public String showEdit(@RequestParam Integer id, ModelMap map) {
		UomType u1 = service.getOneUomType(id);
		map.addAttribute("uomType", u1);
		return "UomTypeEdit";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute("uomType") UomType uomType, ModelMap map,BindingResult result) {
		service.updateUomType(uomType);
		List<UomType> s = service.getAllUomTypes();
		map.addAttribute("uomType", new UomType());
		map.addAttribute("list", s);
		map.addAttribute("msg", "shipment'" + uomType.getId() + "' updated..");
		return "UomTypeData";
	}
	@RequestMapping("/view")
	public String getOneUom(@RequestParam Integer id,ModelMap map)
	{
		UomType u=service.getOneUomType(id);
		map.addAttribute("ob",u);
		return "UomTypeViewOne";
	}
	@RequestMapping("/excel")
	public ModelAndView getExcel()
	{
		ModelAndView m=new ModelAndView();
		List<UomType> uom=service.getAllUomTypes();
	m.setView(new UomTypeExcelView());
	m.addObject("list",uom);
		return m;
	}
	@RequestMapping("/pdf")
public ModelAndView getPdf()
{
	ModelAndView m=new ModelAndView();
	List<UomType> list=service.getAllUomTypes();
	m.setView(new UomTypeExcelView());
	m.addObject("list",list);
	return m;
	}
	@RequestMapping("/charts")
	public String generateCharts()
	{
		String path=context.getRealPath("/");
		List<Object[]> list=service.getAllUomTypesCount();
		util.generatePie(path,list);
		util.generateBar(path,list);
		return "UomTypeCharts";
	}
	
}
