Feature: Dynamics CRM application test
#With Examples Keyword: Here Scenario Outline is needed.
Scenario Outline: Verify Dynamics CRM Login functionality
Given user is on Login Page of TMR D365
When user types "<username>" & clicks Next button
And user types "<password>" & clicks SignIn button
And user clicks on the Yes
Then user validates Dynamics CRM home page title Page of TMR


##Below is a Parameterisation example using Examples.

#Examples:
#    | username | password |
#    | admin@CRM215677.onmicrosoft.com | pf8POcMEtF |

#Below is for HASH MAP - For Role Based Scenarios - HASH     
Examples: 
    | username | password |
    | IPU_Operator| IPU_Operator |
    

   
     

#Scenario Outline: Verify CRM's Contacts creation functionality
#Given user opens the browser
#When user is on Login Page
#Then User types "<username>" and clicks Next
#Then User types "<password>" and clicks SignIn button
#Then User clicks on the Yes option
#Then User validates Dynamics CRM home page title Page
#Then on the Home Page user clicks on Contacts Menu
#Then user clicks on New button
#And User enters Contact details "<firstname>" "<lastname>" "<JobTitle>" "<Email>" "<MobileNumber>" and clicks Save
#Then user verifies Contact Creation
#
#
##Below is a Parameterisation example using Examples.
#Examples:
#     | username | password | firstname | lastname | JobTitle | Email | MobileNumber |
#     | admin@crm898120.onmicrosoft.com | P2nEbs012T | Tom | Moody | Cricketer| tom@gmail.com | 0410312333 |
   