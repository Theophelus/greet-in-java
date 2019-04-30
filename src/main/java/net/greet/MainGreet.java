package net.greet;

import net.greet.commands.CommandsProcessor;

import java.util.Scanner;

//package greet;
class MainGreet {

public static void main(String[] args){
    //Define an instance of CommandsProcessor class
    CommandsProcessor commands = new CommandsProcessor();
    System.out.println("----------------------------------------------------------------------------------------");
    System.out.println("                             ***  WELCOME TO MY  ***                                    ");
    System.out.println("               ************ GREETINGS CONSOLE APPLICATION  ************                 ");
    System.out.println("----------------------------------------------------------------------------------------");
    System.out.println("..");
    System.out.println("Greetings is an Console Application that allow user to be greeted in different Languages");
    System.out.println("----------------------------------------------------------------------------------------");
    System.out.println("..");
    //Define a variable to control the loop
    Boolean selection = true;
    while (selection){
        System.out.print("Please enter a Command =>  ");
        Scanner input = new Scanner(System.in);
        String enterCommand = input.nextLine();
        if (enterCommand.equalsIgnoreCase("exit")) break;
        System.out.println(commands.greets(enterCommand));
    }
    }
}

