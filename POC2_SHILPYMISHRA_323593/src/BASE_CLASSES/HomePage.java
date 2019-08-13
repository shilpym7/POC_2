package BASE_CLASSES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver dr;
	@FindBy(xpath="//*[@class='ico-register']")
	WebElement regLink;
	@FindBy(xpath="//*[@class='ico-login']")
	WebElement loginLink;
	
	public HomePage(WebDriver dr) {
		this.dr =dr;
		PageFactory.initElements(dr, this);	
	}
	public String verifyTitle()
	{
		return dr.getTitle();
	}
	public String RegLink()
	{
		return regLink.getText();
	}
	public String LoginLink()
	{
		return loginLink.getText();
	}
}
