package game;

import java.util.Arrays;
import java.util.Scanner;

public class IOHandler {

    public int[] inputReader (char[][] currentGameField) {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter the coordinates: ");
        String rawData = null;
        int coordinates[] = new int[2];
        boolean isGood = false;
        do {
            rawData = read.nextLine();
            String[] data = rawData.split("\\s+");
            try {
                coordinates[0] = Integer.parseInt(data[0])-1;
                coordinates[1] = Integer.parseInt(data[1])-1;
                if (!(coordinates[0] <= 2 && coordinates[0] >= 0 && coordinates[1] <= 2 && coordinates[1] >= 0)){
                    throw new IndexOutOfBoundsException();
                }
                if (currentGameField[coordinates[0]][coordinates[1]] != '_'){
                    throw new IllegalArgumentException();
                }

                isGood = true;
            } catch (NumberFormatException e){
                System.out.println("You should enter numbers!");
            } catch (IndexOutOfBoundsException e){
                System.out.println("Coordinates should be from 1 to 3!");
            } catch (IllegalArgumentException e){
                System.out.println("This cell is occupied! Choose another one!");
            }


        } while(!isGood);

        return coordinates;
    }


}
