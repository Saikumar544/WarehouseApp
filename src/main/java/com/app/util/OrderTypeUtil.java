package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class OrderTypeUtil {

	public void generatePieChart(String path, List<Object[]> list) {
		// TODO Auto-generated method stub
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:list)
		{
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		JFreeChart chart=ChartFactory.createPieChart3D("OrderUserType", dataset);
	try {
		ChartUtils.saveChartAsJPEG(new File(path+("/resources/images/OrderUserType.jpg")), chart, 500, 300);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public void generateBarChart(String path, List<Object[]> list) {
		// TODO Auto-generated method stub
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob:list)
		{
			dataset.setValue(new Double(ob[1].toString()),(ob[0].toString()), "welcome to orderType");
		}
		JFreeChart chart=ChartFactory.createBarChart("OrderType", "UserType", "count", dataset);
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/OrderTypeBar.jpg"), chart, 500, 300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
