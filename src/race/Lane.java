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
import java.util.HashSet;

/**
 *
 * @author track36
 */
public class Lane {

    private static Lane INSTANCE = null; //private variable to store instance
    private String[] laneCheck = {"-", "-", "-", "-", "-", "-", "-", "-", "-"}; //default table body
    private String laneTable = "1\t2\t3\t4\t5\t6\t7\t8"; //table header 1-8    
    private String laneTaken = "This lane has already been chosen"; //default output if lane is taken

    private static HashSet laneList = new HashSet(); //creates new hashset for lanes

    private Lane() {
    }//private constructor for singleton.

    /**
     * determines if laneList contains the laneChoice argument
     *
     * @param laneChoice
     * @return laneList
     */
    public HashSet setLane(int laneChoice) {
        /*
        if laneList does not contain laneChoice add laneChoice to laneList
         */
        if (!laneList.contains(laneChoice)) {
            laneList.add(laneChoice);
        } else {
            System.out.println(laneTaken); //print default message
        }
        printTable(laneChoice); //invokes printTable method

        System.out.println();//creates space between lane input
        System.out.println();
        return laneList;
    }

    /**
     * Prints table of occupied lanes
     *
     * @param laneChoice
     */
    private void printTable(int laneChoice) {
        System.out.println(laneTable);
        laneCheck[laneChoice] = "X";
        for (int i = 1; i < laneCheck.length; i++) {
            System.out.print(laneCheck[i] + "\t");
        }
    }

    /**
     * gets single instance of Lane object for caller
     *
     * @return INSTANCE
     */
    public static Lane getInstance() { //global access to get instance of Lane
        /**
         * if no instance of Lane object exists instantiates one
         */
        if (INSTANCE == null) {
            INSTANCE = new Lane();
        }
        return INSTANCE;
    }
}
