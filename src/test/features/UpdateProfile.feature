Feature: PKR profile update Form
  In order to update profile and change privacy setting
  As a customer
  I want to update the profile page

  Background:
    Given I go to PKR website
    When I click on login button
    And I input the following information:
      | fieldName | fieldValue  |
      | Username  | playernow14 |
      | Password  | pkr123      |
    And   I click on Submit Login button

  Scenario: Update the Profile
    When I click on MYPKR link
    And I go to MyPKR page
    And I go to Profile page
    And I click on edit button
    When I input the following information:
      | fieldName               | fieldValue  |
      | About me                | This is PKR |
      | All-time money list     | Yes         |
      | Show my status          | My Friends  |
      | Show my profile         | Only Me     |
      | Show my tournament page | Everyone    |
    And I click on update button
    Then I see the message 'Profile updated'

  Scenario: Verify profile is updated
    When I click on MYPKR link
    And I go to MyPKR page
    And I go to Profile page
    And I click on edit button
    Then I see the information:
      | fieldName               | fieldValue |
      | Show my status          | My Friends |
      | All-time money list     | Yes        |
      | Show my profile         | Only Me    |
      | Show my tournament page | Everyone   |