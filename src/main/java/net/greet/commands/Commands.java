package net.greet.commands;

import net.greet.dbCounter.CounterUsingJDBC;
import net.greet.greet.Languages;

import java.util.Scanner;

public class Commands {

//    GreetCounterUsingMap greetUser = new GreetCounterUsingMap();
    CounterUsingJDBC greetUser = new CounterUsingJDBC();
    //Define Scanner to read user inputs
    Scanner input = new Scanner(System.in);

    public void runCommands() throws IllegalArgumentException {
        printMainHeader();
        greets();
    }
    //Define a method to for headers
    private void printMainHeader() {
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("                             ***  WELCOME TO MY  ***                                    ");
        System.out.println("               ************ GREETINGS CONSOLE APPLICATION  ************                 ");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("..");
        System.out.println("Greetings is an Console Application that allow user to be greeted in different Languages");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("..");
    }


    private void greets() {
        //Define a variable to control the loop
        Boolean selection = true;

        while (selection) {

            System.out.print("Please enter a Command: ");
            String enterCommand = input.nextLine();


            String[] commandUser = enterCommand.trim().split(" ");
            String command = commandUser[0].trim();

            try {
                if ("greet".equalsIgnoreCase(command) && commandUser.length == 2) {
                    String userName = commandUser[1];
                    String greetType = "Isixhosa".toLowerCase();
                    Languages.valueOf(greetType);
                    System.out.println("----------------------------------");
                    System.out.println(greetUser.greet(userName, greetType));
                    System.out.println("----------------------------------");
                    System.out.println("Grand counter" + " | " + greetUser.getMapSize());

                } else if ("greet".equalsIgnoreCase(command) && commandUser.length > 1) {
                    String userName = commandUser[1];
                    String lang = commandUser[2].toLowerCase();
                    System.out.println("----------------------------------");
                    System.out.println(" " + greetUser.greet(userName, lang));
                    System.out.println("----------------------------------");
                    System.out.println("Grand counter" + " | " + greetUser.getMapSize());
                } else if ("greeted".equalsIgnoreCase(command)) {
                    if (commandUser.length > 1) {
                        String userName = commandUser[1];
                        System.out.println(userName + " " + "you have been greeted: " + greetUser.getSingleUser(userName) + " " + "time(s)");
                    } else {
                        System.out.println("Greeted users" + " | " + greetUser.getGreeted());
                    }
                } else if ("clear".equalsIgnoreCase(command)) {
                    if (commandUser.length > 1) {
                        String userName = commandUser[1];
                        greetUser.deleteSpecificUsersInsideTheMap(userName);
                        System.out.println(userName + " " + "Have Been Deleted Successfully..!");

                    } else {
                        greetUser.clearAllUsersInTheMap();
                        System.out.println("All Users Have Been Deleted Successfully..!");
                    }
                } else if ("help".equalsIgnoreCase(command)) help();
                else if ("exit".equalsIgnoreCase(command)) exit();
                else if ("net/greet/dbCounter".equalsIgnoreCase(command)) {
                    System.out.println("There are" + " | " + greetUser.getMapSize() + " | " + "greeted users");
                }else
                if (!command.isEmpty() && commandUser.length > 0) {
                    System.out.println("-------------------------------------------------");
                    System.out.println("Invalid command type  HELP for valid commands...!");
                    System.out.println("-------------------------------------------------");
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    //Define a method for help
    public void help(){
        System.out.println("*****************Valid Commands*****************");
        System.out.println("[ greet ] followed by the name and the language the user is to be greeted in, \n"
                + "[ greeted ] should display a list of all users that has been greeted and how many time each user has been greeted, \n"
                + "[ greeted ] followed by a username returns how many times that username have been greeted,\n"
                + "[ counter ] returns a count of how many unique users has been greeted, \n"
                + "[ clear ] deletes of all users greeted and the reset the greet counter to 0,\n"
                + "[ clear ] followed by a username delete the greet counter for the specified user and decrement the greet counter by 1, \n"
                + "[ exit ] exits the application,\n");
    }

    //define a method to exit the program
    public void exit(){
        System.exit(0);
    }
}




