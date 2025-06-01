package hotel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlanPage {
    private WebDriver driver;
    private By themeParkPlanButton = By.xpath("//div[contains(text(),'テーマパーク')]/following-sibling::div//a[text()='このプランで予約']");

    public PlanPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectThemeParkPlan() {
        driver.findElement(themeParkPlanButton).click();
    }
}
