package net.greet.commands;

import net.greet.GreetCounter;
import net.greet.greet.Languages;

public class CommandsProcessor {

    private final GreetCounter greetCounter;

    public CommandsProcessor(GreetCounter greetCounter) {
        this.greetCounter = greetCounter;
    }

    public String execute(String commands) {
        CommandExtractor commandExtractor = new CommandExtractor(commands);
            try {
                if ("greet".equalsIgnoreCase(commandExtractor.getCommand())) {
                    if (commandExtractor.hasName() && commandExtractor.hasLanguage()) {
                        return greetCounter.greet(commandExtractor.getUserName(), commandExtractor.getLang());
                    }
                    else
                    {return greetCounter.greet(commandExtractor.getUserName(), (Languages.isixhosa).toString());}
                }
               else if ("greeted".equalsIgnoreCase(commandExtractor.getCommand())) {
                    if (commandExtractor.hasName()) {
                        return (commandExtractor.getUserName() + " " + "you have been greeted: " + greetCounter.getSingleUser(commandExtractor.getUserName()) + " " + "time(s)");
                    } else {
                        return ("All greeted users" + " |  " + greetCounter.getGreeted());
                    }
                }
                else if ("clear".equalsIgnoreCase(commandExtractor.getCommand())) {
                    if (commandExtractor.hasName()) {
                        greetCounter.deleteSpecificUsersInsideTheMap(commandExtractor.getUserName());
                        return (commandExtractor.getUserName() + " " + "Have Been Deleted Successfully..!");
                    } else {
                        greetCounter.clearAllUsersInTheMap();
                        return ("All Users Have Been Deleted Successfully..!");
                    }
                }
                else if ("help".equalsIgnoreCase(commandExtractor.getCommand())){ help();}
                else if ("counter".equalsIgnoreCase(commandExtractor.getCommand())) {
                    return ("There are" + " | " + greetCounter.getMapSize() + " | " + "greeted users");
                }
                else
                if (!commandExtractor.getCommand().isEmpty()) {
                    return ("Invalid command type  HELP for valid commands...!");
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            return "";
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
}




