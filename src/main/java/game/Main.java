package game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        //Scanner scanner = new Scanner(System.in);
//        //System.out.print("Enter cells: ");
//        String emptyField = "         ";
//        GameController gameController = new GameController(emptyField);
//        IOHandler input = new IOHandler();
//        gameController.printGameField();
//        int[] coordinates = input.inputReader(gameController.getGameField());
//        gameController.setField(coordinates, 'X');
//        gameController.printGameField();
//        //System.out.println(gameController.getGameStateDescription());
//        //System.out.println(Arrays.toString(input.inputReader(ch)));
         GameLoop game = new GameLoop();
         String gameResult = game.runGame();
         System.out.println(gameResult);

    }
}
