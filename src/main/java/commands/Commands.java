package commands;

import greet.GreetUser;
import greet.Greeted;

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
        //Define a variable to control the loop
        Boolean selection = true;

        while (selection) {

            System.out.print("Enter A Command: ");
            String enterCommand = input.nextLine();


            String[] commandUser = enterCommand.trim().split(" ");
            String command = commandUser[0].trim();

            if ("greet".equals(command) && commandUser.length > 1) {
                String userName = commandUser[1];
                String lang = commandUser[2];
                System.out.println(greetUser.greet(userName, lang));

                System.out.println("Counter: " + " " + greetUser.getMapSize());
                System.out.println("Greeted Users: \n" + " " + greetUser.getGreeted());
            }

            else if ("greeted".equals(command) && commandUser.length > 1){
                String userName = commandUser[1].toLowerCase();
                System.out.println(greetUser.getSingleUser(userName));
            }else
                System.out.println("All Greeted Users: \n" + " " + greetUser.getGreeted());

//            if ("clear".equals(command) && commandUser.length > 2)
//            {
//                String userName = commandUser[1];
//                greetUser.deleteSpecificUsersInsideTheMap(userName);
//            }else
//                greetUser.clearAllUsersInTheMap();
//                System.out.println("All Users Have Been Cleared..!");
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
//            {

//                String userName = commandUser[1];
//                System.out.println(greetUser.getSpecificUser(userName));
//            }else



