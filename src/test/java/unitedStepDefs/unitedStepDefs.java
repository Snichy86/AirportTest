package unitedStepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.pages.BaseFunc;
import pageObjects.pages.FlightSelectionPage;
import pageObjects.pages.MainPage;

public class unitedStepDefs {

    private String URL = "https://www.united.com/en/us";

    private BaseFunc baseFunc = new BaseFunc();
    private MainPage mainPage = new MainPage(baseFunc);
    private FlightSelectionPage flightSelectionPage = new FlightSelectionPage(baseFunc);

    @Given("homepage")
    public void open_homepage() {
        baseFunc.openURL(URL);
    }


    @When("choose one-way flight")
    public void one_way_flight() {
        mainPage.chooseOneWay();
    }

    @When("set flights From New York JFK to Miami all airports")
    public void set_destinations() {
        mainPage.setDestinations();
    }

    @When("choose departure date August 20")
    public void departure_date() {
        mainPage.setDepartureDate();
    }

    @When("choose economy class")
    public void choose_class() {
        mainPage.chooseEconomy();
    }

    @When("click Find flights")
    public void click_find() {
        mainPage.clickFindFlights();
    }

    @When("sort flights by Economy class")
    public void sort_by_class() {
        flightSelectionPage.sortByBasicEconomy();
    }

    @Then("collect and print Depart, Arrive, Stops, Duration, Price data")
    public void collect_data() {
        flightSelectionPage.getFlightData();
    }

}
