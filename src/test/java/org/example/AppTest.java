package org.example;

import org.example.Pages.GoogleMain;
import org.example.Pages.GoogleResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    WebDriver driver;
    @BeforeEach
    public  void setup(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromeSource\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.google.com.ua/?hl=ru");
    }
    @Test
    public void shouldAnswerWithTrue() {
       GoogleMain googleMain= PageFactory.initElements(driver,GoogleMain.class);
        googleMain.enterQuery("Oleg");
       googleMain.clickFindButton();
        googleMain.chooseSite();
        GoogleResult googleResult=PageFactory.initElements(driver,GoogleResult.class);
       String actual= googleResult.getUrl();
        String expected = "https://en.wikipedia.org/wiki/Oleg#People_named_Oleg";
        Assertions.assertEquals(expected, actual);
    }
}
