package CodenBoxAutomationTest.CodenBoxAutomationTest;

import java.io.File;
import java.io.IOException;
import java.util.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

    WebDriver driver = new ChromeDriver();
    String URL = "https://codenboxautomationlab.com/practice/";
    Random rand = new Random();
    String[] CountryPrefixes = { "JO", "Ca", "Us", "FR", "DE", "IT" };

    @BeforeTest
    public void SetUp() {
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void RadioButton() {
        List<WebElement> allButtons = driver.findElements(By.className("radioButton"));
        int index = rand.nextInt(allButtons.size());
        allButtons.get(index).click();
        Assert.assertTrue(allButtons.get(index).isSelected());
    }

    @Test(priority = 2)
    public void DynamicDropdown() throws InterruptedException {
        WebElement CountryDropdown = driver.findElement(By.id("autocomplete"));
        CountryDropdown.sendKeys(CountryPrefixes[rand.nextInt(CountryPrefixes.length)]);
        Thread.sleep(1000);
        CountryDropdown.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
    }

    @Test(priority = 3)
    public void StaticDropdown() {
        WebElement StaticDropdown = driver.findElement(By.id("dropdown-class-example"));
        Select Static_Dropdown = new Select(StaticDropdown);
        Static_Dropdown.selectByIndex(2);
        Assert.assertEquals(Static_Dropdown.getFirstSelectedOption().getText(), "Appium");
    }

    @Test(priority = 4)
    public void Checkbox() {
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("#checkbox-example input[type='checkbox']"));
        int first = rand.nextInt(checkBoxes.size());
        int second;
        do {
            second = rand.nextInt(checkBoxes.size());
        } while (second == first);

        checkBoxes.get(first).click();
        checkBoxes.get(second).click();

        Assert.assertTrue(checkBoxes.get(first).isSelected());
        Assert.assertTrue(checkBoxes.get(second).isSelected());
    }

    @Test(priority = 5)
    public void SwitchWindow() throws InterruptedException {
        driver.findElement(By.id("openwindow")).click();
        Set<String> windows = driver.getWindowHandles();
        List<String> list = new ArrayList<>(windows);
        Thread.sleep(1000);
        driver.switchTo().window(list.get(1));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(list.get(0));
    }

    @Test(priority = 6)
    public void OpenTab() throws InterruptedException {
        driver.findElement(By.id("opentab")).click();
        Set<String> tabs = driver.getWindowHandles();
        List<String> tabList = new ArrayList<>(tabs);
        Thread.sleep(1000);
        driver.switchTo().window(tabList.get(1));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(tabList.get(0));
    }

    @Test(priority = 7)
    public void SwitchToAlert() throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys("Dalia");
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(500);
        driver.switchTo().alert().accept();
        Thread.sleep(500);

        driver.findElement(By.id("name")).sendKeys("DALIA");
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(500);
        driver.switchTo().alert().dismiss();
    }

    @Test(priority = 8)
    public void WebTable() {
        List<WebElement> data = driver.findElements(By.cssSelector("#product td"));
        data.forEach(cell -> System.out.println(cell.getText()));
        Assert.assertFalse(data.isEmpty());
    }
    
    @Test(priority = 9)
    public void PrintTableRows() {
        List<WebElement> rows = driver.findElements(By.cssSelector("#product tr"));
        rows.forEach(row -> System.out.println(row.getText()));
        Assert.assertFalse(rows.isEmpty());
    }

    @Test(priority = 10)
    public void HideAndShowTextbox() throws InterruptedException {
        WebElement textbox = driver.findElement(By.id("displayed-text"));
        textbox.sendKeys("Hello");
        driver.findElement(By.id("hide-textbox")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("show-textbox")).click();
        Thread.sleep(1000);
        Assert.assertTrue(textbox.isDisplayed());
    }

    @Test(priority = 11)
    public void MouseHover() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,1800)");
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(By.id("mousehover"));
        actions.moveToElement(hover).perform();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Top")).click();
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0,1800)");
        actions.moveToElement(hover).perform();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Reload")).click();
    }

    @Test(priority = 12)
    public void IframeTest() throws InterruptedException {
        driver.switchTo().frame("courses-iframe");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,4500)");
        Thread.sleep(2000);
        driver.findElement(By.id("ct-menu-mobile")).click();
        driver.switchTo().defaultContent();
    }

    @Test(priority = 13, invocationCount = 5)
    public void DownloadApkFileAndScreenshot() throws InterruptedException, IOException {
        Thread.sleep(1000);
        driver.findElement(By.linkText("Download Apk files")).click();

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        String timestamp = new Date().toString().replace(":", "_").replace(" ", "_");
        String path = System.getProperty("user.dir") + "/src/test/ScreenShot/" + timestamp + ".png";
        File destFile = new File(path);
        FileUtils.copyFile(srcFile, destFile);
        Assert.assertTrue(destFile.exists());
    }
    @AfterTest
    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
