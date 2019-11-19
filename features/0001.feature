Feature: Login in to Trello website
  Scenario: As a registered user I want to try log into Trello website using unregistered password with correct email. I expect to see "Invalid password notification"
    Given I enter log in page of Trello
    And I fill in login text box with registered login
    And I fill in password with incorrect password
    When I click on log in button
    Then I can see invalid password notification

  Scenario: As a registered user I want to log into Trello website in order to use most of it's offerings
    Given I enter log in page of Trello
    And I fill in login text box with registered login
    And I fill in password with registered password
    When I click on log in button
    Then I am logged into Trello