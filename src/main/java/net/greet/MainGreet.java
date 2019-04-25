package net.greet;

import net.greet.commands.Commands;

import java.sql.SQLException;

//package greet;
class MainGreet {

public static void main(String[] args) throws SQLException {
    //Define an instance of Commands class
    Commands commands = new Commands();
    commands.runCommands();
    }
}

