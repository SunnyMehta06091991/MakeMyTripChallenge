package com.makemytrip.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.qa.base.TestBase;
import com.makemytrip.qa.util.TestUtils;

public class SearchPage extends TestBase{
      
	public SearchPage(){
		PageFactory.initElements(driver, this);
	}

	    //WebElement to locate nonStopCheckbox;
		@FindBy(xpath = "//span[contains(text() , 'Non Stop')]/preceding::span[1]")
		WebElement nonStopCheckbox;
		
		//WebElement to locate 1 Stop checkbox
		@FindBy(xpath = "//span[contains(text() , '1 Stop')]/preceding::span[1]")
		WebElement oneStopCheckbox;
			
	    //WebElement to locate the DepRate after selecting flight
		@FindBy(xpath = "//*[@id='left-side--wrapper']/div[2]/div/div[3]/div/div[1]/div[1]/div[1]/div/div[2]/div[4]/p/span")
		WebElement depRateFlightCheck;
	
	    //WebElement to locate the RetRate after selecting flight
        @FindBy(xpath = "//*[@id='left-side--wrapper']/div[2]/div/div[3]/div/div[1]/div[1]/div[2]/div/div[2]/div[4]/p/span")
        WebElement retRateFlightCheck;
	
	    //WebELement to locate TotalRAte after selecting flight in  footer
        @FindBy(xpath = "//*[@id='left-side--wrapper']/div[2]/div/div[3]/div/div[1]/div[1]/div[3]/div[1]/p/span/span")
        WebElement totalRate;
	
	public String searchPageTitle(){
		return driver.getTitle();
	}

	public int numberOfGetDepartureFlights(){
		  List<WebElement> ele = driver.findElements(By.xpath("//div[contains(@class , 'splitVw-sctn pull-left')]/div[2]/child::div"));
		  int noOfDepartureFlight = ele.size();
		  return noOfDepartureFlight;
		}
		
		public int numberOfGetReturnFlights(){
			  List<WebElement> ele1 = driver.findElements(By.xpath("//div[contains(@class , 'splitVw-sctn pull-right')]/div[2]/child::div"));
	          int noOfReturnFlight = ele1.size();
	          return noOfReturnFlight;
		}
        
		public void clickOnNonStopsCheckbox() throws InterruptedException{
			nonStopCheckbox.click();
			Thread.sleep(1500);
		}
	
		public void clickOnOneStopsCheckbox() throws InterruptedException{
			oneStopCheckbox.click();
			Thread.sleep(1500);
	      }

		
		public String selectDepartureFlight(int i) throws InterruptedException{
			driver.manage().deleteAllCookies();
			String before_xpath = "//*[@id='ow_domrt-jrny']/div[2]/div[";
			String after_xpath = "]/label/div[1]/span[1]/span";
			String before_xpathr = "//*[@id='ow_domrt-jrny']/div[2]/div[";
			String bef_xpath = "//*[@id='ow_domrt-jrny']/div[2]/div[";
		    String aft_xpath = "]/label/div[2]/div[3]/p/span";
			WebElement ele = driver.findElement(By.xpath(before_xpathr + i + "]"));
			TestUtils.scrollelementtoview(ele);
			Thread.sleep(2000);
			driver.manage().deleteAllCookies();
			//WebDriverWait wait = new WebDriverWait(driver,30);
			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(before_xpath+ i + after_xpath))));
			WebElement etc = driver.findElement(By.xpath(before_xpath+ i + after_xpath));
			TestUtils.moveToElement(etc);
			String depRate = driver.findElement(By.xpath(bef_xpath + i + aft_xpath)).getText();
		    return depRate;
		}
	
		public String selectReturnFlight(int i) throws InterruptedException{
            TestUtils.scrollUp();
			String bef_xpath = "//*[@id='rt-domrt-jrny']/div[2]/div[";
            String b_xpath = "//*[@id='rt-domrt-jrny']/div[2]/div[";
            String a_xpath = "]/label/div[1]/span[1]/span";
 			String rate_xpath = "]/label/div[2]/div[3]/p/span";
            WebElement ele = driver.findElement(By.xpath(bef_xpath + i + "]"));
			TestUtils.scrollelementtoview(ele);
			Thread.sleep(2000);
			WebElement e = driver.findElement(By.xpath(b_xpath + i + a_xpath));
			TestUtils.moveToElement(e);
            String retRate = driver.findElement(By.xpath(b_xpath + i + rate_xpath)).getText();
            return retRate;
			
		}
		
		public String returnDepRateFromFotter(){
			String depFooterRate = depRateFlightCheck.getText();
			return depFooterRate;
		}
		
		public String returnRetRateFromFotter(){
			String retFooterRate = retRateFlightCheck.getText();
			return retFooterRate;
		}
		
		public String returnTotalAmount(){
			String totalAmount = totalRate.getText();
			return totalAmount;
		}
}
