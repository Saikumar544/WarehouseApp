package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WarehouseUserType;

public class WarehouseTypeExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.addHeader("content-Disposition", "attachment;filename=WarehouseType.Xlsx");
		Sheet sheet=workbook.createSheet();
		List<WarehouseUserType> list=(List<WarehouseUserType>) model.get("list");
		setHead(sheet);
		setBody(sheet, list);
	}
	public void setHead(Sheet sheet)
	{
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Type");
		row.createCell(2).setCellValue("Code");
		row.createCell(3).setCellValue("For");
		row.createCell(4).setCellValue("Mail");
		row.createCell(5).setCellValue("Contact");
		row.createCell(6).setCellValue("IdType");
		row.createCell(7).setCellValue("IdNumber");
	}
public void setBody(Sheet sheet,List<WarehouseUserType> list)
{
	int rowNum=1;
	for(WarehouseUserType w:list)
	{
	Row row=sheet.createRow(rowNum++);
	row.createCell(0).setCellValue(w.getIdNumber());
	row.createCell(1).setCellValue(w.getuType());
	row.createCell(2).setCellValue(w.getuCode());
	row.createCell(3).setCellValue(w.getUserFor());
	row.createCell(4).setCellValue(w.getuMail());
	row.createCell(5).setCellValue(w.getuContact());
	row.createCell(6).setCellValue(w.getuIdType());
	row.createCell(7).setCellValue(w.getIdNumber());
	}
}
}
