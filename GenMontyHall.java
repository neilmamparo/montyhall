//****************************************************************
//	GenMontyHall.java	Programming Fundamentals Fall 2024
// 
//	Neil Mamparo
// 
//	Programming Assignment #2 (Generalized Monty Hall)
//****************************************************************


import java.util.Scanner;
import java.util.Random;

// Simulates the Monty Hall Problem
public class GenMontyHall {

    public static void main(String[] args) {
        // Create random and scanner obj
        Random gen = new Random(2);
        Scanner scan = new Scanner(System.in);

        // Header
        System.out.println("Programming Fundamentals\nNAME: Neil Mamparo\nPROGRAMMING ASSIGNMENT 2\n");
/Users/neil/Desktop/GenMontyHall.java
        // Prompt user for amount of doors
        int numDoors;
        do {
            System.out.print("Choose the number of doors (3 to 9): ");
            numDoors = scan.nextInt();
            if (numDoors < 3 || numDoors > 9) {
                System.out.println("Incorrect number of doors!");
            }
        } while (numDoors < 3 || numDoors > 9);

        // Compute prize door
        int prizeDoor = gen.nextInt(numDoors) + 1;

        // Display visual and prompt user for selection
        System.out.println("\nWelcome to the Game Show!");
        drawBox(numDoors);
        int chosenDoor;
        do {
        	 System.out.print("\nChoose a door number (1-" + numDoors + "): ");
        	 chosenDoor = scan.nextInt();
        	 if (chosenDoor < 1 || chosenDoor > numDoors) {
        		 System.out.print("Incorrect door selection!");
        	 }
        } while (chosenDoor < 1 || chosenDoor > numDoors);
        


        // Compute
        int remainingDoor;
        int revealedDoor = getRevealedDoor3(chosenDoor, prizeDoor);
        if (numDoors == 3) {
            remainingDoor = getRemainingDoor3(chosenDoor, prizeDoor, revealedDoor);
        } else {
            remainingDoor = getRemainingDoor(chosenDoor, prizeDoor, numDoors);
        }

        // Reveal door and prompt user
        System.out.println("\nBefore we see if you won, I will reveal all but one of the other doors: ");
        drawBox2(numDoors, chosenDoor, remainingDoor);
        System.out.printf("\n\nYou can remain with door number %d or you can switch to door number %d.", chosenDoor, remainingDoor);
        System.out.print("\nWould you like to switch (y/n): ");
        chosenDoor = scan.next().equals("y") ? remainingDoor : chosenDoor;

        // Display result
        drawBox3(numDoors, chosenDoor, remainingDoor, prizeDoor);
        if (chosenDoor == prizeDoor) {
            System.out.println("\n\nCongratulations! You won the car.");
        } else {
            System.out.println("\n\nSorry, you just get the goats.");
        }
    }

    // Method that gets the remaining door (3 door only)
    private static int getRemainingDoor3(int chosenDoor, int prizeDoor, int revealed) {
        if (chosenDoor == prizeDoor) {
            return 6 - revealed - prizeDoor;
        } else {
            return prizeDoor;
        }
    }

    // Method that gets the revealed door (3 door only)
    public static int getRevealedDoor3(int chosenDoor, int prizeDoor) {
        if (chosenDoor == prizeDoor) {
            Random gen = new Random();
            int randomize = gen.nextInt(2); // Generates random num 0-1 that reveals one of the two doors
            return 1 + (prizeDoor + randomize) % 3;
        } else {
            return 6 - chosenDoor - prizeDoor; // Reveals the only other door
        }
    }

    // Method that gets the remaining door
    private static int getRemainingDoor(int chosenDoor, int prizeDoor, int numDoors) {
        if (chosenDoor == prizeDoor) {
            Random gen = new Random();
            while (chosenDoor == prizeDoor) {
                prizeDoor = gen.nextInt(numDoors) + 1;
            }
            return prizeDoor;
        } else {
            return prizeDoor;
        }
    }


    private static void drawBox(int numDoors) {
        for (int i = 1; i <= numDoors; i++) {
            System.out.print("|-------| ");
        }
        System.out.println();
        for (int i = 1; i <= numDoors; i++) {
            System.out.print("|       | ");
        }
        System.out.println();
        for (int i = 1; i <= numDoors; i++) {
            System.out.print("|   " + i + "   | ");
        }
        System.out.println();
        for (int i = 1; i <= numDoors; i++) {
            System.out.print("|       | ");
        }
        System.out.println();
        for (int i = 1; i <= numDoors; i++) {
            System.out.print("|       | ");
        }
        System.out.println();
        for (int i = 1; i <= numDoors; i++) {
            System.out.print("|-------| ");
        }
    }

    private static void drawBox2(int numDoors, int chosenDoor, int remainingDoor) {
        for (int i = 1; i <= numDoors; i++) {
            System.out.print("|-------| ");
        }
        System.out.println();
        for (int i = 1; i <= numDoors; i++) {
            if (i == chosenDoor) {
                System.out.print("| Choice| ");
            } else {
                System.out.print("|       | ");
            }
        }
        System.out.println();
        for (int i = 1; i <= numDoors; i++) {
            System.out.print("|   " + i + "   | ");
        }
        System.out.println();
        for (int i = 1; i <= numDoors; i++) {
            if (numDoors == 3) {
                if (i != remainingDoor && i != chosenDoor) {
                    System.out.print("| Goats | ");
                } else {
                    System.out.print("|       | ");
                }
            } else {
                if (i == chosenDoor || i == remainingDoor) {
                    System.out.print("|       | ");
                } else {
                    System.out.print("| Goats | ");
                }
            }
        }
        System.out.println();
        for (int i = 1; i <= numDoors; i++) {
            System.out.print("|       | ");
        }
        System.out.println();
        for (int i = 1; i <= numDoors; i++) {
            System.out.print("|-------| ");
        }
    }

    private static void drawBox3(int numDoors, int chosenDoor, int remainingDoor, int prizeDoor) {
        for (int i = 1; i <= numDoors; i++) {
            System.out.print("|-------| ");
        }
        System.out.println();
        for (int i = 1; i <= numDoors; i++) {
            if (i == chosenDoor) {
                System.out.print("| Choice| ");
            } else {
                System.out.print("|       | ");
            }
        }
        System.out.println();
        for (int i = 1; i <= numDoors; i++) {
            System.out.print("|   " + i + "   | ");
        }
        System.out.println();
        for (int i = 1; i <= numDoors; i++) {
            if (numDoors == 3) {
                if (i != prizeDoor) {
                    System.out.print("| Goats | ");
                } else {
                    System.out.print("|       | ");
                }
            } else {
                if (i != prizeDoor) {
                    System.out.print("| Goats | ");
                } else {
                    System.out.print("|       | ");
                }
            }
        }
        System.out.println();
        for (int i = 1; i <= numDoors; i++) {
            if (i == prizeDoor) {
                System.out.print("| CAR!  | ");
            } else {
                System.out.print("|       | ");
            }
        }
        System.out.println();
        for (int i = 1; i <= numDoors; i++) {
            System.out.print("|-------| ");
        }
    }
}