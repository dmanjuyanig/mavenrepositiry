package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WenGeneric;

public class DashBoardPage 
{
	private WebDriver driver;
	
	@FindBy(id="welcome")
	private WebElement Welcome;
	
	@FindBy(xpath="//*[@id=\"welcome-menu\"]/ul/li[2]/a")
	private WebElement Logout;
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickWelcome(){
		Welcome.click();
	}
	
	public void clickLogout(long time)
	{
		WenGeneric.waitForVisibilityAndClick(driver, time, Logout);		
	}
}
