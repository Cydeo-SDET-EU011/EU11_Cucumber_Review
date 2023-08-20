Feature: Test librarian user table


  @wip
  Scenario: Librarian user table
    Given user login as librarian
    When user clicks Users link
    Then user should be able to see below columns
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |
