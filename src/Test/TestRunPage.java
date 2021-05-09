package Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Objects.ItemsPage;
import Objects.LoginPage;

public class TestRunPage {

	@SuppressWarnings("deprecation")
	@Test
	public void loggingInReddif() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome_89\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();

		LoginPage rd = new LoginPage(driver);
		rd.signingIn().click();
		rd.userNamevalue().sendKeys("krcharan");
		rd.password().sendKeys("password");
		rd.loginButton().click();
		ItemsPage it = new ItemsPage(driver);
		it.rediffLinkText().click();
		driver.switchTo().frame("moneyiframe");
//		Actions act=new Actions(driver);
//		act.moveToElement(it.searchItemsInRediff());
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(it.searchItemsInRediff()));
		it.searchItemsInRediff().click();
		it.searchItemsInRediff().sendKeys(Keys.chord("tcs",Keys.ENTER));
		Thread.sleep(2000);
//		it.rediffLinkText().sendKeys(Keys.ENTER);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iw = windows.iterator();
		String pageOne = iw.next();
		String pageTwo = iw.next();
		driver.switchTo().window(pageTwo);
		System.out.println("page title is"+driver.getTitle());
		String firstcmpnyname=it.firstCompany().getText(); 
		System.out.println("2nd page first company name is "+firstcmpnyname);
		driver.switchTo().window(pageOne);
		it.serchwordwoxfinals().sendKeys(Keys.chord(firstcmpnyname,Keys.ENTER));
		System.out.println("navigated to 2 windows");
		
	}

}
