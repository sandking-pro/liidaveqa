package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLead extends BaseClass{

	public CreateLead() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstName")
	private WebElement fnTxt;
	
	@FindBy(id="lastName")
	private WebElement lnTxt;
	
	@FindBy(id="phNo")
	private WebElement phNo;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(xpath="//button//span[contains(text(),'SAVE LEAD')]")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getFnTxt() {
		return fnTxt;
	}

	public void setFnTxt(WebElement fnTxt) {
		this.fnTxt = fnTxt;
	}

	public WebElement getLnTxt() {
		return lnTxt;
	}

	public void setLnTxt(WebElement lnTxt) {
		this.lnTxt = lnTxt;
	}

	public WebElement getPhNo() {
		return phNo;
	}

	public void setPhNo(WebElement phNo) {
		this.phNo = phNo;
	}

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(WebElement email) {
		this.email = email;
	}
	

}
