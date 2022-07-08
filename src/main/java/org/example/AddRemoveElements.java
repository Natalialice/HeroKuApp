package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class AddRemoveElements {
    WebDriverManager chromedriver;
    WebDriver driver;
    By addButtons = By.xpath("//button[text()='Add Element']");
    By deleteButtons = By.xpath("//button[2][text()='Delete']");

    public List<WebElement> getAllElementsOnPage() {
        return driver.findElements(addButtons);
    }

    @BeforeMethod
    public void setUp() {
        //Initialize web driver and create driver instance
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Set up driver settings
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    //добавить 2 элемента, удалить элемент, проверить количество элементов
    @Test
    public void AddTwoElementsAndDeleteOneElement() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[2][text()='Delete']")).click();
        List<WebElement> allButtonOnPageAfterDelete = getAllElementsOnPage();
        Assert.assertEquals(allButtonOnPageAfterDelete.size(), 1, "One button has not been deleted");


    }
}
