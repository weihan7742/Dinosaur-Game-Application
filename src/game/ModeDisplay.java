package game;

import edu.monash.fit2099.engine.Display;

import java.util.ArrayList;
import java.util.Scanner;

public class ModeDisplay {

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
        int input = inputNumber("Choose a mode: ", true);
        return input;
    }

    public int inputNumber(String condition, boolean chooseMode){
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int input = 0;
        do{
            try{
                display.println(condition);
                input = scanner.nextInt();

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

    public void addMode(String newMode){
        modes.add(newMode);
    }

    public void displayDivider(){
        display.println("----------------------");
    }
}
