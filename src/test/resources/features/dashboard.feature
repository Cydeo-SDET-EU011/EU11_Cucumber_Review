Feature: Dashboard Test

  Background:
    Given I logged into app

# DRY = Dont repeat yourself

  Scenario: Check navigation bar
    When I check student navigation bar
    Then I should see navigation options
      | Books           |
      | Borrowing Books |

  #@wip
  Scenario: Check ISBN number and book name match
    When choose classic from book categories
    Then ISBN number should match book name
      | 978 - 0140280197 | The 48 Laws of Power      |
      | 9579-8799-5274   | Carrion Comfort           |
      | 7845621589       | Selling Clunkers for Java |