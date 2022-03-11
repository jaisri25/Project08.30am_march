package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver chromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;

	}

	public static WebDriver firefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		return driver;

	}

	public static WebDriver browserLaunch(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		return driver;

	}

	public static void browserName(String browserName) {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		case "firefox":
			WebDriverManager.edgedriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser name");
		}
	}

	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

	}

	public static void sendKeys(WebElement e, String value) {
		e.sendKeys(value);

	}

	public static void click(WebElement e) {
		e.click();
	}

	public static String getCurrentUrl() {
		// String url = driver.getCurrentUrl();
		// return url;
		return driver.getCurrentUrl();
	}

	public static String getTitle() {
		return driver.getTitle();

	}

	public static String getText(WebElement e) {
		return e.getText();

	}

	public static String getAttribute(WebElement e) {
		return e.getAttribute("value");

	}

	public static void quit() {
		driver.quit();
	}

	// LOCATORS
	public static WebElement FindElement(String locatorName, String locValue) {
		return null;

	}

	// Actions
	public static void moveToElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);

		a.dragAndDrop(source, target).perform();
	}

	public static void contextClick(WebElement e) {
		Actions a = new Actions(driver);
		a.contextClick(e).perform();
	}

	public static void doubleClick(WebElement e) {
		Actions a = new Actions(driver);
		a.doubleClick(e).perform();
	}

	public static void click1(WebElement e) {
		Actions a = new Actions(driver);
		a.click(e).perform();
	}

	// Alert
	public static void accept() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public static void dismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	public static String getText1() {
		Alert a = driver.switchTo().alert();
		return a.getText();
	}

	public static void sendKeys1(WebElement e, String value) {
		e.sendKeys(value);

	}

	// SELECT
	public static void selectByIndex(WebElement e, int a) {
		Select s = new Select(e);
		s.selectByIndex(a);
	}

	public static void selectByValue(WebElement e, String a) {
		Select s = new Select(e);
		s.selectByValue(a);
	}

	public static void selectByVisibleText(WebElement e, String a) {
		Select s = new Select(e);
		s.selectByVisibleText(a);
	}

	public static void getOptions(WebElement e) {
		Select s = new Select(e);
		s.getOptions();

	}

	public static boolean isMultiple(WebElement e) {
		Select s = new Select(e);
		return s.isMultiple();

	}

	public static void getAllOptions(WebElement e) {
		Select s = new Select(e);
		s.getAllSelectedOptions();

	}

	public static void getFirstSelected(WebElement e) {
		Select s = new Select(e);
		s.getFirstSelectedOption();
	}

	public static void deselectByIndex(WebElement e, int a) {
		Select s = new Select(e);
		s.deselectByIndex(a);
	}

	public static void deselectByVisibleText(WebElement e, String a) {
		Select s = new Select(e);
		s.deselectByVisibleText(a);
	}

	public static void deselectByValue(WebElement e, String a) {
		Select s = new Select(e);
		s.deselectByValue(a);
	}

	public static void deselectAll(WebElement e) {
		Select s = new Select(e);
		s.deselectAll();
	}

	// SCREENSHOT
	public static void screenShot(String fileName) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File from = tk.getScreenshotAs(OutputType.FILE);
		File to = new File("C:\\Users\\K. JAYABALAN\\eclipse-workspace\\SeleniumFeb\\ScreenShot\\" + fileName + ".png");
		FileUtils.copyFile(from, to);

	}

	// NAVIGATION

	// int age=32;
	// System.out.println("age");

	// }

	// JAVA SCRIPT

	// send keys
	public static void jsSendkeys(WebElement e, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + text + "')", e);
	}

	public static void jsGetAttribute(WebElement e, String a) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAttribute('value')", e);
	}

	// WINDOWS HANDLE
	public static String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public static void windowhandles(int index) {

		Set<String> allId = driver.getWindowHandles();

		List<String> li = new LinkedList<>();
		li.addAll(allId);
		driver.switchTo().window(li.get(index));

	}

	public static String getExcelData(String fileName, String sheetName, int rowNo, int cellNo) throws IOException {
		File loc = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelSheet\\" + fileName + ".xlsx");
		FileInputStream st = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(st);
		Sheet sheet = w.getSheet("sheetName");
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int type = cell.getCellType();
		System.out.println(type);

		// type1 string
		// type0 number,date
		String Value = null;
		if (type == 1) {
			Value = cell.getStringCellValue();

		} else {
			if (DateUtil.isCellDateFormatted(cell)) {
				Value = new SimpleDateFormat("dd-MMM-yyyy").format(cell.getDateCellValue());
			} else {
				Value = String.valueOf((long) cell.getNumericCellValue());
			}
		}
		return Value;
	}
}
