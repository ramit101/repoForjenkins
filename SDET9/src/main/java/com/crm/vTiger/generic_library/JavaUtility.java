package com.crm.vTiger.generic_library;

import java.util.Random;

public class JavaUtility {
	/**
	 * @author ramit
	 * @return
	 */
	
	public int  generateRandomNum() {
		Random random = new Random();
		 int randomInt = random.nextInt(1000);

		 return randomInt;
	}
}
