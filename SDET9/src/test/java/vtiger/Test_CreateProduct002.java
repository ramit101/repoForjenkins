package vtiger;

import org.testng.annotations.Test;

import com.crm.vTiger.generic_library.BaseClass;
import com.crm.vTiger.objectRepository.Home;
import com.crm.vTiger.objectRepository.Login;

public class Test_CreateProduct002 extends BaseClass{
	@Test
	public void createQuickproduct_withTeamSales() throws Throwable{
		Login lgn = new Login(driver);
		lgn.getUsername();
		lgn.getPwd();
		lgn.getLognButton();
		
		Home hm=new Home(driver);
		hm.getQuickcreate_product();
		webutl.switchWindow(driver);
		Thread.sleep(2000);
		hm.getQuickprodName();
		hm.get_selectGroup();
		hm.get_TeamSelling_dropDown();
		hm.getquickSave();	
	}
	@ Test
	public void createProduct_withQuickCreate() throws Throwable{
		Login lgn = new Login(driver);
		lgn.getUsername();
		lgn.getPwd();
		lgn.getLognButton();
		
		Home hm=new Home(driver);
		hm.getQuickcreate_product();
		webutl.switchWindow(driver);
		Thread.sleep(2000);
		hm.getQuickprodName();
		hm.getquickSave();	
		
	}
}
