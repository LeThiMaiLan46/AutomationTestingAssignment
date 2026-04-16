package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TC1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("mailan1234@gmail.com");

        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Mai");

        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Lan");

        WebElement company = driver.findElement(By.id("Company"));
        company.sendKeys("This is company");

        WebElement phoneNumber = driver.findElement(By.id("Phone"));
        phoneNumber.sendKeys("00923452");

        WebElement country = driver.findElement(By.id("Country"));
        Select countryOption = new Select(country);
        countryOption.selectByVisibleText("Austria");

        WebElement interest = driver.findElement(By.id("Solution_Interest__c"));
        Select interestOption = new Select(interest);
        interestOption.selectByVisibleText("Visual Testing");

        WebElement comments = driver.findElement(By.id("Sales_Contact_Comments__c"));
        comments.sendKeys("This is comment");

        WebElement tickBox = driver.findElement(By.id("mktoCheckbox_47709_0"));
        if(!tickBox.isSelected()) {
            tickBox.click();
        }

        WebElement letTalkBtn = driver.findElement(By.xpath("//button[text()=\"Let's Talk\"]"));
        Thread.sleep(3000);
        letTalkBtn.click();

        Thread.sleep(3000);
        driver.quit();
    }
}