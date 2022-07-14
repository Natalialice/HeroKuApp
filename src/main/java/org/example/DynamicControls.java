package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControls extends BasePage {

    @Test
    public void waitTitle() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement element = driver.findElement(By.xpath("//form[@id='input-example']/input"));
        Assert.assertFalse(element.isEnabled());
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']/input")));
        Assert.assertTrue(element.isEnabled());
    }
}


