package com.cydeo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormPage {

    public static void submitForm(WebDriver driver) throws InterruptedException {

        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("job-title")).sendKeys("QA Engineer");
        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-1")).click();
        WebElement selectMenu = driver.findElement(By.id("select-menu"));
        Select select = new Select(selectMenu);
        select.selectByVisibleText("0-1");

        driver.findElement(By.cssSelector("option[value='1']")).click();
        driver.findElement(By.id("datepicker")).sendKeys("03/01/2023");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class='btn btn-lg btn-primary']")).click();


    }


}
