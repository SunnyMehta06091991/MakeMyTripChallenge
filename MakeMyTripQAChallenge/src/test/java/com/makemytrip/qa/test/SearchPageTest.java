package com.makemytrip.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makemytrip.qa.pages.HomePage;
import com.makemytrip.qa.pages.SearchPage;
import com.makemytrip.qa.util.TestUtils;
import com.makemytrip.qa.base.TestBase;

public class SearchPageTest extends TestBase{

    HomePage homePage;
    SearchPage searchPage;

    public SearchPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		homePage = new HomePage();
		Thread.sleep(1500);
	    homePage.clickRoundTripCheckbox();
	    homePage.fromSearchCityMethod(prop.getProperty("FromCityName"));
	    homePage.toSearchCityMethod(prop.getProperty("ToCityName"));
	    homePage.calenderMethod();
	    searchPage=homePage.clickonSearchButton();
        Thread.sleep(3000);

    }

	@Test(priority = 1)
	public void searchPageTitleTest(){
		String actualSearchPageTitle = searchPage.searchPageTitle();
		System.out.println("SearchPage Title is " + actualSearchPageTitle);
	    Assert.assertEquals(actualSearchPageTitle, prop.getProperty("SearchPageTitle"));
	}
	
	@Test(priority = 2)
	public void numberOfGetDepRetFlightsTest() throws InterruptedException{
		TestUtils.scrollelement();
		int noOfDepFlights = searchPage.numberOfGetDepartureFlights();
		System.out.println("*********************************" + "**********************************");
		System.out.println("Number of Deaprture Flights without any checkbox clicked are  " + noOfDepFlights );
		int noOfRetFlights = searchPage.numberOfGetReturnFlights();
		System.out.println("Number of Return Flights without any checkbox clicked are  " + noOfRetFlights );
		System.out.println("*********************************" + "**********************************");

	}

	
	@Test(priority = 3)
	public void numberOfGetDepRetFlightsNonStopsTest() throws InterruptedException{
	     searchPage.clickOnNonStopsCheckbox();
		 TestUtils.scrollelement();
		 int noOfDepNonStopsFlight = searchPage.numberOfGetDepartureFlights();
		 System.out.println("*********************************" + "**********************************");
         System.out.println("Number of Departure Flights with both Stops checkbox checked " + noOfDepNonStopsFlight);
	     int noOfRepNonStopsFlight = searchPage.numberOfGetReturnFlights();
	     System.out.println("Number of Return Flights with both Stops checkbox checked " + noOfRepNonStopsFlight);
	     System.out.println("*********************************" + "**********************************");

	}
	
	@Test(priority = 4)
	public void numberOfGetDepRetFlightsOneStopsTest() throws InterruptedException{
          searchPage.clickOnOneStopsCheckbox();
 	      TestUtils.scrollelement();
		 int noOfDepOneStopsFlight = searchPage.numberOfGetDepartureFlights();
		 System.out.println("*********************************" + "**********************************");
         System.out.println("Number of Departure Flights with both Stops checkbox checked " + noOfDepOneStopsFlight);
	     int noOfRepOneStopsFlight = searchPage.numberOfGetReturnFlights();
	     System.out.println("Number of Return Flights with both Stops checkbox checked " + noOfRepOneStopsFlight);
		 System.out.println("*********************************" + "**********************************");
 
	}
     
	@Test(priority = 5)
	public void getFlightRates() throws InterruptedException{
	String actualDepRates = searchPage.selectDepartureFlight(3);
	System.out.println("**************************** " + " " + "****************"  );
    System.out.println("Actual Departure Rates are " + actualDepRates);	
	System.out.println("**************************** " + " " + "****************"  );
    Thread.sleep(2000);
	String actualRetRates = searchPage.selectReturnFlight(3);
	System.out.println("**************************** " + " " + "****************"  );
    System.out.println("Actual Return Rates are " + actualRetRates);	
	System.out.println("**************************** " + " " + "****************"  );
	String depRatesFooter = searchPage.returnDepRateFromFotter();
	System.out.println("**************************** " + " " + "****************"  );
    System.out.println("Actual Return Rates from footers are " + depRatesFooter);	
	System.out.println("**************************** " + " " + "****************"  );
    String retRatesFooter = searchPage.returnRetRateFromFotter();
	System.out.println("**************************** " + " " + "****************"  );
    System.out.println("Actual Return Rates from footers are " + retRatesFooter);	
	System.out.println("**************************** " + " " + "****************"  );
    String totalAmount = searchPage.returnTotalAmount();
	System.out.println("**************************** " + " " + "****************"  );
    System.out.println("Actual Total Rates from footers are " + totalAmount);	
	System.out.println("**************************** " + " " + "****************"  );

	//Validate the Departure Rates of flight selected and present in fotter
	Assert.assertEquals(actualDepRates, depRatesFooter , "Departure Rates are not Equal");
	//Validate the Return Rates of flight selected and present in fotter
	Assert.assertEquals(actualRetRates, retRatesFooter , "Return Rates are not Equal");

	
	}
    
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
