package hotel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmPage {
    private WebDriver driver;

    private By dateText = By.id("date");
    private By daysText = By.id("days");
    private By guestsText = By.id("guest");
    private By planText = By.id("plan");
    private By contactText = By.id("contact");
    private By phoneText = By.id("tel");
    private By submitButton = By.id("submit-button");
    private By completeMessage = By.id("complete");
    private By closeButton = By.id("close-button");

    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCheckInDate() {
        return driver.findElement(dateText).getText();
    }

    public String getStayDays() {
        return driver.findElement(daysText).getText();
    }

    public String getGuestCount() {
        return driver.findElement(guestsText).getText();
    }

    public String getPlanName() {
        return driver.findElement(planText).getText();
    }

    public String getContactMethod() {
        return driver.findElement(contactText).getText();
    }

    public String getPhoneNumber() {
        return driver.findElement(phoneText).getText();
    }

    public void clickFinalizeReservationButton() {
        driver.findElement(submitButton).click();
    }

    public boolean isReservationCompleteMessageDisplayed() {
        return driver.findElement(completeMessage).isDisplayed();
    }

    public void clickCloseButton() {
        driver.findElement(closeButton).click();
    }
}
