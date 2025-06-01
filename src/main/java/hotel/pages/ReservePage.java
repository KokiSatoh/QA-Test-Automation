package hotel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservePage {
    private WebDriver driver;

    private By dateField = By.id("date");
    private By daysField = By.id("days");
    private By guestsField = By.id("guest");
    private By breakfastCheckbox = By.id("breakfast");
    private By contactRadioPhone = By.id("contact_phone");
    private By phoneField = By.id("tel");
    private By totalPrice = By.id("total");
    private By confirmButton = By.id("submit-button");

    public ReservePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterReservationDetails(String date, int days, int guests, String plan, String contact, String phone) {
        driver.findElement(dateField).clear();
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(daysField).clear();
        driver.findElement(daysField).sendKeys(String.valueOf(days));
        driver.findElement(guestsField).clear();
        driver.findElement(guestsField).sendKeys(String.valueOf(guests));
        if (plan.contains("朝食")) driver.findElement(breakfastCheckbox).click();
        if (contact.contains("電話")) driver.findElement(contactRadioPhone).click();
        driver.findElement(phoneField).sendKeys(phone);
    }

    public int getTotalAmount() {
        return Integer.parseInt(driver.findElement(totalPrice).getText().replaceAll("[^0-9]", ""));
    }

    public int calculateExpectedTotal() {
        return 7000 * 3 * 2 + 1000 * 3 * 2; // 仮定：1泊7000円 + 朝食1000円/人/泊
    }

    public void clickConfirmReservationButton() {
        driver.findElement(confirmButton).click();
    }
}
