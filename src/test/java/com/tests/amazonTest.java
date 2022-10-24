package com.tests;

import static com.codeborne.selenide.Selenide.*;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import static com.codeborne.selenide.Condition.*;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Selected;
import com.pages.HamburgerMenupage;
//HamburgerMenupage;
import com.pages.Homepage;
import com.pages.ProductdetailsPage;
import com.pages.Resultspage;
import com.utils.JSONData;

import org.json.JSONObject;
import org.json.JSONTokener;


@SuppressWarnings("unused")
public class amazonTest{
	
	InputStream inputstream;
	public static Properties props;
	JSONData testData = new JSONData();
	
	@BeforeMethod
	public void beforeMethod() {
		
	}

	@AfterMethod
	public void afterMethod() {
		Selenide.closeWebDriver();
	}

	@BeforeTest
	public void beforeTest()
	{
	  try {
		props=new Properties();
		String propFilename="config.properties";
		inputstream=getClass().getClassLoader().getResourceAsStream(propFilename);
		props.load(inputstream);
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	}
	
	@AfterTest
	public void afterTest()
	{
		try {
		 if(inputstream!=null)
		  {
			  inputstream.close();
		  }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	@Test
	public void testProduct() throws Exception 
	{
		Homepage homepage = new Homepage();
		homepage.openAmazon(props.getProperty("baseURL"));
		wait(5);
		refresh();
		wait(5);
		HamburgerMenupage  hamburgerMenupage = homepage.clickHamburgermenu();
		wait(5);
		hamburgerMenupage.ScrollTolnkComputers();
		wait(5);
		hamburgerMenupage=hamburgerMenupage.ClickComputers();
		wait(5);
		Resultspage resultspage = hamburgerMenupage.ClickMonitor();
		resultspage.returnBrands(testData.readJSONData("Brand"));
		resultspage.clickSortBy();
		resultspage.SelectSortOption(testData.readJSONData("Sort By"));
		ProductdetailsPage prodctdetailspage = resultspage.clickOnSecondHighest();
		System.out.println("Product title is "+prodctdetailspage.getProductTitle());
		System.out.println("Product price is "+prodctdetailspage.getProductPrice());
		System.out.println("Product About Item Info is "+prodctdetailspage.getAboutItem());
	}
	
 public void wait(int num) throws Exception
 {
	 for(int i=0;i<num;i++)
	 {
		 Thread.sleep(i);
	 }
 }

	
}
