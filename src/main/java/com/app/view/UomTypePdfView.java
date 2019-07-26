package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.UomType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomTypePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.addHeader("content-Disposition", "attachment;filename=UomTypes.pdf");
		Paragraph p=new Paragraph("welcome to Uom");
		document.add(p);
		PdfPTable table=new PdfPTable(4);
		table.addCell("ID");
		table.addCell("UserType");
		table.addCell("UserModel");
		table.addCell("UserNote");
	@SuppressWarnings("unchecked")
	List<UomType> list=(List<UomType>) model.get("list");
	for(UomType u:list)
	{
		table.addCell(u.getId().toString());
		table.addCell(u.getUserType());
		table.addCell(u.getUserModel());
		table.addCell(u.getUserNote());
	}
		document.add(table);
	}
}
