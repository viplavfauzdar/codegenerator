Feature: Ransom Note
  As a kidnapper
  I want to create a ransom note from a magazine
  So that I can communicate without being traced

  Scenario: Creating a ransom note from a magazine
    Given I have a magazine with words "give me one grand today night"
    And I have a ransom note with words "give one grand today"
    When I try to create the ransom note from the magazine
    Then I should be able to create the ransom note