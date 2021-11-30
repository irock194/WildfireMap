# WildfireMap

University: San Jose State University

Course: CMPE 172 / Fall 2021

Team Members: Andrew Nguyen, Gabriel Tenocelotl, Jeffrey Ong

## Introduction:
The wildfire map application does an API call to get information from NASA to gather information about current wildfires and other natural disasters.
The application stores information about each wildfire into a SQL database. Next, our application will display on a google map API library to
display the current locations of wildfires. These wildfires will range within the current year and will display information about each wildfire throughout
the world. This application is used to help people understand where wildfires have occured throughout the world. 

## Sample Demo Screenshots: 

![Demo Screenshots](/Documentation/wildfireFrontPage.PNG?raw=true "Start Page")

![Demo Screenshots](/Documentation/wildfireFrontPage2.PNG?raw=true "Start 2")

![Demo Screenshots](/Documentation/secondExample.PNG?raw=true "More information on wildfires")

![Demo Screenshots](/Documentation/thirdExample.PNG?raw=true "Europe wildfires")

## How to run locally:

Create a database in MySQL named wildfiremap. Create a table named wildfires under the wildfiremap schema.

In order to start the java application, run the WildfireApplication class. This should boot up the
Springboot.

Then, run the frontend which is React after booted up the backend, just run the npm start in the correct path and this should boot up the React server in localhost:3000.

## System Diagram:

![System Diagram](/Documentation/System%20Diagram.PNG?raw=true)

## Class Diagram:

![Class Diagram](/Documentation/Class%20Diagram.PNG?raw=true)

## Sequence Diagram:

![Sequence Diagram](/Documentation/Sequence%20Diagram.PNG?raw=true)

## Database Schema:

![Database Schema](/Documentation/Database%20Schema.PNG?raw=true)

Link to the website: http://disastertracker.us-west-1.elasticbeanstalk.com/
