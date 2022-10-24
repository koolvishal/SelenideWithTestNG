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

public class HamburgerMenupage{
	
	
	
	@Step
	public HamburgerMenupage ClickComputers() {
		SelenideElement se = $(By.xpath("//a[@class='hmenu-item' and @data-menu-id='6']"));
		se.should(Condition.visible,Duration.ofSeconds(15));
		se.click();
		//$(By.xpath("//a[@class='hmenu-item' and @data-menu-id='6']/div")).click();
		 return page(HamburgerMenupage.class);
		
	}
	@Step
	public HamburgerMenupage ScrollTolnkComputers() {
		//SelenideElement se = $(By.xpath("//a[@class='hmenu-item' and @data-menu-id='6']/div"));
		SelenideElement se = $(By.xpath("//ul[@class='hmenu hmenu-visible']/li[6]"));
		se.should(Condition.visible,Duration.ofSeconds(15));
		se.scrollIntoView(true);
		//$(By.xpath("//a[@class='hmenu-item' and @data-menu-id='6']/div")).scrollIntoView(true);
		 return page(HamburgerMenupage.class);
		
	}
	@Step
	public Resultspage ClickMonitor() {
		SelenideElement se = $(By.xpath("//ul[@class='hmenu hmenu-visible hmenu-translateX']/li[9]/a"));
		se.should(Condition.visible,Duration.ofSeconds(15));
		se.click();
		//$(By.xpath("//ul[@class='hmenu hmenu-visible hmenu-translateX']/li[9]/a")).click();
		 return page(Resultspage.class);
		
	}
}
