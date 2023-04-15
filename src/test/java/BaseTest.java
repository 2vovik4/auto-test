import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    private final String BASE_URL = "https://automationtesting.co.uk/index.html";
    protected WebDriver driver;

    protected ChromeOptions chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        return options;
    }

    @BeforeSuite
    static void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected void initDriver(){
        driver = new ChromeDriver(chromeOptions());
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
