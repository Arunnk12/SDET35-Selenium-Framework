package com.crm.comcast.organizationTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.crm.comcast.POMRepo.CreateOrgPage;
import com.crm.comcast.POMRepo.HomePage;
import com.crm.comcast.POMRepo.LoginPage;
import com.crm.comcast.POMRepo.OrgInfoPage;
import com.crm.comcast.POMRepo.OrganizationPage;

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.PropertyFile_Utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateOrgTest extends Base_Class{
	@Test(groups="smoke")
	public void CreateOrg() throws Throwable {
		Excel_Utility exl = new Excel_Utility();
		Java_Utility jav = new Java_Utility();
		String orgName =exl.getStringDataFromExcel("Sheet1", 4, 7)+jav.getRandomNum();
		
		HomePage homeP = new HomePage(driver);
		homeP.getOrganizationLink().click();
		
		OrganizationPage orgP = new OrganizationPage(driver);
		orgP.getOrganizationPlusLink().click();
		
		OrgInfoPage orgInfoP = new OrgInfoPage(driver);
		orgInfoP.getOrgNameTF().sendKeys(orgName);
		orgInfoP.getSaveButton().click();
		
		CreateOrgPage createdOP = new CreateOrgPage(driver);
		drivelib.pageCreateConfirmationMsg(createdOP.getCreatedPageName().getText(), orgName);

		drivelib.mouseOverOnElement(driver, homeP.getAdministratorSignout());
		homeP.getSignoutButton();
	}
}
