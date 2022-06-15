		package com.crm.comcastcampaignTest;

		import org.openqa.selenium.By;

import org.testng.annotations.Test;
import com.crm.comcast.POMRepo.CampaignInfoPage;
import com.crm.comcast.POMRepo.CampaignPage;
import com.crm.comcast.POMRepo.CreateProductPage;
import com.crm.comcast.POMRepo.CreatedCpamPage;
import com.crm.comcast.POMRepo.HomePage;
import com.crm.comcast.POMRepo.ProductInfoPage;
import com.crm.comcast.POMRepo.ProductPage;
import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;  


		public class CreateCampaginWithProduct_2_Test extends Base_Class {
	
		@Test(groups="regression")
	
		public void CreateCampaginWithProduct() throws Throwable{
		
		
		Excel_Utility exl = new Excel_Utility();
		Java_Utility jav = new Java_Utility();
		
		String campaignName =exl.getStringDataFromExcel("Sheet1", 4, 7)+jav.getRandomNum();
		String productName =exl.getStringDataFromExcel("Sheet1", 4, 8);
		
		HomePage homeP = new HomePage(driver);
		homeP.getProductsLink().click();
		
		ProductPage productP = new ProductPage(driver);
		productP.getProductPlusLink().click();
		
		ProductInfoPage productIP = new ProductInfoPage(driver);
		productIP.getProductNameTF().sendKeys(productName);
		productIP.getSaveButton().click();
		
		CreateProductPage createdPdtP = new CreateProductPage(driver);
		String actualProductMsg =createdPdtP.getCreatedPdtPageName().getText();
		drivelib.pageCreateConfirmationMsg(actualProductMsg, productName);
		
		drivelib.mouseOverOnElement(driver, homeP.getMoreLink());
		homeP.getCampaignsLink().click();
		
		CampaignPage campaignP = new CampaignPage(driver);
		campaignP.getCampaignPlusLink().click();
	
		CampaignInfoPage campaignIP = new CampaignInfoPage(driver);
		String parentWin = driver.getWindowHandle(); 
		campaignIP.getCampaignNameTF().sendKeys(campaignName);
		campaignIP.getProdWinButton().click();
		drivelib.switchToWindowExcludeParent(driver, actualProductMsg);
		driver.findElement(By.linkText(productName)).click();
		
		driver.switchTo().window(parentWin);
		campaignIP.getSaveButton().click();
		
		CreatedCpamPage createdCpanP = new CreatedCpamPage(driver);
		drivelib.pageCreateConfirmationMsg(createdCpanP.getCreatedCpanName().getText(), campaignName);	
				
		drivelib.mouseOverOnElement(driver, homeP.getAdministratorSignout());
		homeP.getSignoutButton();
	
		}
	}
