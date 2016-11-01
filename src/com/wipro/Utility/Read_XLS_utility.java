package com.wipro.Utility;


import java.io.FileInputStream;



import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Read_XLS_utility {

	public  FileInputStream inputstream;
	
	public Workbook wb;
	public Sheet ws;
	

	public Read_XLS_utility(String excelpath,String wsName){
		try{
			inputstream=new FileInputStream(excelpath);
			
			
			 wb=WorkbookFactory.create(inputstream);
			 
			 
			 
			ws = wb.getSheet(wsName);
			inputstream.close();

		}catch(Exception e){
			e.printStackTrace();
		}


	}

	public int retrieveNoOfRows(String wsName){		

		ws = wb.getSheet(wsName);
		int rowCount=ws.getLastRowNum();		
		return rowCount;		
	}



	public int retrieveNoOfCols(String wsName){

		ws = wb.getSheet(wsName);
		int colCount=ws.getRow(0).getLastCellNum();			
		return colCount;
	}


	public Object[][] retrieveTestData(String wsName) {

		int rowNum = retrieveNoOfRows(wsName);
		int colNum = retrieveNoOfCols(wsName);

		Object data[][] = new Object[rowNum][colNum];
		
		for (int i=0; i<rowNum; i++){
			
			Row row=ws.getRow(i+1);
			
			for(int j=0;j< colNum; j++){	
				
              Cell cell=row.getCell(j);
              
              
				String value = cellToString(cell);
				data[i][j] = value;
				
              }	
			
		}	
		
		return data;		
	}		


		public static String cellToString(Cell cell){
			int type;
			Object result;
			type = cell.getCellType();	
			
			switch (type){
				case 0 :
					result =(int)cell.getNumericCellValue();
					
					break;
				
				case 1 : 
					result = cell.getStringCellValue();
					break;
					
				case Cell.CELL_TYPE_BLANK:
					result=null;
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					result=cell.getBooleanCellValue();
					break;
					
				case Cell.CELL_TYPE_FORMULA:
					result=cell.getCellFormula();
					break;
			
					default :
					throw new RuntimeException("Unsupportd cell.");			
			}
			return result.toString();
		}
	
}
