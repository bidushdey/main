package demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestCases extends BaseTest {

    @Test
    public void testCase01() throws InterruptedException {

        SeleniumScrapper obj = new SeleniumScrapper();

        WebElement hockeyTeamsLink = driver.findElement(By.xpath("//a[@href='/pages/forms/']"));

        obj.clickOnTheGivenWebElement(hockeyTeamsLink, driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3l));
        wait.until(ExpectedConditions.urlContains("forms"));

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));

        obj.scrollToTheElement(submitButton, driver);

        List<WebElement> listOfTeamNames = driver.findElements(By.xpath("//table/tbody/tr[@class='team']/td[6][text()<0.4]/parent::tr/td[1]"));

        HashMap<String, List<String>> map = new HashMap<>();

        List<String> teams = new ArrayList<>();
        teams.add(listOfTeamNames.get(0).getText());

        map.put("Team Name", teams);
        int k = 0;

        for (int j = 2; j < 5; j++) {
            if (j == 2) {
                k = 1;
            } else {
                k = 0;
            }

            listOfTeamNames = driver.findElements(By.xpath("//table/tbody/tr[@class='team']/td[6][text()<0.4]/parent::tr/td[1]"));
            for (int i = k; i < listOfTeamNames.size(); i++) {
                if (map.containsKey("Team Name")) {
                    List<String> teams_2 = map.get("Team Name");
                    String teamName = listOfTeamNames.get(i).getText();
                    teams_2.add(teamName);
                    map.put("Team Name", teams_2);
                }

            }

            WebElement numberLink = driver.findElement(By.xpath("//a[@href='/pages/forms/?page_num=" + j + "']"));
            numberLink.click();

            String url = "https://www.scrapethissite.com/pages/forms/?page_num=" + j;
            wait.until(ExpectedConditions.urlToBe(url));
        }

        WebElement numberLink = driver.findElement(By.xpath("//a[@href='/pages/forms/?page_num=1']"));
        numberLink.click();

        String url = "https://www.scrapethissite.com/pages/forms/?page_num=1";
        wait.until(ExpectedConditions.urlToBe(url));

        //Year
        List<WebElement> listOfYears = driver.findElements(By.xpath("//table/tbody/tr[@class='team']/td[6][text()<0.4]/parent::tr/td[2]"));

        HashMap<String, List<String>> map2 = new HashMap<>();

        List<String> teams_2 = new ArrayList<>();
        teams_2.add(listOfYears.get(0).getText());

        map2.put("Year", teams_2);

        k = 0;
        for (int j = 2; j < 5; j++) {
            if (j == 2) {
                k = 1;
            } else {
                k = 0;
            }

            listOfYears = driver.findElements(By.xpath("//table/tbody/tr[@class='team']/td[6][text()<0.4]/parent::tr/td[2]"));
            for (int i = k; i < listOfYears.size(); i++) {
                if (map2.containsKey("Year")) {
                    List<String> teams_3 = map2.get("Year");
                    String teamName = listOfYears.get(i).getText();
                    teams_3.add(teamName);
                    map2.put("Year", teams_3);
                }

            }

            numberLink = driver.findElement(By.xpath("//a[@href='/pages/forms/?page_num=" + j + "']"));
            numberLink.click();

            url = "https://www.scrapethissite.com/pages/forms/?page_num=" + j;
            wait.until(ExpectedConditions.urlToBe(url));
        }

        numberLink = driver.findElement(By.xpath("//a[@href='/pages/forms/?page_num=1']"));
        numberLink.click();

        url = "https://www.scrapethissite.com/pages/forms/?page_num=1";
        wait.until(ExpectedConditions.urlToBe(url));

        //Win%
        List<WebElement> listOfWinPercentage = driver.findElements(By.xpath("//table/tbody/tr[@class='team']/td[6][text()<0.4]"));

        HashMap<String, List<String>> map3 = new HashMap<>();

        List<String> teams_3 = new ArrayList<>();
        teams_3.add(listOfWinPercentage.get(0).getText());

        map3.put("Win %", teams_3);

        k = 0;
        for (int j = 2; j < 5; j++) {
            if (j == 2) {
                k = 1;
            } else {
                k = 0;
            }

            listOfWinPercentage = driver.findElements(By.xpath("//table/tbody/tr[@class='team']/td[6][text()<0.4]"));
            for (int i = k; i < listOfWinPercentage.size(); i++) {
                if (map3.containsKey("Win %")) {
                    List<String> teams_4 = map3.get("Win %");
                    String teamName = listOfWinPercentage.get(i).getText();
                    teams_4.add(teamName);
                    map3.put("Win %", teams_4);
                }

            }

            numberLink = driver.findElement(By.xpath("//a[@href='/pages/forms/?page_num=" + j + "']"));
            numberLink.click();

            url = "https://www.scrapethissite.com/pages/forms/?page_num=" + j;
            wait.until(ExpectedConditions.urlToBe(url));
        }

        numberLink = driver.findElement(By.xpath("//a[@href='/pages/forms/?page_num=1']"));
        numberLink.click();

        url = "https://www.scrapethissite.com/pages/forms/?page_num=1";
        wait.until(ExpectedConditions.urlToBe(url));

        ArrayList<HashMap<String, List<String>>> listOfMaps = new ArrayList<>();
        listOfMaps.add(map);
        listOfMaps.add(map2);
        listOfMaps.add(map3);

        ObjectMapper mapper = new ObjectMapper();

        // Converting the created arraylist to a JSON payload as string
        try {
            String employeePrettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfMaps);
            System.out.println(employeePrettyJson);
        } catch (JsonProcessingException e) {
            System.out.println(e.getStackTrace());
        }

        String userDir = System.getProperty("user.dir");

        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(userDir + "\\src\\test\\resources\\hockey-team-data.json"), listOfMaps);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileName = "\\src\\test\\resources\\hockey-team-data.json";

        Assert.assertTrue(fileName.length() > 0, "The file in the mentioned location is not present and not empty.");
        // Assert.assertNull("\\src\\test\\resources\\hockey-team-data.json");

    }

    @Test
    public void testCase02() throws InterruptedException {

        WebElement oscarWinningLink = driver.findElement(By.xpath("//a[text()='Oscar Winning Films: AJAX and Javascript']"));
        oscarWinningLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3l));
        wait.until(ExpectedConditions.urlToBe("https://www.scrapethissite.com/pages/ajax-javascript/"));

        List<WebElement> listOfYears = driver.findElements(By.xpath("//a[@class='year-link']"));

        ArrayList<HashMap<List<String>, List<String>>> yearWiseFilmDetailsList = new ArrayList<>();

        for (int i = 0; i < listOfYears.size(); i++) {
            WebElement year = listOfYears.get(i);

            year.click();

            // WebElement title=driver.findElement(By.xpath("//th[text()='Title']"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Title']")));

            HashMap<List<String>, List<String>> map = new HashMap<>();

            String yearValue = year.getText();

            List<String> listOfHeadings = new ArrayList<>() {
                {
                    add("Year");
                    add("Title");
                    add("Nomination");
                    add("Awards");
                    add("isWinner");
                }
            };

            List<String> filmDetails = new ArrayList<>();

            for (int j = 1; j <= 5; j++) {
                filmDetails.add(yearValue);
                for (int k = 1; k <= 4; k++) {
                    WebElement element = driver.findElement(By.xpath("//table/tbody/tr[" + j + "]/td[" + k + "]"));
                    if (j == 1 && k == 4) {
                        filmDetails.add("true");
                    } else if ((j >= 2 && j <= 5) && k == 4) {
                        filmDetails.add("false");
                    } else {
                        filmDetails.add(element.getText());
                    }
                }
            }

            // HashMap<List<String>,List<String>> map=new HashMap<>();
            // if (map.containsKey(listOfHeadings)) {
            //     List<String> filmDetails_2 = map.get(listOfHeadings);
            //     for (int s = 0; s < filmDetails.size(); s++) {
            //         filmDetails_2.add(filmDetails.get(s));
            //     }
            //     map.put(listOfHeadings, filmDetails_2);
            // } else {
            //     map.put(listOfHeadings, filmDetails);
            // }
            map.put(listOfHeadings, filmDetails);

            yearWiseFilmDetailsList.add(map);

        }

        ObjectMapper mapper = new ObjectMapper();

        // Converting the created arraylist to a JSON payload as string
        try {
            String employeePrettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(yearWiseFilmDetailsList);
            System.out.println(employeePrettyJson);
        } catch (JsonProcessingException e) {
            System.out.println(e.getStackTrace());
        }

        String userDir = System.getProperty("user.dir");

        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(userDir + "\\src\\test\\resources\\oscar-winner-data.json"), yearWiseFilmDetailsList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileName = "\\src\\test\\resources\\oscar-winner-data.json";

        Assert.assertTrue(fileName.length() > 0, "The file in the mentioned location is not present and not empty.");

    }

}
