package org.example.Pages;

import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleMain {
   private WebDriver driver;
   private WebDriverWait wait;
    public GoogleMain(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public GoogleMain goTo(){
        driver.get("https://www.google.com.ua/?hl=ru");
        return this;
    }
    public GoogleMain enterQuery(String query){
        WebElement queryField=driver.findElement(By.xpath("//input[contains(@class,'gLFyf gsfi')]"));
        queryField.sendKeys(query);
        return this;
    }

    public GoogleMain clickFindButton(){
        WebElement findButton= driver.findElement(By.xpath("//input[contains(@class,'gNO89b')]"));
        findButton.submit();
        return this;
    }
    public GoogleMain chooseSite(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Oleg')]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Oleg')]")));
        element.click();
        return this;
    }
}
