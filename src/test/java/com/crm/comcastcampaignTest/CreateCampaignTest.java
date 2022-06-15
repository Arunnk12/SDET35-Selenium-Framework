package com.crm.comcastcampaignTest;

import org.testng.annotations.Test;
import com.crm.comcast.POMRepo.CampaignInfoPage;
import com.crm.comcast.POMRepo.CampaignPage;
import com.crm.comcast.POMRepo.CreatedCpamPage;
import com.crm.comcast.POMRepo.HomePage;
import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;

		public class CreateCampaignTest extends Base_Class {		
		@Test(groups="smoke")
		public void CreateCampaign() throws Throwable {
					
		Excel_Utility exl = new Excel_Utility();
		Java_Utility jav = new Java_Utility();
		
		String campaignName =exl.getStringDataFromExcel("Sheet1", 4, 7)+jav.getRandomNum();
	
		HomePage homeP = new HomePage(driver);
		drivelib.mouseOverOnElement(driver, homeP.getMoreLink());
		homeP.getCampaignsLink().click();
		
		CampaignPage campaignP = new CampaignPage(driver);
		campaignP.getCampaignPlusLink().click();
		
		CampaignInfoPage campaignIP = new CampaignInfoPage(driver);
		campaignIP.getCampaignNameTF().sendKeys(campaignName);
		campaignIP.getSaveButton().click();
				
		CreatedCpamPage createdCpanP = new CreatedCpamPage(driver);
		drivelib.pageCreateConfirmationMsg(createdCpanP.getCreatedCpanName().getText(), campaignName);
		
		drivelib.mouseOverOnElement(driver, homeP.getAdministratorSignout());
		homeP.getSignoutButton();
		
		}
	}
