package com.crm.vTiger.generic_library;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	public String getPropertyValue(String key) throws Throwable  {
		  
		FileInputStream fis = new FileInputStream(IConstant.commonDataFilePath);
		 Properties pObj = new Properties();
		 pObj.load(fis);
		 String value = pObj.getProperty(key);
	
	return value;
}
}
