package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com");

        WebElement userName = webDriver.findElement(By.xpath("//input[@id=\"user-name\"]"));
        WebElement passWord = webDriver.findElement(By.xpath("//input[@id=\"password\"]"));
        WebElement loginButton = webDriver.findElement(By.xpath("//input[@id=\"login-button\"]"));

        userName.sendKeys("standard_user");
        passWord.sendKeys("secret_sauce");
        loginButton.click();

        //Common items
        WebElement logo = webDriver.findElement(By.xpath("//div[@class='app_logo']"));
        WebElement title = webDriver.findElement(By.xpath("//span[@class='title']"));
        WebElement shoppingCartIcon = webDriver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        WebElement menuIcon = webDriver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));

        //Your cart screen
        //Sauce Labs Bike Light
        WebElement bikeLightName = webDriver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));

        WebElement bikeLightDescription = webDriver.findElement(By.xpath("//div[contains(text(),'A red light isn')]"));

        WebElement bikeLightPrice = webDriver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item_label']//div[@class='inventory_item_price']"));

        WebElement bikeLightRemoveBtn = webDriver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item_label']//button[@id='remove-sauce-labs-bike-light']"));

        //Sauce Labs Bolt T-Shirt
        WebElement boltShirtName = webDriver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));

        WebElement boltShirtDescription = webDriver.findElement(By.xpath("//div[contains(text(),'A red light isn')]"));

        WebElement boltShirtPrice = webDriver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']/ancestor::div[@class='cart_item_label']//div[@class='inventory_item_price']"));

        WebElement boltShirtRemoveBtn = webDriver.findElement(By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']"));

        //Sauce Labs Backpack
        WebElement backpackName = webDriver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));

        WebElement backpackDescription = webDriver.findElement(By.xpath("//div[contains(text(),'carry.allTheThings')]"));

        WebElement backpackPrice = webDriver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item_label']//div[@class='inventory_item_price']"));

        WebElement backpackRemoveBtn = webDriver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));

        //Sauce Labs Fleece Jacket
        WebElement fleeceName = webDriver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));

        WebElement fleeceDescription = webDriver.findElement(By.xpath("//div[contains(text(),'midweight quarter-zip fleece')]"));

        WebElement fleecePrice = webDriver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item_label']//div[@class='inventory_item_price']"));

        WebElement fleeceRemoveBtn = webDriver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));

        //Sauce Labs Onesie
        WebElement onesieName = webDriver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']"));

        WebElement onesieDescription = webDriver.findElement(By.xpath("//div[contains(text(),'Rib snap infant onesie')]"));

        WebElement onesiePrice = webDriver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']/ancestor::div[@class='cart_item_label']//div[@class='inventory_item_price']"));

        WebElement onesieRemoveBtn = webDriver.findElement(By.xpath("//button[@id='remove-sauce-labs-onesie']"));

        //Test.allTheThings() T-Shirt (Red)
        WebElement redShirtName = webDriver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']"));

        WebElement redShirtDescription = webDriver.findElement(By.xpath("//div[contains(text(),'This classic Sauce Labs t-shirt')]"));

        WebElement redShirtPrice = webDriver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']/ancestor::div[@class='cart_item_label']//div[@class='inventory_item_price']"));

        WebElement redShirtRemoveBtn = webDriver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']"));

        //Buttons
        WebElement continueShoppingBtn = webDriver.findElement(By.xpath("//button[@id='continue-shopping']"));
        WebElement checkoutBtn = webDriver.findElement(By.xpath("//button[@id='checkout']"));

        //Checkout: your information
        WebElement firstNameInput = webDriver.findElement(By.xpath("//input[@id='first-name']"));
        WebElement lastNameInput = webDriver.findElement(By.xpath("//input[@id='last-name']"));
        WebElement postalCodeInput = webDriver.findElement(By.xpath("//input[@id='postal-code']"));

        WebElement cancelBtn = webDriver.findElement(By.xpath("//button[@id='cancel']"));
        WebElement continueBtn = webDriver.findElement(By.xpath("//button[@id='continue']"));

        //Checkout: Overview
        WebElement paymentInfoText = webDriver.findElement(By.xpath("//div[@class='summary_info']/div[text()='Payment Information:']"));
        WebElement paymentInfoValue = webDriver.findElement(By.xpath("//div[text()='Payment Information:']/following::div[contains(text(),'SauceCard')]"));

        WebElement shippingInfoText = webDriver.findElement(By.xpath("//div[@class='summary_info']/div[text()='Shipping Information:']"));
        WebElement shippingInfoValue = webDriver.findElement(By.xpath("//div[text()='Shipping Information:']/following::div[contains(text(),'Delivery!')]"));

        WebElement priceTotalText = webDriver.findElement(By.xpath("//div[@class='summary_info']/div[text()='Price Total']"));

        WebElement itemTotal = webDriver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        WebElement tax = webDriver.findElement(By.xpath("//div[@class='summary_tax_label']"));
        WebElement total = webDriver.findElement(By.xpath("//div[@class='summary_total_label']"));

        WebElement overviewCancelBtn = webDriver.findElement(By.xpath("//button[@id='cancel']"));
        WebElement finishBtn = webDriver.findElement(By.xpath("//button[@id='finish']"));

        //Checkout: Completed
        WebElement completeImage = webDriver.findElement(By.xpath("//img[@class='pony_express']"));
        WebElement completeHeader = webDriver.findElement(By.xpath("//h2[@class='complete-header']"));
        WebElement completeText = webDriver.findElement(By.xpath("//div[@class='complete-text']"));
        WebElement backHomeBtn = webDriver.findElement(By.xpath("//button[@id='back-to-products']"));




        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        webDriver.quit();
    }
}