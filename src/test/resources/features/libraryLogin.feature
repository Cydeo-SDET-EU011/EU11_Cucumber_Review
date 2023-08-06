Feature: Login test for library project

  Background:
    Given I am on the login page


  #@wip
  Scenario: login with valid credentials
    When I enter valid credentials and login
    Then I should be on the dashboard

  #@wip
  Scenario: login with invalid credentials
    When I enter invalid credentials and login
    Then I should not be on the dashboard