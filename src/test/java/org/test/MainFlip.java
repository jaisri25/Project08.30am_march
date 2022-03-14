package org.test;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainFlip extends BaseClass {
	public static void main(String[] args) throws Throwable {
		browserLaunch("chrome");
		urlLaunch("https://www.flipkart.com/");
		implicitWait(10);
	Thread.sleep(2000);
				
		FlipkartPom f=new FlipkartPom();
		click(f.getBtnX());
		sendKeys(f.getSearchText(), "iphone");
		click(f.getEnter());
		
		
	List<WebElement> products = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	int size = products.size();
	System.out.println(size);
	for(int i=0;i<products.size();i++) {
	WebElement webElement = products.get(i);
	String text = webElement.getText();
	System.out.println(text);
	}
	
	//product price
	List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	int size2 = productPrice.size();
	System.out.println(size2);
}}