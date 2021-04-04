package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void enterText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void btnClick(WebElement element) {
		element.click();
	}
	
	public void timeOut(int i){
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}
	public Boolean waitTillElement() {	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Boolean until = wait.until(new ExpectedCondition<Boolean>() {
		                    public Boolean apply(WebDriver driver) {                
		                        return  driver.findElements(By.xpath("//div[contains(@class, 'select-lead-model show')]")).size() == 0;                   
		                    }
		                });
		return until;
	}

	public void screenShot(String data) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "\\target\\" + data + ".png");
		FileUtils.copyFile(srcFile, destFile);
	}

	public void selectDropdown(WebElement dropdown, String text, String by) {
		Select sel = new Select(dropdown);
		if (by == "vt") {
			sel.selectByVisibleText(text);
		} else if (by == "val") {
			sel.selectByValue(text);
		} else {
			int indx = Integer.parseInt(text);
			sel.selectByIndex(indx);
		}
	}

	public String getAttributeText(WebElement element) {
		return element.getAttribute("value");
	}
	
	public void putExcelData(String pathName,String sheet,String data) throws IOException {
		File file =new File(pathName);
		FileInputStream stream =new FileInputStream(file);
		Workbook wb=new XSSFWorkbook(stream);
		Sheet sheet1 = wb.getSheet(sheet);
		int LastRowNum = sheet1.getLastRowNum();
		System.out.println(LastRowNum);
//		   for(int RowNum= 0;RowNum<LastRowNum-1;RowNum++){
//		      Row row2 = sheet1.getRow(RowNum);
		      
//		     for(int CellNum = 0; CellNum<row2.getLastCellNum();CellNum++){
//		       Cell cell2 = row2.getCell(CellNum);
//		       String TextInCell=row2.toString();
//		       if(TextInCell.contains("JUNI")){
//		        sheet1.shiftRows(RowNum+1, LastRowNum, -1);
//		        LastRowNum--;
//		        RowNum--;
//		        break;
//		       }
//		     }
//		   }
		
		Row row1 = sheet1.createRow(LastRowNum+1);
		Cell cell2 = row1.createCell(0);
		cell2.setCellValue(data);
		
		FileOutputStream fs  = new FileOutputStream(file);
		wb.write(fs);
		}
		
}
