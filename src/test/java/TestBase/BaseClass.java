package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

// contains reusable methods...
public class BaseClass {

	public static WebDriver driver;
	public Logger logger;  // log4j set up
	public Properties p;  // to read config.preporties file data.

	@BeforeClass (groups = {"sanity", "master", "regression",})
	
	public void SetUp() throws InterruptedException, IOException {

		// loading config properties...
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		//  log 4j2 implementation.. 
		logger = LogManager.getLogger(this.getClass());  // log4j2 code... one line only.
		/*
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))  {

			DesiredCapabilities capabilities = new DesiredCapabilities();

			// os set up in remote...

			if(os.equalsIgnoreCase("windows")) {

				capabilities.setPlatform(Platform.WIN11);
			}

			else {

				System.out.println("No matching OS...");
			}


			// browser...

			switch(br.toLowerCase()) {

			case "chrome" :	capabilities.setBrowserName("chrome"); break ;

			default : System.out.println("No matching browser found.."); return;
	}
                 driver = new RemoteWebDriver(new URL ("http://localhost:4444/wd/hub"), capabilities);

		}

		if(p.getProperty("execution_env").equalsIgnoreCase("local")) { 
		 */

		//	  if(os.equalsIgnoreCase("windows")) {



		/*
		switch(br.toLowerCase())  {

		case "chrome" : 	driver = new ChromeDriver();
		case "edge"   :      driver = new EdgeDriver();
		case "firefox" :     driver = new FirefoxDriver();
		default : System.out.println("invalid browser.."); 

		}
		 */
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//	driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("appURL"));   //  loading the URL from the config file....
		Thread.sleep(8000);
	}





	@AfterClass  (groups = {"sanity", "master", "regression"})

	public void TearDown() {
		driver.close();
	}


	@SuppressWarnings("deprecation")
	public String Randomstring() {

		String generatedstring = RandomStringUtils.randomAlphabetic(6);
		return generatedstring;

	}

	public String randomnumber() {

		String generatednumber = RandomStringUtils.randomNumeric(9);
		return generatednumber;

	}

	public String randomPassword() {
		String generatedstring = RandomStringUtils.randomAlphabetic(6);
		String generatednumber = RandomStringUtils.randomNumeric(9);

		String genpwd = (generatedstring+"@"+generatednumber);
		return genpwd;

	}

	public String captureScreen(String tname) {

		String timestamp = new SimpleDateFormat("YYDDMMhhmmss").format(new Date());

		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File sourcefile = takescreenshot.getScreenshotAs(OutputType.FILE);

		String targetfilePath = System.getProperty("user.dir" + "\\Screenshots\\" + tname + "_" + timestamp);
		File targetfile = new File (targetfilePath);

		sourcefile.renameTo(targetfile);

		return targetfilePath;

	}


}
