package BASE_CLASSES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
WebDriver dr;
@FindBy(xpath="//*[@class='header-links']/ul/li[1]/a[1]")
WebElement emailid;
@FindBy(xpath="//*[@class='ico-logout']")
WebElement logoutLink;
public MyAccount(WebDriver dr)
{
	this.dr =dr;
	PageFactory.initElements(dr, this);	
}
public String verifyTitle()
{
	return dr.getTitle();
}
public String verifyEmail()
{
	return emailid.getText();
}
public void logout()
{
logoutLink.click();
}
}
