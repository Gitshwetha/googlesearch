package com.tech11autoui.PageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

	WebDriver ldriver;

	public GooglePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "q")
	WebElement text;

	@FindBy(xpath = "//button[@class='Tg7LZd']")
	WebElement btnsearch;

	@FindBy(xpath = "//div[@class='r']//a")
	List<WebElement> lnk;
	
	@FindBy(xpath = "//td[@class='YyVfkd']")
	WebElement page;

	public void searchKey(String search) {
		text.sendKeys(search);
		text.sendKeys(Keys.ENTER);
	}

	public List<WebElement> searchlink() {
		return lnk;

	}
	
	public WebElement getPage() {
		return page;
	}
	
	
}
