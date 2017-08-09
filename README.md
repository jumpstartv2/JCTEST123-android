# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

This repository is where the Android mobile project template used by **JumpStart** is stored.

### How do I get set up? ###

##### Summary of set up #####
####The following are the configurations already handled within the project:####
* Installation of dependencies needed for:
    * HockeyApp
    * ApiClient
    * JSONModel
* Constants and Util files
* Push Notifications setup
* Project Directory and File Directory structure already prepared
* Fastlane

##### Update project template #####
After cloning this template, you need to update the Package Name to conform to your project specifications. Also, add your preferred prefix to the Project settings so that files created afterwards will be distinct based on the prefix of choice.

There are two steps to update the Package name:
* First Changing the directory package:
    * First, go to the project directory in android studio then change the view to "Project"
    * then, click on the settings(the cog wheel symbol) then uncheck the "Compact Empty Middle Packages"
    * you can refer to this image http://prntscr.com/g66i5c
* Second open the build.gradle of the project:
    * in the file there are blocks of codes, under android > defaultConfig there is a field applicationId change the package name under that field.
    * you can refer to this image http://prntscr.com/g66jtt
    
##### Dependencies #####
Here are some of the dependencies you need to cater to be able to fully use the project template:

###### Firebase ######
* Firebase just replace the contents of "google-services.json" under the app folder of your project directory.
* the contents of "google-services.json" is generated from the firebase project console.

### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###

* Repo owner or admin
* Other community or team contact