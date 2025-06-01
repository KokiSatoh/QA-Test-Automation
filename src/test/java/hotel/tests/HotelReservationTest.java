package hotel.tests;

import hotel.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelReservationTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private PlanPage planPage;
    private ReservePage reservePage;
    private ConfirmPage confirmPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://hotel-example-site.takeyaqa.dev/ja/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        planPage = new PlanPage(driver);
        reservePage = new ReservePage(driver);
        confirmPage = new ConfirmPage(driver);
    }

    @Test
    public void testPremiumMemberHotelReservation() {
        loginPage.loginAsPremiumMember("premium_user", "password");
        homePage.clickReserveButton();
        planPage.selectThemeParkPlan();
        reservePage.enterReservationDetails("2024/07/15", 3, 2, "朝食バイキング", "電話でのご連絡", "00011112222");
        int expectedTotal = reservePage.calculateExpectedTotal();
        int actualTotal = reservePage.getTotalAmount();
        assertEquals(expectedTotal, actualTotal);
        reservePage.clickConfirmReservationButton();
        assertEquals("2024/07/15", confirmPage.getCheckInDate());
        assertEquals("3", confirmPage.getStayDays());
        assertEquals("2", confirmPage.getGuestCount());
        assertEquals("朝食バイキング", confirmPage.getPlanName());
        assertEquals("電話でのご連絡", confirmPage.getContactMethod());
        assertEquals("00011112222", confirmPage.getPhoneNumber());
        confirmPage.clickFinalizeReservationButton();
        Assertions.assertTrue(confirmPage.isReservationCompleteMessageDisplayed());
        confirmPage.clickCloseButton();
        Assertions.assertTrue(homePage.isAtHomePage());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
