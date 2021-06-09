package com.kodilla.sudoku;


import java.util.Scanner;

public class SudokuGame {

    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        String playerDecision = "";
        SudokuSystem processor = new SudokuSystem();
        SudokuBoard sudokuBoard = processor.createBoard();
        boolean gameFinished = false;

        while(!gameFinished) {
            if(playerDecision.equals("")) {
                System.out.println(sudokuBoard);
            }
            System.out.println("Type FILL if you want to fill more elements with numbers\n" +
                    "Type SUDOKU to solve sudoku\n" +
                    "Type END to finish the game");
            playerDecision = scan.nextLine();

            if(playerDecision.equals("FILL")) {
                processor.setSudokuValue(sudokuBoard);
            } else if(playerDecision.equals("SUDOKU")) {
                try{
                    processor.eliminateNumbers(sudokuBoard);
                    processor.putNumber(sudokuBoard);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("index out of bound");
                }
            } else if(playerDecision.equals("TESTBOARD")) {
                processor.testBoard(sudokuBoard);
                System.out.println(sudokuBoard);
            }
            else if(playerDecision.equals("END")) {
                gameFinished = true;
            }
        }
    }
}
