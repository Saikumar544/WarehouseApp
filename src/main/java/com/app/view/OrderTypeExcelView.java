package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderType;

public class OrderTypeExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//		create file name
		response.addHeader("content-Disposition","attachment;fileName=OrderType.Xlsx");
		//		create sheet
		Sheet sheet=workbook.createSheet("OrderType");
		@SuppressWarnings("unchecked")
		List<OrderType> list=(List<OrderType>) model.get("list");
		setHead(sheet);
		setBody(list, sheet);
	}
	private void setHead(Sheet sheet)
	{
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("OderMode");
		row.createCell(2).setCellValue("OrderCode");
		row.createCell(3).setCellValue("OrderTypes");
//		row.createCell(4).setCellValue("accept");
		row.createCell(5).setCellValue("description");
	}
	private void setBody(List<OrderType> list,Sheet sheet)
	{
		int rowNum=1;
		Row row=sheet.createRow(rowNum++);
		for(OrderType s:list)
		{
			row.createCell(0).setCellValue(s.getId());
			row.createCell(1).setCellValue(s.getOrderMode());
			row.createCell(2).setCellValue(s.getOrderCode());
			row.createCell(3).setCellValue(s.getOrderTypes());

			//		row.createCell(4).setCellValue(s.getAccept());
			row.createCell(5).setCellValue(s.getDescription());
		}

	}
}
