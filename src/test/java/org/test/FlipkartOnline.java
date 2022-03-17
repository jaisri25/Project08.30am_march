package org.test;

public class FlipkartOnline extends FlipkartMethods {
	public static void main(String[] args) throws InterruptedException {
		browserLaunch("chrome");
		urlLaunch("https://www.flipkart.com/");
		implicitWait(10);

		FlipkartPom f = new FlipkartPom();
		click(f.getBtnX());
		sendKeys(f.getSearchText(), "iphone");
		click(f.getEnter());

		// productName();

		for (int i = 1; i <= 3; i++) {
			System.out.println("----Product Name........page....."+i);
			productName();
			System.out.println("----Product price........page....."+i);
			productPrice();
			click(FindElement("xpath", "//span[text()='Next']"));
			Thread.sleep(3000);
			System.out.println("======next page=====");

		}
//		productPrice();
//
//		for (int i = 1; i <= 2; i++) {
//			click(FindElement("xpath", "//span[text()='Previous']"));
//			System.out.println("===next line==");
//			
//		}

	}
}