/**
 * Crude depth chart management In particular, it is "append-only", so a player
 * can only be added, and cannot be added in front of another player at a
 * position. Needless to say, there is minimal error handling
 */
package hw1;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class Main {

    public static void main(String[] args) {
        DepthChart chart = new DepthChart();
        String commands[] = {"Quit program", "Add to position", "Display depth chart"};
        final int QUIT = 0, // 0 is code to quit the program
                ADD = 1,
                DISPLAY = 2,
                NUM_COMMANDS = 3;
        Menu choices = new Menu(commands);
        Scanner stdin = new Scanner(System.in);

        int choice;
        // temporary variables to hold input values
        String playerFirstName, playerLastName, position;
        int playerNumber;

        System.out.println("Welcome to Depth Chart Manager 0.01");
        while ((choice = choices.get()) != QUIT) {
            // process the choice
            switch (choice) {
                case ADD:
                    System.out.print("Please enter the player's first name: ");
                    playerFirstName = stdin.next();
                    System.out.print("Please enter the player's last name: ");
                    playerLastName = stdin.next();
                    System.out.print("Please enter the player's uniform number: ");
                    playerNumber = stdin.nextInt();
                    System.out.println("Please enter the player's position.");
                    System.out.print("Valid positions are PG, SG, SF, PF, C : ");
                    position = stdin.next();
                    chart.add(position, new Player(playerFirstName, playerLastName, playerNumber));
                    break;
                case DISPLAY:
                    chart.display();
                    break;
                default:
                    System.err.println("Invalid choice: " + choice);
                    System.err.println("Please try again");
                    break;
            }
        }
    }

}
