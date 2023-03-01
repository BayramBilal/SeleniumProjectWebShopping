package com.cydeo.tests;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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
    @Test
    public void test8RadioButtons() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/radiobutton");



        WebElement radioButton1 = driver.findElement(By.id("radio-button-1"));
        radioButton1.click();


        WebElement radioButton2 = driver.findElement(By.cssSelector("input[value='option2']"));
        radioButton2.click();


        WebElement radioButton3 = driver.findElement(By.cssSelector("input[value='option3']"));
         radioButton3.click();


        driver.quit();

    }
    @Test
    public void test9DatePicker() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/datepicker");
        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.sendKeys("01/03/2023");
       dateField.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
      driver.quit();
}
    @Test
    public void test10Dropdown() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/dropdown");
       WebElement dropdownMenu = driver.findElement(By.id("dropdownMenuButton"));
       dropdownMenu.click();
       WebElement autocompleteItem = driver.findElement(By.id("autocomplete"));
       autocompleteItem.click();
        Thread.sleep(3000);

        driver.quit();
}
    @Test
    public void test11FileUpload() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/fileupload");
        WebElement fileUploadField = driver.findElement(By.id("file-upload-field"));
        fileUploadField.sendKeys("upload.jpg");

}

    @Test
    public void test12FillTheForm() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/form");

        BrowserUtils.submitForm(driver);
        BrowserUtils.waitAlertBanner(driver);


        String expectedtext = "The form was successfully submitted!";

        System.out.println("actualText = " + getAlertBannerText(driver));

        Assert.assertEquals(getAlertBannerText(driver), expectedtext);

}

    public static String getAlertBannerText(WebDriver driver){

        String actualText = driver.findElement(By.className("alert")).getText();

        return actualText;
    }
}