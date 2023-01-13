package com.cydeo.tests;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dragAndDrop {



        @BeforeMethod
        public void setUpMethod() {

            Driver.getDriver().get("https://practice.cydeo.com");

        }

    @Test
    public void testDragAndDrop(){



      WebElement dragAndDrop = Driver.getDriver().findElement(By.linkText("Drag and Drop"));
      dragAndDrop.click();

     Actions actions = new Actions(Driver.getDriver());
     WebElement source = Driver.getDriver().findElement(By.id("column-a"));
     WebElement target = Driver.getDriver().findElement(By.id("column-b"));

     actions.dragAndDrop(source, target).perform();







          //  Driver.closeDriver();

        }
    }
