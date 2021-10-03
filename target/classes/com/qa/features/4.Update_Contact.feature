Feature: Validate the Update Contact feature

#With Examples Keyword: Here Scenario Outline is needed.

Scenario Outline: Validate the Update Contact feature
Given user is on Login Page
Then user types "<username>" and clicks Next
Then user types "<password>" and clicks SignIn button
Then user clicks on the Yes option
Then on the Home Page user clicks on Contacts Menu
And user click on the Existing Contact to Update
Then user updates the "<UpdateJobTitle>" and saves the record
Then user closes the Browser
#
#
##Below is a Parameterisation example using Examples.
Examples:
    | username | password | UpdateJobTitle |
    | admin@CRM215677.onmicrosoft.com | pf8POcMEtF | VICE-CAPTAIN |