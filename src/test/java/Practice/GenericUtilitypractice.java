package Practice;

import genericUtilities.ExcelUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilitypractice {
public static void main(String[] args) throws Throwable {
	PropertyFileUtility putil=new PropertyFileUtility();
	String URL = putil.readDataFromPropertyFile("url");
	System.out.println(URL);
	String UN = putil.readDataFromPropertyFile("username");
	System.out.println(UN);
	
	
	//call excel data
	ExcelUtility eutil=new ExcelUtility();
	String data = eutil.readDataFromExcel("Organization",4,2);
	System.out.println(data);
	
}
}
