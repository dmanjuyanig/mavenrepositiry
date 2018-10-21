package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WenGeneric 
{
	public static void waitForVisibilityAndClick(WebDriver driver, long time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		
		//Adding try-catch to avoid exception in framework and included assert.fail to fail the script if element is not visible.
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is Visible" , true);
		}
		catch (Exception e)
		{
			Reporter.log("Element is NOT Visible" , true);
		}
		
		element.click();
	}
	
	public static void VerifyURL(WebDriver driver, long time, String partialURL)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		try
		{
			wait.until(ExpectedConditions.urlContains(partialURL));
			Reporter.log("Required page is displayed" , true);
		}
		catch (Exception e)
		{
			Reporter.log("Required page is NOT displayed" , true);
		}
	}
}
