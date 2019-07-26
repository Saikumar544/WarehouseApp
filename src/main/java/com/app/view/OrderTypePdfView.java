package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderTypePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.addHeader("content-Disposition","attachment;filename=OrderType.pdf");
	Paragraph p=new Paragraph("welcome to OrderType");
	@SuppressWarnings("unchecked")
	List<OrderType> list=(List<OrderType>) model.get("list");
	document.add(p);
	PdfPTable table=new PdfPTable(6);
	table.addCell("ID");
	table.addCell("ORDERMODE");
	table.addCell("ORDERCODE");
	table.addCell("ORDERTYPES");
	table.addCell("ACCEPT");
	table.addCell("DESCRIPTION");
	for(OrderType o:list)
	{
		table.addCell(o.getId().toString());
		table.addCell(o.getOrderMode());
		table.addCell(o.getOrderCode());
		table.addCell(o.getOrderTypes());
//		table.addCell((PdfPCell) o.getAccept());
		table.addCell(o.getDescription());
		
	}
	document.add(table);
	}

}
