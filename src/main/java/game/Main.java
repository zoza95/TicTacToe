package game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         GameLoop game = new GameLoop();
         String gameResult = game.runGame();
         System.out.println(gameResult);
    }
}
