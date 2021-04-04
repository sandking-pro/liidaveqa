package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "j_username")
	private WebElement usrTxtBox;
	
	@FindBy(id = "j_password")
	private WebElement passTxtBox;
	
	@FindBy(id = "loginSubmit")
	private WebElement loginBtn;

	public WebElement getUsrTxtBox() {
		return usrTxtBox;
	}

	public void setUsrTxtBox(WebElement usrTxtBox) {
		this.usrTxtBox = usrTxtBox;
	}

	public WebElement getPassTxtBox() {
		return passTxtBox;
	}

	public void setPassTxtBox(WebElement passTxtBox) {
		this.passTxtBox = passTxtBox;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(WebElement loginBtn) {
		this.loginBtn = loginBtn;
	}

}
