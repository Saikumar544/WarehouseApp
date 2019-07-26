package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/docs")
public class DocumentController {
	@Autowired
private IDocumentService service;
	@RequestMapping("/show")
	public String showDocsPage(ModelMap map)
	{
List<Object[]> ob=service.getFileAndNames();
map.addAttribute("list", ob);
		return "Documents";
	}
	@RequestMapping("/upload")
	public String uploadDoc(@RequestParam CommonsMultipartFile fob)
	{
		if(fob!=null)
		{
			Document doc=new Document();
			doc.setFName(fob.getOriginalFilename());
			doc.setFData(fob.getBytes());
			service.saveDocument(doc);
			System.out.println("success..");
			
		}
		return "redirect:show";
	}
	@RequestMapping("/download")
	public void downloadDoc(@RequestParam Integer fId,HttpServletResponse resp)
	{
		Document doc=service.getOneDoc(fId);
		resp.addHeader("Content-Disposition", "attachment;filename="+doc.getFName());
		try {
			FileCopyUtils.copy(doc.getFData(), resp.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
