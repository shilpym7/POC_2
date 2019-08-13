package BASE_CLASSES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver dr;
	@FindBy(xpath="//*[@class='ico-login']")
	WebElement loginLink;
	@FindBy(xpath="//*[@id='Email']")
	WebElement mailText;
	@FindBy(xpath="//*[@id='Password\']")
	WebElement pwdText;
	@FindBy(xpath="//*[@class='form-fields']/form/div[5]/input")
	WebElement loginbtn;
	
	public Login(WebDriver dr) {
		this.dr =dr;
		PageFactory.initElements(dr, this);	
	}
	public void userlogin(String email,String pwd)
	{
		loginLink.click();
	mailText.sendKeys(email);
	pwdText.sendKeys(pwd);
    loginbtn.click();
	}
	public String verifyTitle()
	{
		loginLink.click();
		return dr.getTitle();
	}
	
}
