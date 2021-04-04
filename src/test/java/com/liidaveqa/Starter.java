package com.liidaveqa;

import java.util.concurrent.TimeUnit;

import org.base.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pojo.CreateLead;
import org.pojo.HomePage;
import org.pojo.LeadsPage;
import org.pojo.LoginPage;

import junit.framework.Assert;

public class Starter extends BaseClass {
	HomePage hp;
	LoginPage lp;
	LeadsPage leP;
	CreateLead cl;
	Boolean waitTillElement = null;
	
	@BeforeClass
	public static void initDriver() {
		BaseClass b = new BaseClass();
		b.getDriver();
		b.launchUrl("https://www.liidaveqa.com");
	}
	
	@Test
	public void tc0() {
		hp = new HomePage();
		
		btnClick(hp.getSigninbtn());
		
		timeOut(8);
		lp = new LoginPage();
		enterText(lp.getUsrTxtBox(), "lenproautomation8@lenqat.com");
		enterText(lp.getPassTxtBox(), "Community17");
		btnClick(lp.getLoginBtn());	
		
//		Assert.assertTrue("verify login", hp.getSigninSucc().getText().contains("lenproautomation8"));
		
	}
	
	@Test
	public void tc1() {
	
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		if(size > 2) {
		driver.switchTo().frame(3);
		}
		hp = new HomePage();
		btnClick(hp.getNavbutton());
		
		btnClick(hp.getSalestoolbtn());
	
		btnClick(hp.getPropasalbtn());

		try {
			timeOut(5);
		    
		    waitTillElement = waitTillElement();
		    
		    System.out.println(waitTillElement);
		    if(waitTillElement)
		    	btnClick(hp.getSelectleadbtn());
		    
		    
		    
		} catch (Exception ex) {
			btnClick(hp.getSelectleadbtn());
		    System.out.println(waitTillElement);
		} finally {
			timeOut(5);
		}
	}
	
	@Test
	public void tc2() {
		leP = new LeadsPage();
		btnClick(leP.getAddLeadBtn());
	}
	
	@Test
	public void tc3() {
		cl = new CreateLead();
		enterText(cl.getFnTxt(), "test");
		enterText(cl.getLnTxt(), "test");
		enterText(cl.getEmail(), "test"+Math.random()*3+"@gm.com");
		enterText(cl.getPhNo(), "98765"+Math.random()*5);
		btnClick(cl.getSaveBtn());
		
		timeOut(5);
		Assert.assertEquals("verified", driver.findElement(By.xpath("//li[contains(text(),\"Lead Saved Successfully\")]")).getText().contains("Lead Saved Successfully"));
		
	}
	

}
