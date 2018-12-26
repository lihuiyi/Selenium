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
	
	//������ Ȼ�󱣴浽ָ����Ŀ¼�� ������ͼƬ�����Ŀ¼ ������"actual"
	public static String takesScreenshot(WebDriver driver , String Dir){
        //�ж�Ŀ¼�Ƿ���ڣ���������ھʹ���Ŀ¼�� ͼƬ�����ڴ�Ŀ¼��
		File f = new File(Dir);
        if (!f.exists()){
            f.mkdirs();
        }
        //��ȡ��ǰϵͳʱ�䣬���ڴ����ļ���
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-hhmmss-SSS");
        String time =dateFormat.format( new Date());
        //��ȡ ���������������������������� �����ڴ����ļ���
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String className = stackTrace[1].getClassName();
        String MethodName = stackTrace[1].getMethodName(); //������
        int LineNumber = stackTrace[1].getLineNumber(); //�����ڵڼ���
        //�����ļ���
        String imageName = time + "-" + className + "." + MethodName + "-��" + LineNumber + "��" + ".png";
        //ƴ�ӳ� �ļ�·��
        String imagePath = Dir + "\\" + imageName; //�Զ���ͼƬ·��
//        String imagePath = f.getAbsolutePath() + "\\" + imageName; //ͼƬ������Ŀ��
        //��ͼ��ʼ
        try {
            //ִ����Ļ��ͼ������file�ļ���Ĭ�ϱ��浽tempĿ¼��
            File imageFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //ͼƬ��浽ָ����·����   filePath
            FileUtils.copyFile(imageFile, new File(imagePath));
        }  catch (IOException e) {
            e.printStackTrace();
        }
		return imagePath;
    }
	
	
	//������ͼƬ��������Ŀ�µ�screenshotĿ¼
	public static String takesScreenshot(WebDriver driver) {
		//�ж�Ŀ¼�Ƿ���ڣ���������ھʹ���Ŀ¼�� ͼƬ�����ڴ�Ŀ¼��
		String Dir = "screenshot\\exception";
        File f = new File(Dir);  //������Ŀ¼��
        if (!f.exists()){
            f.mkdirs();
        }
        //��ȡ��ǰϵͳʱ�䣬���ڴ����ļ���
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HH��mm��ss��SSS");
        String time =dateFormat.format( new Date());
        //�����ļ���
        String imageName = time  + ".png";
        //ƴ�ӳ� �ļ�·��
        String imagePath = f.getAbsolutePath() + "\\" + imageName; //ͼƬ������Ŀ��
		try {
            //ִ����Ļ��ͼ������file�ļ���Ĭ�ϱ��浽tempĿ¼��
            File imageFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //ͼƬ��浽ָ����·����   filePath
            FileUtils.copyFile(imageFile, new File(imagePath));
        }  catch (IOException e) {
            e.printStackTrace();
        }
		return imagePath;
    }
	
	
	public static Boolean checkScreenshot(String expectedPath , String actualPath){
		//�����������ļ�����һ����ʵ�ʲ��Թ����в�����ͼƬ��һ����֮ǰ�Ѿ���ȡ������ͼƬ��
    	File fileOutPut = new File(actualPath);  //ʵ�ʽ�ͼ
    	File fileInput = new File(expectedPath); //������ͼ
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
		Boolean a = Screenshot.checkScreenshot("F:\\�ȸ�.png", "F:\\���.png");
		System.out.println(a);
	}
	
}
