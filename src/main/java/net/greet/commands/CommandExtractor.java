package net.greet.commands;

public class CommandExtractor {

    String[] command;
    String userName;
    String lang;

    public CommandExtractor(String commands) {
        this.command = commands.trim().split(" ");

        if (getCommandLength() > 1) {
            this.userName =command[1];
        }
        else {this.userName = "";}
        if (getCommandLength() == 3) {
            this.lang = command[2];
        } else
        {this.lang = "";}
    }
    public String getCommand() {
        return command[0];
    }

    public  boolean hasName(){
        return !userName.isEmpty();
    }
    public  boolean hasLangauge(){
        return !lang.isEmpty();
    }

    public String getUserName() {
        return this.userName;
    }

    public String getLang() {
        return this.lang;
    }
    public int getCommandLength() {
        return command.length;
    }
}
