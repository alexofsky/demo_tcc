package com.blbuyer.erp.util.excelHepler;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;



public class ExportExCell {

	public static  <T> ExcelExportHelper returnexportExcell(String tempFile, int row, List<String> colList,List<T> list)
			throws IOException {
		Workbook workbook = ExcelReadUtils.getWorkbook(tempFile);
		ExcelExportHelper helper = new ExcelExportHelper(workbook);
		
		int col = 0;
		int rowNum = row;
		SimpleDateFormat formatter;
		
		formatter = new SimpleDateFormat ("yyyy-MM-dd");

		for (Object obj : list) {
			int i = -1;
			helper.createRow(rowNum);
			
			for (String colFiled : colList) {

				Object object = Reflections.getFieldValue(obj, colFiled);
				i = i + 1;
				if (object == null) {
					helper.setCell(col + i, "");
					continue;
				}
				if (object instanceof Integer) {
					helper.setCell(col + i, (int) object);
				} else if (object instanceof Date) {
					if (object != null)
						helper.setCell(col + i, formatter.format((Date) object));
				} else if (object instanceof BigDecimal) {
					helper.setCell(col + i, ((BigDecimal) object).toString());
				} else {
					helper.setCell(col + i, object.toString());
				}
			}
			rowNum = rowNum + 1;
		}
		return helper;
	}

	public static  <T> ExcelExportHelper returnexportExcell(String tempFile, int row, List<String> colList,List<T> list, boolean b)
			throws IOException {
		Workbook workbook = ExcelReadUtils.getWorkbook(tempFile);
		ExcelExportHelper helper = new ExcelExportHelper(workbook);
		
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框   
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框   
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框   
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框   
		cellStyle.setWrapText(true);

		int col = 0;
		int rowNum = row;
		SimpleDateFormat formatter;
		
		formatter = new SimpleDateFormat ("yyyy-MM-dd");
		if(list!=null && list.size()>0){
			for (Object obj : list) {
				int i = -1;
				helper.createRow(rowNum);
				
				for (String colFiled : colList) {

					Object object = Reflections.getFieldValue(obj, colFiled);
					i = i + 1;
					if (object == null) {
						helper.setCell(col + i, "", cellStyle);
						continue;
					}
					if (object instanceof Integer) {
						helper.setCell(col + i, (int) object, cellStyle);
					} else if (object instanceof Date) {
						if (object != null){
							helper.setCell(col + i, formatter.format((Date) object), cellStyle);
						}
					} else if (object instanceof BigDecimal) {
						helper.setCell(col + i, ((BigDecimal) object).toString(), cellStyle);
					} else {
						helper.setCell(col + i, object.toString(), cellStyle);
					}
				}
				rowNum = rowNum + 1;
			}
		}
		
		return helper;
	}

	
	
	   /**
	 * 处理生成excel时 姓名只显示一种语言
	 * @return
	 * object[14] 总负责人
	 * object[15] 执行人
	 * object[16] 收集人
	 */
	public static String parseZhAndEnName(boolean isZhorEn,String inputname){
		if(isZhorEn){//中文
			if(inputname.indexOf(",")>0){
				String[] strs = inputname.toString().split(",");
				 StringBuffer buf = new StringBuffer();
				 for(int i=0;i<strs.length;i++){
					 if(strs[i].indexOf("(")>0 && strs[i].indexOf(")")>0){
						 if(i==strs.length-1){
							 buf.append(strs[i].substring(0, strs[i].indexOf("(")));
						 }else{
							 buf.append(strs[i].substring(0, strs[i].indexOf("("))+",");
						 }
					 }else{
						 if(i==strs.length-1){
							 buf.append(strs[i]);
						 }else{
							 buf.append(strs[i]+",");
						 }
					 }
				 }
				 inputname = buf.toString();
			}else{
				if(inputname.indexOf("(")>0 && inputname.indexOf(")")>0){
					inputname = inputname.substring(0, inputname.indexOf("("));
				}
			}
		}else{//英文
			if(inputname.indexOf(",")>0){
				String[] strs = inputname.split(",");
				 StringBuffer buf = new StringBuffer();
				 for(int i=0;i<strs.length;i++){
					 if(strs[i].indexOf("(")>0 && strs[i].indexOf(")")>0){
						 if(i==strs.length-1){
							 buf.append(strs[i].substring(strs[i].indexOf("(")+1,strs[i].lastIndexOf(")")));
						 }else{
							 buf.append(strs[i].substring(strs[i].indexOf("(")+1,strs[i].lastIndexOf(")"))+",");
						 }
					 }else{
						 if(i==strs.length-1){
							 buf.append(strs[i]);
						 }else{
							 buf.append(strs[i]+",");
						 }
					 }
				 }
				 inputname = buf.toString();
			}else{
				if(inputname.indexOf("(")>0 && inputname.indexOf(")")>0){
					inputname = inputname.substring(inputname.indexOf("(")+1,inputname.lastIndexOf(")"));
				}
			}
		}
		return inputname;
	}
	   /**
	    * 去除空白
	    * @param input
	    * @return
	    */
	  private static String parseText(String input){
		  
	   return input.replaceAll("((\r\n)|\n)[\\s\t ]*(\\1)+", "$1").replaceAll("^((\r\n)|\n)", "");   
		  
	  }
	  
}
