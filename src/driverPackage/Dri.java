package driverPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dri {
	public WebDriver driver;
	public int timeout = 10;
	Actions actions = null;
	
	
	//���췽����������driver
	public Dri(WebDriver driver) {
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	
	
	public void get(String url) {
		driver.get(url);
	}

	
	
	/*
	 * ��ȡelementԪ��
	 * �������locator����"//"����xpath��������css
	*/
	public WebElement getElement(String locator) {
		WebElement element = null;
		if(locator.contains("//")){
			try {
				element = driver.findElement(By.xpath(locator));
			}catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}else{
			try {
				element = driver.findElement(By.cssSelector(locator));
			}catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
		return element;
	}
	
	
	
	public List<WebElement> getElementList(String locator) {
		List<WebElement> element = null;
		if(locator.contains("//")){
			try {
				element = driver.findElements(By.xpath(locator));
			}catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}else{
			try {
				element = driver.findElements(By.cssSelector(locator));
			}catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
		return element;
	}

	
	
	public void waitForElementPresent(String locator) {
		if(locator.contains("//")){
			try {
				new WebDriverWait(driver, timeout)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
			}catch (TimeoutException e) {
				e.printStackTrace();
			}catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}else{
			try {
				new WebDriverWait(driver, timeout)
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
			}catch (TimeoutException e) {
				e.printStackTrace();
			}catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
		waitFor(1500);
	}

	
	
	public void waitForElementIsEnables(String locator) {
		if(locator.contains("//")){
			try {
				new WebDriverWait(driver, timeout)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			}catch (TimeoutException e) {
				e.printStackTrace();
			}catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}else{
			try {
				new WebDriverWait(driver, timeout)
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
			}catch (TimeoutException e) {
				e.printStackTrace();
			}catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
		waitFor(1500);
	}

	
	
	public void waitFor(int timeout) {
		try {
			Thread.sleep(timeout);
		}catch (TimeoutException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//ҳ��ǰ��
	public void forward(){
		driver.navigate().forward();
	}
	
	
	
	//ҳ�����
	public void back(){
		driver.navigate().back();
	}
	
	
	
	//ҳ��ˢ��
	public void refresh(){
		driver.navigate().refresh();
	}
	
	
	
	public void quit(){
		driver.quit();
	}

}
