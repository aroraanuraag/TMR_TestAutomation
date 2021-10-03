Feature: Dynamics CRM Contact creation and Duplicate Contact detection feature

#With Examples Keyword: Here Scenario Outline is needed.

Scenario Outline: Verify CRM's Contacts creation functionality
Given user is on Login Page
Then user types "<username>" and clicks Next
Then user types "<password>" and clicks SignIn button
Then user clicks on the Yes option
Then on the Home Page user clicks on Contacts Menu
Then user clicks on New button
And user enters Contact details "<firstname>" "<lastname>" "<JobTitle>" "<Email>" and clicks Save
Then user verifies Contact Creation
Then user closes the Browser
#
#
##Below is a Parameterisation example using Examples.
Examples:
    | username | password | firstname | lastname | JobTitle | Email |
    | admin@CRM215677.onmicrosoft.com | pf8POcMEtF | Steve | Wagh | Cricketer| steve@yahoo.com |



Scenario Outline: Verify Duplicate Contact detection feature
Given user is on Login Page
Then user types "<username>" and clicks Next
Then user types "<password>" and clicks SignIn button
Then user clicks on the Yes option
Then on the Home Page user clicks on Contacts Menu
Then user clicks on New button
And user enters Contact details "<firstname>" "<lastname>" "<JobTitle>" "<Email>" and clicks Save
Then user verifies Duplicate Contact detection
Then user closes the Browser
#
#
##Below is a Parameterisation example using Examples.
Examples:
    | username | password | firstname | lastname | JobTitle | Email |
    | admin@CRM215677.onmicrosoft.com | pf8POcMEtF | Steve | Wagh | Cricketer| steve@yahoo.com |