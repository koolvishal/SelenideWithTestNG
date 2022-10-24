package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class ProductdetailsPage {

	
	  @Step	
	  public String getProductTitle()
	  {
		  SelenideElement eleTitle = $(By.xpath("//span[@id='productTitle']"));
		  eleTitle.should(Condition.visible,Duration.ofSeconds(20));
		  return eleTitle.getText();
		 
	  }
	  
	  @Step	
	  public String getProductPrice()
	  {
		  SelenideElement elePrice = $(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']/div[1]/span[1]/span[2]"));
		  elePrice.should(Condition.visible,Duration.ofSeconds(20));
		  return elePrice.getText();
		 
	  }	
	  
	  @Step
	  public String getAboutItem()
	  {
		  String str="";
		  ElementsCollection eleOption = $$(By.xpath("//ul[@class='a-unordered-list a-vertical a-spacing-mini']/li"));
			for(int i=0;i<eleOption.size();i++)
			{
				if(i>0)
				{
					SelenideElement ele = eleOption.get(i);
					str = str+" "+ele.getText();
				}		
			}
			return str;
			
			
	  }
}
