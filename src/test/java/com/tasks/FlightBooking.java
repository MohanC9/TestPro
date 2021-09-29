package com.tasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightBooking {
	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		WebDriverWait wait = new WebDriverWait(driver, 8);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id = 'ctl00_mainContent_ddl_originStation1_CTXT']")));
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		driver.findElement(By.cssSelector("input[id = 'ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.cssSelector("a[value='GOI']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@value='HYD'])[2]")));
		driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();
		//driver.findElement(By.cssSelector("input[id='ctl00_mainContent_view_date1']")).click();
		driver.findElement(By.linkText("10")).click();
		driver.findElement(By.linkText("17")).click();
		
		driver.findElement(By.id("divpaxinfo")).click();

		Select NoOfAdults = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		NoOfAdults.selectByValue("2");
		
		driver.findElement(By.id("divpaxinfo")).click();

		Select Currency = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		Currency.selectByValue("INR");
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type ='submit' and @id='ctl00_mainContent_btn_FindFlights' ]")));

		driver.findElement(By.xpath("//input[@type ='submit' and @id='ctl00_mainContent_btn_FindFlights' ]")).click();
		
		

		
		
	}

}
