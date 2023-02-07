package com.cydeo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Fipkart3 {


    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.flipkart.com/");

        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

        // driver.switchTo().frame(0);
        //driver.switchTo().frame(0);
        WebElement element = driver.findElement(By.xpath("//div[@class='_3eARKq']"));
        element.click();
        WebElement elMenu = driver.findElement(By.xpath("//span[.='Electronics']"));
        elMenu.click();
        List<WebElement> elMenus = driver.findElements(By.xpath("//div[@class='_1QrT3s']/div[@class='_1fwVde'][1]"));

        System.out.println(elMenus.size());
        for(WebElement element1 : elMenus){
            System.out.println(element1.getText());
        }
    }
    }

