package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IphonePg extends BaseClass{
	public IphonePg() {
		PageFactory.initElements(driver, this);
	}
         @FindBy(xpath="//div[@class='_4rR01T']")
          private WebElement phones;
         
         
          public WebElement getPhones() {
			return phones;
		}


		public WebElement getPhonePrices() {
			return phonePrices;
		}
		@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
          private WebElement phonePrices;

}
