@signUp
Feature: signUp Feature 
	Description: The purpose of this feature is to sign up into application for new user
 
Background: user is new to application and wish to signUp 
	Given launches the application 
	Then user verifies visiblitity of logo 
	And user clicks on "CANADA ENGLISH" button
	
Scenario Outline:: user signUp into the application 
	Then user scrolls to "SIGN UP NOW" button
	Then user enters valid details "<row_index>" and "<col_index>" dataset from datasheet "canadaRoots_data.xlsx"
	Then user clicks on "SIGN UP NOW" button on signUp page
	Then user closes the browser
	Examples:
    |row_index|col_index|
    |1|0|
    |2|0|