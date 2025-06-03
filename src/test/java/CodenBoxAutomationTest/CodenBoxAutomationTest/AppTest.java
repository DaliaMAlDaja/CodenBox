package CodenBoxAutomationTest.CodenBoxAutomationTest;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.print.DocFlavor.STRING;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

	// chose radio button randomly
	@Test(priority = 1, enabled = true)
	public void RadioButton() {

		List<WebElement> allButtons = driver.findElements(By.className("radioButton"));
		int index = rand.nextInt(allButtons.size());
		allButtons.get(index).click();

	}

	@Test(priority = 2, enabled = true)
	public void DynamicDropdown() throws InterruptedException {
		WebElement CountryDropdown = driver.findElement(By.id("autocomplete"));
		int random = rand.nextInt(CountryPrefixes.length);

		CountryDropdown.sendKeys(CountryPrefixes[random]);
		Thread.sleep(1000);
		CountryDropdown.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

	}

	@Test(priority = 3, enabled = true)

	public void StaticDropdown()

	{

		WebElement StaticDropdown = driver.findElement(By.id("dropdown-class-example"));
		// StaticDropdown.click();
		Select Static_Dropdown = new Select(StaticDropdown);
		Static_Dropdown.selectByIndex(2);

	}

	@Test(priority = 4, enabled = true)
	public void Checkbox() {

		WebElement CheckboxDiv = driver.findElement(By.id("checkbox-example"));
		List<WebElement> checkBoxes = CheckboxDiv.findElements(By.tagName("input"));

		int firstIndex = rand.nextInt(checkBoxes.size());
		int secondIndex = rand.nextInt(checkBoxes.size());

		while (secondIndex == firstIndex) {
			secondIndex = rand.nextInt(checkBoxes.size());
		}

		WebElement firstCheckbox = checkBoxes.get(firstIndex);
		WebElement secondCheckbox = checkBoxes.get(secondIndex);

		if (firstCheckbox.isSelected() == false) {
			firstCheckbox.click();
		}

		if (secondCheckbox.isSelected() == false) {
			secondCheckbox.click();
		}

	}

	@Test(priority = 5, enabled = true)
	public void SwitchWindow() throws InterruptedException {
		WebElement SwitchWindow = driver.findElement(By.id("openwindow"));
		SwitchWindow.click();

		Set<String> handels = driver.getWindowHandles();
		List<String> windowslist = new ArrayList<>(handels);
		Thread.sleep(1000);
		driver.switchTo().window(windowslist.get(1));

		System.out.println(driver.getTitle());
		driver.switchTo().window(windowslist.get(0));
		System.out.println(driver.getTitle());

	}

	@Test(priority = 7, enabled = true)
	public void OpenTap() throws InterruptedException {
		WebElement OpenTap = driver.findElement(By.id("opentab"));

		OpenTap.click();
		Set<String> handels = driver.getWindowHandles();
		List<String> windowslist = new ArrayList<>(handels);
		Thread.sleep(1000);
		driver.switchTo().window(windowslist.get(1));

		System.out.println(driver.getTitle());
		driver.switchTo().window(windowslist.get(0));
		System.out.println(driver.getTitle());

	}

	@Test(priority = 8, enabled = true)
	public void SwitchToAlert() throws InterruptedException {

		WebElement SwitchToAlert = driver.findElement(By.id("name"));

		SwitchToAlert.sendKeys("Dalia");
		driver.findElement(By.id("alertbtn")).click();

		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);

		driver.findElement(By.id("name")).sendKeys("DALIA");
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(1000);

		driver.switchTo().alert().dismiss();

	}

	@Test(priority = 9, enabled = true)

	public void webTable() {
		WebElement thetable = driver.findElement(By.id("product"));
		thetable.findElements(By.tagName("td"));

		List<WebElement> alldata = thetable.findElements(By.tagName("td"));
		for (int i = 0; i < alldata.size(); i++)

			System.out.println(alldata.get(i).getText());

	}

	@Test(priority = 10, enabled = true)
	public void thecrows() {
		WebElement table = driver.findElement(By.id("product"));
		List<WebElement> ROWS = table.findElements(By.tagName("tr"));
		for (int i = 0; i < ROWS.size(); i++)
			System.out.println(ROWS.get(i).getText());

	}

	@Test(priority = 11, enabled = true)

	public void HideandShow() throws InterruptedException {

		WebElement HideandShow = driver.findElement(By.id("displayed-text"));
		HideandShow.sendKeys("Hello");
		WebElement Hidebtn = driver.findElement(By.id("hide-textbox"));
		Hidebtn.click();
		Thread.sleep(2000);
		WebElement Showbox = driver.findElement(By.id("show-textbox"));
		Showbox.click();

		Assert.assertEquals(Showbox.isDisplayed(), true);
	}

	@Test(priority = 12, enabled = true)
	public void MouseHover() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1800)");

		Actions action = new Actions(driver);
		WebElement MouseHover = driver.findElement(By.id("mousehover"));
		Thread.sleep(1000);

		action.moveToElement(MouseHover).build().perform();
		Thread.sleep(2000);
		WebElement top = driver.findElement(By.linkText("Top"));
		top.click();
		Thread.sleep(2000);

		js.executeScript("window.scrollTo(0,1800)");
		Thread.sleep(2000);

		action.moveToElement(MouseHover).build().perform();
		Thread.sleep(2000);
		WebElement reload = driver.findElement(By.linkText("Reload"));
		reload.click();

	}

	@Test(priority = 13, enabled = false)
	public void Calendar() throws InterruptedException {

		WebElement CalendarBtn = driver.findElement(By.linkText("Booking Calendar"));
		CalendarBtn.click();

		Set<String> handels = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(handels);
		driver.switchTo().window(windowList.get(1));
		Thread.sleep(1000);
		System.out.println(driver.getTitle());

		WebElement theTable = driver.findElement(By.cssSelector(".datepick.wpbc_calendar"));
		List<WebElement> allDates = theTable.findElements(By.tagName("td"));
		Thread.sleep(1000);

		for (int i = 0; i < allDates.size(); i++) {
			String calendar = allDates.get(i).getText();
			System.out.println(calendar);

		}
	}

	@Test(priority = 14, enabled = true)
	public void Iframe() throws InterruptedException {

		driver.switchTo().frame("courses-iframe");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,4500)");
		Thread.sleep(3000);
		WebElement BurgerMenu = driver.findElement(By.id("ct-menu-mobile"));
		BurgerMenu.click();
		driver.switchTo().defaultContent();

	}

	@Test(priority = 15,invocationCount = 5)
	public void DownloadApkFileandScreenShot() throws InterruptedException, IOException {
		Thread.sleep(1500);
		WebElement DownloadBtn = driver.findElement(By.linkText("Download Apk files"));

		DownloadBtn.click();

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		String mydate = new Date().toString().replace(":", "_");
		System.out.println(mydate);
		Thread.sleep(1000);

		String path = System.getProperty("user.dir") + "/src/test/ScreenShot/" + mydate + ".png";
		File DestFile = new File(path);
		FileUtils.copyFile(SrcFile, DestFile);

	}
}
