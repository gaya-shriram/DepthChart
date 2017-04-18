/*
 * Represents a simple console-based menu of choices for a simple user interface
 */
package hw1;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class Menu {

    protected String[] choices; // array of descriptions of choices    

    /**
     * Constructor of menu
     *
     * @param _choices array of descriptions of choices
     */
    public Menu(String[] _choices) {
        choices = new String[_choices.length];

        for (int nextChoice = 0; nextChoice < _choices.length; ++nextChoice) {
            choices[nextChoice] = _choices[nextChoice];
        }
    }

    /**
     * Copy constructor -- because Java does not let you pass objects by value,
     * this is not really necessary. Any call of this constructor has to be
     * explicitly done, like: Menu copy = new Menu(original);
     *
     * @param source menu to copy
     */
    public Menu(Menu source) {
        choices = new String[source.choices.length];

        for (int nextChoice = 0; nextChoice < source.choices.length; ++nextChoice) {
            choices[nextChoice] = source.choices[nextChoice];
        }
    }

    /**
     * Gets next choice made by user -- does not do error checking
     *
     * @return integer code for next command
     */
    public int get() {
        int choice;
        Scanner stdin = new Scanner(System.in);

        System.out.println("Please choose one of the following: ");
        // in the spirit of using better variable names, I have modified the
        // "i" variable to "choiceIndex", but you did not have to change
        // the name
        for (int choiceIndex = 0; choiceIndex < choices.length; ++choiceIndex) {
            System.out.println(choiceIndex + ". " + choices[choiceIndex]);
        }
        choice = stdin.nextInt();
        return choice;

    }
}
