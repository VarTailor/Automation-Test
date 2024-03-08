# This is a Test Automation Base Framework to automate TK Maxx website

# About

This framework contains a feature to automate Purchasing flow as Guest user on TK Maxx website.
A API test case to validate a reponse and get required details
Sample code to connect to a DataBase and execute a SQL query

## Installing

Clone the repo to your local branch
Configure the project in the IDE and run build
Ensure necessary dependencies are present like JDK,Maven,Java are installed and configured in the path variables in your environment

## Run
	mvn clean test -Dbrowser=chrome -Durl=QA

##Known issues

In the feature file HomePage.feature the script might break as the view products api call on screen is taking several minutes to load the page so not able to validate the feature end to en
Intermittent Pop up to subscribe is coming at different screens




 
	
