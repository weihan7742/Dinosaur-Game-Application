package game;

import edu.monash.fit2099.engine.Display;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class which allows user to input number and choose game modes.
 */
public class ModeDisplay {

    private Display display = new Display();
    private ArrayList<String> modes = new ArrayList<>();

    /**
     * Allow user to choose game modes.
     *
     * @param player Player playing
     * @return integer representing mode chosen
     */
    public int chooseMode(Player player){
        displayDivider();
        addMode("Challenge");
        addMode("Sandbox");
        addMode("Quit");
        for(int i=0; i<modes.size(); i++) {
            display.println((i + 1) + ": " + modes.get(i));
        }

        // User input
        int input = inputNumber("Choose a mode: ", true);
        return input;
    }

    /**
     * Allow user to input integer
     *
     * @param condition String to be displayed to prompt user
     * @param chooseMode true if user wants to choose mode, false otherwise.
     * @return integer
     */
    public int inputNumber(String condition, boolean chooseMode){
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int input = 0;
        do{
            try{
                display.println(condition);
                input = scanner.nextInt();

                // Ensure user does not input out or range when choosing mode.
                if(chooseMode){
                    if(input <= 0 || input > modes.size()){
                        throw new Exception("Invalid input");
                    }
                }

                valid = true;

            } catch (Exception e) {
                display.println("Invalid input");
                scanner = new Scanner(System.in);
            }
        } while(!valid);
        displayDivider();
        return input;
    }

    /**
     * Allow different game modes to be added.
     *
     * @param newMode String representing of new mode.
     */
    public void addMode(String newMode){
        modes.add(newMode);
    }

    /**
     * Display divider represented by '-'
     */
    public void displayDivider(){
        display.println("----------------------");
    }

    /**
     * Retrieve array list of game modes.
     *
     * @return array list of game modes
     */
    public ArrayList<String> getModes() {
        return new ArrayList<>(modes);
    }
}
