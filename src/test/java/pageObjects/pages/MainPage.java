package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {
    private BaseFunc baseFunc;

    private final By ONE_WAY_RADIO = By.xpath(".//span[contains(text(),'One-way')]");
    private final By ORIGIN_FIELD = By.id("bookFlightOriginInput");
    private final By ORIGIN_INPUT_MENU_0 = By.id("bookFlightOriginInput-menu-item-0");
    private final By DESTINATION_FIELD = By.id("bookFlightDestinationInput");
    private final By DESTINATION_INPUT_MENU_0 = By.id("bookFlightDestinationInput-menu-item-0");
    private final By DEPARTURE_DATE = By.id("DepartDate");
    private final By CLASS_DROPDOWN = By.id("cabinType");
    private final By ECONOMY_CLASS = By.id("cabinType_item-0");
    private final By FIND_FLIGHTS_BUTTON = By.xpath(".//span[contains(text(),'Find flights')]");

    public MainPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void chooseOneWay() {
        baseFunc.findElement(ONE_WAY_RADIO).click();
    }

    public void setDestinations() {
        baseFunc.wait(ORIGIN_FIELD);
        WebElement originField = baseFunc.findElement(ORIGIN_FIELD);
        originField.clear();
        originField.sendKeys("JFK");
        baseFunc.wait(ORIGIN_INPUT_MENU_0);
        baseFunc.findElement(ORIGIN_INPUT_MENU_0).click();
        baseFunc.wait(DESTINATION_FIELD);
        WebElement destinationField = baseFunc.findElement(DESTINATION_FIELD);
        destinationField.clear();
        destinationField.sendKeys("Miami");
        baseFunc.hoverOnElement(destinationField);
        baseFunc.wait(DESTINATION_INPUT_MENU_0);
        baseFunc.findElement(DESTINATION_INPUT_MENU_0).click();
    }

    public void setDepartureDate() {
        baseFunc.wait(DEPARTURE_DATE);
        WebElement departureDate = baseFunc.findElement(DEPARTURE_DATE);
        departureDate.click();
        departureDate.clear();
        departureDate.sendKeys("Aug 20");
    }

    public void chooseEconomy() {
        baseFunc.wait(CLASS_DROPDOWN);
        baseFunc.findElement(CLASS_DROPDOWN).click();
        WebElement classDropdown = baseFunc.findElement(CLASS_DROPDOWN);
        baseFunc.hoverOnElement(classDropdown);
        baseFunc.findElement(ECONOMY_CLASS).click();
    }

    public void clickFindFlights() {
        baseFunc.wait(FIND_FLIGHTS_BUTTON);
        baseFunc.findElement(FIND_FLIGHTS_BUTTON).click();
    }
}
