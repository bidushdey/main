package demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumScrapper {

    public void clickOnTheGivenWebElement(WebElement element, ChromeDriver driver) {
        element.click();
    }

    public void scrollToTheElement(WebElement element, ChromeDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }
}
