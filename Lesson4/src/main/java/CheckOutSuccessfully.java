import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

class Product {
    String name;
    String price;

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

public class CheckOutSuccessfully {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        //Step 1: Login to https://www.saucedemo.com/
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Step 2: Sort by Price (low to high)
        WebElement sortBtn = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select sortSelection = new Select(sortBtn);
        Thread.sleep(3000);
        sortSelection.selectByValue("lohi");
        Thread.sleep(3000);

        //Step 3: Add to cart 2 random items
        List<WebElement> addToCartBtns = driver.findElements(By.xpath("//div[@class='pricebar']//child::button[contains(@id, 'add-to-cart')]"));
        List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='pricebar']//ancestor::div[@class=\"inventory_item_description\"]//descendant::div[contains(@class, \"name\")]"));
        List<WebElement> productPrices = driver.findElements(By.xpath("//div[@class='pricebar']//child::div"));
        Product product1 = new Product();
        Product product2 = new Product();

        if (addToCartBtns == null) {
            System.out.println("All items has been added to cart");
        }
        else if(addToCartBtns.size() == 1) {
            System.out.println("Not enough 2 products in order to add to cart");
        } else {
        Random random = new Random();
        int random1 = random.nextInt(addToCartBtns.size());

        product1.setName(productNames.get(random1).getText());
        product1.setPrice(productPrices.get(random1).getText());

        addToCartBtns.get(random1).click();
        Thread.sleep(3000);
            int random2 = random.nextInt(addToCartBtns.size());
        while (random2 == random1) {
            random2 = random.nextInt(addToCartBtns.size());
        };

        product2.setName(productNames.get(random2).getText());
        product2.setPrice(productPrices.get(random2).getText());
        addToCartBtns.get(random2).click();
        System.out.println("2 items have been added to the Cart successfully");
        }
        Thread.sleep(3000);

        //Step 4: Click on Cart icon
        WebElement cartBtn = driver.findElement(By.xpath("//div[@id=\"shopping_cart_container\"]//child::a"));
        cartBtn.click();
        List<WebElement> addedPdNames = driver.findElements(By.xpath("//div[@class=\"inventory_item_name\"]"));
        List<WebElement> addedPdPrices = driver.findElements(By.xpath("//div[@class=\"inventory_item_price\"]"));

        for(int i=0; i < addedPdNames.size(); i++) {
            if(addedPdNames.get(i).getText().equalsIgnoreCase(product1.getName())
                    || addedPdNames.get(i).getText().equalsIgnoreCase(product2.getName())) {
                System.out.println("Product information: Name = " + addedPdNames.get(i).getText() + ", Price = " + addedPdPrices.get(i).getText());
            }
        }
        Thread.sleep(3000);

        //Step 5: Click Checkout button, Input Last name, First name, Zip code
        WebElement checkoutBtn = driver.findElement(By.id("checkout"));
        checkoutBtn.click();

        WebElement firstNameTxt = driver.findElement(By.id("first-name"));
        firstNameTxt.sendKeys("Mai");

        WebElement lastNameTxt = driver.findElement(By.id("last-name"));
        lastNameTxt.sendKeys("Lan");

        WebElement postalCodeTxt = driver.findElement(By.id("postal-code"));
        postalCodeTxt.sendKeys("X00342-34");
        Thread.sleep(3000);

        //Step 6: Click Continue button
        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();
        List<WebElement> checkoutPdNames = driver.findElements(By.xpath("//div[@class=\"inventory_item_name\"]"));
        List<WebElement> checkoutPdPrices = driver.findElements(By.xpath("//div[@class=\"inventory_item_price\"]"));
        List<WebElement> checkoutPdQtys = driver.findElements(By.xpath("//div[@class=\"cart_quantity\"]"));

        double price1 = Double.parseDouble(product1.getPrice().replaceAll("[^0-9].", ""));
        double price2 = Double.parseDouble(product2.getPrice().replaceAll("[^0-9.]", ""));
        double totalOfItems = price1 + price2;
        double tax = totalOfItems * 8 / 100;
        double totalPaid = totalOfItems + tax;

        for(int i=0; i<checkoutPdNames.size(); i++) {
            System.out.println("Checkout item information: Name = " + checkoutPdNames.get(i).getText() + ", Quantity = " + checkoutPdQtys.get(i).getText()
            + ", Price = " + checkoutPdPrices.get(i).getText());
        }

        WebElement shippingInfo = driver.findElement(By.xpath("//div[text() = \"Shipping Information:\"]//following::div[contains(text(), \"Delivery\")]"));
        System.out.println("Shipping information: " + shippingInfo.getText());

        WebElement itemTotal = driver.findElement(By.xpath("//div[text() = \"Shipping Information:\"]//following::div[contains(text(), \"Item\")]"));
        WebElement itemTax = driver.findElement(By.xpath("//div[@class=\"summary_tax_label\"]"));
        double acItemTotal = Double.parseDouble(itemTotal.getText().replaceAll("[^0-9.]", ""));
        double acTaxItem = Double.parseDouble(itemTax.getText().replaceAll("[^0-9.]", ""));
        if(totalOfItems == acItemTotal && tax == acTaxItem) {
            System.out.println("The total of items: " + itemTotal.getText() + " and Tax: " + itemTax.getText());
        } else {
            System.out.println("Incorrect item total");
        }

        WebElement finishBtn = driver.findElement(By.id("finish"));
        if(finishBtn.isDisplayed()) {
            System.out.println("Finish button is displayed");
            finishBtn.click();
        }
        Thread.sleep(3000);

        //Step 7: Checkout successfully
        WebElement thanksTxt = driver.findElement(By.xpath("//h2[contains(@class, \"complete\")]"));
        System.out.println(thanksTxt.getText());

        WebElement messageTxt = driver.findElement(By.xpath("//div[contains(@class, \"complete-text\")]"));
        System.out.println(messageTxt.getText());

        WebElement backHomeBtn = driver.findElement(By.id("back-to-products"));
        if(backHomeBtn.isDisplayed()) {
            System.out.println("Back Home button is displayed");
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
