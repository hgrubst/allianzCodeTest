# Welcome to the Allianz UI Code test

The objective of this test is to understand your ability and skills with the following technologies in particular : 
- Html/css generally
- Bootstrap
- angularjs


### High level view of what you will do
You will have to develop a (very) simple bug tracking application, with only 2 features : 
- listing of issues
- editing an issue

### Orgnasiation of this repository
There are 2 sections in this repository : 
- a UI section which contains a scaffold of an bootsrap/angular application
- a Server section which contains a simple spring MVC application that provides reference data and services to manage an issue from our application

### Computer setup
Your computer has already been setup and contains all the tools you need to complete this test : 
- git (accessible through command line or you can also access through a right click in explorer and doing `git bash here`)
- git gui (if your are more comfortable using a gui, accessible by right click in a folder and doing `git gui here`)
- maven (type mvn in cmd)
- java
- sublime text (icon pinned to the windows taskbar)
- environment variables and paths are setup appropriately so 

### Getting started
- A folder with your name has been created on your box in the following directory : `C:\dev\candidates`
- Navigate to it and clone this repo
- Navigate to the UI section and run `http-server` which will start a http server to serve your UI. 
You should be able to type in `http:localhost:3000` and see your UI, which contains nothing for now.
- Navigate to the server folder and type in `mvn tomcat7:run`. This will start the spring MVC app.
Verify it works by typing in `http://localhost:8080/issueTracker/ref/issueTypes` which should send back a list of issue types

### Start implementing

#### Get a simple UI up and running
You must first build a simple UI with the following elements : 
- a navbar at the top. Title of the application is `VBIT` (for very basic issue tracker)
- a left navigation menu with the following elements : 
	- Issue list local
	- Issue list remote

You need to plugin the necessary states with UI router to allow navigation to these pages.
Just put dummy text in each page for now.
- a footer that should contain the following elements : 
	- Version 0.1 - Still under active development
	- Designed and built by *insert your name*

#### Display list of issues from local service
In the `Issue list local` page, display the list of issues in a list/table.
The list is provided in an angular service called **issueServiceLocal.js** through the method **getIssues**

#### Display list of issues from remote service
Do the same thing as before but getting the issues from a remote service.
You should create a **issueServiceRemote.js** angular service that talks to the backend for this.
The backend API to get the issues from is the following : **GET http://localhost:8080/issueTracker/issue**

#### Create issues
In the Issue list remote page, add a button to allow creating an issue.
This navigates to a form to allow creating an issue.
The form contains the following elements : 
- Issue title
- Issue description
- Issue category (bug, story or task)


