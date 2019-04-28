package com.makemytrip.qa.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.makemytrip.qa.base.TestBase;

public class TestUtils extends TestBase{
	
	public static long pageLoadTimeout = 30 ;
	public static long implicitWautTimeout = 20 ; 
        public static int totalDaysToday = 0;
	public static int totalDaysTodayplus7 = 7;

	
	
	public static void flash(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor  = element.getCssValue("backgroundColor");
        for (int i = 0; i <  10; i++) {
            changeColor("rgb(0,200,0)", element,driver);//1
            changeColor(bgcolor, element,driver);//2
        }
    }
    public static void changeColor(String color, WebElement element, WebDriver driver) {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

        try {
            Thread.sleep(20);
        }  catch (InterruptedException e) {
        }
     }
     
	public static String calenderMethod(int numberOfDays){
		SimpleDateFormat sdf = new SimpleDateFormat("d");
        Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, numberOfDays );
		String newDate = sdf.format(cal.getTime());  
        int i = 0;
        while (newDate.charAt(i) == '0')
        i++;
        StringBuffer sb = new StringBuffer(newDate); 
        sb.replace(0, i, ""); 
        String finalDate =  sb.toString();
         return finalDate;
	
	}

	public static void scrollelement() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for (int second = 0;; second++) {
		    if(second >=40){
		        break;
		    }
		    jse.executeScript("window.scrollBy(0,2000)", ""); 
		    Thread.sleep(1500);
		}
	
	}
   
	public static void scrollelementtoview(WebElement ele) throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for (int second = 0;; second++) {
		    if(second >=20){
		        break;
		    }
		    jse.executeScript("window.scrollBy(0,100)", ""); 
		    Thread.sleep(1500);
		    TestUtils.scrolltoView(ele);
		    
		}
	
	}

	public static void moveToElement(WebElement target){
		Actions action = new Actions(driver);
		Action act = action.moveToElement(target).click().build();
	    act.perform();
	}
	public static void scrolltoView(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);" + "window.scrollBy(0,-130);", element);

	}
	
	
	public static void scrollUp(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-1000)");

	}
	
	

}
