package game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        GameController gameController = new GameController(scanner.nextLine());
        gameController.printGameField();
        System.out.println(gameController.getGameStateDescription());
    }
}
