Feature:  Validation of news articles from guardian site

  Background:
    Given user launches the browser

  @Test
  Scenario: Book Ticket
    Given  user Fill in From city
    And user Fill in To city
    When user Select the departure and return date
    And user Select the travellers
    Then   user should see flight information