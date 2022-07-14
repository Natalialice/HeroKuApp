package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OnlinerTestJavaScriptExecutor extends BasePage {

    @Test
    public void javaScriptExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.onliner.by/");
        js.executeScript("window.scrollTo(0,100)");
        WebElement element = driver.findElement(By.xpath("//a[text()='Все новости об автомобилях']"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);",element);
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
        WebElement bottomElement = driver.findElement(By.xpath("//a[text()='Все разделы форума']"));
        js.executeScript("arguments[0].scrollIntoView(true);", bottomElement);
    }
}
