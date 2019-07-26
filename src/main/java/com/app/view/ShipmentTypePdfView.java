package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.addHeader("content-Disposition", "attachment;filename=ShipmentType");
		Paragraph p=new Paragraph("welcome to shipment type");
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		document.add(p);
		PdfPTable table=new PdfPTable(6);
		table.addCell("ID");
		table.addCell("MODE");
		table.addCell("CODE");
		table.addCell("ENABLE");
		table.addCell("GRADE");
		table.addCell("NOTE");
		for(ShipmentType s:list)
		{
			table.addCell(s.getWid().toString());
			table.addCell(s.getsMode());
			table.addCell(s.getShipmentCode());
			table.addCell(s.getEnableShipment());
			table.addCell(s.getSgrade());
			table.addCell(s.getNote());
		}
		document.add(table);
	}

}
