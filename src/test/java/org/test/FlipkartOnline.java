package org.test;

public class FlipkartOnline extends FlipkartMethods {
	public static void main(String[] args) {
		browserLaunch("chrome");
		urlLaunch("https://www.flipkart.com/");
		implicitWait(10);
				
		FlipkartPom f=new FlipkartPom();
		click(f.getBtnX());
		sendKeys(f.getSearchText(), "iphone");
		click(f.getEnter());
		
		productName();
		
		for (int i = 1; i <= 2; i++) {
			click(f.getBtnNext());
System.out.println("======next page=====");
productName();

		}
		productPrice();
		
for (int i = 1; i <= 2; i++) {
	click(f.getBtnNext());
	System.out.println("===next line==");
	productPrice();
}
}
}