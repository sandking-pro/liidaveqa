package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass {
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href=\"#navigation\"]")
	private WebElement navbutton;
	
	@FindBy(xpath="//a[text()=\"Sales Tools\"]")
	private WebElement salestoolbtn;
	
	@FindBy(xpath="//a[text()=\"Build a Proposal\"]")
	private WebElement propasalbtn;
	
	@FindBy(xpath="//a[text()=\"SELECT LEAD\"]")
	private WebElement selectleadbtn;
	
	@FindBy(xpath="//a[@href=\"/signin\"]")
	private WebElement signinbtn;
	
	@FindBy(className="signedin-user")
	private WebElement signinSucc;
	
	public WebElement getSigninSucc() {
		return signinSucc;
	}

	public void setSigninSucc(WebElement signinSucc) {
		this.signinSucc = signinSucc;
	}

	public WebElement getSigninbtn() {
		return signinbtn;
	}

	public void setSigninbtn(WebElement signinbtn) {
		this.signinbtn = signinbtn;
	}

	public WebElement getSelectleadbtn() {
		return selectleadbtn;
	}

	public void setSelectleadbtn(WebElement selectleadbtn) {
		this.selectleadbtn = selectleadbtn;
	}

	public WebElement getPropasalbtn() {
		return propasalbtn;
	}

	public void setPropasalbtn(WebElement propasalbtn) {
		this.propasalbtn = propasalbtn;
	}

	public WebElement getSalestoolbtn() {
		return salestoolbtn;
	}

	public void setSalestoolbtn(WebElement salestoolbtn) {
		this.salestoolbtn = salestoolbtn;
	}

	public WebElement getNavbutton() {
		return navbutton;
	}

	public void setNavbutton(WebElement navbutton) {
		this.navbutton = navbutton;
	}
	
}
