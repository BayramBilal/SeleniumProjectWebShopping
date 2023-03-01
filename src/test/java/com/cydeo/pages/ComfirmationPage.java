package com.cydeo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComfirmationPage {

    public static void waitAlertBanner(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));

    }

    public static String getAlertBannerText(WebDriver driver){

        String actualText = driver.findElement(By.className("alert")).getText();

        return actualText;
    }
}
