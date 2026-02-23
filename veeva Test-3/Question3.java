package SeleniumTest1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Question3 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://select2.github.io/examples.html");
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='select2-selection select2-selection--single']")));
        dropdown.click();
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='select2-search__field']")));
        searchBox.sendKeys("in");
        List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='select2-results__options']/li")));
        System.out.println("Suggestions are:");
        for (WebElement o:suggestions) {
            System.out.println(o.getText());
        }
        
    }
}