package tools;

import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Student_Registration_Form extends EnumHelper implements IStudentForm {

	public WebDriver driver;
	public WebDriver.Timeouts wiat;
	
	public void button() {
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).submit();
	}


	@BeforeTest
	public void before() {
		
		//Setting and opening browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
	}

	@Test(priority = 7, description = "First name, last name and email")
	public void seventhTest() {
		//Typing first name and making assertion
		driver.findElement(By.id("firstName")).sendKeys("Rancer");
		String expectedValue1 = "Rancer";
		String actualValue1 = driver.findElement(By.id("firstName")).getAttribute("value"); 
		Assert.assertEquals(actualValue1, expectedValue1);
		
		//Typing last name and making assertion
		driver.findElement(By.id("lastName")).sendKeys("Ventura");
		String expectedValue2 = "Ventura";
		String actualValue2 = driver.findElement(By.id("lastName")).getAttribute("value"); 
		Assert.assertEquals(actualValue2, expectedValue2);
		
		//Typing email name and making assertion
		driver.findElement(By.id("userEmail")).sendKeys("thabest@automation.com");
		String expectedValue3 = "thabest@automation.com";
		String actualValue3 = driver.findElement(By.id("userEmail")).getAttribute("value"); 
		Assert.assertEquals(actualValue3, expectedValue3);	

	}

	@Test(priority = 2, description = "Selecting all radio button")
	public void secondTest() {
		
		//selecting first radio button
		driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")).click();
		WebElement radio1 = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")); 
		Assert.assertFalse(radio1.isSelected());
		
		//selecting second radio button
		driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")).click();
		WebElement radio2 = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")); 
		Assert.assertFalse(radio2.isSelected());
		
		//selecting third radio button
		driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]/label")).click();
		WebElement radio3 = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]/label")); 
		Assert.assertFalse(radio3.isSelected());
	}

	@Test(priority = 3, description = "Mobile and Date of Birth")
	public void thirdTest() {
		
		//Typing the Mobile number
		driver.findElement(By.id("userNumber")).sendKeys("8293393549");
		String expectedValue1 = "8293393549";
		String actualValue1 = driver.findElement(By.id("userNumber")).getAttribute("value"); 
		Assert.assertEquals(expectedValue1, actualValue1);
		
		//this is used to click on the date of birth, and choose month, year and day.
		WebElement el = driver.findElement(By.id("dateOfBirthInput"));
		el.click(); 
		WebElement ddrown1 = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
		Select select1 = new Select(ddrown1);
		select1.selectByValue("0");
		WebElement ddrown2 = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));
		Select select2 = new Select(ddrown2);
		select2.selectByValue("1991");
		driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[7]")).click();
		String expectedValue2 = "19 Jan 1991";
		String actualValue2 = driver.findElement(By.id("dateOfBirthInput")).getAttribute("value"); 
		Assert.assertEquals(actualValue2, expectedValue2);
	}

	@Test(priority = 4, description = "Subjects")
	public void fourthTest() {
		
		//this is use to select different subjets
		WebElement e = driver.findElement(By.xpath("//*[@id=\"subjectsInput\"]"));
		e.sendKeys("English");
		e.sendKeys(Keys.ENTER);
		e.sendKeys("Maths");
		e.sendKeys(Keys.ENTER);
		e.sendKeys("Chemistry");
		e.sendKeys(Keys.ENTER);
		e.sendKeys("Computer Science");
		e.sendKeys(Keys.ENTER);
		e.sendKeys("Physics");
		e.sendKeys(Keys.ENTER);
		String expectedValue1 = "Physics";
		String actualValue1 = driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]/div[5]/div[1]")).getText(); 
		Assert.assertEquals(actualValue1, expectedValue1);
		
	}
	
	@Test(priority = 5, description = "Hoobies Check Boxes")
	public void fifthTest() {
		
		//Checking all check boxes 
		driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")).click();
		WebElement checkBox1 = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")); 
		Assert.assertFalse(checkBox1.isSelected());
		driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label")).click();
		WebElement checkBox2 = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label")); 
		Assert.assertFalse(checkBox2.isSelected());
		driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label")).click();
		WebElement checkBox3 = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label")); 
		Assert.assertFalse(checkBox3.isSelected());
	}
	
	@Test(priority = 6, description = "Current Address typing box")
	public void sixthTest() {
		
		//Typing address on the box
		driver.findElement(By.id("currentAddress")).sendKeys("Francisco J. Peniado #56, Edif. Calu apart 2A, Cuidad Nueva, Santo Domingo");
		String expectedValue1 = "Francisco J. Peniado #56, Edif. Calu apart 2A, Cuidad Nueva, Santo Domingo";
		String actualValue1 = driver.findElement(By.id("currentAddress")).getAttribute("value"); 
		Assert.assertEquals(actualValue1, expectedValue1);
	}

	@Test(priority = 1, description = "State and City Drop Down Manus")
	public void firstTest() {
		
		//Placing the state
		WebElement element = driver.findElement(By.xpath("//*[@id=\"react-select-3-input\"]"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.sendKeys(Keys.ENTER);
		element.sendKeys(Enum_State.NCR.state);
		element.sendKeys(Keys.ENTER);
		String expectedValue1 = Enum_State.NCR.state;
		String actualValue1 = driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]")).getText(); 
		Assert.assertEquals(actualValue1, expectedValue1);
		
		//Placing the city
		WebElement web = driver.findElement(By.xpath("//*[@id=\"react-select-4-input\"]"));
		web.sendKeys(Keys.ENTER);
		web.sendKeys(Enum_City.DELHI.city);
		web.sendKeys(Keys.ENTER);
		String expectedValue2 = Enum_City.DELHI.city;
		String actualValue2 = driver.findElement(By.xpath("//*[@id=\"city\"]/div/div[1]/div[1]")).getText(); 
		Assert.assertEquals(actualValue2, expectedValue2);

	}

	@AfterTest
	public void after() {
		
		//submiting the form and closing the browser
		button();
		driver.close();

	}

}
