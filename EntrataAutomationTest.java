package seleniumtesting.automation.entrata;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

/**
 * This class is for Providing a basic automation of entrata website using
 * Selenium.
 * 
 * @author SHAIFALI VERMA
 *
 */
public class EntrataAutomationTest {
	

	private WebDriver driver;

	@Before
	public void setUp() {
		
		//setting up the WebDriver property as a key & value pair
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\browserWebdriver\\chromedriver-win64\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait
		driver.manage().window().maximize();
		driver.get("https://www.entrata.com");
	}

	/**
	 * To test the Title of the Home page once the link is opened.
	 * 
	 */
	@Test
	public void testHomePageTitle() {
		assertEquals("Property Management Software | Entrata", driver.getTitle());
	}

	/**
	 * test to click the button for Watch demo and verify the new page
	 * 
	 */
	@Test
	public void testClickToWatchDemo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
		
		//find the element and click on it
		WebElement clickToWatchDemoButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Watch Demo")));
		clickToWatchDemoButton.click();
		assertEquals("Property Management Software | Entrata", driver.getTitle());
	}
	/**
	 * Test the basic functionality of accepting the cookies once you enter the
	 * website.
	 * 
	 */
	@Test
	public void testToacceptCookies() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
		// Check if the cookies popup is present
		if (isCookiesPopupPresent(wait)) {
			// Accept cookies
			acceptCookies(wait);
		}
		assertEquals("Property Management Software | Entrata", driver.getTitle());
	}

	/**
	 * Test for opening the sign-in page from the Entrata Website and Click on the
	 * Property Manager Login.
	 * 
	 */
	@Test
	public void testToOpenUpSignInPage() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
		WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In")));
		signInButton.click();
		
		//Sign-In page gets open
		assertEquals("Entrata Sign In", driver.getTitle());
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
		
		//check for the cookies present
				if (isCookiesPopupPresent(wait)) {
					// Accept cookies
					acceptCookies(wait);
				}
		
		//click on the Project Manger Login button
		WebElement propertyManagerButton = wait1
				.until(ExpectedConditions.elementToBeClickable(By.linkText("Property Manager Login")));
		propertyManagerButton.click();
		assertNotEquals("Property Management Software | Entrata", driver.getTitle());
		

	}

	/**
	 * test to click the Schedule Demo button and Schedule the demo in the new page
	 * adding all the necessary data asked for.
	 * 
	 */
	@Test
	public void testScheduleADemo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
		
		//Check for the Cookies pop-up
		if (isCookiesPopupPresent(wait)) {
			// Accept cookies
			acceptCookies(wait);
		}
        //Using Actions class for moving to the Element and interacting with it.
		WebElement scheduleDemoLink = driver.findElement(By.partialLinkText("Schedule Demo"));
		Actions actions = new Actions(driver);
		actions.moveToElement(scheduleDemoLink).click().perform();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait

		// enter the first name
		WebElement firstName = wait1.until(ExpectedConditions.elementToBeClickable(By.id("FirstName")));
		assertTrue("text field is not null", firstName.getText().isEmpty());
		firstName.sendKeys("Shefali");

		// enter the last name
		WebElement lastName = driver.findElement(By.id("LastName"));
		assertTrue("text field is not null", lastName.getText().isEmpty());
		lastName.sendKeys("Verma");

		// enter the email
		WebElement email = driver.findElement(By.id("Email"));
		assertTrue("text field is not null", email.getText().isEmpty());
		email.sendKeys("abc@123.com");

		// enter the company name
		WebElement companyName = driver.findElement(By.id("Company"));
		assertTrue("text field is not null", companyName.getText().isEmpty());
		companyName.sendKeys("Capgemini");

		// enter the phone number
		WebElement phoneNumber = driver.findElement(By.id("Phone"));
		assertTrue("text field is not null", phoneNumber.getText().isEmpty());
		phoneNumber.sendKeys("8839301339");

		// Select the Unit count from dropdown
		WebElement dropdown = driver.findElement(By.id("Unit_Count__c"));
		dropdown.sendKeys("1-10");

		// enter the Job title
		WebElement jobTitle = driver.findElement(By.id("Title"));
		assertTrue("text field is not null", jobTitle.getText().isEmpty());
		dropdown.sendKeys("Tester");

		// Explicitly wait for 20 seconds
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Click the Schedule Demo button
		WebElement scheduleDemoButton = wait2
				.until(ExpectedConditions.elementToBeClickable(By.className("mktoButton")));
		assertFalse("Button was not clicked", scheduleDemoButton.isSelected());
		scheduleDemoButton.click();

	}


	/**
	 * Boolean Condition to Check whether the Cookies popup is Present.
	 * 
	 * @param wait
	 * @return
	 */
	private boolean isCookiesPopupPresent(WebDriverWait wait) {
		try {
			// Check if the cookies popup is present (adjust the locator accordingly)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cookie-button-holder")));
			return true;
		} catch (Exception e) {
			// Cookies pop-up not found
			return false;
		}
	}

	/**
	 * Accept the Cookies from the Cookies pop-up.
	 * 
	 * @param wait
	 */
	private void acceptCookies(WebDriverWait wait) {
		// Click the button or link to accept cookies (adjust the locator accordingly)
		WebElement acceptCookiesButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.id("rcc-confirm-button")));
		acceptCookiesButton.click();
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
