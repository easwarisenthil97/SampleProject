package com.dataprovider.excel;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.utils.BaseClass;

public class ReadExcelDataProvider extends BaseClass {
	 
	   @BeforeMethod
	    public void setUp() {
	        browserOpen("chrome");
	        loadUrl("https://adactinhotelapp.com/");
	 
	    }
	 
	    @Test(dataProvider = "excelData", dataProviderClass = ReadExcel.class)
	    public void logintest(String uName, String pWord) {
	 
	    	WebElement username = findElementById("username");
			WebElement password = findElementById("password");
			WebElement login = findElementById("login");
			username.sendKeys(uName);
			password.sendKeys(pWord);
			login.click();
	    }
	 
	    @AfterMethod
	    public void burnDown() {
	       pageClose();
	    }

}
