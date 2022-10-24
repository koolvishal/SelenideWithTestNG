package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class Homepage{

	/*
	 * @FindBy(how = How.XPATH, using = "//a[@id='nav-hamburger-menu']/span")
	 * protected SelenideElement hamburgerMenu;
	 */
	
	 @Step
	  public Homepage openAmazon(String strURL)
	  {
		 	open(strURL,Homepage.class);
			return page(Homepage.class);
	}
	
	  @Step
	  public HamburgerMenupage clickHamburgermenu()
	  {
		  	SelenideElement se = $(By.xpath("//a[@id='nav-hamburger-menu']"));
		  	se.should(Condition.visible,Duration.ofSeconds(20));
			se.click();
			return page(HamburgerMenupage.class);
	}
	 
	
	
	
	
}
