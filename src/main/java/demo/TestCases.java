package demo;

import java.time.Instant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
<<<<<<< HEAD
    public void testCase01(){
=======
    public  void testCase01() throws InterruptedException{
>>>>>>> 3453d957e1d2c9d2b42f518bff0f7d6b7f192e9d
        System.out.println("Start Test case: testCase01");

        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

        Thread.sleep(2000);

        WebElement name=driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]"));
        name.sendKeys("Bidush Dey");
        Thread.sleep(2000);

        String sampleText="I want to be the best QA Engineer! ";

        Long epochTime=Instant.now().getEpochSecond();

        WebElement whyAutomation=driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        whyAutomation.sendKeys(sampleText + epochTime);
        Thread.sleep(2000);

        WebElement automationExperience=driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[1]"));
        automationExperience.click();
        Thread.sleep(2000);

        WebElement javaCheckbox=driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[1]"));
        javaCheckbox.click();
        Thread.sleep(2000);

        WebElement seleniumCheckbox=driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[2]"));
        seleniumCheckbox.click();
        Thread.sleep(2000);

        WebElement testNGCheckbox=driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[4]"));
        testNGCheckbox.click();
        Thread.sleep(2000);

        WebElement addressed=driver.findElement(By.xpath("(//div[@class='e2CuFe eU809d'])[1]"));
        addressed.click();
        Thread.sleep(2000);

        WebElement mrSelection=driver.findElement(By.xpath("(//span[text()='Mr'])[2]"));
        mrSelection.click();
        Thread.sleep(2000);

  

        WebElement date=driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[2]"));
        date.sendKeys("05-05-2024");

       // js.executeScript("document.evaluate('(//input[@class=\"whsOnd zHQkBf\"])[2]', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.setAttribute('data-initial-value', '2024-05-05')");

       // js.executeScript("document.getElementByXpath('(//input[@class=\"whsOnd zHQkBf\"])[2]').setAttribute('data-initial-value', '2024-05-05')");

        Thread.sleep(2000);

       // WebElement time=driver.findElement(By.xpath("(//div[@class='e2CuFe eU809d'])[2]"));
      //  time.click();
     //   Thread.sleep(2000);

       // WebElement pm=driver.findElement(By.xpath("(//span[text()='PM'])[2]"));
       // pm.click();
      //  Thread.sleep(2000);

      WebElement timeInHours=driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[3]"));
      timeInHours.sendKeys("23");
        
      //  js.executeScript("document.evaluate('(//input[@class=\"whsOnd zHQkBf\"])[3]', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.setAttribute('data-initial-value', '21')");

        Thread.sleep(2000);

        WebElement timeInMins=driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[4]"));
        timeInMins.sendKeys("35");

       // js.executeScript("document.evaluate('(//input[@class=\"whsOnd zHQkBf\"])[4]', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.setAttribute('data-initial-value', '00')");

        //js.executeScript("document.getElementByXpath('(//input[@class="whsOnd zHQkBf"])[4]').setAttribute('data-initial-value', '00')");

        Thread.sleep(2000);

      // driver.get("https://www.amazon.in");

      // Thread.sleep(2000);

       WebElement submitButton=driver.findElement(By.xpath("//span[text()='Submit']"));
       submitButton.click();

       Thread.sleep(2000);

       WebElement thanksMessage=driver.findElement(By.xpath("//div[@class='vHW8K']"));
       System.out.println(thanksMessage.getText());




        System.out.println("end Test case: testCase01");
    }


}
