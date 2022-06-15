package com.crm.comcast.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	private WebDriver driver; 
	public CreateProductPage(WebDriver driver){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (className = "lvtHeaderText")
	private WebElement  createdPdtPageName;

	public WebElement getCreatedPdtPageName() {
		return createdPdtPageName;
	}

}
