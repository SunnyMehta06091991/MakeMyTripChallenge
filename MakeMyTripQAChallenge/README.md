This Framework is designed to test Make My trip site 
This is an Readme file for project which describes the classes and methods in src\main\java for pages.

Pages Present are:
1.)HomePage
2.)SearchPage


1.) HOmePage Methods:

a.) clickRoundTripCheckbox       ---> Used to Click Round Trip Checkbox on HomePage.
b.) getHomePageTitle             ---> Used to get HomePage Title for verification
c.) fromSearchCityMethod         ---> Used to Enter the From City Name in From SearchBox.
d.) toSearchCityMethod           ---> Used to Enter the To City Name in To SearchBox.
e.) calenderMethod               ---> Used to Select the Departure and Return Date at Time interval of 7 Days.
f.) clickonSearchButton          ---> Used to Click on SearchButton.

---------------------------------------------------------------------------------------
2.) SearchPage Methods:

a.) searchPageTitle              ----> Used to get SearchPage Title for verification
b.) numberOfGetDepartureFlights  ----> Used to get the departure Flight numbers on Searchpage.
c.) numberOfGetReturnFlights     ----> Used to get the return Flight Numbers on SearchPage.
d.) clickOnNonStopsCheckbox      ----> Used to Click on non-Stop checkbox on Search Page.
e.) clickOnOneStopsCheckbox      ----> Used to Click on one-Stop checkbox on Search Page
f.) selectDepartureFlight        ----> Used to select the departure Checkbox based on interger passed 
g.) selectReturnFlight           ----> Used to select the return Checkbox based on interger passed 
h.) returnDepRateFromFotter      ----> Used to return a String of Deparature Rates of selected flight in Footer
i.) returnRetRateFromFotter      ----> Used to return a String of Return Rates of selected flight in Footer
j.) returnTotalAmount            ----> used to return a String of Total Amount of both Departure And Return Rates present in Footer.

---------------------------------------------------------------------------------------------

Other than this framework consists of Util class which contains basic utilities methos:

Utils Class Method:
a.) flash                        -----> Utility to highlight an element before clicking/performing action.
b.) changeColor                  -----> Utility to change backgroundcolor of element
c.) calenderMethod               -----> Utiltiy to return Calender Dates basen on input provided in number of Days.
d.) scrollelement                -----> Utiltiy to scroll to bottom of page which is dynamically loading.
e.) scrollelementtoview          -----> Utiltiy to scroll to particular element of page which is dynamically loading.
f.) moveToElement                -----> Utiltiy to perform click on particular element using action class.
g.) scrollUp                     -----> Utility to scroll up the webPage.

--------------------------------------------------------------------------------------------


From TEsting point of view there are 2 classes with test cases :

1.) HomePageTest
2.) SearchPageTest

A.) HomePageTest Test Cases.
1.) homePageTitleTest            -----> To validate the HomePage Title.
2.) selectToFromStations         -----> To navigate to SearchPage.

-------------------------------------------------------------------------------------------
B.)SearchPageTest Test Cases
1.) searchPageTitleTest                 ------> To validate the SearchPAge Title.
2.) numberOfGetDepRetFlightsTest        ------> Display the number of Departure and Return Flights on SearchPAge
3.)numberOfGetDepRetFlightsNonStopsTest ------> Display the number of Departure and Return Flights on SearchPAge with non Stop checkbox checked.
4.) numberOfGetDepRetFlightsOneStopsTest ------> Display the number of Departure and Return Flights on SearchPAge with one Stop checkbox checked.
5.) getFlightRates                      -------> Assert the Selected Departure and return Rates of flight with price displayed in footer alogwith the Total Amount 

-------------------------------------------------------------------------------------------

