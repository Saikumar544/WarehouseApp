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
public class ShipmentTypeUtil {
public void generatePie(String path,List<Object[]> list)
{
	DefaultPieDataset d=new DefaultPieDataset();
	for(Object[] ob:list)
	{
		d.setValue(ob[0].toString(), new Double(ob[1].toString()));
	}
	JFreeChart chart=ChartFactory.createPieChart3D("ShipmentPie", d);
	try {
		ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/ShipmentPie.jpg"), chart, 500, 300);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void generateBar(String path,List<Object[]> list)
{
	DefaultCategoryDataset dataset=new DefaultCategoryDataset();
	for(Object[] ob:list)
	{
		dataset.setValue(new Double(ob[1].toString()),ob[0].toString(),"Shipment Mode Deatils");
	}
	JFreeChart chart=ChartFactory.createBarChart("shipment mode details", "Modes", "count", dataset);
	try {
		ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/ShipmentBar.jpg"), chart, 500, 300);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
