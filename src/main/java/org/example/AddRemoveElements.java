package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElements extends BasePage {
    By addButtons = By.xpath("//button[text()='Add Element']");


    public List<WebElement> getAllElementsOnPage() {
        return driver.findElements(addButtons);
    }

    //добавить 2 элемента, удалить элемент, проверить количество элементов
    @Test
    public void addTwoElementsAndDeleteOneElement() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[2][text()='Delete']")).click();
        List<WebElement> allButtonOnPageAfterDelete = getAllElementsOnPage();
        Assert.assertEquals(allButtonOnPageAfterDelete.size(), 1, "One button has not been deleted");

    }
}
