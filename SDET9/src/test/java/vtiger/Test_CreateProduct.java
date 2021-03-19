package vtiger;

import org.testng.annotations.Test;

import com.crm.vTiger.generic_library.BaseClass;
import com.crm.vTiger.generic_library.WebDriverUtils;
import com.crm.vTiger.objectRepository.CreatingNewProduct;
import com.crm.vTiger.objectRepository.Home;
import com.crm.vTiger.objectRepository.Login;
import com.crm.vTiger.objectRepository.Products;

public class Test_CreateProduct  extends BaseClass{
@Test
public void createProduct() throws Throwable{
	
	int randomNum = javaLib.generateRandomNum();
	String productName = excelLib.getExcelData("products", 1,1)+ randomNum;
	Login lgn = new Login(driver);
	lgn.getUsername();
	lgn.getPwd();
	lgn.getLognButton();
	
	Home hm=new Home(driver);
	hm.getproductlink();
	
	Products pro = new Products(driver);
	pro.click_CreateProduct();
	
	
	CreatingNewProduct cnp = new CreatingNewProduct(driver);
	cnp.getproductName(productName);
	cnp.getSave();
     }

@Test(invocationCount=0)
public void createProduct_withoutMandatoryfield() throws Throwable{
	
	Login lgn = new Login(driver);
	lgn.getUsername();
	lgn.getPwd();
	lgn.getLognButton();
	
	Home hm=new Home(driver);
	hm.getproductlink();
	
	Products pro = new Products(driver);
	pro.click_CreateProduct();
	
	
	CreatingNewProduct cnp = new CreatingNewProduct(driver);
	int randomNum = javaLib.generateRandomNum();
	String Productserialno = excelLib.getExcelData("products", 3,1)+ randomNum;	
	cnp.getproductSerialNo(driver,Productserialno);	
	cnp.getSave();
	webutl.switch_to_AlertPopup_getText(driver);
	
     }

@Test
public void createProduct_without_active() throws Throwable{
	int randomNum = javaLib.generateRandomNum();
	String productName = excelLib.getExcelData("products", 1,1)+ randomNum;
	Login lgn = new Login(driver);
	lgn.getUsername();
	lgn.getPwd();
	lgn.getLognButton();
	
	Home hm=new Home(driver);
	hm.getproductlink();
	
	Products pro = new Products(driver);
	pro.click_CreateProduct();
	
	
	CreatingNewProduct cnp = new CreatingNewProduct(driver);
	cnp.getproductName(productName);
	cnp.clickProductactivecheckbox();
	cnp.getSave();
	
	
     }

}
