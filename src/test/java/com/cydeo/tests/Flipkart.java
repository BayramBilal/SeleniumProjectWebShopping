package com.cydeo.tests;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Flipkart {

   @Test
    public void testFlipkart(){

        Driver.getDriver().get("https://www.flipkart.com/");
        WebElement cookiesClose = Driver.getDriver().findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        cookiesClose.click();

       WebElement electronics = Driver.getDriver().findElement(By.xpath("//img[@alt='Electronics']"));

       Actions actions = new Actions(Driver.getDriver());
      actions.moveToElement(electronics).clickAndHold().perform();

      WebElement powerbank = Driver.getDriver().findElement(By.linkText("Powerbank"));
      powerbank.click();
       BrowserUtils.sleep(5);
      WebElement fourStars = Driver.getDriver().findElement(By.xpath("//div[@title='4★ & above']"));

      actions.moveToElement(fourStars).perform();
      fourStars.click();
       BrowserUtils.sleep(3);
//      WebElement ubon = Driver.getDriver().findElement(By.xpath("//a[contains(@title,'Unix 10000 mAh Power Bank (Fast Charging)')]"));
//      WebElement ubon = Driver.getDriver().findElement(By.xpath("//div[@data-id='PWBGYAU9NDP5RJXS']"));
        WebElement ubon = Driver.getDriver().findElement(By.xpath("//div[.='₹1,099']"));
      ubon.click();

       String currentWindowHandle = Driver.getDriver().getWindowHandle();

       // Get a list of all window handles
       Set<String> handles = Driver.getDriver().getWindowHandles();

       // Switch to the new tab
       for (String handle : handles) {
           if (!handle.equals(currentWindowHandle)) {
               Driver.getDriver().switchTo().window(handle);

           }
       }

       BrowserUtils.sleep(3);

      WebElement addchart = Driver.getDriver().findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
      addchart.click();

       String actualChart = Driver.getDriver().findElement(By.xpath("//span[@class='_2-ut7f _1WpvJ7']")).getText();
       String expectedChartTotal = Driver.getDriver().findElement(By.xpath("//div[@class='_1dqRvU']")).getText();

       System.out.println("actualChart = " + actualChart);
       System.out.println("expectedChartTotal = " + expectedChartTotal);


       Assert.assertEquals(actualChart, expectedChartTotal);



        Driver.closeDriver();

}
               }
