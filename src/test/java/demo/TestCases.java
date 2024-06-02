package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TestCases extends BaseTest{

   @Test
  public void testCase01() throws InterruptedException{

   

    driver.get("https://www.youtube.com/");

try{

    String expectedUrl="https://www.youtube.com/";
    String currentUrl=driver.getCurrentUrl();

    Assert.assertEquals(expectedUrl, currentUrl,"The expected url is not matching.");

    WebElement aboutLink=driver.findElement(By.xpath("//a[text()='About']"));

    JavascriptExecutor jse=(JavascriptExecutor)driver;
    jse.executeScript("arguments[0].scrollIntoView();",aboutLink);

    aboutLink.click();

    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3l));
    wait.until(ExpectedConditions.urlToBe("https://about.youtube/"));

    jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("(//p[@class='lb-font-display-3 lb-font-color-text-primary'])[1]")));

    WebElement aboutYoutubeText=driver.findElement(By.xpath("//section[@class='ytabout__content']/h1"));

    String youtubeText=aboutYoutubeText.getText().trim();

    WebElement youTubeMessage=driver.findElement(By.xpath("(//p[@class='lb-font-display-3 lb-font-color-text-primary'])[1]"));
    String updatedYoutubeMessage=youTubeMessage.getText().trim();

    System.out.println(youtubeText);
    System.out.println(updatedYoutubeMessage);


}

  catch(Exception e)
  {
    System.out.println(e.getMessage());
  }

    
  }


    @Test
    public void testCase02() throws InterruptedException{

      driver.get("https://www.youtube.com/");

      try{

      WebElement movies=driver.findElement(By.xpath("//yt-formatted-string[text()='Movies']"));

      JavascriptExecutor jse=(JavascriptExecutor)driver;
      jse.executeScript("arguments[0].scrollIntoView();", movies);

      movies.click();

      WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3l));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Movies']")));


     
      while(true){ 
        // System.out.println("1");
        WebElement forwardButton=driver.findElement(By.xpath("(//ytd-button-renderer[@class='style-scope yt-horizontal-list-renderer arrow'])[2]//button"));
      //  System.out.println(forwardButton);
      //  System.out.println(forwardButton.isDisplayed());
        if(forwardButton.isDisplayed())
        {
         // System.out.println("2");
          forwardButton.click();
        }
        else{
          break;
        }

      }

      WebElement movieGradeA=driver.findElement(By.xpath("(//p[@class='style-scope ytd-badge-supported-renderer'])[32]"));

     SoftAssert obj=new SoftAssert();
     String movieGradeFound=movieGradeA.getText();
     String expectedMovieGrade="A";

     obj.assertEquals(movieGradeFound, expectedMovieGrade);

     WebElement movieGenre=driver.findElement(By.xpath("(//span[@class='grid-movie-renderer-metadata style-scope ytd-grid-movie-renderer'])[16]"));

     boolean status=false;

     if(movieGenre.getText().contains("Comedy") || movieGenre.getText().contains("Animation"))
     {
      status=true;
     }

     obj.assertTrue(status);

     obj.assertAll();

    }

    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }


      
    }

   
    @Test
    public void testCase03() throws InterruptedException{

      driver.get("https://www.youtube.com/");


      try{

      WebElement music=driver.findElement(By.xpath("(//yt-icon-shape[@class='style-scope yt-icon'])[26]"));
      music.click();

      WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3l));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@aria-label='Next'])[1]")));
      


      JavascriptExecutor jse=(JavascriptExecutor)driver;
      jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("(//div[@class='style-scope ytd-shelf-renderer'])[2]//span")));

      while(true){ 

        WebElement nextButton=driver.findElement(By.xpath("(//button[@aria-label='Next'])[1]"));
        if(nextButton.isDisplayed())
        {
          nextButton.click();
        }
        else{
          break;
        }
        
      }

      Thread.sleep(3000);

      WebElement filmsTitle=driver.findElement(By.xpath("(//h3[@class='style-scope ytd-compact-station-renderer'])[11]"));

      System.out.println(filmsTitle.getText().trim());

      WebElement tracksInput=driver.findElement(By.xpath("(//p[@id='video-count-text'])[11]"));

      String updatedTracksInput=tracksInput.getText().trim();
      String current=" tracks";
      String replace="";
      String neededTracksInput=updatedTracksInput.replace(current, replace);

      int tracksCount=Integer.parseInt(neededTracksInput);
      boolean status=false;
      if(tracksCount<=50)
      {
         status=true;
      }

      System.out.println(status);
      SoftAssert obj=new SoftAssert();
      obj.assertTrue(status,"The tracks count is not equal to and less than 50.");
      obj.assertAll();

    }

    catch(Exception e)
    {
       System.out.println(e.getMessage());
    }

      
  }


     @Test
     public void testCase04() throws InterruptedException{

      try{
 
       driver.get("https://www.youtube.com/");

       WebElement news=driver.findElement(By.xpath("(//yt-icon-shape[@class='style-scope yt-icon'])[30]"));
       news.click();

       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(6l));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Latest news posts']")));

       JavascriptExecutor jse=(JavascriptExecutor)driver;
       jse.executeScript("window.scrollBy(0,300)", "");

       List<WebElement> listOfNewsPosts=driver.findElements(By.xpath("//ytd-post-renderer[@class='style-scope ytd-rich-item-renderer']"));

         int sum=0;
         int count=0;
         for(WebElement parentElement : listOfNewsPosts){
          if(count==3)
          {
            break;
          }
         WebElement newsPostsTitle=parentElement.findElement(By.xpath(".//a[@id='author-text']//span"));
         System.out.println("News posts title:- "+newsPostsTitle.getText());

         WebElement newsPostsBody=parentElement.findElement(By.xpath(".//yt-formatted-string[@id='home-content-text']"));
         System.out.println("News post body:- "+newsPostsBody.getText());

         WebElement likes=parentElement.findElement(By.xpath(".//span[@id='vote-count-middle']"));
        // System.out.println(likes.getAttribute("aria-label"));
         String likes_2=likes.getText();
         if(likes_2.length()!=0)
         {
           String updatedLikes=likes_2.trim();
           int likesCount=Integer.parseInt(updatedLikes);
           //System.out.println(likesCount);
           sum=sum+likesCount;
         }
         count++;

       }
       System.out.println("The sum of likes count of 1st 3 latest news posts:- "+sum);

      }

      catch(Exception e)
      {
        System.out.println(e.getMessage());
      }

     }
    
    


}

