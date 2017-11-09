/**
 * Derek Dahl
 * PRG/421 - Week1 Singleton Race Lane Program 2.0
 * Allows user to enter a desired race lane 1-8
 * If lane is available saves the state to instance of Lane object using a singleton pattern
 * Prints simple table of occupied lanes as a visual representation
 */
package race;

/**
 *
 * @author Derek Dahl
 */
import java.util.Scanner;

/**
 *
 * @author track36
 */
public class Race {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Lane newRace = Lane.getInstance(); // creates Lane object called newRace

        String userPrompt = "Enter a lane choice(1-8, 0 to exit): ";
        String invalidPrompt = "ERROR! (Not a valid integer";
        String exitMessage = "Thank you... goodbye!";
        String echoInput = "Your lane choice is: ";
        int laneChoice;

        Scanner laneInput = new Scanner(System.in); //creates new scanner laneInput

        while (true) {//infinite loop            

            System.out.print(userPrompt); //prints initial user prompt
            laneChoice = laneInput.nextInt(); //sets laneChoice to next int value
            /**
             * Branching logic for lane choice input
             */
            if (laneChoice == 0) {
                System.out.println(exitMessage); //prints exit message
                break; //exits program loop
                /**
                 * Invokes the setLane method for newRace object if input is
                 * between 1-8
                 */
            } else if (laneChoice >= 1 && laneChoice <= 8) {
                System.out.println(echoInput + laneChoice); //echos input back to user
                newRace.setLane(laneChoice);//invokes setLane method
            } else {
                System.out.println(invalidPrompt);//prints invalid input message
            }
        }
    }

}
