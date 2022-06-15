package com.crm.comcast.contactTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.comcast.POMRepo.ContactsInfoPage;
import com.crm.comcast.POMRepo.ContactsPage;
import com.crm.comcast.POMRepo.CreatedCntPage;
import com.crm.comcast.POMRepo.HomePage;
import com.crm.comcast.POMRepo.LoginPage;

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.PropertyFile_Utility;
import Generic_Utilities.WebDriver_Utility;

public class DeleteContact_3_Test extends Base_Class {
	
	@Test(groups="regression")
	public void DeleteContact() throws Throwable {
		
		Excel_Utility exl = new Excel_Utility();
		Java_Utility jav = new Java_Utility();
		String LastName =exl.getStringDataFromExcel("Sheet1", 4, 7)+jav.getRandomNum();
		String alertMsg =exl.getStringDataFromExcel("Sheet1", 4, 14)+jav.getRandomNum();

		HomePage homeP = new HomePage(driver);
		homeP.getContactsLink().click();
		
		ContactsPage contactsP = new ContactsPage(driver);
		contactsP.getContactsPlusLink().click();
		
		ContactsInfoPage contactsIP = new ContactsInfoPage(driver);
		contactsIP.getLastNameTF().sendKeys(LastName);
		contactsIP.getSaveButton().click();
		
		CreatedCntPage createdCP = new CreatedCntPage(driver);
		drivelib.pageCreateConfirmationMsg(createdCP.getCreatedCntPageName().getText(), LastName);
		createdCP.getDeletePage().click();
		
		drivelib.switchToAlertAndAccept(driver, alertMsg);	
		
		int count =0;
		
		List<WebElement> listLastName = driver.findElements(By.xpath("(//a[@title='Contacts'])[position() mod 2 =0]"));
		for (WebElement lastNameEle : listLastName) {
			if(lastNameEle.equals(LastName)) {
				count++;
				break;
			}
		}
		
		if(count!=0)
			System.out.println("Contact "+LastName+" is not deleted and script Failed");
		else 
			System.out.println("Contact "+LastName+" is deleted and script Pass");
		
		drivelib.mouseOverOnElement(driver, homeP.getAdministratorSignout());
		homeP.getSignoutButton();	
	}
}
