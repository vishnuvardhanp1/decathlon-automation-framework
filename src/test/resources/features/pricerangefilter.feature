@PriceRangeFilter
Feature: Validate Price Range Filter functionality

Scenario Outline: Validate products using price range filter

When User searches for "Nutrition" type
And User selects the minimum price as "<minPrice>"
And User selects the maximum price as "<maxPrice>"
Then User verifies the selected minimum price is "<minPrice>"
And User verifies the selected maximum price is "<maxPrice>"
And User verifies all displayed products are within the selected price range

Examples:
| minPrice | maxPrice |
| 59       | 243      |
| 71       | 280      |
| 108      | 400      |