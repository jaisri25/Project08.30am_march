package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPom extends BaseClass{
	public FlipkartPom() {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	private WebElement btnX;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchText;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement enter;

	
	@FindBy(xpath="//span[text()='Next']")
	private WebElement btnNext;

	@FindBy(xpath="//span[text()='Previous']")
	private WebElement btnPrevious;
	


	public WebElement getBtnX() {
		return btnX;
	}
	

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getEnter() {
		return enter;
	}
	
	public WebElement getBtnNext() {
		return btnNext;
	}

	public WebElement getBtnPrevious() {
		return btnPrevious;
	}


}
