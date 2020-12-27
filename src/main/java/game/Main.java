package game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        GameController gameController = new GameController(scanner.nextLine());
        IOHandler input = new IOHandler();
        gameController.printGameField();
        int[] coordinates = input.inputReader(gameController.getGameField());
        gameController.setField(coordinates, 'X');
        gameController.printGameField();
        //System.out.println(gameController.getGameStateDescription());
        //System.out.println(Arrays.toString(input.inputReader(ch)));

    }
}
