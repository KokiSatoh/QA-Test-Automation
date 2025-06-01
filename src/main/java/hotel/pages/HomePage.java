package hotel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By reserveButton = By.id("reserve-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickReserveButton() {
        driver.findElement(reserveButton).click();
    }

    public boolean isAtHomePage() {
        return driver.findElement(reserveButton).isDisplayed();
    }
}
