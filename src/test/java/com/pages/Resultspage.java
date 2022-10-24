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


public class Resultspage{

	/*
	 * @FindBy(how = How.XPATH, using =
	 * "//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium' and @aria-labelledby='p_89-title']//a/span"
	 * ) public ElementsCollection listBrands;
	 */
	
	
	/*
	 * public int sizeOfBrands(ElementsCollection lstBrands) { return
	 * lstBrands.size(); }
	 */
	
	
	  @Step	
	  public void returnBrands(String str)
	  {
		  SelenideElement elelblBrand = $(By.xpath("(//span[contains(text(),'Brand')])[1]"));
		  elelblBrand.should(Condition.visible,Duration.ofSeconds(20));
		  ElementsCollection eleBrands = $$(By.xpath("//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium' and @aria-labelledby='p_89-title']//a/span"));
		  for(SelenideElement e:eleBrands) 
		  {
			  //System.out.println("Value is "+e.getText());
			  //System.out.println("Value "+e.getText());
			  if(str.contentEquals(e.getText()))
			  {  System.out.println("Selected "+e.getText());
			  		e.click();
			  		break;
			  }
		  }
	  
	  }
	  @Step
	  public void clickSortBy()
		{
			SelenideElement se = $(By.xpath("//span[@data-csa-c-func-deps='aui-da-a-dropdown-button']"));
			se.should(Condition.visible,Duration.ofSeconds(15));
			se.click();
			 //return page(Resultspage.class);
		}
	  
	  @Step
	  public Resultspage SelectSortOption(String strOption)
	  {
		  ElementsCollection eleOption = $$(By.xpath("//div[@id='a-popover-2']/div/div/ul/li"));
			for(SelenideElement ele:eleOption)
			{
				if(ele.getText().contentEquals(strOption))
				{
					System.out.println("Value is "+ele.getText());
					ele.click();
					break;
				}
			}
			
			return page(Resultspage.class);
	  }
	  
	  @Step
	  public ProductdetailsPage clickOnSecondHighest()
		{
			SelenideElement se = $(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
			se.should(Condition.visible,Duration.ofSeconds(15));
			se.click();
			return page(ProductdetailsPage.class);
			
		}

	
}
