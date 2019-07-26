package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WarehouseUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WarehouseTypePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.addHeader("content-disposition","attachment;filename=WarehouseType.pdf");
		List<WarehouseUserType> list=(List<WarehouseUserType>) model.get("list");
		Paragraph p=new Paragraph("welcome to warehouse pdf");
		document.add(p);
		PdfPTable table=new PdfPTable(8);
		table.addCell("ID");
		table.addCell("USER TYPE");
		table.addCell("USER CODE");
		table.addCell("USER FOR");
		table.addCell("USER MAIL");
		table.addCell("USER CONTACT");
		table.addCell("USER ID TYPE");
		table.addCell("USER ID NUMBER");
		for(WarehouseUserType w:list)
		{
			table.addCell(w.getId().toString());
			table.addCell(w.getuType());
			table.addCell(w.getuCode());
			table.addCell(w.getUserFor());
			table.addCell(w.getuMail());
			table.addCell(w.getuContact());
			table.addCell(w.getuIdType());
			table.addCell(w.getIdNumber());
		}
		document.add(table);
	}

}
