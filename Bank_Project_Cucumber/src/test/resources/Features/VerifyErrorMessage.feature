Feature: verify Error Message

Scenario: verify error message in uname and password text fields
Given goto home page
When uname and pwd as empty
Then verify error messages