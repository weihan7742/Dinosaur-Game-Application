package game;

import edu.monash.fit2099.engine.Display;

import java.util.ArrayList;
import java.util.Scanner;

public class ModeDisplay {

    private Scanner scanner = new Scanner(System.in);
    private Display display = new Display();
    private ArrayList<String> modes = new ArrayList<>();

    public int chooseMode(Player player){
        displayDivider();
        addMode("Challenge");
        addMode("Sandbox");
        addMode("Quit");
        for(int i=0; i<modes.size(); i++) {
            display.println((i + 1) + ": " + modes.get(i));
        }

        // User input
        boolean valid = false;
        int input = 0;
        do {
            try{
                display.println("Choose a mode.");
                input = scanner.nextInt();

                if(input <= 0 || input > modes.size()){
                    throw new Exception("Invalid input");
                }

                valid = true;

            } catch (Exception e) {
                display.println("Invalid input");
            }
        } while (!valid);

        displayDivider();
        return input;
    }

    public void addMode(String newMode){
        modes.add(newMode);
    }

    public void displayDivider(){
        display.println("----------------------");
    }
}
