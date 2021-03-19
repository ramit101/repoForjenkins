package flipkart;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vTiger.generic_library.RETRYTestListIm;

public class ReteyAnalyserImp {

//	@Test((retryAnalyzer = RETRYTestListIm.class)

	public void tc_01(){

		Assert.assertEquals("ddt","ddd");



		System.out.println("test got failed");


	}
}
