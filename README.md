# TestAutomationFramework
Ready to use Java based automation framework for UI testing. Fastest way to start wring your automated UI Tests.



This project is written in Java and will serve an example for implementing Selenium Automation Tests. Running this project will run all the written test cases and help for faster integration level testing. Everything is set up and additional tests can be added straight away. Used JUnit and TestNG libraries and is based on Keyword Data Driven(KDD) framework.

## Prerequisites
- Java (JDK-1.8 or higher)
- Selenium Webdriver
- Firefox Browser
- Eclipse
- Eclipse External Jars
	- JUnit
	- TestNG

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

To execute the project, clone this repository in your local machine.
 Following installations need to be performed before running the code:
```
1. Install Eclipse IDE.
2. Install Java(JDK 1.8 or higher).
```

### Installing

Once Eclipse and Java has been installed, make sure you have added in the path.
The following are the steps to upload the project in Eclipse IDE.


```
1. Open Eclipse.
2. Click File and Open project from file system.
3. Make sure all the files(classes and packages) are added and should be visible on the Package Explorer section on the left side of Eclipse window.
4. Now it is important to add JUnit and TestNg dependencies in the project.
    1. For this, right click on the Project>Build Path>Configure Build Path. 
    2. Add External Jars: JUnit and TestNG.(And any latest stable version)
5. Now you are all set for the project.
```
### Understanding the code
- All the base methods that are required to interact with the UI Elements are written in the FrameworkHome.java class.
- FrameworkHome.java class needs to be extended to any new class that you create for writing the additional test cases.
- You can create a new package to add addition classes for adding more test cases to the project.
- All the locators or xpath are located in the elementLocators.properties file.
- Web Browsers Drivers path or on load URL are located in environmentSetup.properties file.

## Running the tests

Once you are all set you can run indivitual test cases by running each class file.
```
To run the Test Suite:
Navigate to Right Click on testng.xml>Run as>TestNG Suite
```
### Inspection of Results
- Right click on project folder> Click Refresh
- This will generate test-output folder.
-  You can browse through the test.html or emailable-report.html or index.html for test results.

## Questions

For any queries reach out to Karan Shah: karanshah21june@gmail.com
