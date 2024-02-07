Feature: Login Scenario's

Scenario: verify login with valid data
Given goto website
When enter uname "mngr546420" and pwd "gajened"
Then click login

Scenario Outline: verify_Login_With_Invalid_Data
When enter uname as "<uname>" and password as "<pwd>"
Then click login button
And Verify alert is open 
Examples:
|uname|pwd|
|admin|admin|
