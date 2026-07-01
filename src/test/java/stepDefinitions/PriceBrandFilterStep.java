package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PriceBrandFilterStep {
	@When("User searches for {string}")
	public void user_searches_for(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("user searches for String");
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
