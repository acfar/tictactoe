package id.co.games.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Play {

    public static int N;
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Welcome to Tic-Tac-Toe!!!");
            System.out.println();

            //create marker
            String marker1 = "x";
            String marker2 = "o";
            int playMore;

            Scanner s = new Scanner(System.in);

            do
            {
                //Determining the size of the board
                N = getBoardSize();

                if(N<=0)
                {
                    System.out.println("Size of the board must be greater than '0'!"
                            + "\nPlease enter a valid number for size!!");
                    System.exit(N);
                }
                //run board setup
                Set set = new Set();

                set.createBoardGame();
                set.printBoardGame();

                //create object player and choose marker
                FirstPlayer firstPlayer = new FirstPlayer();
                SecondPlayer secondPlayer = new SecondPlayer();
                System.out.println("Player 1, please choose your marker");
                System.out.println("type 1 for 'X' or 2 for 'O'");

                int marker = s.nextInt();
                //set markers for player 1 & 2
                if(marker == 1)
                {
                    // create player objects
                    System.out.println("You chose cross 'X'");
                    firstPlayer.setMarker("X");
                    secondPlayer.setMarker("O");
                }
                else if(marker == 2)
                {
                    System.out.println("You chose Knought 'O'");
                    firstPlayer.setMarker("O");
                    secondPlayer.setMarker("X");
                }
                else if((marker != 1) && (marker != 2))
                {
                    System.out.println("Please choose either '1' or '2'!!");
                    System.exit(marker);
                }
                // determine will be go first in game
                int first = (int) (Math.random() * 2);
                int playerPlay = first+1;
                System.out.println("Player "+playerPlay+" will go first");
                boolean won = false;
                int turns = 0;

                if(first == 0)
                {
                    if((N == 1) || (N == 2))
                    {
                        System.out.println("When the board is of size 1X1 or 2X2,"
                                + "\nFirst player will  won the game!!");
                        System.exit(turns);
                    }
                }
                else
                {
                    if((N == 1) || (N == 2))
                    {
                        System.out.println("When the board is of size 1X1 or 2X2,"
                                + "\nFirst player will  won the game!!");
                        System.exit(turns);
                    }
                }

                if(first == 0)
                {
                    System.out.println();
                    while(!won)
                    {
                        firstPlayer.getTurn(set.getBoardGame());
                        turns++;
                        set.printBoardGame();
                        if(set.hasWonGame(set.getBoardGame()))
                        {
                            won = true;
                            System.out.println("Congrats, player 1 you just won the game!");
                        }
                        if(turns == N*N)
                        {
                            won = true;
                            //System.out.println(N*N);
                            System.out.println("Its a bore draw!");
                            break;
                        }
                        if(!won)
                        {
                            secondPlayer.getTurn(set.getBoardGame());
                            turns++;
                            System.out.println();
                            set.printBoardGame();
                            System.out.println();
                            if(set.hasWonGame(set.getBoardGame()))
                            {
                                won = true;
                                System.out.println("Congrats Player 2 you just won the game!");
                            }
                            if(turns == N*N)
                            {
                                won = true;
                                System.out.println("Its a draw!");
                                break;
                            }
                        }
                    }  // close while 1
                }
                else
                {
                    System.out.println();
                    while(!won)
                    {
                        secondPlayer.getTurn(set.getBoardGame());
                        turns++;
                        set.printBoardGame();
                        if(set.hasWonGame(set.getBoardGame()))
                        {
                            won = true;
                            System.out.println("Congrats Player 2 you just won the game!");
                        }

                        //checks if maximum moves are made and declares a draw
                        if(turns == N*N)
                        {
                            won = true;
                            System.out.println("Its a draw!");
                            break;
                        }
                        if(!won)
                        {
                            firstPlayer.getTurn(set.getBoardGame());
                            turns++;
                            System.out.println();
                            set.printBoardGame();
                            System.out.println();
                            if(set.hasWonGame(set.getBoardGame()))
                            {
                                won = true;
                                System.out.println("Congrats Player 1 you just won the game!");
                            }
                            if(turns == N*N)
                            {
                                won = true;
                                System.out.println("Its a draw!");
                                break;
                            }
                        }
                    }
                }

                System.out.println("Would you like to play again? Type '1' for yes!!\n"
                        + "Any other input will be considered as a 'NO'!!");
                System.out.println();
                playMore = s.nextInt();
            }while(playMore == 1);
        }
        catch(InputMismatchException e)
        {
            System.out.println("Invalid input!! \n ");
        }
    }
    public static int getBoardSize()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Please choose size board that you want! \n"
                + "Enter 3 for 3X3 Game board, 4 for 4X4 Game board, etc..");
        int boardSize;
        boardSize = s.nextInt();
        System.out.print("You chose a "+boardSize+"X"+boardSize+" board.\n");
        return boardSize;
    }

    public static int bs()
    {
        return N;
    }
}
