package greet;

import java.util.Scanner;

public class Commands extends Greeted {

    Greeted greeted = new Greeted();

    public void runCommands(){
        printMainHeader();
        greets();
    }
    private void greets() {
        System.out.println("PlEASE ENTER ONE OF THE COMMANDS");
        System.out.println("1) Greet");
        System.out.println("2) Greeted");
        System.out.println("3) Greeted followed by < username >");
        System.out.println("4) Clear");
        System.out.println("5) Clear followed by < username >");

        //Define a variable to control the loop
        Boolean selection = true;

        System.out.println();
        while (selection){
            //Define Scanner to read user inputs
            Scanner input = new Scanner(System.in);
            System.out.print("Enter A Command: ");
            String username = input.next();

            switch (username){
                case "Greet":
//                    if (true){ greeted.greetUser(g)}
                    break;

            }

        }
    }



    ////Define a method to for headers
    private void printMainHeader() {
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("                             ***  WELCOME TO MY  ***                                    ");
        System.out.println("             ************ GREETINGS CONSOLE APPLICATION  ************                   ");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("..");
        System.out.println("Greetings is an Console Application that allow user to be greeted in different Languages");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("..");
    }

}




