package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import base.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PriceBrandFilterPage;


public class PriceBrandFilterStep extends Base{
	PriceBrandFilterPage priceBrandFilterPage;
	WebElement search;
	WebElement brandsMenu;
	WebElement selectedBrand;
	WebElement slider;
	WebElement price;
	List<WebElement> brandsList=new ArrayList<>();
	List<WebElement> pricesList=new ArrayList<>();
	private static final Logger logger =
			LogManager.getLogger(PriceBrandFilterStep.class);
	@When("User searches for {string}")
	public void user_searches_for(String string) {
	    // Write code here that turns the phrase above into concrete actions
		try {
		 	Thread.sleep(5000);
		 	getDriver().get(this.getFrameworkUrl());
		    Thread.sleep(5000);
		    priceBrandFilterPage=new PriceBrandFilterPage(getDriver());
		    priceBrandFilterPage.getSearchBar().sendKeys(string, Keys.ENTER);
		    Thread.sleep(5000);

	        logger.info("Title : " + getDriver().getTitle());
	        logger.info("URL : " + getDriver().getCurrentUrl());
	}
	catch(Exception ex)
	{
		System.out.println(ex.getMessage());
	logger.debug("Exception occurred:"+ex.getMessage());
	}
	}
	@When("User applies the maximum price filter as {string}")
	public void user_applies_the_maximum_price_filter_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("User applies the maximum price filter as {string}");
	}
	@Then("User verifies all displayed products have price less than or equal to {string}")
	public void user_verifies_all_displayed_products_have_price_less_than_or_equal_to(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User verifies all displayed products have price less than or equal to {string}");
	}
	@When("User selects the brand {string}")
	public void user_selects_the_brand(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User selects the brand {string}");
	}
	@Then("User verifies all displayed products belong to brand {string}")
	public void user_verifies_all_displayed_products_belong_to_brand(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User verifies all displayed products belong to brand {string}");
	}
	
	
}
