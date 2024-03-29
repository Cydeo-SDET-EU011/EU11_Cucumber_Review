@smoke
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


  #@wip
  Scenario: login with different roles
    When I enter "student" credentials and login
    Then I should see "student" page


  @invalidLoginWithParamsSceOutLine
  Scenario Outline: Login with invalid credential
    When I login with "<username>","<password>"
    Then I should not be able to log in

    Examples:
      | username            | password      |
      | wrongUserName       | libraryUser   |
      | librarian12@library | wrongPassword |
      | wrongUserName       | wrongPassword |
      | wrongUserName       | empty         |
      | empty               | wrongPassword |
      | empty               | empty         |
