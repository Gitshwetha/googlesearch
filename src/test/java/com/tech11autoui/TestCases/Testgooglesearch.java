package com.tech11autoui.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tech11autoui.PageObjects.GooglePage;

import junit.framework.Assert;

public class Testgooglesearch extends BaseClass {
	/*
	 * TC01 test google search with search key Validate the first link found is
	 * equal to the app url in first page
	 */

	@Test
	public void TC01_Searchgoogle() {

		logger.info("Test execution starting...");
		GooglePage gp = new GooglePage(driver);
		gp.searchKey(searchKey);

		List<WebElement> lst = gp.searchlink();

		WebElement page = gp.getPage();

		System.out.println("page1:---" + page.getText());
		boolean pageone = page.getText().equals("1");
		try {
			page.findElement(By.tagName("a"));
			Assert.assertFalse("url found", false);
		} catch (Exception e) {
			Assert.assertTrue("no url found", true);
			logger.info("An error occured during execution : " + e.getMessage());
		}
		if (pageone) {
			if (lst.get(0).getAttribute("href").contains(appurl)) {
				logger.info("TC01_Searchgoogle method passed");
				Assert.assertTrue(true);

			} else
				Assert.fail();

		} else
			Assert.fail();
		logger.info("Execution completed");

	}
}
