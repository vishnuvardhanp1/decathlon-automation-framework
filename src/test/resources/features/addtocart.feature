@AddToCart
Feature: Validate Add to Cart functionality

Scenario: Validate Add to Cart functionality and pricing for a Nutrition product

When User searches for "Nutrition" category
And User selects the maximum price filter less than "250"
And User clicks the product "Granola Bar Cashew Berry - Healthy Nutrition Energy & Breakfast Bar"
And User clicks Add to Cart button
And User navigates to the cart
And User increases the quantity to "3"
Then The cart should display correct quantity 
And The cart should display the correct selling price, MRP, discount and total price
