package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Mouse {
	public WebDriver driver = null;
	Actions actions = null;
	int timeout = 10;
	
	//构造方法
	public Mouse(WebDriver driver){
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	
	//鼠标在指定的元素上进行：双击、点击右键、悬停、释放鼠标
	public void mouseActions(String actionName ,String element){
		if(actionName.contains("双击")){
			actions.doubleClick(driver.findElement(By.xpath(element))).build().perform(); // 鼠标双击指定的元素
		}else if(actionName.contains("右键")){
			actions.contextClick(driver.findElement(By.xpath(element))).build().perform(); //在指定的元素上点击鼠标右键
		}else if(actionName.contains("移动")){
			actions.moveToElement(driver.findElement(By.xpath(element))).build().perform(); // 将鼠标移到指定的元素中点
		}else if(actionName.contains("悬停")){
			actions.clickAndHold(driver.findElement(By.xpath(element))).build().perform(); //鼠标悬停在指定的元素上
		}else if(actionName.contains("释放")){
			actions.release().build().perform(); // 释放鼠标
		}
	}
	
	
	//鼠标拖拽动作，将 element元素拖放到target元素的位置。
	public void dragElementToElement(String element ,String targetElement){
		actions.dragAndDrop(driver.findElement(By.xpath(element)),driver.findElement(By.xpath(targetElement))).build().perform();
	}
	
	
	//鼠标拖拽动作，将指定的元素拖放到(X,Y)位置，其中 X为横坐标，Y为纵坐标。
	public void dragElementToXY(String element ,int X ,int Y){
		actions.dragAndDropBy(driver.findElement(By.xpath(element)), X, Y).build().perform(); //拖拽
		@SuppressWarnings("unused")
		Point point = driver.findElement(By.xpath(element)).getLocation(); //获取拖拽后的坐标
	}
	
	
	//js实现拖滚动条，拖到到某个元素所在的坐标
	public void dragScrollToElement(String locator){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(locator));
		Point point = element.getLocation();
		js.executeScript("window.scrollTo(" + 0 + ","  + point.getY() + ")" );
	}
	
	
	//鼠标双击指定的元素
	public void doubleClick(String element){
		actions.doubleClick(driver.findElement(By.xpath(element))).build().perform();
	}
	
	
	//在指定的元素上点击鼠标右键
	public void contextClick(String element){
		actions.contextClick(driver.findElement(By.xpath(element))).build().perform();
	}
	
	
	// 将鼠标移到 element元素中点
	public void moveToElement(String element){
		actions.moveToElement(driver.findElement(By.xpath(element))).build().perform();
	}
	
	
	//鼠标悬停在指定的元素上
	public void clickAndHold(String element){
		actions.clickAndHold(driver.findElement(By.xpath(element))).build().perform();
	}
	
	
	// 释放鼠标
	public void release(String element){
		actions.release().build().perform();
	}
}
