Feature: Login test with different users


  Background:
    Given User go to library login page

  Scenario: Login with student
    When User enter student username and password and click login
    Then User should be able to login


  Scenario: login with librarian
    When User enter library username and password and click login
    Then User should be able to login

  #@wip
  Scenario Outline: login with parameters
    When user enter "<role>" information
    Then User should be able to login

    Examples:
      | role      | username            | password    |
      | student   | student5@library    | libraryUser |
      | librarian | librarian58@library | libraryUser |


#  @wip
#  Scenario Outline: login with parameters
#    When user enter "<role>" information
#    And user enter "<username>" and "<password>" for role
#    Then User should be able to login
#
#    Examples:
#      | role      | username            | password    |
#      | student   | student5@library    | libraryUser |
#      | librarian | librarian58@library | libraryUser |
