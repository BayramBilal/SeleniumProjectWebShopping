package com.cydeo.tests;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A101 {

    @Test
   public void testA101(){

        Driver.getDriver().get("https://www.a101.com.tr");


    WebElement cookiesAccept = Driver.getDriver().findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        cookiesAccept.click();

        BrowserUtils.sleep(2);
    WebElement searchBox = Driver.getDriver().findElement(By.xpath("//form[@class='js-search-form']//input"));
    searchBox.sendKeys("deterjan");
    searchBox.submit();

//     WebElement searchBtn = Driver.getDriver().findElement(By.xpath("//button[@class='search-btn']"));
//       searchBtn.click();

        BrowserUtils.sleep(2);
        WebElement bingo = Driver.getDriver().findElement(By.xpath("//ul//label[@for='attributes_integration_brand1255']"));
        bingo.click();

        WebElement bingoAdet = Driver.getDriver().findElement(By.xpath("//div[@data-pk='31737']"));
        bingoAdet.click();


        WebElement sepeteGit = Driver.getDriver().findElement(By.xpath("//a[@class='go-to-shop']"));
        sepeteGit.click();

        WebElement sepetteki = Driver.getDriver().findElement(By.xpath("//div[@id='basket-item-31737']//a[@title='Bingo Toz Deterjan 5,5 Kg']"));
        String expectedText = "Bingo Toz Deterjan 5,5 Kg";
        String actualText = sepetteki.getText();

        Assert.assertEquals(actualText, expectedText);

Driver.closeDriver();
    
}

}