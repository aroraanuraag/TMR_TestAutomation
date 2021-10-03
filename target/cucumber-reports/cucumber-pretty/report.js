$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/TEST Automation - Selenium Java/eclipse-workspace/TMR_D365_Test_Automation/src/main/java/com/qa/features/1_NTT_CRM_file_01.feature");
formatter.feature({
  "line": 1,
  "name": "Dynamics CRM application test",
  "description": "",
  "id": "dynamics-crm-application-test",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 2,
      "value": "#With Examples Keyword: Here Scenario Outline is needed."
    }
  ],
  "line": 3,
  "name": "Verify Dynamics CRM Login functionality",
  "description": "",
  "id": "dynamics-crm-application-test;verify-dynamics-crm-login-functionality",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user is on Login Page of TMR D365",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user types \"\u003cusername\u003e\" \u0026 clicks Next button",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user types \"\u003cpassword\u003e\" \u0026 clicks SignIn button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "user clicks on the Yes",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user validates Dynamics CRM home page title Page of TMR",
  "keyword": "Then "
});
formatter.examples({
  "comments": [
    {
      "line": 11,
      "value": "##Below is a Parameterisation example using Examples."
    },
    {
      "line": 13,
      "value": "#Examples:"
    },
    {
      "line": 14,
      "value": "#    | username | password |"
    },
    {
      "line": 15,
      "value": "#    | admin@CRM215677.onmicrosoft.com | pf8POcMEtF |"
    },
    {
      "line": 17,
      "value": "#Below is for HASH MAP - For Role Based Scenarios - HASH"
    }
  ],
  "line": 18,
  "name": "",
  "description": "",
  "id": "dynamics-crm-application-test;verify-dynamics-crm-login-functionality;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 19,
      "id": "dynamics-crm-application-test;verify-dynamics-crm-login-functionality;;1"
    },
    {
      "cells": [
        "IPU_Operator",
        "IPU_Operator"
      ],
      "line": 20,
      "id": "dynamics-crm-application-test;verify-dynamics-crm-login-functionality;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5998033600,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Verify Dynamics CRM Login functionality",
  "description": "",
  "id": "dynamics-crm-application-test;verify-dynamics-crm-login-functionality;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user is on Login Page of TMR D365",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user types \"IPU_Operator\" \u0026 clicks Next button",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user types \"IPU_Operator\" \u0026 clicks SignIn button",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "user clicks on the Yes",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user validates Dynamics CRM home page title Page of TMR",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps_01.user_is_on_Login_Page()"
});
formatter.result({
  "duration": 1022022400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "IPU_Operator",
      "offset": 12
    }
  ],
  "location": "HomePageSteps_01.user_types_and_clicks_Next_button(String)"
});
formatter.result({
  "duration": 1615365900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "IPU_Operator",
      "offset": 12
    }
  ],
  "location": "HomePageSteps_01.user_types_and_clicks_SignIn_button(String)"
});
formatter.result({
  "duration": 4205680700,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps_01.user_clicks_on_the_Yes_option()"
});
formatter.result({
  "duration": 1890140100,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps_01.dynamics_CRM_home_page_is_displayed()"
});
formatter.result({
  "duration": 92697890000,
  "error_message": "java.lang.AssertionError: expected [] but found [Microsoft Dynamics 365]\r\n\tat org.testng.Assert.fail(Assert.java:96)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:776)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:137)\r\n\tat org.testng.Assert.assertEquals(Assert.java:118)\r\n\tat org.testng.Assert.assertEquals(Assert.java:453)\r\n\tat org.testng.Assert.assertEquals(Assert.java:463)\r\n\tat com.qa.stepDefinitions.HomePageSteps_01.dynamics_CRM_home_page_is_displayed(HomePageSteps_01.java:169)\r\n\tat ✽.Then user validates Dynamics CRM home page title Page of TMR(C:/TEST Automation - Selenium Java/eclipse-workspace/TMR_D365_Test_Automation/src/main/java/com/qa/features/1_NTT_CRM_file_01.feature:8)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 692281900,
  "status": "passed"
});
});