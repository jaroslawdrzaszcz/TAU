import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

@RunWith(JUnit4.class)
public class TestSeleniumMantis {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mantis.testpro.pl/");
        driver.manage().window().fullscreen();
    }

    @Test
    public void getUrlTest() throws IOException {
        String currentUrl = driver.getCurrentUrl();

        if (driver instanceof TakesScreenshot) {
            File f = ((TakesScreenshot) driver).
                    getScreenshotAs(OutputType.FILE);
            FileHandler.copy(f,
                    new File("D:\\informa\\Semestr 7\\TestowanieAutomtyczne\\cw\\TAU\\TAU_lab5\\src\\" +
                            "screanshots\\mantisHomePage.png"));
        }
        Assert.assertEquals("http://mantis.testpro.pl/login_page.php", currentUrl);
    }

    @Test
    public void navigationTest() {
        driver.findElement(By.xpath("//*[@id=\"login-box\"]/div/div[2]/a")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("http://mantis.testpro.pl/signup_page.php", currentUrl);
    }

    @Test
    public void correctLoginTest() {
        driver.findElement(By.id("username")).sendKeys("testowe");
        driver.findElement(By.id("password")).sendKeys("seleniumtest");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[2]")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("http://mantis.testpro.pl/my_view_page.php", currentUrl);
    }

    @Test
    public void incorrectLoginTest() {
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[2]")).click();
        Assert.assertTrue(
                driver.findElement(By.cssSelector("#main-container > div > div > div > div > div.alert.alert-danger"))
                        .isDisplayed());
    }

    @Test
    public void checkBoxTest() {
        driver.manage().window().setSize(new Dimension(400, 600));
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/label/span")).click();
        Assert.assertTrue(driver.findElement(By.className("ace")).isEnabled());
    }

    @After
    public void cleanup() {
        driver.quit();
    }

}

