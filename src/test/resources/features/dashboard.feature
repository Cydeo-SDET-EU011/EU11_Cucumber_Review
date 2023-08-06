Feature: Dashboard Test

# DRY = Dont repeat yourself
  @wip
  Scenario: Check navigation bar
    Given I logged into app
    When I check student navigation bar
    Then I should see navigation options
      | Books           |
      | Borrowing Books |


