package com.crm.comcast.contactTest;

import org.testng.annotations.Test;

import com.crm.comcast.POMRepo.ContactsInfoPage;
import com.crm.comcast.POMRepo.ContactsPage;
import com.crm.comcast.POMRepo.CreatedCntPage;
import com.crm.comcast.POMRepo.HomePage;


import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;

public class CreateContactTest extends Base_Class{
	
@Test(groups="regression")
	
	public void CreateContact() throws Throwable {
	
		Excel_Utility exl = new Excel_Utility();	
		Java_Utility jav = new Java_Utility();
	
		String LastName =exl.getStringDataFromExcel("Sheet1", 4, 7)+jav.getRandomNum();
		HomePage homep = new HomePage(driver);
		homep.getContactsLink().click();
		
		ContactsPage contactsP = new ContactsPage(driver);
		contactsP.getContactsPlusLink().click();
		
		ContactsInfoPage contactsIP = new ContactsInfoPage(driver);
		contactsIP.getLastNameTF().sendKeys(LastName);
		contactsIP.getSaveButton().click();
		
		CreatedCntPage createdCP = new CreatedCntPage(driver);
		drivelib.pageCreateConfirmationMsg(createdCP.getCreatedCntPageName().getText(), LastName);

		drivelib.mouseOverOnElement(driver, homep.getAdministratorSignout());
		homep.getSignoutButton();
	}
}
