package lab6;

import java.util.Scanner;
public class lab6 {
	
	
    public static void main(String[] args) {
        //Declare variables and create scanner
        Scanner scnr = new Scanner(System.in);
        int diceSides;
        int firstRoll;
        int secondRoll;
        int rollCount = 0;
        String cont = "y";
        //Loop the program based on whether the user wants to continue
        do {
            //Ask user how may die sides they want
            System.out.println("How many sides would you like on your dice?");
            //Take input
            diceSides = scnr.nextInt();
            //Roll the dice by calling the dieRoll method
            System.out.println("Alright, roll the dice ...");
            firstRoll = dieRoll(diceSides);
            
            secondRoll = dieRoll(diceSides);
            //Print die rolls
            System.out.println("Your first roll is: " + firstRoll);
            System.out.println("Your second roll is: " + secondRoll);
            //Determine which roll type function to call based on how many rolls the user has done
            if (rollCount == 0) {
                initialRollType (firstRoll, secondRoll);
            }
            
            else {
                subsequentRollType (firstRoll, secondRoll);
            }
            //Ask the user whether they want to continue and take their input
            System.out.println("\nContinue? (y/n)");
            
            cont = scnr.next();
            //increment the total number of rolls
            ++rollCount;
        } while (cont.equalsIgnoreCase("y"));
        //Say bye to user and close scanner
        System.out.println("OK, bye!");
        scnr.close();
    }
    
    //Create a method to make a random die roll
    public static int dieRoll(int diceSides) {
        int dieRoll = (int) (Math.random() * ((diceSides - 1) + 1)) + 1;
        return dieRoll;
    }
    
    //Create a method to determine the roll type for the first roll
    public static void initialRollType(int firstRoll, int secondRoll) {
        if (firstRoll == 1 && secondRoll == 1) {
            System.out.println("Snake eyes ... and you got craps.");
        }
        else if (firstRoll == 6 && secondRoll == 6) {
            System.out.println("Box cars ... and you got craps");
        }
        else if (firstRoll + secondRoll == 3) {
            System.out.println("Craps!");
        }
        return;
    }
    
    //Create a method to determine the roll type for subsequent rolls (can't roll craps after first roll)
        public static void subsequentRollType(int firstRoll, int secondRoll) {
            if (firstRoll == 1 && secondRoll == 1) {
                System.out.println("Snake eyes.");
            }
            else if (firstRoll == 6 && secondRoll == 6) {
                System.out.println("Box cars.");
            }
            return;
        }
}