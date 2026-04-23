package Action;

import Utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class ReadDataToForm {
    private static final String EXCEL_PATH = "src/test/java/DemoForm.xlsx";
    private static final String SHEET_NAME = "Sheet1";
    private static final String LOGIN_URL = "https://saucelabs.com/request-demo";

    public static void main(String[] args) {
        List<Map<String, String>> testData = ExcelUtils.readExcelData(EXCEL_PATH,SHEET_NAME);
        WebDriver driver = new ChromeDriver();
        try {
            for(Map<String, String> row : testData) {
                String email = row.get("Business Email");
                String firstName = row.get("First Name");
                String lastName = row.get("Last Name");
                String company = row.get("Company");
                String phone = row.get("Phone Number");
                String country = row.get("Country");
                String interest = row.get("Interest");
                String comments = row.get("Comments");

                System.out.println("Dien form voi cac thong tin tuong ung: " + email + " + " + firstName + " + "
                        + lastName + " + " + company + " + " + phone + " + " + country + " + " + interest + " + " + comments);
                OpenThePage.openThePage(driver, LOGIN_URL);
                FillDataToDemoForm.fillDataToDemoForm(driver, email, firstName, lastName, company, phone, country,
                        interest, comments);
                }
            } finally {
                driver.quit();

            }

    }
}
