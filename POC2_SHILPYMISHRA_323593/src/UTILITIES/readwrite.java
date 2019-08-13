
  package UTILITIES;
  
  import java.io.File; import java.io.FileInputStream; import
  java.io.FileOutputStream; import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell; import
  org.apache.poi.xssf.usermodel.XSSFRow; import
  org.apache.poi.xssf.usermodel.XSSFSheet; import
  org.apache.poi.xssf.usermodel.XSSFWorkbook;
  
  
  
  public class readwrite { 
	  ArrayList<Per_Details> al=new ArrayList<Per_Details>(); 
	  Per_Details pd;
	  public String[][] readFromExcelsheet() {
  
  try {
  
  
  File path=new File("Data.xlsx");
  FileInputStream f=new FileInputStream(path);
  XSSFWorkbook wb=new XSSFWorkbook(f);
  XSSFSheet sheet=wb.getSheet("Sheet1");
  for(int i=1;i<=(sheet.getLastRowNum()-sheet.getFirstRowNum());i++)
  {
	pd=new Per_Details();
  XSSFRow r=sheet.getRow(i);
  pd.email=r.getCell(0).getStringCellValue();
  pd.pwd=r.getCell(1).getStringCellValue();
  pd.expres=r.getCell(2).getStringCellValue();
  al.add(pd);
  }
  }
  catch(IOException ee)
  { ee.getMessage(); 
  }
  String[][] str=new String[al.size()][3];
  int k=0;
  for(int i=0;i<al.size();i++)
  {
	  
		  str[i][0]=al.get(i).email;
		  str[i][1]=al.get(i).pwd;
		  str[i][2]=al.get(i).expres;
	  
  }
  return str; 
  }
  
   }
 