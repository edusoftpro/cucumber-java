package pro.edusoft.cucumber.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pro.edusoft.cucumber.base.BaseUtil;
import io.cucumber.java.en.Then;

public class Steps extends BaseUtil {
	private BaseUtil baseUtil;

	public Steps(BaseUtil util) {
		this.baseUtil = util;
	}

	private WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\dev\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Given("I am in login page")
	@Given("I am in login page of Para Bank Application")
	public void i_am_in_login_page_of_para_bank_application() {
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}

	@When("I enter valid {string} and {string} with {string}")
	public void i_enter_valid_credentials(String username, String password, String userFullName) {
		baseUtil.userFullName = userFullName;

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("username")).submit();
	}

	@Then("I should be taken to Overview page")
	public void i_should_be_taken_to_overview_page() throws InterruptedException {
		Thread.sleep(1000);

		String actualFullUserName = driver.findElement(By.className("smallText")).getText().toString();
		System.out.println(baseUtil.userFullName.toString());
		assertTrue(actualFullUserName, actualFullUserName.contains(baseUtil.userFullName));

		driver.findElement(By.xpath("//*[@id=\"rightPanel\"]")).isDisplayed();
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();
	}

	@After
	public void terminate() {
		driver.quit();
	}

}
