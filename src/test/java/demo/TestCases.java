package demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCases extends BaseTest{

    @Test    
    public void testCase01() throws InterruptedException{

        try{

        driver.get("https://www.flipkart.com/");

        WebElement flipkartSearch=driver.findElement(By.xpath("//input[@class='Pke_EE']"));
        flipkartSearch.click();
        flipkartSearch.sendKeys("Washing Machine");
        
        Thread.sleep(3000);

        WebElement searchButton=driver.findElement(By.xpath("//button[@class='_2iLD__']"));
        searchButton.click();
        Thread.sleep(3000);

        WebElement popularity=driver.findElement(By.xpath("//div[text()='Popularity']"));
        popularity.click();

        Thread.sleep(3000);

        List<WebElement> productRating=driver.findElements(By.xpath("//span[@class='Y1HWO0']/div"));

        int count=0;
        for(int i=0;i<productRating.size();i++)
        {
            String productValue=productRating.get(i).getText();
            //System.out.println(productValue);
            //int integerProductValue=Integer.parseInt(productValue);
           float integerProductValue=Float.parseFloat(productValue);

            if(integerProductValue<=4.0)
            {
               count++;
            }
        }

    }
    catch(Exception e)
    {
        System.out.println(e.getStackTrace());
        Assert.assertFalse(false,"The Washing Machine search testcase is failed.");
    }

      Assert.assertTrue(true,"The Washing Machine search testcase is passed.");

    }


    @Test
    public void testCase02() throws InterruptedException{

        try{

        WebElement productSearch=driver.findElement(By.xpath("//input[@class='zDPmFV']"));
        productSearch.click();
        Thread.sleep(2000);
        Actions action=new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
        action.perform();
        action.sendKeys(Keys.DELETE);
        action.perform();
      //  productSearch.clear();
        Thread.sleep(3000);
        productSearch.sendKeys("iPhone");
        Thread.sleep(3000);

        WebElement searchKey=driver.findElement(By.xpath("//button[@class='MJG8Up']"));
        searchKey.click();
        Thread.sleep(3000);

        List<WebElement> listOfProductsDiscounts=driver.findElements(By.xpath("//div[@class='tUxRFH']"));

        for(WebElement parentElement : listOfProductsDiscounts)
        {
            WebElement productDiscount=parentElement.findElement(By.xpath(".//div[@class='UkUFwK']/span"));
            String productDiscountText=productDiscount.getText();
            String replace="% off";
            String current="";
            String exactProductDiscount=productDiscountText.replace(replace, current);
            int productDiscountValue=Integer.parseInt(exactProductDiscount);
            if(productDiscountValue>17)
            {
                WebElement productTitle=parentElement.findElement(By.xpath(".//div[@class='KzDlHZ']"));
                System.out.println("Product title:-" + productTitle.getText() + " and discount percentage:-" + productDiscountValue);

            }
        }

    }

    catch(Exception e)
    {
      System.out.println(e.getStackTrace());
      Assert.assertFalse(false,"The iPhone search testcase is failed.");
    }

    Assert.assertTrue(true,"The iPhone search testcase is passed.");

    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    public void testCase03() throws InterruptedException{

        try{

        WebElement productSearch=driver.findElement(By.xpath("//input[@class='zDPmFV']"));
        productSearch.click();
        Thread.sleep(2000);
        Actions action=new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
        action.perform();
        action.sendKeys(Keys.DELETE);
        action.perform();
      //  productSearch.clear();
        Thread.sleep(3000);
        productSearch.sendKeys("Coffee Mug");
        Thread.sleep(3000);

        WebElement searchKey=driver.findElement(By.xpath("//button[@class='MJG8Up']"));
        searchKey.click();
        Thread.sleep(3000);

       JavascriptExecutor jse=(JavascriptExecutor)driver;
        
      // WebElement oneStar=driver.findElement(By.xpath("//div[text()='1★ & above']"));
      //  System.out.println(oneStar.getText());
        jse.executeScript("window.scrollBy(0,350)","");

        Thread.sleep(2000);

        //WebElement fourStarCheckbox=driver.findElement(By.xpath("//div[text()='4★ & above']//parent::label//div[@class='XqNaEv']"));
       // WebElement fourStarCheckbox=driver.findElement(By.xpath("(//input[@class='vn9L2C'])[2]"));
       WebElement fourStarCheckbox=driver.findElement(By.cssSelector("#container > div > div.nt6sNV.JxFEK3._48O0EI > div.DOjaWF.YJG4Cf > div.DOjaWF.gdgoEp.col-2-12 > div > div > div > section:nth-child(6) > div.SDsN9S > div > div:nth-child(1) > div > label > div.XqNaEv"));
       fourStarCheckbox.click();

        Thread.sleep(3000);

        List<WebElement> reviews=driver.findElements(By.xpath("//span[@class='Wphh3N']"));

        int[] reviews_2=new int[reviews.size()];
        int index=0;

        
        for(WebElement element : reviews)
        {

          //  System.out.println(element.getText());
            
           String element_2=element.getText();
            // System.out.println(element_2);
            if(element_2.contains(","))
            {
                String current=",";
                String replace="";
                String updated=element_2.replace(current, replace);
                element_2=updated;
            }
          //  System.out.println(element_2);
             int endIndex=element_2.length()-1;
            // System.out.println(endIndex);
             String subStr=element_2.substring(1, endIndex);
             int reviewCountValue=Integer.parseInt(subStr);
             reviews_2[index]=reviewCountValue;
             index++;

        }

    
   

          Arrays.sort(reviews_2);

          int updatedArray[]=new int[5];
          int c=0,index2=0;

          for(int i=reviews_2.length-1;i>=0;i--)
          {
               if(c==5)
               {
                break;
               }
              updatedArray[index2]=reviews_2[i];
              index2++;
              c++;

          }

          //System.out.println(updatedArray[3]+ " " +updatedArray[4]);



          List<WebElement> listOfItems=driver.findElements(By.xpath("//div[@class='slAVV4']"));


          for(WebElement parentElement : listOfItems)
          {

          //  System.out.println(parentElement.getText());
            WebElement reviewsCount=parentElement.findElement(By.xpath(".//span[@class='Wphh3N']"));
      
            String element_2=reviewsCount.getText();

            if(element_2.contains(","))
            {
                String current=",";
                String replace="";
                String updated=element_2.replace(current, replace);
                element_2=updated;
            }

             String subStr=element_2.substring(1, element_2.length()-1);

            
           int reviewCountValue=Integer.parseInt(subStr);
           //System.out.println("list element" + reviewCountValue);
           //System.out.println(updatedArray[0] +", " + updatedArray[1] +", "+ updatedArray[2] + ", "+updatedArray[3]+ ", "+ updatedArray[4]);
           boolean isElement=IntStream.of(updatedArray).anyMatch(x -> x == reviewCountValue);
          //  System.out.println(isElement);
            if(isElement==true)
            {
                WebElement itemTitle=parentElement.findElement(By.xpath(".//a[@class='wjcEIp']"));
                WebElement itemImage=parentElement.findElement(By.xpath(".//img[@class='DByuf4']"));
                System.out.println("item Title:- " + itemTitle.getText() + "itemImageUrl:- " + itemImage.getAttribute("src"));
   
            }
          }

        }

          catch(Exception e)
          {
             System.out.println(e.getStackTrace());
             Assert.assertFalse(false,"The Coffee Mug search testcase is failed.");
          }

          Assert.assertTrue(true,"The Coffee Mug search testcase is passed.");

        
        
     }

    
    


}

