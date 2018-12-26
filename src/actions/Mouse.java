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
	
	//���췽��
	public Mouse(WebDriver driver){
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	
	//�����ָ����Ԫ���Ͻ��У�˫��������Ҽ�����ͣ���ͷ����
	public void mouseActions(String actionName ,String element){
		if(actionName.contains("˫��")){
			actions.doubleClick(driver.findElement(By.xpath(element))).build().perform(); // ���˫��ָ����Ԫ��
		}else if(actionName.contains("�Ҽ�")){
			actions.contextClick(driver.findElement(By.xpath(element))).build().perform(); //��ָ����Ԫ���ϵ������Ҽ�
		}else if(actionName.contains("�ƶ�")){
			actions.moveToElement(driver.findElement(By.xpath(element))).build().perform(); // ������Ƶ�ָ����Ԫ���е�
		}else if(actionName.contains("��ͣ")){
			actions.clickAndHold(driver.findElement(By.xpath(element))).build().perform(); //�����ͣ��ָ����Ԫ����
		}else if(actionName.contains("�ͷ�")){
			actions.release().build().perform(); // �ͷ����
		}
	}
	
	
	//�����ק�������� elementԪ���Ϸŵ�targetԪ�ص�λ�á�
	public void dragElementToElement(String element ,String targetElement){
		actions.dragAndDrop(driver.findElement(By.xpath(element)),driver.findElement(By.xpath(targetElement))).build().perform();
	}
	
	
	//�����ק��������ָ����Ԫ���Ϸŵ�(X,Y)λ�ã����� XΪ�����꣬YΪ�����ꡣ
	public void dragElementToXY(String element ,int X ,int Y){
		actions.dragAndDropBy(driver.findElement(By.xpath(element)), X, Y).build().perform(); //��ק
		@SuppressWarnings("unused")
		Point point = driver.findElement(By.xpath(element)).getLocation(); //��ȡ��ק�������
	}
	
	
	//jsʵ���Ϲ��������ϵ���ĳ��Ԫ�����ڵ�����
	public void dragScrollToElement(String locator){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(locator));
		Point point = element.getLocation();
		js.executeScript("window.scrollTo(" + 0 + ","  + point.getY() + ")" );
	}
	
	
	//���˫��ָ����Ԫ��
	public void doubleClick(String element){
		actions.doubleClick(driver.findElement(By.xpath(element))).build().perform();
	}
	
	
	//��ָ����Ԫ���ϵ������Ҽ�
	public void contextClick(String element){
		actions.contextClick(driver.findElement(By.xpath(element))).build().perform();
	}
	
	
	// ������Ƶ� elementԪ���е�
	public void moveToElement(String element){
		actions.moveToElement(driver.findElement(By.xpath(element))).build().perform();
	}
	
	
	//�����ͣ��ָ����Ԫ����
	public void clickAndHold(String element){
		actions.clickAndHold(driver.findElement(By.xpath(element))).build().perform();
	}
	
	
	// �ͷ����
	public void release(String element){
		actions.release().build().perform();
	}
}
