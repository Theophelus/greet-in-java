package net.greet.commands;

public class CommandExtractor {

    String[] command;
    String userName;
    String lang;

    public CommandExtractor(String commands)
    {
        this.command = commands.trim().split(" ");
    }
    public String getCommand() {
        return command[0];
    }

    public String getUserName() {
       this.userName = command[1];
        return this.userName;
    }

    public String getLang() {
        this.lang = command[2];
        return this.lang;
    }
    public int getCommandLength() {
        return command.length;
    }
}
