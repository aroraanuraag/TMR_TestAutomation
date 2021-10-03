Feature: Validate the Contact Search feature

#With Examples Keyword: Here Scenario Outline is needed.
#Remember - Then is used for Verification Points

Scenario Outline: Validate the Contact Search functionality
Given user is on Login Page
When user types the "<username>" and clicks Next
And user types the "<password>" and clicks SignIn button
And user clicks the Yes option
When on Home Page user clicks on the Contacts Menu
And user enters the "<firstname>" in the search box and clicks Enter
Then user verifies the Contact Search functionality is pass or fail
#And finally user closes the Browser
#
#
##Below is a Parameterisation example using Examples.
Examples:
    | username | password | firstname |
    | admin@CRM215677.onmicrosoft.com | pf8POcMEtF | Neil |
