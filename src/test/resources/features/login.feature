Feature: Login test with different users


  @wip
  Scenario: Login with student
    Given User go to library login page
    When User enter student username and password and click login
    Then User should be able to login