@PriceBrandFilter
 Feature: Validating price and brand by filter functionality
 
  Scenario: Validate Nutrition products using Price and Brand filters

    When User searches for "Nutrition"
    And User applies the maximum price filter as "400"
    Then User verifies all displayed products have price less than or equal to "400"
   
    When User selects the brand "Decathlon"
    Then User verifies all displayed products belong to brand "Decathlon"
