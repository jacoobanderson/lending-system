# A2

Project for Assignment 2

A project template based on gradle and a gitlab pipeline. You should always build and run the application using gradle regularely.

[design.md](design.md) contains the prescribed architectural design of the application.

## Building
The build must pass by running console command:  
`./gradlew build`  
Note that you should get a report over the quality like:
```
CodeQualityTests > codeQuality() STANDARD_OUT
    0 CheckStyle Issues in controller/App.java
    0 CheckStyle Issues in controller/Simple.java
    0 CheckStyle Issues in model/Simple.java
    0 CheckStyle Issues in view/Simple.java
    0 FindBugs Issues in controller/App.java
    0 FindBugs Issues in model/Simple.java
    0 FindBugs Issues in view/Simple.java
    0 FindBugs Issues in controller/Simple.java
```

Removing or manipulating the code quality checks results in an immediate assignment **Fail**. 

## Running
The application should start by running console command:  
`./gradlew run -q --console=plain`

## Adding Your Own Code
The `Simple` classes project should likely be removed do not forget to also remove the test case associated to `model.Simple`.  

Add your own code to the packages respectively and feel free to add automatic test cases for your own code. A good process is to design a little - code a little - test a little one feature at a time and then iterate.

## Versioning

Adhere to the git versioning instructions according to the assignment.

## System test
Adhere to the instructions according to the assigment.

## Handing In
Adhere to the instructions according to the assigment.


## Applicatio instructions (How to use)
You are initially faced with a main menu where you can Create a member, show the members, advance a day and select a member. If you select a member you do so with the member email. At that point you get to the member menu where you can choose to show the member information, change the member's information, create an item, contract etc. When you select an item you do so with the number of that item (Index + 1), this is also where you can see all the member's items. If you select an item you can view the contracts of that item aswell as change information and delete the item. If you create a new contract you specify the item, start day and end day, then the funds are transfered if there are enough when you advance the day to the start day the it will show (show verbose) the start day end day and to whom the item is lended to. At the end day it will become available and the contract information will no longer show.