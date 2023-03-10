package com.cydeo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TestAmazonShop {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        driver.get("https://www.amazon.com.tr");

        WebElement cookiesAccept = driver.findElement(By.id("sp-cc-accept"));
        cookiesAccept.click();

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        String expectedInTitle = "wooden spoon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedInTitle)) {
            System.out.println("Title verification passed");
        } else {
            System.out.println("Title verification failed");
        }
        Thread.sleep(3000);

        WebElement spoon = driver.findElement(By.xpath("//span[.='Yaootely Wooden Measuring Spoon Set Kitchen Measuring Spoons Tea Coffee Scoop Sugar Measure Spoon Measuring,2 Pcs']"));
        spoon.click();
        WebElement addToChart = driver.findElement(By.id("add-to-cart-button"));
        addToChart.click();


        try {

            WebElement goToChart = driver.findElement(By.xpath("//a[@data-csa-c-content-id='sw-gtc_CONTENT']"));
            goToChart.click();

        }catch(StaleElementReferenceException e){
            //chart verification
            WebElement chartList = driver.findElement(By.xpath("//span[@class='a-truncate-cut']"));

            String expectedChart = spoon.getText();
            String actualChart = chartList.getText();

            System.out.println("actualChart = " + actualChart);
            System.out.println("expectedChart = " + expectedChart);

            Assert.assertEquals(actualChart, expectedChart);


    }
        driver.close();
    }


}