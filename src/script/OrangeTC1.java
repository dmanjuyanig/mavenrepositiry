package script;

import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Utility;
import generic.WenGeneric;
import page.DashBoardPage;
import page.LoginPage;


public class OrangeTC1 extends BaseTest
{
	@Test (priority =1, groups = {"smoke"})
	public void testA() throws InterruptedException
	{
		//take the input data from excel file
		String un=Utility.getXLData(DATA_PATH,"DemoA",1,0);
		String pw=Utility.getXLData(DATA_PATH, "DemoA", 1,1);
		
		String homepageURL=Utility.getXLData(DATA_PATH,"DemoA",1,2);
		String loginpageURL=Utility.getXLData(DATA_PATH, "DemoA", 1,3);
		
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		l.setPassword(pw);
		l.clickLogin();
		//verify that dashboard page is displayed.
		WenGeneric.VerifyURL(driver, lngETO, homepageURL);
		
		
		//click welcome -> logout
		DashBoardPage d = new DashBoardPage(driver);
		d.clickWelcome();
		d.clickLogout(lngETO);
		//verify that login page is displayed
		WenGeneric.VerifyURL(driver, lngETO, loginpageURL);
		
		}
}
