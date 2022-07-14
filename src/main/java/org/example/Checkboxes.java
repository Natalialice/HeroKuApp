package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Checkboxes extends BasePage {

    @Test
    public void checkCheckboxedChecaedOrUncecked() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> elements = driver.findElements(By.cssSelector("[type=checkbox]"));
        WebElement checkBox1 = elements.get(0);
        WebElement checkBox2 = elements.get(1);
        assertFalse(checkBox1.isSelected(), "The first checkbox is marked");
        assertTrue(checkBox2.isSelected(), "The first checkbox is unchecked");
        checkBox1.click();
        assertTrue(checkBox1.isSelected(), "The first checkbox is unchecked after the click");
        checkBox2.click();
        assertFalse(checkBox2.isSelected(), "The first checkbox is marked after the click");
    }
}
