package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.LoginPage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;

    public Properties p;

    protected static final Logger logger = LogManager.getLogger(BaseClass.class);

    @BeforeMethod
    void setUp() throws IOException {

        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }

    void userLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(p.getProperty("valid_userName"));
        loginPage.setPassword(p.getProperty("valid_password"));
        loginPage.clickLogin();
    }

    public String captureScreen(String tname)throws IOException {
        String timeStamp=new SimpleDateFormat("yyyyMMddhhss").format(new Date());
        TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
        File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
        File targetFile=new File(targetFilePath);
        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
}
