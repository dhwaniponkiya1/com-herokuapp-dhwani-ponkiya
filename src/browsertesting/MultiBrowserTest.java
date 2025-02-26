package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * BaseUrl = http://the-internet.herokuapp.com/login
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Refresh the page.
 * 11. Close the browser.
 */

public class MultiBrowserTest {

    static String browser = "firefox";
    static String baseUrl = "https://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) {
        // Launch the browser
        if (browser.equalsIgnoreCase("Chrome"))
            driver = new ChromeDriver();
        else if (browser.equalsIgnoreCase("Edge"))
            driver = new EdgeDriver();
        else if (browser.equalsIgnoreCase("Firefox"))
            driver = new FirefoxDriver();
        else
            System.out.println("Browser name not valid");

        driver.get(baseUrl);

        //Maximise the browser window
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //To get the title of the page
        System.out.println("Title of page " + driver.getTitle());
        //Get current URL
        System.out.println("Current URL" + driver.getCurrentUrl());
        //Print the page source
        System.out.println("Page source" + driver.getPageSource());

        //Enter credentials
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //click login
        driver.findElement(By.className("radius")).click();

        //get current URL
        System.out.println("Current URL" + driver.getCurrentUrl());
        //Refresh the page
        driver.navigate().refresh();
        //close browser
        driver.quit();
    }
}
