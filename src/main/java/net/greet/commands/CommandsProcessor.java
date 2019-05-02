package net.greet.commands;

import net.greet.dbCounter.CounterUsingJDBC;
import net.greet.greet.Languages;

public class CommandsProcessor {
//    GreetCounterUsingMap greetUser = new GreetCounterUsingMap();
    CounterUsingJDBC greetUser  = new CounterUsingJDBC();
    public String greets(String commands) {
        CommandExtractor commandExtractor = new CommandExtractor(commands);
            try {
                if ("greet".equalsIgnoreCase(commandExtractor.getCommand()) && commandExtractor.getCommandLength()  == 2 ) {
                    return greetUser.greet(commandExtractor.getUserName(), String.valueOf(Languages.isixhosa));
                }
                 else
                     if ("greet".equalsIgnoreCase(commandExtractor.getCommand()) && commandExtractor.getCommandLength() > 1) {
                    return greetUser.greet(commandExtractor.getUserName(), commandExtractor.getLang());
                }
                else
                    if ("greeted".equalsIgnoreCase(commandExtractor.getCommand())) {
                        if (commandExtractor.getCommandLength() > 1) {
                            return (commandExtractor.getUserName() + " " + "you have been greeted: " + greetUser.getSingleUser(commandExtractor.getUserName()) + " " + "time(s)");
                        }
                    else {
                        return ("All greeted users" + " |  " + greetUser.getGreeted());
                    }
                } else if ("clear".equalsIgnoreCase(commandExtractor.getCommand())) {
                    if (commandExtractor.getCommandLength() > 1) {
                        greetUser.deleteSpecificUsersInsideTheMap(commandExtractor.getUserName());
                        return (commandExtractor.getUserName() + " " + "Have Been Deleted Successfully..!");
                    }
                    else {
                        greetUser.clearAllUsersInTheMap();
                        return ("All Users Have Been Deleted Successfully..!");

                    }
                } else if ("help".equalsIgnoreCase(commandExtractor.getCommand())){ help();}
                else if ("counter".equalsIgnoreCase(commandExtractor.getCommand())) {
                    return ("There are" + " | " + greetUser.getMapSize() + " | " + "greeted users");
                }
                else
                if (!commandExtractor.getCommand().isEmpty() && commandExtractor.getCommandLength() > 0) {
                    return ("Invalid command type  HELP for valid commands...!");
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

            return commands;
    }
    //Define a method for help
    public void help(){
        System.out.println("*****************Valid CommandsProcessor*****************");
        System.out.println("[ greet ] followed by the name and the language the user is to be greeted in, \n"
                + "[ greeted ] should display a list of all users that has been greeted and how many time each user has been greeted, \n"
                + "[ greeted ] followed by a username returns how many times that username have been greeted,\n"
                + "[ counter ] returns a count of how many unique users has been greeted, \n"
                + "[ clear ] deletes of all users greeted and the reset the greet counter to 0,\n"
                + "[ clear ] followed by a username delete the greet counter for the specified user and decrement the greet counter by 1, \n"
                + "[ exit ] exits the application,\n");
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
}




