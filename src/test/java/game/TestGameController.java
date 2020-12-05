package game;


import org.junit.Test;

import static org.junit.Assert.*;

public class TestGameController {

    /**
     * _ _ _
     * O _ O
     * X X X
     */

    @Test
    public void testWinConditionRowWorksForLastRow(){
        GameController state = new GameController("___O_OXXX");
        assertTrue(state.winConditionRow('X'));
    }

    /**
     * X X X
     * O _ O
     * X O X
     */

    @Test
    public void testWinConditionRowWorksForFirstRow(){
        GameController state = new GameController("XXXO_OXOX");
        assertTrue(state.winConditionRow('X'));
    }

    /**
     * X X O
     * X O _
     * X O O
     */

    @Test
    public void testWinConditionRowWorksForFirstColumn(){
        GameController state = new GameController("XXOXO_XOO");
        assertTrue(state.winConditionColumn('X'));
    }

    /**
     * O X X
     * O O X
     * _ O X
     */

    @Test
    public void testWinConditionRowWorksForLastColumn(){
        GameController state = new GameController("OXXOOX_OX");
        assertTrue(state.winConditionColumn('X'));
    }

    /**
     * X O O
     * O X _
     * O X X
     */

    @Test
    public void testWinConditionDiagonal1Works(){
        GameController state = new GameController("XOOOX_OXX");
        assertTrue(state.winConditionDiagonal('X'));
    }

    /**
     * O O X
     * O X O
     * X _ X
     */

    @Test
    public void testWinConditionDiagonal2Works(){
        GameController state = new GameController("OOXOXOX_X");
        assertTrue(state.winConditionDiagonal('X'));
    }

    /**
     * _ _ O
     * X _ O
     * _ X _
     */

    @Test
    public void testIsFinishedWorksForMoreThanFourEmptyFields(){
        GameController state = new GameController("__OX_O_X_");
        assertFalse(state.isFinished());
    }

    /**
     * X O X
     * O X O
     * O O X
     */

    @Test
    public void testIsFinishedWorksForWinConditionReached(){
        GameController state = new GameController("XOXOXOOOX");
        assertTrue(state.isFinished());
    }

    /**
     * X O X
     * O _ X
     * O X O
     */

    @Test
    public void testIsFinishedWorksForOneEmptyField(){
        GameController state = new GameController("XOXO_XOXO");
        assertFalse(state.isFinished());
    }

    /**
     * X X X
     * O O O
     * X O _
     */

    @Test
    public void testIsPossibleTwoWinner(){
        GameController state = new GameController("XXXOOOXO_");
        assertFalse(state.isPossible());
    }

    /**
     * X X X
     * O X X
     * O O X
     */

    @Test
    public void testIsPossibleALotMoreSymbolThanTheOther(){
        GameController state = new GameController("XXXOXXOOX");
        assertFalse(state.isPossible());
    }

    /**
     * X X X
     * O X _
     * O O X
     *
     * X X _
     * _ _ _
     * _ _ _
     */

    @Test
    public void testIsPossible2MoreSymbolThanTheOther(){
        GameController state = new GameController("XXXOX_OOX");
        assertFalse(state.isPossible());

        state = new GameController("XX_______");
        assertFalse(state.isPossible());
    }

    /**
     * X O X
     * X X O
     * O O O
     */

    @Test
    public void testoWinsWorks(){
        GameController state = new GameController("XOXXXOOOO");
        assertTrue(state.checkWin('O'));
    }

    /**
     * O X O
     * X X O
     * O X X
     */

    @Test
    public void testoWinsWorksIfXWins(){
        GameController state = new GameController("OXOXXOOXX");
        assertFalse(state.checkWin('O'));
    }

    /**
     * O X O
     * X X O
     * O X X
     */

    @Test
    public void testxWinsWorks(){
        GameController state = new GameController("OXOXXOOXX");
        assertTrue(state.checkWin('X'));
    }

    /**
     * X O X
     * X X O
     * O O O
     */

    @Test
    public void testxWinsWorksIfOWins(){
        GameController state = new GameController("XOXXXOOOO");
        assertFalse(state.checkWin('X'));
    }

    /**
     * X O X
     * O X O
     * O X O
     */

    @Test
    public void testisDrawWorks(){
        GameController state = new GameController("XOXOXOOXO");
        assertTrue(state.isDraw());
    }

    /**
     * X O X
     * O _ X
     * O X O
     */

    @Test
    public void testgetGameStateDescriptionWorks(){
        GameController state1 = new GameController("XOXOXOOXO");
        GameController state2 = new GameController("XOXXXOOOO");
        GameController state3 = new GameController("OXOXXOOXX");
        GameController state4 = new GameController("XOXO_XOXO");
        GameController state5 = new GameController("XXXOOOXO_");
        assertEquals("Draw", state1.getGameStateDescription());
        assertEquals("O wins", state2.getGameStateDescription());
        assertEquals("X wins", state3.getGameStateDescription());
        assertEquals("Game not finished", state4.getGameStateDescription());
        assertEquals("Impossible", state5.getGameStateDescription());
    }

}
