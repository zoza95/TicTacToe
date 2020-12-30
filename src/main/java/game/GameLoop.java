package game;

public class GameLoop {

    //String emptyField = "         ";
    String emptyField = "_________";
    char symbol = 'X';
    int[] coordinates = new int[2];

    public String runGame (){
        GameController gameController = new GameController(emptyField);
        IOHandler input = new IOHandler();

        /**
         * Stage 5/1. Prints an empty grid at the beginning of the game.
         */

        gameController.printGameField();

        /**
         * Stage 5/2. Creates a game loop where the program asks the user to enter the cell coordinates,
         * analyzes the move for correctness and shows a grid with the changes if everything is okay.
         */

        do {
            coordinates = input.inputReader(gameController.getGameField());
            gameController.setField(coordinates, symbol);
            gameController.printGameField();
            if(symbol == 'X') {
                symbol = 'O';
            }
            else symbol = 'X';
        } while(gameController.isFinished() == false);


        /**
         * Stage 5/3. Ends the game when someone wins or there is a draw.
         */




        return gameController.getGameStateDescription();
    }
}
