Feature: Login to application

@RegressionTest
Scenario Outline: Login to Gmail application
Given the user is in gmail login page
When the user enters "<username>" and "<password>"
Then the user should be able to navigate to gmail home page

Examples:
	| username     | password  |
	| madanjoy1959 | Madan1959 |
	| jobyjoy1959  | Madan1959 |


@SmokeTest
Scenario: Login to facebook application
Given the user is in facebook page
When the user enters "Madan@jj.com" and "dash"
Then the user should be able to close the screen.

@DataTest
Scenario: Login to facebook application
Given the user is in facebook page
When the user enters the credentials
    | testuser_1 | Test@153 |
Then the user should be able to close the screen.

@MapTest
Scenario: Login to facebook application
Given the user is in facebook page
When the user enters the user credentials
    | UserName   | Password |
    | testuser_1 | Test@153 |
    | jinouser_1 | Jino@153 |
Then the user should be able to close the screen.