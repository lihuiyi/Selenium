package actions;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {
	
	//截屏， 然后保存到指定的目录， 参数：图片保存的目录 ，比如"actual"
	public static String takesScreenshot(WebDriver driver , String Dir){
        //判断目录是否存在，如果不存在就创建目录， 图片保存在此目录中
		File f = new File(Dir);
        if (!f.exists()){
            f.mkdirs();
        }
        //获取当前系统时间，用于创建文件名
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-hhmmss-SSS");
        String time =dateFormat.format( new Date());
        //获取 包名、类名、方法名、代码行数 ，用于创建文件名
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String className = stackTrace[1].getClassName();
        String MethodName = stackTrace[1].getMethodName(); //方法名
        int LineNumber = stackTrace[1].getLineNumber(); //代码在第几行
        //创建文件名
        String imageName = time + "-" + className + "." + MethodName + "-第" + LineNumber + "行" + ".png";
        //拼接出 文件路径
        String imagePath = Dir + "\\" + imageName; //自定义图片路径
//        String imagePath = f.getAbsolutePath() + "\\" + imageName; //图片放在项目下
        //截图开始
        try {
            //执行屏幕截图，返回file文件，默认保存到temp目录中
            File imageFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //图片另存到指定的路径：   filePath
            FileUtils.copyFile(imageFile, new File(imagePath));
        }  catch (IOException e) {
            e.printStackTrace();
        }
		return imagePath;
    }
	
	
	//截屏，图片保存在项目下的screenshot目录
	public static String takesScreenshot(WebDriver driver) {
		//判断目录是否存在，如果不存在就创建目录， 图片保存在此目录中
		String Dir = "screenshot\\exception";
        File f = new File(Dir);  //参数是目录名
        if (!f.exists()){
            f.mkdirs();
        }
        //获取当前系统时间，用于创建文件名
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HH：mm：ss：SSS");
        String time =dateFormat.format( new Date());
        //创建文件名
        String imageName = time  + ".png";
        //拼接出 文件路径
        String imagePath = f.getAbsolutePath() + "\\" + imageName; //图片放在项目下
		try {
            //执行屏幕截图，返回file文件，默认保存到temp目录中
            File imageFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //图片另存到指定的路径：   filePath
            FileUtils.copyFile(imageFile, new File(imagePath));
        }  catch (IOException e) {
            e.printStackTrace();
        }
		return imagePath;
    }
	
	
	public static Boolean checkScreenshot(String expectedPath , String actualPath){
		//生成了两个文件对象，一个是实际测试过程中产生的图片，一个是之前已经截取的期望图片，
    	File fileOutPut = new File(actualPath);  //实际截图
    	File fileInput = new File(expectedPath); //期望截图
    	BufferedImage bufileInput = null;
        BufferedImage bufileOutPut = null;
		try {
			bufileInput = ImageIO.read(fileInput);
			bufileOutPut = ImageIO.read(fileOutPut);
		} catch (IOException e) {
			e.printStackTrace();
		}
        DataBuffer dafileInput = bufileInput.getData().getDataBuffer();
        int sizefileInput = dafileInput.getSize();
        DataBuffer dafileOutPut = bufileOutPut.getData().getDataBuffer();
        int sizefileOutPut = dafileOutPut.getSize();
        Boolean matchFlag = true;
        if(sizefileInput == sizefileOutPut){
	        for(int j = 0; j<sizefileInput; j ++){
	        	if(dafileInput.getElem(j) != dafileOutPut.getElem(j)) {
	                matchFlag =  false;
	                break;
	            }
	        }
        }else{
        	matchFlag = false;
        }
		return matchFlag;
	}
	
	public static void main(String[] args) {
		Boolean a = Screenshot.checkScreenshot("F:\\谷歌.png", "F:\\火狐.png");
		System.out.println(a);
	}
	
}
