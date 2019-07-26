package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.UomType;

public class UomTypeExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.addHeader("content-Disposition", "attachment;filename=UomType.Xlsx");
		Sheet sheet=workbook.createSheet("UomTypes");
		List<UomType> list=(List<UomType>) model.get("list");
		setHead(sheet);
		setBody(sheet, list);
	}
private void setHead(Sheet sheet) {
	Row row=sheet.createRow(0);
	row.createCell(0).setCellValue("ID");
	row.createCell(1).setCellValue("USER Type");
	row.createCell(2).setCellValue("UserModel");
	row.createCell(3).setCellValue("UserNote");
}
private void setBody(Sheet sheet,List<UomType> list)
{
	int rowNum=1;
	for(UomType s:list)
	{
		Row row=sheet.createRow(rowNum++);
		row.createCell(0).setCellValue(s.getId());
		row.createCell(1).setCellValue(s.getUserType());
		row.createCell(2).setCellValue(s.getUserModel());
		row.createCell(3).setCellValue(s.getUserNote());
	}
}
}
