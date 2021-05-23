package id.co.games.tictactoe;

import java.util.Scanner;

public class SecondPlayer extends Player {
    public SecondPlayer()
    {

    }

    public void getTurn(String[][] boardGame)
    {

        Scanner s = new Scanner(System.in);

        boolean turn = true;

        int bs = Play.bs();
        System.out.println("Player 2 it's your turn");
        while(turn)
        {
            System.out.println("please enter row");
            int row = s.nextInt();
            System.out.println("please enter col");
            int column = s.nextInt();
            System.out.print("you entered "+row+" "+column);
            System.out.println();
            if(row<1 || row>bs || column<1 ||column>bs)
            {
                System.out.println("Please enter valid row and column that you want");
                System.exit(bs);
            }
            if(!"X".equals(boardGame[row - 1][column - 1]) && !"O".equals(boardGame[row - 1][column - 1]))
            {
                boardGame[row - 1][column - 1] = Marker;
                turn = false;
            } // closes if
            else
            {
                System.out.println("Already Marker here! please guess again!");
            }
        }
    }
}
