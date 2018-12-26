package other;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	public WebDriver driver;
	public int timeout = 10;


	public Wait(WebDriver driver) {
		this.driver = driver;
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
		} catch (TimeoutException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
