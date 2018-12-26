package actions;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Keyboard {
	public WebDriver driver = null;
	Actions actions = null;
	
	//构造方法
	public Keyboard(WebDriver driver){
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	
	/*
	 键盘操作（参数要小写）：
	ctrl、shift、alt、26个英文字母、F1到F12、0到9的数字、esc取消、tab标签、windows、space空格、、enter回车、add加号、subtract减号、
	backspace退格键、up上箭头、down下箭头、left左箭头、right右箭头、delete删除、insert、end、home、pgdn、pgup 
	*/
	public void pressKey(String key1 ,String key2 ,String key3){
		String [] NumKey ={"0","1","2","3","4","5","6","7","8","9"};
		//按下修饰键：ctrl、shift、alt
		for(int i=0;i<NumKey.length;i++){
			//如果参数是0到9的数字键，就调用 RobotPressKey()方法，通过Robot来模拟键盘按下并释放的动作
			if(key1.equals(NumKey[i]) || key2.equals(NumKey[i]) || key3.equals(NumKey[i])){
				this.RobotPressKey(key1, key2, key3);
			}
			//如果参数不是0到9的数字键，就执行Actions类中keyDown()
			else{
				//按下修饰键：ctrl、shift、alt
				if(key1.equals("ctrl") || key2.equals("ctrl") || key3.equals("ctrl")){
					 actions.keyDown(Keys.CONTROL);
				}else if(key1.equals("shift") || key2.equals("shift") || key3.equals("shift")){
					actions.keyDown(Keys.SHIFT);
				}else if(key1.equals("alt") || key2.equals("alt") || key3.equals("alt")){
					actions.keyDown(Keys.SEMICOLON);
				}
			}
		}
		//按下并释放26个英文字母
		String [] LetterKey = {"listener","b","c","d","e","f","g","h","i","j","k","l","m","n",
				"o","p","q","r","s","t","u","v","w","x","y","z"};
		for(int i=0;i<LetterKey.length;i++){
			if(LetterKey[i].equals(key1.toLowerCase()) || LetterKey[i].equals(key2.toLowerCase()) || 
					LetterKey[i].equals(key3.toLowerCase())){
				actions.sendKeys(LetterKey[i]);
			}
		}
		//按下并释放F1到F12
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
		 按下并释放其他键
		esc取消、Tab标签、windows键、space空格、、enter回车、add加号、subtract减号、backspace退格键、
		up上箭头、down下箭头、left左箭头、right右箭头、delete删除、insert、end、home、pgdn、pgup 
		*/
		String key1Low = key1.toLowerCase();
		String key2Low = key2.toLowerCase();
		String key3Low = key3.toLowerCase();
		if("esc取消".contains(key1Low) || "esc取消".contains(key2Low) || "esc取消".contains(key3Low)){
			actions.sendKeys(Keys.ESCAPE);
		}else if("tab标签".contains(key1Low) || "tab标签".contains(key2Low) || "tab标签".contains(key3Low)){
			actions.sendKeys(Keys.TAB);
		}else if("windows".contains(key1Low) || "windows".contains(key2Low) || "windows".contains(key3Low)){
			actions.sendKeys(Keys.COMMAND);
		}else if("space空格".contains(key1Low) || "space空格".contains(key2Low) || "space空格".contains(key3Low)){
			actions.sendKeys(Keys.SPACE);
		}else if("enter回车".contains(key1Low) || "enter回车".contains(key2Low) || "enter回车".contains(key3Low)){
			actions.sendKeys(Keys.ENTER);
		}else if("add + 加号".contains(key1Low) || "add + 加号".contains(key2Low) || "add + 加号".contains(key3Low)){
			actions.sendKeys(Keys.ADD);
		}else if("subtract - 减号".contains(key1Low) || "subtract - 减号".contains(key2Low) || "subtract - 减号".contains(key3Low)){
			actions.sendKeys(Keys.SUBTRACT);
		}else if("backspace退格".contains(key1Low) || "backspace退格".contains(key2Low) || "backspace退格".contains(key3Low)){
			actions.sendKeys(Keys.BACK_SPACE);
		}else if("up上箭头".contains(key1Low) || "up上箭头".contains(key2Low) || "up上箭头".contains(key3Low)){
			actions.sendKeys(Keys.ARROW_UP);
		}else if("down下箭头".contains(key1Low) || "down下箭头".contains(key2Low) || "down下箭头".contains(key3Low)){
			actions.sendKeys(Keys.ARROW_DOWN);
		}else if("left左箭头".contains(key1Low) || "left左箭头".contains(key2Low) || "left左箭头".contains(key3Low)){
			actions.sendKeys(Keys.ARROW_LEFT);
		}else if("right右箭头".contains(key1Low) || "right右箭头".contains(key2Low) || "right右箭头".contains(key3Low)){
			actions.sendKeys(Keys.ARROW_RIGHT);
		}else if("delete删除".contains(key1Low) || "delete删除".contains(key2Low) || "delete删除".contains(key3Low)){
			actions.sendKeys(Keys.DELETE);
		}else if("insert插入".contains(key1Low) || "insert插入".contains(key2Low) || "insert插入".contains(key3Low)){
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
		//释放修饰键：ctrl、shift、alt
		actions.keyUp(Keys.CONTROL).perform(); //释放ctrl
		actions.keyUp(Keys.SHIFT).perform(); //释放shift
		actions.keyUp(Keys.ALT).perform(); //释放alt
	}
	
	
	
	public void RobotPressKey(String key1 ,String key2 ,String key3){
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		//按下修饰键：ctrl、shift、alt
		if(key1.equals("ctrl") || key2.equals("ctrl") || key3.equals("ctrl")){
			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL); //按下ctrl键
		}else if(key1.equals("shift") || key2.equals("shift") || key3.equals("shift")){
			robot.keyPress(java.awt.event.KeyEvent.VK_SHIFT); //按下shift键
		}else if(key1.equals("alt") || key2.equals("alt") || key3.equals("alt")){
			robot.keyPress(java.awt.event.KeyEvent.VK_ALT); //按下alt键
		}
		//按下并释放prtsc键
		if(key1.equals("prtsc") || key2.equals("prtsc") || key3.equals("prtsc")){
			robot.keyPress(java.awt.event.KeyEvent.VK_PRINTSCREEN);
		}
		//按下并释放0到9的数字键
		if(key1.equals("0") || key2.equals("0") || key3.equals("0")){
			robot.keyPress(java.awt.event.KeyEvent.VK_0); //按下数字键0
			robot.keyRelease(java.awt.event.KeyEvent.VK_0); //释放数字键0
		}else if(key1.equals("1") || key2.equals("1") || key3.equals("1")){
			robot.keyPress(java.awt.event.KeyEvent.VK_1);  //按下并释放数字键
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
		//释放修饰键：ctrl、shift、alt
		robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL); //释放ctrl键
		robot.keyRelease(java.awt.event.KeyEvent.VK_SHIFT); //释放shift键
		robot.keyRelease(java.awt.event.KeyEvent.VK_ALT); //释放alt键
	}
	
}
