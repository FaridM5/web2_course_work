package az.edu.ada.librarySystem.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddBookTest {

    @Autowired
//    private WebDriver driver;
//    private static WebDriverWait wait;
    private static WebDriver driver;
    private static WebDriverWait wait;

//    @BeforeAll
//    static void setUp() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//
//        driver = new ChromeDriver(options);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }


    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    @Order(1)
    @DisplayName("Add a new book")
    void testAddBook() throws InterruptedException {
        driver.get("http://localhost:8080/add");
        Thread.sleep(2000); // Consider using WebDriverWait here instead of Thread.sleep

        wait.until(ExpectedConditions.elementToBeClickable(By.id("name"))).sendKeys("for_testing_purposes");
        driver.findElement(By.id("author")).sendKeys("POM");
        driver.findElement(By.id("L")).click(); // Assuming the location radio button has an ID "L"

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(5000); // Wait for redirect or confirmation
    }

    @Test
    @Order(2)
    @DisplayName("Verify the added book is listed")
    void testVerifyBookAdded() throws InterruptedException {
        driver.get("http://localhost:8080/books");
        Thread.sleep(5000); // Wait for page load

        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("for_testing_purposes"), "The book should be listed on the books page.");
    }

    @Test
    @Order(3)
    @DisplayName("Delete the added book")
    void testDeleteBook() throws InterruptedException {
        driver.get("http://localhost:8080/books");
        Thread.sleep(5000); // Wait for the page and JavaScript to fully load

        // Find the <tr> element that contains the book's name
        WebElement bookRow = driver.findElement(By.xpath("//tr[td[text()='for_testing_purposes']]"));

        // Within that row, find the delete icon and click it
        WebElement deleteIcon = bookRow.findElement(By.xpath(".//a[@id='deleteicon']"));
        deleteIcon.click();

        Thread.sleep(5000); // Wait for the action to complete and to be redirected or for the page to refresh

        // Optional: Verify the deletion
        driver.navigate().refresh();
        Thread.sleep(2000); // Wait for refresh
        String pageSourceAfterDeletion = driver.getPageSource();
        assertFalse(pageSourceAfterDeletion.contains("for_testing_purposes"), "The book should no longer be listed.");
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
