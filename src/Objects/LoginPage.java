package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
 public LoginPage(WebDriver driver) {
	 
	 this.driver=driver;
	 
 }
 By signIn=By.xpath("//a[contains(text(),'Sign in')]");
 By userName=By.xpath("//input[@id='login1']");
 By password=By.xpath("//input[@id='password']");
 By login=By.xpath("//input[@type='submit']");
 
 public  WebElement signingIn() {
	 return driver.findElement(signIn);
 }
 
 public  WebElement userNamevalue() {
	 return driver.findElement(userName);
 }
 
 public  WebElement password() {
	 return driver.findElement(password);
 }
 
 public  WebElement loginButton() {
	 return driver.findElement(login);
 }
}
