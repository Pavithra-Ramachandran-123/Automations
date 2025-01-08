/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */

 package flipkart.automation;

 import java.time.Duration;
 import java.util.Set;
 
 import org.openqa.selenium.By;
 import org.openqa.selenium.Keys;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.openqa.selenium.chrome.ChromeOptions;
 import org.openqa.selenium.interactions.Actions;
 import org.openqa.selenium.support.ui.ExpectedConditions;
 import org.openqa.selenium.support.ui.WebDriverWait;
 import org.testng.annotations.AfterTest;
 import org.testng.annotations.BeforeTest;
 import org.testng.annotations.Parameters;
 import org.testng.annotations.Test;
 
 import io.github.bonigarcia.wdm.WebDriverManager;
 
 public class TestCases {
     ChromeDriver driver;
     WebDriverWait wait; 
     
     @Test(priority=1)
     public void openUrl() throws InterruptedException{
         
         driver.get("https://www.flipKart.com/");
         Thread.sleep(4000);
     }
 
     @Test(priority=2)
     @Parameters("productName")
     public void searchForProduct(String productName) throws InterruptedException{
         
         WebElement searchBox= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
         Actions actions = new Actions(driver);
         actions.sendKeys(searchBox, productName).sendKeys(Keys.ENTER).build().perform();
         //Thread.sleep(4000);
         
     }
 
     @Test(priority=3)
     public void buyNow() throws InterruptedException{
         String mainWindow = driver.getWindowHandle();
         WebElement pen=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Dominic 0 Digital Pen')]")));
         pen.click();
         //Thread.sleep(4000);
         //String mainWindow = driver.getWindowHandle();
         Set<String> allWindows = driver.getWindowHandles();
         for (String windowHandle : allWindows) {
             if (!windowHandle.equals(mainWindow)) {
                 driver.switchTo().window(windowHandle);
                 System.out.println("Switched to new window: " + driver.getTitle());
                 break;
             }
         }
         
         //Thread.sleep(4000);
         WebElement buyNow=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'_3Yl67G')]")));
         buyNow.click();
         Thread.sleep(2000);
 
     }
 
     @Test(priority=4)
     @Parameters("phoneNum")
     public void login(String phoneNum) throws InterruptedException{
         System.out.println("start of testCase03");
         WebElement phoneNumber=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value]")));
         phoneNumber.sendKeys(phoneNum);
         WebElement continueButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'CONTINUE')]")));
         continueButton.click();
         Thread.sleep(2000);
         WebElement otpField=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form/div[2]/input")));
         //otpField.sendKeys("123456");
         Thread.sleep(30000);
 
         WebElement login=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
         login.click();
         System.out.println("end of testCase03");
     }
 
     @Test(priority=5)
     public void addressAndPayment() throws InterruptedException{
         System.out.println("start of testCase04");
         WebElement deliverHere=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Deliver Here']")));
         deliverHere.click();
 
         WebElement continueButton2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='CONTINUE']")));
         continueButton2.click();
         Thread.sleep(4000);
 
         WebElement paymentOption=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Credit / Debit / ATM Card']")));
         paymentOption.click();
 
         Thread.sleep(4000);
         
         System.out.println("end of testCase04");
     }
 
 
     
     @BeforeTest
     public void startBrowser()
     {
 
         WebDriverManager.chromedriver().timeout(30).setup();
 
         ChromeOptions options = new ChromeOptions();
 
         driver = new ChromeDriver(options);
 
         driver.manage().window().maximize();
         wait= new WebDriverWait(driver,Duration.ofSeconds(10));
     }
 
     @AfterTest
     public void endTest()
     {
         driver.close();
         driver.quit();
     }
 }
 