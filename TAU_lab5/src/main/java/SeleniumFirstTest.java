import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFirstTest {
    public static void main(String[] args)

    {

        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

//        driver.get("http://google.com");

        driver.get("http://demo.testarena.pl/zaloguj");

        driver.findElement(By.id("email")).sendKeys("administrator@testarena.pl");

        driver.findElement(By.id("password")).sendKeys("sumXQQ72$L");

        driver.findElement(By.id("login")).click();

        driver.quit();

    }
}

