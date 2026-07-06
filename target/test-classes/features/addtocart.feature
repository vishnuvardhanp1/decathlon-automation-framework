@AddToCart
Feature: Validating Add to Cart functionality

Scenario: Validate adding a Nutrition product to the cart and verify pricing

When User searches for "Nutrition" category
And User selects the maximum price filter less than "250"
And User clicks the product "Granola Bar Cashew Berry - Healthy Nutrition Energy & Breakfast Bar"

When User clicks Add to Cart button in product details page
Then User clicks on view cart icon
When User increases quantity to "3"
Then Validate correct quantity is added  
Then Validate selling price,discount,mrp 
