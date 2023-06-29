package genericUtilities;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileUtility {
public String readDataFromPropertyFile(String key) throws Throwable  {
	FileInputStream fisp=new FileInputStream(IconstantsUtility.propertyFilePath); 
	Properties p=new Properties();
	p.load(fisp);
	 return p.getProperty(key);
	 
	
}
}
