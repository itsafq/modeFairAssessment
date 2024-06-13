package modeFairHomeAssessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Test;
import java.util.concurrent.TimeUnit;

public class currencyAutomation {
	WebDriver driver;
	
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium WebDriver\\chromedriver-win64\\");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.xe.com/");
	}
	
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testConvertUsdToEur() {
		
		setUp();
		
		//Step 1: Open convert currency module
		driver.findElement(By.linkText("https://www.xe.com/currencyconverter/")).click();
		
		//Step 2: Select USD as the source currency
		WebElement sourceCurrency = driver.findElement(By.cssSelector("label:contains('From') + input"));
		sourceCurrency.sendKeys("USD");
		
		//Step 3: Select EUR as the target currency
		WebElement targetCurrency =  driver.findElement(By.cssSelector("label:contains('To') + input"));
		targetCurrency.sendKeys("EUR");
		
		//Step 4: Enter amount
		driver.findElement(By.className("amount-input")).sendKeys("100");
		
		//Step 5: Click convert
		driver.findElement(By.className("sc-fe840e0c-0 vAkEN")).click();
		
		//Expected result: Correct EUR amount displayed based on the latest exchange rate
		WebElement result = driver.findElement(By.className("sc-b201c78d-1 hPoRYc"));
		String resultText = result.getText();
		Assert.assertTrue(resultText.contains("Euros"));
		
		tearDown();
		
	}
	
	//Similar methods for other test cases
	
	@Test
	public void testConvertEurToGbp() {
		
		setUp();
		
		//Step 1: Open convert currency module
		driver.findElement(By.id("https://www.xe.com/currencyconverter/")).click();
		
		//Step 2: Select USD as the source currency
		WebElement sourceCurrency = driver.findElement(By.cssSelector("label:contains('From') + input"));
		sourceCurrency.sendKeys("EUR");
		
		//Step 3: Select EUR as the target currency
		WebElement targetCurrency =  driver.findElement(By.cssSelector("label:contains('To') + input"));
		targetCurrency.sendKeys("USD");
		
		driver.findElement(By.className("amount-input")).sendKeys("50");
		
		driver.findElement(By.className("sc-fe840e0c-0 vAkEN")).click();
		
		//Expected result: Correct GBP amount displayed based on the latest exchange rate
		WebElement result = driver.findElement(By.className("sc-b201c78d-1 hPoRYc"));
		String resultText = result.getText();
		Assert.assertTrue(resultText.contains("US Dollars"));
		
		tearDown();
		
	}
	
	@Test
	public void testInvalidAmountInput() {
		
		setUp();
		
		//Step 1: Open convert currency module
		driver.findElement(By.id("https://www.xe.com/currencyconverter/")).click();
		
		//Step 2: Select USD as the source currency
		WebElement sourceCurrency = driver.findElement(By.cssSelector("label:contains('From') + input"));
		sourceCurrency.sendKeys("USD");
		
		//Step 3: Select EUR as the target currency
		WebElement targetCurrency =  driver.findElement(By.cssSelector("label:contains('To') + input"));
		targetCurrency.sendKeys("EUR");
		
		driver.findElement(By.className("amount-input")).sendKeys("ADD");
		
		driver.findElement(By.className("sc-fe840e0c-0 vAkEN")).click();
		
		//Expected result: Error message displayed: "Invalid amount. Please enter a numeric value."
		WebElement error = driver.findElement(By.className("sc-4f0f6f94-1 xeMov"));
		String errorMessage = error.getText();
		Assert.assertEquals("Please enter a valid amount.", errorMessage);
		
		tearDown();
		
	}
	
	@Test
	public void testUnsupportedCurrency() {
	
		setUp();
		
		//Step 1: Open convert currency module
		driver.findElement(By.id("https://www.xe.com/currencyconverter/")).click();
		
		//Step 2: Select USD as the source currency
		WebElement sourceCurrency = driver.findElement(By.cssSelector("label:contains('From') + input"));
		sourceCurrency.sendKeys("BTC");
		
		//Step 3: Select EUR as the target currency
		WebElement targetCurrency =  driver.findElement(By.cssSelector("label:contains('To') + input"));
		targetCurrency.sendKeys("USD");
		
		driver.findElement(By.className("amount-input")).sendKeys("100");
		
		driver.findElement(By.className("sc-fe840e0c-0 vAkEN")).click();
		
		// Expected Result: Error message displayed: "Currency not supported."
		WebElement error = driver.findElement(By.className("sc-4f0f6f94-1 xeMov"));
        String errorMessage = error.getText();
        Assert.assertEquals("Currency not supported.", errorMessage);
		
	}
	
	@Test
	public void testHighPrecisionConversion() {
		
		setUp();
		
		//Step 1: Open convert currency module
		driver.findElement(By.id("https://www.xe.com/currencyconverter/")).click();
		
		//Step 2: Select USD as the source currency
		WebElement sourceCurrency = driver.findElement(By.cssSelector("label:contains('From') + input"));
		sourceCurrency.sendKeys("USD");
		
		//Step 3: Select EUR as the target currency
		WebElement targetCurrency =  driver.findElement(By.cssSelector("label:contains('To') + input"));
		targetCurrency.sendKeys("EUR");
		
		driver.findElement(By.className("amount-input")).sendKeys("1000.123456");
		
		driver.findElement(By.className("sc-fe840e0c-0 vAkEN")).click();
		
		// Expected Result: Correct JPY amount displayed with precision up to 6 decimal places
        WebElement result = driver.findElement(By.className("sc-b201c78d-1 hPoRYc"));
        String resultText = result.getText();
        Assert.assertTrue(resultText.contains("Japanese Yen"));
        
        tearDown();
		
	}
	
}
