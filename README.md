# Greetings From The Console

[![Build Status](https://travis-ci.org/Theophelus/greet-in-java.svg?branch=master)](https://travis-ci.org/Theophelus/greet-in-java)

## About

This is a java console app that can greet user in three different languages [isixhosa, english an isizulu]
This app is able to count how many times a specific user have been greeted, and is able to keep count after its being terminated.

## The app is able to prompt users by entering the following commnad:

* greet followed by the name and the language the user is to be greeted in,
* greeted should display a list of all users that has been greeted and how many time each user has been greeted,
* greeted followed by a username returns how many times that username have been greeted,
* counter returns a count of how many unique users has been greeted,
* clear deletes of all users greeted and the reset the greet counter to 0,
* clear followed by a username delete the greet counter for the specified user and decrement the greet counter by 1,
  exit exits the application,
* help shows a user an overview of all possible commands.

## Technologies

This app is created using Maven. The flexibility of this app you can either switch by using java collection to store data 
or use persistence to store data:

* By using java collections you will use HashMap to store data.
* Add persistence
  * I persitence my application state In a SQL database using JDBC with H2 SQL.
  * I have used embedded database, which is flyway to setup database tables.

## Unit Tests
I have done few tests to test both data in database and hashMap using JUnit. 
## To run JUnit unit tests from the terminal use
  ### mvn test

## Run greetings with H2 database drivers

To copy the jar file your project depends on into your projects target foler run:

### mvn dependency:copy-dependencies

The target folder will contain all the jar files your project depends on, after running this command.

## Run it

Add all the jar files in the target folder in your applications classpath like this:
## java -cp .:target/*: net.greet.mainGreet


