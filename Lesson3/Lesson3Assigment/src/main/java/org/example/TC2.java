package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TC2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://saucelabs.com/request-demo");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement letTalkBtn = webDriver.findElement(By.xpath("//button[text()=\"Let's Talk\"]"));
        letTalkBtn.click();
        Thread.sleep(3000);


        WebElement email = webDriver.findElement(By.id("Email"));
        email.sendKeys("mailan1234@gmail.com");
        Thread.sleep(2000);
        letTalkBtn.click();

        WebElement lastName = webDriver.findElement(By.id("LastName"));
        lastName.sendKeys("Lan");

        WebElement company = webDriver.findElement(By.id("Company"));
        company.sendKeys("This is company");

        WebElement phoneNumber = webDriver.findElement(By.id("Phone"));
        phoneNumber.sendKeys("00923452");

        WebElement country = webDriver.findElement(By.id("Country"));
        Select countryOption = new Select(country);
        countryOption.selectByVisibleText("Austria");

        WebElement interest = webDriver.findElement(By.id("Solution_Interest__c"));
        Select interestOption = new Select(interest);
        interestOption.selectByVisibleText("Visual Testing");

        WebElement comments = webDriver.findElement(By.id("Sales_Contact_Comments__c"));
        comments.sendKeys("This is comment");


        WebElement tickBox = webDriver.findElement(By.id("mktoCheckbox_47709_0"));
        if(!tickBox.isSelected()) {
            tickBox.click();
        }

        Thread.sleep(2000);
        letTalkBtn.click();

        Thread.sleep(3000);
        webDriver.quit();
    }
}
