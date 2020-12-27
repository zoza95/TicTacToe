package game;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class TestIOHandler {

    private static InputStream sysInBackup;
    private static PrintStream sysOutBackup;


    @BeforeClass
    public static void beforeClass(){
        sysInBackup = System.in;
        sysOutBackup = System.out;
    }

    @AfterClass
    public static void afterClass(){
        System.setIn(sysInBackup);
        System.setOut(sysOutBackup);
    }

    @Test
    public void testinputReaderParsesInputData(){
        IOHandler inputData = new IOHandler();
        ByteArrayInputStream testInput = new ByteArrayInputStream("3 1\n".getBytes()); //Konzolrol olvasas helyett statikus inputot adunk meg.
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream(); //outputStreamCaptor : Ezzel elfogjuk az outputot, nem engedjuk ki a konzolra, ebbe a valtozoba rakjuk.
        System.setIn(testInput);
        System.setOut(new PrintStream(testOutput));
        assertArrayEquals(new int[]{2, 0} ,inputData.inputReader(new char [][]{
                {'X', '_', 'X'},
                {'_', 'O', '_'},
                {'_', '_', '_'}
        }));
        assertEquals("Enter the coordinates: ", testOutput.toString());
    }

    @Test
    public void testinputReaderParsesInputData2(){
        IOHandler inputData = new IOHandler();
        ByteArrayInputStream testInput = new ByteArrayInputStream("1 1\n".getBytes());
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setIn(testInput);
        System.setOut(new PrintStream(testOutput));
        assertArrayEquals(new int[]{0, 0} ,inputData.inputReader(new char [][]{
                {'_', 'X', 'X'},
                {'O', 'O', '_'},
                {'X', 'X', '_'}
        }));
        assertEquals("Enter the coordinates: ", testOutput.toString());
    }

    @Test
    public void testinputReaderParsesInputData3(){
        IOHandler inputData = new IOHandler();
        ByteArrayInputStream testInput = new ByteArrayInputStream("3 3\n".getBytes());
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setIn(testInput);
        System.setOut(new PrintStream(testOutput));
        assertArrayEquals(new int[]{2, 2} ,inputData.inputReader(new char [][]{
                {'X', 'O', 'X'},
                {'_', 'O', '_'},
                {'O', 'X', '_'}
        }));
        assertEquals("Enter the coordinates: ", testOutput.toString());
    }

    @Test
    public void testinputReaderParsesInputData4(){
        IOHandler inputData = new IOHandler();
        ByteArrayInputStream testInput = new ByteArrayInputStream("2 3".getBytes());
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setIn(testInput);
        System.setOut(new PrintStream(testOutput));
        assertArrayEquals(new int[]{1, 2} ,inputData.inputReader(new char [][]{
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        }));
        assertEquals("Enter the coordinates: ", testOutput.toString());
    }

    @Test
    public void testinputReaderIsCellOccupied(){
        IOHandler inputData = new IOHandler();
        ByteArrayInputStream testInput = new ByteArrayInputStream("3 1\n1 1\n".getBytes());
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setIn(testInput);
        System.setOut(new PrintStream(testOutput));
        assertArrayEquals(new int[]{0, 0} ,inputData.inputReader(new char [][]{
                {'_', 'X', 'X'},
                {'O', 'O', '_'},
                {'O', 'X', '_'}
        }));
        assertEquals("Enter the coordinates: " +
                "This cell is occupied! Choose another one!" + System.lineSeparator(), testOutput.toString());
    }

    @Test
    public void testinputReaderIsCellOccupied2(){
        IOHandler inputData = new IOHandler();
        ByteArrayInputStream testInput = new ByteArrayInputStream("1 3\n1 1\n".getBytes());
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setIn(testInput);
        System.setOut(new PrintStream(testOutput));
        assertArrayEquals(new int[]{0, 0} ,inputData.inputReader(new char [][]{
                {'_', 'X', 'X'},
                {'O', 'O', '_'},
                {'O', 'X', '_'}
        }));
        assertEquals("Enter the coordinates: " +
                "This cell is occupied! Choose another one!" + System.lineSeparator(), testOutput.toString());
    }

    @Test
    public void testinputReaderInputIsNumber(){
        IOHandler inputData = new IOHandler();
        ByteArrayInputStream testInput = new ByteArrayInputStream("\none\none one\n1 1\n".getBytes());
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setIn(testInput);
        System.setOut(new PrintStream(testOutput));
        assertArrayEquals(new int[]{0, 0} ,inputData.inputReader(new char [][]{
                {'_', 'X', 'X'},
                {'O', 'O', '_'},
                {'O', 'X', '_'}
        }));
        assertEquals("Enter the coordinates: " +
                        "You should enter numbers!" + System.lineSeparator() +
                        "You should enter numbers!" + System.lineSeparator() +
                        "You should enter numbers!" + System.lineSeparator()
                , testOutput.toString());
    }

    @Test
    public void testinputReaderInputIsNumber2(){
        IOHandler inputData = new IOHandler();
        ByteArrayInputStream testInput = new ByteArrayInputStream("1 one\none 1 1\n1 1\n".getBytes());
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setIn(testInput);
        System.setOut(new PrintStream(testOutput));
        assertArrayEquals(new int[]{0, 0} ,inputData.inputReader(new char [][]{
                {'_', 'X', 'X'},
                {'O', 'O', '_'},
                {'O', 'X', '_'}
        }));
        assertEquals("Enter the coordinates: " +
                        "You should enter numbers!" + System.lineSeparator() +
                        "You should enter numbers!" + System.lineSeparator()
                , testOutput.toString());
    }

    @Test
    public void testinputReaderInputIsInRange(){
        IOHandler inputData = new IOHandler();
        ByteArrayInputStream testInput = new ByteArrayInputStream("0 0\n4 4\n4 1\n1 4\n1 1\n".getBytes());
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setIn(testInput);
        System.setOut(new PrintStream(testOutput));
        assertArrayEquals(new int[]{0, 0} ,inputData.inputReader(new char [][]{
                {'_', 'X', 'X'},
                {'O', 'O', '_'},
                {'O', 'X', '_'}
        }));
        assertEquals("Enter the coordinates: Coordinates should be from 1 to 3!" + System.lineSeparator() +
                "Coordinates should be from 1 to 3!" + System.lineSeparator() +
                "Coordinates should be from 1 to 3!" + System.lineSeparator() +
                "Coordinates should be from 1 to 3!" + System.lineSeparator(), testOutput.toString());
    }

    @Test
    public void testinputReaderTwoCoordinates(){
        IOHandler inputData = new IOHandler();
        ByteArrayInputStream testInput = new ByteArrayInputStream("1 1 2\n".getBytes());
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setIn(testInput);
        System.setOut(new PrintStream(testOutput));
        assertArrayEquals(new int[]{0, 0} ,inputData.inputReader(new char [][]{
                {'_', 'X', 'X'},
                {'O', 'O', '_'},
                {'O', 'X', '_'}
        }));
        assertEquals("Enter the coordinates: ", testOutput.toString());
    }

    @Test
    public void testinputReaderTwoCoordinates2(){
        IOHandler inputData = new IOHandler();
        ByteArrayInputStream testInput = new ByteArrayInputStream("1 1 2 2 2 3\n".getBytes());
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setIn(testInput);
        System.setOut(new PrintStream(testOutput));
        assertArrayEquals(new int[]{0, 0} ,inputData.inputReader(new char [][]{
                {'_', 'X', 'X'},
                {'O', 'O', '_'},
                {'O', 'X', '_'}
        }));
        assertEquals("Enter the coordinates: ", testOutput.toString());
    }
}
