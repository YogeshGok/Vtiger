package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileDataFetching {
public static void main(String[] args) throws Throwable {
	//create object of FileInputStream class
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\Ankush.properties");
	Properties p=new Properties();
	p.load(fisp);
	//call the keys automatically values can be printed
	String UN = p.getProperty("un");
	System.out.println(UN);
	String PWD = p.getProperty("password");
	System.out.println(PWD);
	String BROWSER = p.getProperty("browser");
	System.out.println(BROWSER);
}
}
