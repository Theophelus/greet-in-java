package commands;

import greet.GreetUser;
import greet.Greeted;

import java.util.Map;
import java.util.Scanner;

public class Commands extends Greeted {

    GreetUser greetUser = new GreetUser();
    //Define Scanner to read user inputs
    Scanner input = new Scanner(System.in);

    public void runCommands(){
        printMainHeader();
        greets();
    }
    private void greets() {
//        System.out.println("PlEASE ENTER ONE OF THE COMMANDS");
//        System.out.println("1) Greet");
//        System.out.println("2) Greeted");
//        System.out.println("3) Greeted followed by < username >");
//        System.out.println("4) Clear");
//        System.out.println("5) Clear followed by < username >");

        //Define a variable to control the loop
        Boolean selection = true;

        while (selection) {
            System.out.print("Enter A Command: ");
            String enterCommand = input.nextLine();

            String[] commandUser = enterCommand.trim().split(" ");

            if (commandUser.length > 1) {
                String command = commandUser[0].trim();
                if ("greet".equals(command)) {
                    String userName = commandUser[1];
                    String lang = commandUser[2];
//                    greetUser.greet(userName, lang);

                    System.out.println(greetUser.greet(userName, lang));
                    System.out.println(greetUser.getMapSize());
                    System.out.println(greetUser.getGreeted());

                } else if ("greeted".equals(command)){
                   Map<String, Integer> getUsers = greetUser.getGreeted();
                    System.out.println("All Greeted Users In the System:" + "\n" + getUsers);
                }
            }
        }
    }

    ////Define a method to for headers
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




