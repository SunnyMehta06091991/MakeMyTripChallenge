package com.makemytrip.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.qa.pages.SearchPage;
import com.makemytrip.qa.base.TestBase;
import com.makemytrip.qa.util.TestUtils;

public class HomePage extends TestBase{
	   public HomePage(){
		    PageFactory.initElements(driver, this);
		}
	
	    //WebElement to locate departure click
	    @FindBy(xpath = "//label[@for = 'departure']")
		WebElement departureClick;
		
	    //Webelement to locate roundTripCheckbox
		@FindBy(xpath = "//li[contains(text(), 'Round Trip')]//descendant::span[1]")
		WebElement roundTripCheckbox;
		
        //WebElement to click on FromCity
		@FindBy(xpath = "//div[contains(@class ,'fsw_inputBox searchCity inactiveWidget')]")
		WebElement fromCity;
		
		//WebElement to click on FromSearchBox
		@FindBy(xpath = "//input[@placeholder = 'From']")
		WebElement fromSearchBox;
		
		//WebElement to highlight From Value in From Searchbox
		@FindBy(xpath = "//span[contains(text(),'From')]")
		WebElement fromHighlight;
		
		//WebElment to highlight To Value in To SearchBox
		@FindBy(xpath = "//span[contains(text(),'To')]")
		WebElement toHighlight;
		
		//WebElement to click on toSearchbox
		@FindBy(xpath = "//input[@placeholder = 'To']")
		WebElement toSearchBox;

		//WebElement to click on FromFirstElement
		@FindBy(xpath = "//div[@class = 'react-autosuggest__section-container react-autosuggest__section-container--first']/child::ul")
		WebElement firstFromClick;
		
		@FindBy(xpath = "//div[@class = 'react-autosuggest__section-container react-autosuggest__section-container--first']/child::ul")
		WebElement firstToClick;
		
		//WebElement to highlight departure value
		@FindBy(xpath = "//span[contains(@class,'lbl_input latoBold appendBottom10')]")
		WebElement depHighlight;
		
		//WebElement to locate searchButton
		@FindBy(xpath = "//a[contains(@class , 'primaryBtn font24 latoBlack widgetSearchBtn')]")
		WebElement searchButton;

		public void clickRoundTripCheckbox() {
			roundTripCheckbox.click();
			driver.manage().deleteAllCookies();
	    }

		public String getHomePageTitle(){
			return driver.getTitle();
		}

		public void fromSearchCityMethod(String fromCityName) throws InterruptedException{
			fromCity.click();
			TestUtils.flash(fromHighlight,driver);
                        fromSearchBox.sendKeys(fromCityName);
                        Thread.sleep(1000);
                        firstFromClick.click();
			}
       
	   public void toSearchCityMethod(String toCityName)throws InterruptedException{
		   TestUtils.flash(toHighlight, driver);
		   toSearchBox.sendKeys(toCityName);
		   Thread.sleep(1000);
		   firstToClick.click();
	   }
	   
	   public void calenderMethod() throws InterruptedException{
		   Thread.sleep(1000);
		   TestUtils.flash(depHighlight, driver);
		   String todaysDate = TestUtils.calenderMethod(TestUtils.totalDaysToday);
		   System.out.println("Today's date is " + todaysDate);
		   //departureClick.click();
		     String before_xpath = "//*[@id='root']/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[";
		     String after_xpath  = "]/div[";
		     boolean flag =false;
		     final int totalWeekDays = 7;
		     for(int rowNum = 1 ; rowNum <= 5; rowNum++){
		    	 for (int colNum = 1 ; colNum <= totalWeekDays ; colNum++){
		    	String day = driver.findElement(By.xpath(before_xpath+rowNum+after_xpath+colNum+"]")).getText();
		    	   if(day.equals(todaysDate)){
		   			   driver.findElement(By.xpath(before_xpath+rowNum+after_xpath+colNum+"]")).click();
		    		       flag = true;
		    	           break;
		    	   }
		    	   }
		     }
		     boolean flag1 = false;
		     String todaysDateplus7 = TestUtils.calenderMethod(TestUtils.totalDaysTodayplus7);
		     System.out.println("Today's date plus 7 days is " + todaysDateplus7);
		     String before_xpath2 = "//*[@id='root']/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[";
		     String before_xpath1 = "//*[@id='root']/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[";
		     String after_xpath1  = "]/div[";
			    System.out.println("Clicking on return date");
			    if(Integer.parseInt(todaysDateplus7) > Integer.parseInt(todaysDate)){ 
			     int totalWeekDays1 = 7;
			     for(int rowNum1 = 1 ; rowNum1 <= 5; rowNum1++){
			    	 for (int colNum1 = 1 ; colNum1 <= totalWeekDays1 ; colNum1++){
			    	String day = driver.findElement(By.xpath(before_xpath1+rowNum1+after_xpath1+colNum1+"]")).getText();
			    	if(day.equals(todaysDateplus7)){
			    		   driver.findElement(By.xpath(before_xpath1+rowNum1+after_xpath1+colNum1+"]")).click();
			    	       flag1 = true;
			    	       break;
			    	       
			    	}
			    	 }
			     }
			    }else{
				    boolean flag2 =false;
				    int totalWeekDays1 = 7;
 			    	outerloop:
				    for(int rowNum1 = 1 ; rowNum1 <= 5; rowNum1++){
				    	 for (int colNum1 = 1 ; colNum1 <= totalWeekDays1 ; colNum1++){
				    	String day = driver.findElement(By.xpath(before_xpath2+rowNum1+after_xpath1+colNum1+"]")).getText();
				    	if(day.equals(todaysDateplus7)){
				    		   driver.findElement(By.xpath(before_xpath2+rowNum1+after_xpath1+colNum1+"]")).click();
				    		   flag2 = true;
				    	       break outerloop;
		
				    	}
				    	 }
				     }

			    }
			      }
	   
		public SearchPage clickonSearchButton(){
		       new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class , 'primaryBtn font24 latoBlack widgetSearchBtn')]")));
		       TestUtils.flash(searchButton, driver);
			   searchButton.click();
		       driver.manage().deleteAllCookies();
    		   return new SearchPage();
		}

		
}
