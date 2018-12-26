package actions;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Keyboard {
	public WebDriver driver = null;
	Actions actions = null;
	
	//���췽��
	public Keyboard(WebDriver driver){
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	
	/*
	 ���̲���������ҪСд����
	ctrl��shift��alt��26��Ӣ����ĸ��F1��F12��0��9�����֡�escȡ����tab��ǩ��windows��space�ո񡢡�enter�س���add�Ӻš�subtract���š�
	backspace�˸����up�ϼ�ͷ��down�¼�ͷ��left���ͷ��right�Ҽ�ͷ��deleteɾ����insert��end��home��pgdn��pgup 
	*/
	public void pressKey(String key1 ,String key2 ,String key3){
		String [] NumKey ={"0","1","2","3","4","5","6","7","8","9"};
		//�������μ���ctrl��shift��alt
		for(int i=0;i<NumKey.length;i++){
			//���������0��9�����ּ����͵��� RobotPressKey()������ͨ��Robot��ģ����̰��²��ͷŵĶ���
			if(key1.equals(NumKey[i]) || key2.equals(NumKey[i]) || key3.equals(NumKey[i])){
				this.RobotPressKey(key1, key2, key3);
			}
			//�����������0��9�����ּ�����ִ��Actions����keyDown()
			else{
				//�������μ���ctrl��shift��alt
				if(key1.equals("ctrl") || key2.equals("ctrl") || key3.equals("ctrl")){
					 actions.keyDown(Keys.CONTROL);
				}else if(key1.equals("shift") || key2.equals("shift") || key3.equals("shift")){
					actions.keyDown(Keys.SHIFT);
				}else if(key1.equals("alt") || key2.equals("alt") || key3.equals("alt")){
					actions.keyDown(Keys.SEMICOLON);
				}
			}
		}
		//���²��ͷ�26��Ӣ����ĸ
		String [] LetterKey = {"listener","b","c","d","e","f","g","h","i","j","k","l","m","n",
				"o","p","q","r","s","t","u","v","w","x","y","z"};
		for(int i=0;i<LetterKey.length;i++){
			if(LetterKey[i].equals(key1.toLowerCase()) || LetterKey[i].equals(key2.toLowerCase()) || 
					LetterKey[i].equals(key3.toLowerCase())){
				actions.sendKeys(LetterKey[i]);
			}
		}
		//���²��ͷ�F1��F12
		if(key1.equals("F1") || key2.equals("F1") || key3.equals("F1")){
			actions.sendKeys(Keys.F1);
		}else if(key1.equals("F2") || key2.equals("F2") || key3.equals("F2")){
			actions.sendKeys(Keys.F2);
		}else if(key1.equals("F3") || key2.equals("F3") || key3.equals("F3")){
			actions.sendKeys(Keys.F3);
		}else if(key1.equals("F4") || key2.equals("F4") || key3.equals("F4")){
			actions.sendKeys(Keys.F4);
		}else if(key1.equals("F5") || key2.equals("F5") || key3.equals("F5")){
			actions.sendKeys(Keys.F5);
		}else if(key1.equals("F6") || key2.equals("F6") || key3.equals("F6")){
			actions.sendKeys(Keys.F6);
		}else if(key1.equals("F7") || key2.equals("F7") || key3.equals("F7")){
			actions.sendKeys(Keys.F7);
		}else if(key1.equals("F8") || key2.equals("F8") || key3.equals("F8")){
			actions.sendKeys(Keys.F8);
		}else if(key1.equals("F9") || key2.equals("F9") || key3.equals("F9")){
			actions.sendKeys(Keys.F9);
		}else if(key1.equals("F10") || key2.equals("F10") || key3.equals("F10")){
			actions.sendKeys(Keys.F10);
		}else if(key1.equals("F11") || key2.equals("F11") || key3.equals("F11")){
			actions.sendKeys(Keys.F11);
		}else if(key1.equals("F12") || key2.equals("F12") || key3.equals("F12")){
			actions.sendKeys(Keys.F12);
		}
		/*
		 ���²��ͷ�������
		escȡ����Tab��ǩ��windows����space�ո񡢡�enter�س���add�Ӻš�subtract���š�backspace�˸����
		up�ϼ�ͷ��down�¼�ͷ��left���ͷ��right�Ҽ�ͷ��deleteɾ����insert��end��home��pgdn��pgup 
		*/
		String key1Low = key1.toLowerCase();
		String key2Low = key2.toLowerCase();
		String key3Low = key3.toLowerCase();
		if("escȡ��".contains(key1Low) || "escȡ��".contains(key2Low) || "escȡ��".contains(key3Low)){
			actions.sendKeys(Keys.ESCAPE);
		}else if("tab��ǩ".contains(key1Low) || "tab��ǩ".contains(key2Low) || "tab��ǩ".contains(key3Low)){
			actions.sendKeys(Keys.TAB);
		}else if("windows".contains(key1Low) || "windows".contains(key2Low) || "windows".contains(key3Low)){
			actions.sendKeys(Keys.COMMAND);
		}else if("space�ո�".contains(key1Low) || "space�ո�".contains(key2Low) || "space�ո�".contains(key3Low)){
			actions.sendKeys(Keys.SPACE);
		}else if("enter�س�".contains(key1Low) || "enter�س�".contains(key2Low) || "enter�س�".contains(key3Low)){
			actions.sendKeys(Keys.ENTER);
		}else if("add + �Ӻ�".contains(key1Low) || "add + �Ӻ�".contains(key2Low) || "add + �Ӻ�".contains(key3Low)){
			actions.sendKeys(Keys.ADD);
		}else if("subtract - ����".contains(key1Low) || "subtract - ����".contains(key2Low) || "subtract - ����".contains(key3Low)){
			actions.sendKeys(Keys.SUBTRACT);
		}else if("backspace�˸�".contains(key1Low) || "backspace�˸�".contains(key2Low) || "backspace�˸�".contains(key3Low)){
			actions.sendKeys(Keys.BACK_SPACE);
		}else if("up�ϼ�ͷ".contains(key1Low) || "up�ϼ�ͷ".contains(key2Low) || "up�ϼ�ͷ".contains(key3Low)){
			actions.sendKeys(Keys.ARROW_UP);
		}else if("down�¼�ͷ".contains(key1Low) || "down�¼�ͷ".contains(key2Low) || "down�¼�ͷ".contains(key3Low)){
			actions.sendKeys(Keys.ARROW_DOWN);
		}else if("left���ͷ".contains(key1Low) || "left���ͷ".contains(key2Low) || "left���ͷ".contains(key3Low)){
			actions.sendKeys(Keys.ARROW_LEFT);
		}else if("right�Ҽ�ͷ".contains(key1Low) || "right�Ҽ�ͷ".contains(key2Low) || "right�Ҽ�ͷ".contains(key3Low)){
			actions.sendKeys(Keys.ARROW_RIGHT);
		}else if("deleteɾ��".contains(key1Low) || "deleteɾ��".contains(key2Low) || "deleteɾ��".contains(key3Low)){
			actions.sendKeys(Keys.DELETE);
		}else if("insert����".contains(key1Low) || "insert����".contains(key2Low) || "insert����".contains(key3Low)){
			actions.sendKeys(Keys.INSERT);
		}else if("end".contains(key1Low) || "end".contains(key2Low) || "end".contains(key3Low)){
			actions.sendKeys(Keys.END);
		}else if("home".contains(key1Low) || "home".contains(key2Low) || "home".contains(key3Low)){
			actions.sendKeys(Keys.HOME);
		}else if("pgdn".contains(key1Low) || "pgdn".contains(key2Low) || "pgdn".contains(key3Low)){
			actions.sendKeys(Keys.PAGE_DOWN);
		}else if("pgup".contains(key1Low) || "pgup".contains(key2Low) || "pgup".contains(key3Low)){
			actions.sendKeys(Keys.PAGE_UP);
		}
		//�ͷ����μ���ctrl��shift��alt
		actions.keyUp(Keys.CONTROL).perform(); //�ͷ�ctrl
		actions.keyUp(Keys.SHIFT).perform(); //�ͷ�shift
		actions.keyUp(Keys.ALT).perform(); //�ͷ�alt
	}
	
	
	
	public void RobotPressKey(String key1 ,String key2 ,String key3){
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		//�������μ���ctrl��shift��alt
		if(key1.equals("ctrl") || key2.equals("ctrl") || key3.equals("ctrl")){
			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL); //����ctrl��
		}else if(key1.equals("shift") || key2.equals("shift") || key3.equals("shift")){
			robot.keyPress(java.awt.event.KeyEvent.VK_SHIFT); //����shift��
		}else if(key1.equals("alt") || key2.equals("alt") || key3.equals("alt")){
			robot.keyPress(java.awt.event.KeyEvent.VK_ALT); //����alt��
		}
		//���²��ͷ�prtsc��
		if(key1.equals("prtsc") || key2.equals("prtsc") || key3.equals("prtsc")){
			robot.keyPress(java.awt.event.KeyEvent.VK_PRINTSCREEN);
		}
		//���²��ͷ�0��9�����ּ�
		if(key1.equals("0") || key2.equals("0") || key3.equals("0")){
			robot.keyPress(java.awt.event.KeyEvent.VK_0); //�������ּ�0
			robot.keyRelease(java.awt.event.KeyEvent.VK_0); //�ͷ����ּ�0
		}else if(key1.equals("1") || key2.equals("1") || key3.equals("1")){
			robot.keyPress(java.awt.event.KeyEvent.VK_1);  //���²��ͷ����ּ�
			robot.keyRelease(java.awt.event.KeyEvent.VK_1);
		}else if(key1.equals("2") || key2.equals("2") || key3.equals("2")){
			robot.keyPress(java.awt.event.KeyEvent.VK_2);
			robot.keyRelease(java.awt.event.KeyEvent.VK_2);
		}else if(key1.equals("3") || key2.equals("3") || key3.equals("3")){
			robot.keyPress(java.awt.event.KeyEvent.VK_3);
			robot.keyRelease(java.awt.event.KeyEvent.VK_3);
		}else if(key1.equals("4") || key2.equals("4") || key3.equals("4")){
			robot.keyPress(java.awt.event.KeyEvent.VK_4);
			robot.keyRelease(java.awt.event.KeyEvent.VK_4);
		}else if(key1.equals("5") || key2.equals("5") || key3.equals("5")){
			robot.keyPress(java.awt.event.KeyEvent.VK_5);
			robot.keyRelease(java.awt.event.KeyEvent.VK_5);
		}else if(key1.equals("6") || key2.equals("6") || key3.equals("6")){
			robot.keyPress(java.awt.event.KeyEvent.VK_6);
			robot.keyRelease(java.awt.event.KeyEvent.VK_6);
		}else if(key1.equals("7") || key2.equals("7") || key3.equals("7")){
			robot.keyPress(java.awt.event.KeyEvent.VK_7);
			robot.keyRelease(java.awt.event.KeyEvent.VK_7);
		}else if(key1.equals("8") || key2.equals("8") || key3.equals("8")){
			robot.keyPress(java.awt.event.KeyEvent.VK_8);
			robot.keyRelease(java.awt.event.KeyEvent.VK_8);
		}else if(key1.equals("9") || key2.equals("9") || key3.equals("9")){
			robot.keyPress(java.awt.event.KeyEvent.VK_9);
			robot.keyRelease(java.awt.event.KeyEvent.VK_9);
		}
		//�ͷ����μ���ctrl��shift��alt
		robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL); //�ͷ�ctrl��
		robot.keyRelease(java.awt.event.KeyEvent.VK_SHIFT); //�ͷ�shift��
		robot.keyRelease(java.awt.event.KeyEvent.VK_ALT); //�ͷ�alt��
	}
	
}
