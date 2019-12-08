import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSeleniumAutomationpractice {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
    }

    @Test
    public void navigationTest() {
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("http://automationpractice.com/index.php?id_category=8&controller=category",
                currentUrl);
    }

    @Test
    public void correctLoginTest() {
        driver.manage().window().setSize(new Dimension(600, 800));
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("testowy@pjwstk.edu.pl");
        driver.findElement(By.xpath("//form[@id='login_form']/div")).click();
        driver.findElement(By.name("passwd")).sendKeys("testowy123");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", currentUrl);
    }

    @Test
    public void incorrectLoginTest() {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("test@wp.pl");
        driver.findElement(By.xpath("//form[@id='login_form']/div")).click();
        driver.findElement(By.name("passwd")).sendKeys("test");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void incorrectRegistrationTest() {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.name("email_create")).click();
        driver.findElement(By.name("email_create")).sendKeys("test1234@wp.pl");
        driver.findElement(By.xpath("//button[@id='SubmitCreate']/span")).click();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submitAccount']/span"))).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[1]")).isDisplayed());
    }

    @After
    public void cleanup() {
        driver.quit();
    }

}