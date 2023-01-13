package com.cydeo.tests;


import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class FlipkartSecondWay {

    @Test
    public void flipKart_Test() throws InterruptedException {
        Driver.getDriver().get("https://www.flipkart.com/");
        Thread.sleep(3000);
        WebElement closeButton = Driver.getDriver().findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        closeButton.click();

        //hover over Electronic mnu
        WebElement electronicsMenu = Driver.getDriver().findElement(By.xpath("(//div[.='Electronics'])[1]"));
        Actions action2 = new Actions(Driver.getDriver());
        action2.moveToElement(electronicsMenu).perform();

        //click powerBank
        WebElement powerBank = Driver.getDriver().findElement(By.xpath("//a[.='Powerbank']"));
        powerBank.click();
        Thread.sleep(3000);

        //scroll and click 4* checkbox
        WebElement checkBox4StarAbove = Driver.getDriver().findElement(By.xpath("(//div[.='4★ & above'])[last()]"));
        Actions action3 = new Actions(Driver.getDriver());
        action3.moveToElement(checkBox4StarAbove).perform();
        Thread.sleep(2000);
        checkBox4StarAbove.click();
        Thread.sleep(3000);

        //Product Info at ProductsPage
        WebElement firstProductName = Driver.getDriver().findElement(By.xpath(("(//div[@class='_13oc-S'])[1]/div[1]//a[@class='s1Q9rs']")));
        WebElement firstProductFeature = Driver.getDriver().findElement(By.xpath(("//div[@class='_3Djpdu']")));
        WebElement firstProductPrice = Driver.getDriver().findElement(By.xpath(("(//div[@class='_13oc-S'])[1]/div[1]//div[@class='_30jeq3']")));
        String expectedProductName = firstProductName.getAttribute("title")+ "  ("+firstProductFeature.getText()+")";
        String expectedProductPrice = firstProductPrice.getText();

        //we open and switch to second TAB
        firstProductName.click();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        ArrayList<String> windowHandlesList = new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(windowHandlesList.get(1));

        //Product Info at SingleProductPage
        WebElement productNameAtSingleProductPage = Driver.getDriver().findElement(By.xpath("//span[@class='B_NuCI']"));
        String actual1productNameAtSingleProductPage = productNameAtSingleProductPage.getText();
        WebElement productPriceAtSingleProductPage = Driver.getDriver().findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']"));
        String actual1productPriceAtSingleProductPage = productPriceAtSingleProductPage.getText();

        //We add product to CART
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.titleContains("Flipkart"));
        WebElement addToCartButton = Driver.getDriver().findElement(By.xpath("//button[text()='Add to cart']"));
        addToCartButton.click();

        //Product info at the ShoppingCart Page
        WebElement totalAmountElement = Driver.getDriver().findElement(By.xpath("//div[.='Total Amount']/following-sibling::span"));
        String totalAmount = totalAmountElement.getText();
        WebElement productNameInCartPage = Driver.getDriver().findElement(By.xpath("//a[@class='_2Kn22P gBNbID']"));
        WebElement productFeatureInCartPage = Driver.getDriver().findElement(By.xpath("//div[@class='_20RCA6']"));
        String actual2ProductNameInCartPage = productNameInCartPage.getText()+ "  ("+productFeatureInCartPage.getText()+")";

        //Assertions
        Assert.assertEquals(actual1productNameAtSingleProductPage, expectedProductName); // productName in ProductsPage VS item in SingleProductPage
        Assert.assertEquals(actual2ProductNameInCartPage, expectedProductName); // productName in ProductsPage VS item in ShoppingCartPage
        Assert.assertEquals(actual1productPriceAtSingleProductPage, expectedProductPrice); // productPrice in ProductsPage VS item in SingleProductPage
        Assert.assertEquals(totalAmount, expectedProductPrice); // productPrice in ProductsPage VS item in ShoppingCartPage

    }
}
