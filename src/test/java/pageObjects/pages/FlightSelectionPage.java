package pageObjects.pages;

import model.FlghtData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FlightSelectionPage {
    private BaseFunc baseFunc;

    private final By RESULTS_LOADER = By.id("fl-results-loader-full");
    private final By BASIC_ECONOMY_SORTER = By.xpath(".//a[@id='column-ECO-BASIC']");
    private final By SHOW_ALL_FLIGHTS_BUTTON = By.id("a-results-show-all");
    private final By FLIGHT_BLOCK = By.xpath(".//li[contains(@class,'flight-block')]");
    private final By DEPARTURE_TIME = By.xpath(".//div[contains(@class,'flight-time flight-time-depart')]");
    private final By ARRIVAL_TIME = By.xpath(".//div[contains(@class,'flight-time flight-time-arrive')]");
    private final By STOPS = By.xpath(".//div[contains(@class,'flight-connection-container')]/div");
    private final By DURATION = By.xpath(".//div[contains(@class,'flight-summary-bottom')]");
    private final By PRICE_MOST_RESTRICTED = By.xpath(".//div[contains(@id,'ECO-BASIC')]/div/div[contains(@class,'price-point-revised')]");

    public FlightSelectionPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void sortByBasicEconomy() {
        baseFunc.waitInvisibility(RESULTS_LOADER);
        baseFunc.wait(BASIC_ECONOMY_SORTER);
        for (int i = 0; i<=3; i++) {
            try {
                baseFunc.findElement(BASIC_ECONOMY_SORTER).click();
                break;
            }
            catch (Exception e) {
            }
        }

        baseFunc.findElement(SHOW_ALL_FLIGHTS_BUTTON).click();
    }


    public FlghtData getFlightData() {
        FlghtData flightData = new FlghtData();
        baseFunc.waitStale(FLIGHT_BLOCK);
        List<WebElement> flightBlocks = baseFunc.findElements(FLIGHT_BLOCK);
        for (int i = 0; i < flightBlocks.size(); i++) {
            try {
                flightBlocks.get(i);
                break;
            }
            catch (Exception e) {
            }
            WebElement flightBlock = flightBlocks.get(i);
            WebElement priceMostRestricted = flightBlock.findElement(PRICE_MOST_RESTRICTED);
            if (!priceMostRestricted.getText().contains("Not available")) {
                flightData.setDeppartureTime(flightBlock.findElement(DEPARTURE_TIME).getText());
                System.out.println(flightData.getDeppartureTime());
                flightData.setArrivalTime(flightBlock.findElement(ARRIVAL_TIME).getText());
                System.out.println(flightData.getArrivalTime());
                flightData.setStops(flightBlock.findElement(STOPS).getText());
                System.out.println(flightData.getStops());
                flightData.setDuration(flightBlock.findElement(DURATION).getText());
                System.out.println(flightData.getDuration());
                flightData.setPrice(flightBlock.findElement(PRICE_MOST_RESTRICTED).getText());
                System.out.println(flightData.getPrice());
            }
        }
        return flightData;
    }


}
