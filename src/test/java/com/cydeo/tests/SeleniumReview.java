package com.cydeo.tests;

import com.cydeo.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumReview {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/keypress");

        WebElement name = driver.findElement(By.id("name"));
        name.click();

        name.sendKeys("Eva Peron");
        Thread.sleep(3000);
        WebElement button = driver.findElement(By.id("button"));
        button.submit();


       driver.close();

    }
    @Test
    public void test1Complete() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebElement address = driver.findElement(By.id("autocomplete"));
        address.sendKeys("Kocasinan mah");

        WebElement street1 = driver.findElement(By.id("street_number"));
        street1.sendKeys("2.sokak No.3E");

        WebElement street2 = driver.findElement(By.id("route"));
        street2.sendKeys("Karanfil apt.");

        WebElement city = driver.findElement(By.id("locality"));
        city.sendKeys("Edirne");

        WebElement state = driver.findElement(By.xpath("//input[@placeholder='State']"));
       state.sendKeys("Merkez");

        WebElement zipCode = driver.findElement(By.id("postal_code"));
        zipCode.sendKeys("22100");

        WebElement country = driver.findElement(By.id("country"));
        country.sendKeys("Turkey");


    }
    @Test
    public void test2Scroll() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/scroll");

    WebElement fullname = driver.findElement(By.id("name"));
    Actions actions = new Actions(driver);
    actions.moveToElement(fullname);
    fullname.sendKeys("Eva Peron");
    Thread.sleep(3000);
    WebElement date = driver.findElement(By.id("date"));
    date.sendKeys("01/03/2023");


        driver.close();

    }
    @Test
    public void test3SwitchToActiveWindow() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/switch-window");

        Thread.sleep(3000);

        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();

        String originalHandle = driver.getWindowHandle();

        for (String handle1 : driver.getWindowHandles()) {
            driver.switchTo().window(handle1);

        }

        Thread.sleep(5000);

        driver.switchTo().window(originalHandle);

        driver.quit();
    }
    @Test
    public void test5SwitchToAlert() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/switch-window");

        WebElement alertButton = driver.findElement(By.id("alert-button"));
        alertButton.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

}
    @Test
    public void test6Model() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/modal");

        WebElement modalButton = driver.findElement(By.id("modal-button"));
        modalButton.click();

        WebElement closeButton = driver.findElement(By.id("close-button"));
//        closeButton.click();

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", closeButton);

}
    @Test
    public void test7DragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/dragdrop");

        WebElement imageSource = driver.findElement(By.id("image"));

        WebElement boxTarget = driver.findElement(By.id("box"));
        Thread.sleep(3000);
        Actions actions = new Actions(driver);

         actions.dragAndDrop(imageSource, boxTarget).build().perform();

    }

}
