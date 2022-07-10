package example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTests {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testGithub() {
        String url = "https://github.com";
        driver.get(url);
        assertThat(driver.getTitle()).isEqualTo("GitHub: Where the world builds software · GitHub");
    }

    @Test
    void testHtmlPage() {
        driver.get("C:\\Users\\Win10Pro\\workspace_idea\\HW-5_Tests\\src\\test\\resources\\page.html");
        driver.findElement(By.id("username")).sendKeys("incognito");
        driver.findElement(By.id("email")).sendKeys("incognito@email.com");
        WebElement male = driver.findElement(By.id("male"));
        male.click();
        assertThat(male.isSelected());
        WebElement dogs = driver.findElement(By.id("loveDogs"));
        dogs.click();
        assertThat(dogs.isSelected());
        assertThat(!driver.findElement(By.id("loveCats")).isSelected());
        driver.findElement(By.tagName("form")).submit();
        assertThat(driver.switchTo().alert().getText()).isEqualTo("Form submitted!");
    }

    @Test
    void testScreenshot() throws IOException {
        driver.get("C:\\Users\\Win10Pro\\workspace_idea\\HW-5_Tests\\src\\test\\resources\\page.html");
        WebElement form = driver.findElement(By.tagName("form"));
        File screenshot = form.getScreenshotAs(OutputType.FILE);
        Path image = Paths.get("screenshot.png");
        Files.move(screenshot.toPath(), image, REPLACE_EXISTING);
        assertThat(image).exists();
    }
}
