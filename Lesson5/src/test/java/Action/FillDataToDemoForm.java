package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FillDataToDemoForm {
    public static void fillDataToDemoForm(WebDriver driver, String emailT, String firstnameT,
                                          String lastnameT, String companyT, String phonenumberT,
                                          String countryT, String interestT, String commentsT) {
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys(emailT);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
        firstName.sendKeys(firstnameT);

        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys(lastnameT);

        WebElement company = driver.findElement(By.id("Company"));
        company.sendKeys(companyT);

        WebElement phoneNumber = driver.findElement(By.id("Phone"));
        phoneNumber.sendKeys(phonenumberT);

        WebElement country = driver.findElement(By.id("Country"));
        Select countryOption = new Select(country);
        countryOption.selectByVisibleText(countryT);

        WebElement interest = driver.findElement(By.id("Solution_Interest__c"));
        Select interestOption = new Select(interest);
        interestOption.selectByVisibleText(interestT);

        WebElement comments = driver.findElement(By.id("Sales_Contact_Comments__c"));
        comments.sendKeys(commentsT);

    }
}
