package game;

public class GameController {
    private char[][] gameField = new char[3][3];

    GameController(String initialGameField) {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                gameField[i][j] = initialGameField.charAt(i * gameField.length + j);
            }
        }
    }

    public char[][] getGameField() {
        return gameField;
    }

    public void setGameField(char[][] gameField) {
        this.gameField = gameField;
    }

    public boolean winConditionDiagonal(char symbol){

        int diag1count = 0;
        int diag2count = 0;

        for(int i = 0; i < gameField.length; i++) {
            if(gameField[i][i] == symbol){
                diag1count++;
            }
           if(gameField[i][2-i] == symbol){
                diag2count++;
            }
        }
        if(2 < diag1count || 2 < diag2count){
            return true;
        }
        return false;
    }

    public boolean winConditionRow(char symbol){
        for(int i = 0; i < gameField.length; i++) {
            int count = 0;
            for (int j = 0; j < gameField.length; j++) {
                if(gameField[i][j] == symbol){
                    count++;
                }
            }
            if(count == 3){
                return true;
            }
        }
        return false;
    }

    public boolean winConditionColumn(char symbol){
        for(int i = 0; i < gameField.length; i++) {
            int count = 0;
            for (int j = 0; j < gameField.length; j++) {
                if(gameField[j][i] == symbol){
                    count++;
                }
            }
            if(count == 3){
                return true;
            }
        }
        return false;
    }

    public int elementCounter(char symbol) {

        int count = 0;

        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                if (gameField[i][j] == symbol) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isFinished(){

        if(isPossible() == true){
            if ((checkWin('O') || checkWin('X')) == true) {
                return true;
            }
            else if(isDraw() == true){
                return true;
            }
        }
        return false;
    }
    public boolean checkWin(char who){
        if((winConditionRow(who) || winConditionColumn(who) || winConditionDiagonal(who)) == true){
            return true;
        }
        return false;
    }

    public boolean isPossible() {
        if (Math.abs(elementCounter('O') - elementCounter('X')) < 2){
            if ((checkWin('O') && checkWin('X')) == false) {
                return true;
            }
        }
        return false;
    }

    public boolean isDraw(){
        if(elementCounter('_') == 0){
            if(checkWin('O') == false && checkWin('X') == false){
                return true;
            }
        }
        return false;
    }

    public String getGameStateDescription(){
        String result = null;
        if(isPossible() == false){
            result = "Impossible";
        }
        else if(isFinished() == false){
            result = "Game not finished";
        }
        else if(isDraw() == true){
            result = "Draw";
        }
        else if(checkWin('O') == true){
            result = "O wins";
        }
        else{
            result = "X wins";
        }



        return result;
    }

    public void setField(int[] coordinates, char symbol){
        gameField[coordinates[0]][coordinates[1]] = symbol;
    }

    public void printGameField() {
        printHeader();
        for (var row : gameField) {
            System.out.print("| ");
            for (var elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println("|");
        }
        printHeader();
    }

    private void printHeader() {
        System.out.println("-".repeat(gameField.length * 2 + 3));
    }
}
