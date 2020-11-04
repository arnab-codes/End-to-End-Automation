Feature: Application login

Scenario Outline: Positive test validating login

Given Initialize the browser with chrome
And Navigate to " https://www.printshoppy.com" website
And Click on login in homepage to land on secure signin page
When user logs in with username <UserName> and password <PassWord>
Then Verify the user is successfully logged in
And Close all the browsers

Examples:
|UserName					|PassWord			|
|arnabspecture64@gmail.com  |8902131833			|
|8334847415  				|1timeinvestment	|