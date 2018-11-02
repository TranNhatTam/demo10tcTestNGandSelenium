package example ;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "http://adam.goucher.ca/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  @Test
  public void testParkingTestCase3() throws Exception {
    driver.get(baseUrl + "/parkcalc/index.php");
      
      //Select Short-Term Parking
    new Select(driver.findElement(By.id("Lot"))).selectByVisibleText("Short-Term Parking");
      
      //Enter 01/02/2014
    driver.findElement(By.id("EntryDate")).clear();
    driver.findElement(By.id("EntryDate")).sendKeys("01/02/2014");
      
      //Enter 01/01/2014
    driver.findElement(By.id("ExitDate")).clear();
    driver.findElement(By.id("ExitDate")).sendKeys("01/01/2014");
      
      //Click Submit
    driver.findElement(By.name("Submit")).click();
      
      //Verify ERROR! Your Exit Date Or Time Is Before Your Entry Date or Time
    try {
      assertEquals("ERROR! Your Exit Date Or Time Is Before Your Entry Date or Time", driver.findElement(By.cssSelector("b")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }
  @Test

  public void testParkingTestCase4Java() throws Exception {
    driver.get(baseUrl + "/parkcalc/index.php");
      
      //Select Valet Parking
    new Select(driver.findElement(By.id("Lot"))).selectByVisibleText("Valet Parking");
     
      //Enter 08:15
    driver.findElement(By.id("EntryTime")).clear();
    driver.findElement(By.id("EntryTime")).sendKeys("08:15");
     
      //Enter 05/05/2015
    driver.findElement(By.id("EntryDate")).clear();
    driver.findElement(By.id("EntryDate")).sendKeys("05/05/2015");
     
      //Select AM
    driver.findElement(By.name("EntryTimeAMPM")).click();
     
      //Enter 11:00
    driver.findElement(By.id("ExitTime")).clear();
    driver.findElement(By.id("ExitTime")).sendKeys("11:00");
     
      //Enter 05/09/2015
    driver.findElement(By.id("ExitDate")).clear();
    driver.findElement(By.id("ExitDate")).sendKeys("05/09/2015");
     
      //Click Submit
    driver.findElement(By.name("Submit")).click();
      
      //Verify Totals are $ 150.00 and 4 Days, 14 Hours, 45 Minutes
    try {
      assertEquals("$ 150.00", driver.findElement(By.cssSelector("b")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("(4 Days, 14 Hours, 45 Minutes)", driver.findElement(By.cssSelector("span.BodyCopy > font > b")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }
  @Test
  public void testParkingTestCase5Java() throws Exception {
    driver.get(baseUrl + "/parkcalc/index.php");
     
      //Select Long-Term Garage Parking
    new Select(driver.findElement(By.id("Lot"))).selectByVisibleText("Long-Term Garage Parking");
     
      //Enter 05:00
    driver.findElement(By.id("EntryTime")).clear();
    driver.findElement(By.id("EntryTime")).sendKeys("05:00");
      
      //Enter 01/05/2015
    driver.findElement(By.id("EntryDate")).clear();
    driver.findElement(By.id("EntryDate")).sendKeys("01/05/2015");
     
      //Enter 03:00
    driver.findElement(By.id("ExitTime")).clear();
    driver.findElement(By.id("ExitTime")).sendKeys("03:00");
     
      //Enter 02/07/2015
    driver.findElement(By.id("ExitDate")).clear();
    driver.findElement(By.id("ExitDate")).sendKeys("02/07/2015");
     
      //Click Submit
    driver.findElement(By.name("Submit")).click();
     
      //Verify totals are $ 348.00 and 32 Days, 22 Hours, 0 Minutes
    try {
      assertEquals("$ 348.00", driver.findElement(By.cssSelector("b")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("(32 Days, 22 Hours, 0 Minutes)", driver.findElement(By.cssSelector("span.BodyCopy > font > b")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }
  @Test
  public void testParkingTestCase6Java() throws Exception {
    driver.get(baseUrl + "/parkcalc/index.php");
      
    //Select Economy Parking
    new Select(driver.findElement(By.id("Lot"))).selectByVisibleText("Economy Parking");
      
    //Enter 01:00
    driver.findElement(By.id("EntryTime")).clear();
    driver.findElement(By.id("EntryTime")).sendKeys("01:00");
      
    //Enter 07/10/2015
    driver.findElement(By.id("EntryDate")).clear();
    driver.findElement(By.id("EntryDate")).sendKeys("07/10/2015");
      
    //Select AM
    driver.findElement(By.name("EntryTimeAMPM")).click();
      
    //Enter 11:30
    driver.findElement(By.id("ExitTime")).clear();
    driver.findElement(By.id("ExitTime")).sendKeys("11:30");
      
    //Enter 07/10/2015
    driver.findElement(By.id("ExitDate")).clear();
    driver.findElement(By.id("ExitDate")).sendKeys("07/10/2015");
      
    //Click Submit
    driver.findElement(By.name("Submit")).click();
      
    //Verify Total amount and time match $ 9.00 and 22hrs, 30mins
    try {
      assertEquals("$ 9.00", driver.findElement(By.cssSelector("b")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("(0 Days, 22 Hours, 30 Minutes)", driver.findElement(By.cssSelector("span.BodyCopy > font > b")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }
  @Test
  public void testParkingTestCase7Java() throws Exception {
    driver.get(baseUrl + "/parkcalc/index.php");
      
      //Select Valet Parking
    new Select(driver.findElement(By.id("Lot"))).selectByVisibleText("Valet Parking");
     
      //Enter 08:00
    driver.findElement(By.id("EntryTime")).clear();
    driver.findElement(By.id("EntryTime")).sendKeys("08:00");
      
      //Enter 09/10/2015
    driver.findElement(By.id("EntryDate")).clear();
    driver.findElement(By.id("EntryDate")).sendKeys("09/10/2015");
     
      //Select AM
    driver.findElement(By.name("EntryTimeAMPM")).click();
     
      //Enter 09:30
    driver.findElement(By.id("ExitTime")).clear();
    driver.findElement(By.id("ExitTime")).sendKeys("09:30");
     
      //Enter 09/10/2015
    driver.findElement(By.id("ExitDate")).clear();
    driver.findElement(By.id("ExitDate")).sendKeys("09/10/2015");
     
      //Select AM
    driver.findElement(By.name("ExitTimeAMPM")).click();
     
      //Click Submit
    driver.findElement(By.name("Submit")).click();
      
      //Verify Totals are $ 12.00 and 0 Days, 1 Hour, 30 Minutes
    try {
      assertEquals("$ 12.00", driver.findElement(By.cssSelector("b")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("(0 Days, 1 Hours, 30 Minutes)", driver.findElement(By.cssSelector("span.BodyCopy > font > b")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }
  @Test
  public void testParkingTestCase8() throws Exception {
    driver.get(baseUrl + "/parkcalc/index.php");
     
      //Select Long-Term Surface Parking
    new Select(driver.findElement(By.id("Lot"))).selectByVisibleText("Long-Term Surface Parking");
      
      //Enter 01:00
    driver.findElement(By.id("EntryTime")).clear();
    driver.findElement(By.id("EntryTime")).sendKeys("01:00");
      
      //Enter 01/20/2015
    driver.findElement(By.id("EntryDate")).clear();
    driver.findElement(By.id("EntryDate")).sendKeys("01/20/2015");
      
      //Enter 08:00
    driver.findElement(By.id("ExitTime")).clear();
    driver.findElement(By.id("ExitTime")).sendKeys("08:00");
      
      //Enter 01/20/2015
    driver.findElement(By.id("ExitDate")).clear();
    driver.findElement(By.id("ExitDate")).sendKeys("01/20/2015");
     
      //Select AM
    driver.findElement(By.name("ExitTimeAMPM")).click();
      
      //Click Submit
    driver.findElement(By.name("Submit")).click();
      
      //Verify totals are $ 0.00 and -1 Day, 19 Hours, 0 Minutes
    try {
      assertEquals("$ 0.00", driver.findElement(By.cssSelector("b")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("(-1 Days, 19 Hours, 0 Minutes)", driver.findElement(By.cssSelector("span.BodyCopy > font > b")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }
  @Test
  public void testParkingTestCase2() throws Exception {
    driver.get(baseUrl + "/parkcalc/index.php");
     
      //Select Long-Term Surface Parking
    new Select(driver.findElement(By.id("Lot"))).selectByVisibleText("Long-Term Surface Parking");
     
      //Enter 01/01/2014, instead of date picker, as it does not act as expected.
    driver.findElement(By.id("EntryDate")).clear();
    driver.findElement(By.id("EntryDate")).sendKeys("01/01/2014");
     
      //Enter 02/02/2014, again instead of date picker
    driver.findElement(By.id("ExitDate")).clear();
    driver.findElement(By.id("ExitDate")).sendKeys("02/01/2014");
      
      //Click Submit
    driver.findElement(By.name("Submit")).click();
      
      //Verify totals are $ 270.00 and 31 Days, 0 Hours, 0 Minutes
    try {
      assertEquals("$ 270.00", driver.findElement(By.cssSelector("b")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("(31 Days, 0 Hours, 0 Minutes)", driver.findElement(By.cssSelector("span.BodyCopy > font > b")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }
  @Test
  public void testParkingTestCase1() throws Exception {
    driver.get(baseUrl + "/parkcalc/index.php");
     
      //Select Short-Term Parking
    new Select(driver.findElement(By.id("Lot"))).selectByVisibleText("Short-Term Parking");
    
      //Enter 10:00
    driver.findElement(By.id("EntryTime")).clear();
    driver.findElement(By.id("EntryTime")).sendKeys("10:00");
     
      //Enter 01/01/2014
    driver.findElement(By.id("EntryDate")).clear();
    driver.findElement(By.id("EntryDate")).sendKeys("01/01/2014");
   
      //Enter 11:00
    driver.findElement(By.id("ExitTime")).clear();
    driver.findElement(By.id("ExitTime")).sendKeys("11:00");
      
      //Enter 01/01/2014
    driver.findElement(By.id("ExitDate")).clear();
    driver.findElement(By.id("ExitDate")).sendKeys("01/01/2014");
      
      //Click Submit
    driver.findElement(By.name("Submit")).click();
      
      //Verify Totals are $ 2.00 and 0 Days, 1 Hours, 0 Minutes
    try {
      assertEquals("$ 2.00", driver.findElement(By.cssSelector("b")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("(0 Days, 1 Hours, 0 Minutes)", driver.findElement(By.cssSelector("span.BodyCopy > font > b")).getText().trim());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @AfterClass
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    System.out.println(verificationErrorString);
  }
}