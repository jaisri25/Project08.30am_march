package org.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class MainFlip extends BaseClass {
	public static void main(String[] args) {
		browserLaunch("chrome");
		urlLaunch("https://www.flipkart.com/");
		implicitWait(10);
				
		FlipkartPom f=new FlipkartPom();
		click(f.getBtnX());
		sendKeys(f.getSearchText(), "iphone");
		click(f.getEnter());
		
		//product name
		List<WebElement> product = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		for(int i=0;i<product.size();i++) {
			String text = product.get(i).getText();
			System.out.println(text);
		}
		
		List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		List<Integer> pricelist = new ArrayList<>();
		Map<String,Integer> mp = new HashMap<>();
		
		int size2 = productPrice.size();
		System.out.println(size2);
		
		for(int j=0;j<productPrice.size();j++) {
			WebElement webElement = productPrice.get(j);
			String text2 = webElement.getText();
			String substring = text2.substring(1); // symbol remove
			String replace = null;
			if (substring.contains(",")) {
				 replace = substring.replace(",", "");
			}
		
				int intPrice = Integer.parseInt(replace); // string to int
				pricelist.add(intPrice);
				mp.put(product.get(j).getText(), Integer.parseInt(replace));
		}
		
		System.out.println(" --------------Price List Before Sorting-----------------");
		for (int x : pricelist) {
			System.out.println(x);
		}
		
		
		Set<Entry<String, Integer>> entrySet = mp.entrySet();
		for (Entry<String,Integer> entry : entrySet) {
			System.out.println(entry);
		}
		



	System.out.println("----ascending order----");

	Collections.sort(pricelist);
	System.out.println("prices is "+pricelist);
	
	
	System.out.println("==minimum price=="+Collections.min(pricelist));
	System.out.println("==maximum price=="+Collections.max(pricelist));
	
	}	
}