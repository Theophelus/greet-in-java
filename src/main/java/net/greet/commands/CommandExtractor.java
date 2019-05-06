package net.greet.commands;

public class CommandExtractor {

    String command;
    String userName = "";
    String lang = "";

    public CommandExtractor(String commands) {

        String[] commandProcessor = commands.trim().split(" ");

        this.command = commandProcessor[0].toLowerCase();

        if (commandProcessor.length > 1) {
            this.userName =commandProcessor[1];
        }
        if (commandProcessor.length == 3) {
            this.lang = commandProcessor[2];
        }
    }

    public String getCommand() {
        return this.command;
    }

    public  boolean hasName(){
        return !userName.isEmpty();
    }
    public  boolean hasLanguage(){
        return !lang.isEmpty();
    }

    public String getUserName() {
        return this.userName;
    }

    public String getLang() {
        return this.lang;
    }
}
