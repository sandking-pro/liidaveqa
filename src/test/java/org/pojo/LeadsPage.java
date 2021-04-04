package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage extends BaseClass{
	public LeadsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a//span[contains(text(),\"ADD LEAD\")])[2]")
	private WebElement addLeadBtn;

	public WebElement getAddLeadBtn() {
		return addLeadBtn;
	}

	public void setAddLeadBtn(WebElement addLeadBtn) {
		this.addLeadBtn = addLeadBtn;
	}

}
