@DiscountFilter
Feature: Bags discount filter

  Scenario: Verify bags with 40% and above discount are displayed
    Given User launches the Decathlon application
    When User search for "bags"
    And User opens the Discount filter
    When User selects the "40% and above" discount filter
    Then All applicable discount options from 40% and above should be selected
   Then Every displayed bag should have a discount of 40% or above