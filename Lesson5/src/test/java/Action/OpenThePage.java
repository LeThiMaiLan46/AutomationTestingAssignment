package Action;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class OpenThePage {
    public static void openThePage(WebDriver driver, String url) {
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
