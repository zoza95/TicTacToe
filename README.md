# TicTacToe

![CI Status](https://github.com/zoza95/TicTacToe/workflows/Java%20CI%20with%20Maven/badge.svg)

TicTacToe Game Implementation from [JetBrains Hyperskill](https://hyperskill.org/onboarding/tracks/1/projects/48)

## __Task Description__

JetBrains Academy now has a Java Developer course which I enrolled to get a deeper understanding in Java and Java-based technologies. 

The project consists of 5 stages:
  1. The program needs to be able to print any state of the field.
  2. Analyzing user input and print the state of the field according to the input. 
  3. In this stage we need to determine who is winning and also program needs to tell whether the given state of field is possible. 
  4. In the fourth stage my task was to change the program so it can change the state of field by getting coordinates from the user. 
  5. The last stage of the project is finally about running the game itself. 

## __My Solution__

In this project I used an Object-oriented approach with test-driven development. I created 3 classes to distribute the tasks I was given:
  * _GameController_ class handles the regulations of the game such as win conditions or whether the state of field is possible. The class also handles the construction and the printing of the field.  
  * _IOHandler_ decides if a coordinate given by the user is correct or not.
  * _GameLoop_ runs the game until one of the win conditions meet like one of the players placing three symbols next to each other diagonally.

By writing the test cases for the methods before implementing them helped me think through what should I be careful with and how each method's implementation should look like and work. 


## __Building the project__

To successfully build the project you will need Java 11+ and Maven.

```shell
$ mvn -B package --file pom.xml
```

## __Playing the game__

After building the project you can run the project like this:

```shell
$ cd target/classes
$ java game/Main.class
```
## __Update__

Adding new contributor (wenjaze) to the project for further development assistance.

