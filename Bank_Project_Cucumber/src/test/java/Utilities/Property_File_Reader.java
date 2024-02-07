package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.checkerframework.common.reflection.qual.GetClass;

public class Property_File_Reader {
	
	//read the data from property file
	
	public    Object getData(String keyward)
	{
		/*FileInputStream fi=null;
		String path=System.getProperty("user.dir")+"//PropertiesFile//properties";
		try
		{
		  fi=new FileInputStream(path);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Properties property=new Properties();
		try
		{
		property.load(fi);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return property.getProperty(keyward);*/
		Properties p=new Properties();
		try {
			//getclass().getResourceAsStream used for getting file from resource folder
			p.load(getClass().getResourceAsStream("/PropertiesFile/Properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p.getProperty(keyward);
	}
	
	
	
	
	

}
