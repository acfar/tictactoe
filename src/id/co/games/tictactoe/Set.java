package id.co.games.tictactoe;

import java.util.Scanner;

public class Set {
    Scanner s = new Scanner(System.in);

    int N = Play.bs();
    public String[][] boardGame = new String [N][N];

    //checking for win condition every player turn
    public boolean hasWonGame (String [] [] boardGame)
    {
        int count = 1;
        //horizontal
        for(int i = 0; i<N; i++)
        {
            for(int j=0;j<N-1;j++)
            {
                if(boardGame[i][j].equals(boardGame[i][j+1]))
                {
                    count = count+1;
                }
                if(count == N)
                {
                    return true;
                }
            }
            count = 1;
        }

        count = 1;
        // check for vertical
        for(int i = 0; i<N; i++)
        {
            for(int j=0;j<N-1;j++)
            {
                if(boardGame[j][i].equals(boardGame[j+1][i]))
                {
                    count = count+1;
                }
                if(count == N)
                {
                    return true;
                }
            }
            count = 1;
        }

        count = 1;
        //check for diagonal left-top to right-bottom
        for(int i=0;i<N-1;i++)
        {
            if(boardGame[i][i].equals(boardGame[i+1][i+1]))
            {
                count = count+1;
            }
            if (count==N)
            {
                return true;
            }
            //counter = 1;
        }

        count = 1;
        //check for diagonal right-top to left-bottom
        for(int i=0;i<N-1;i++)
        {
            if(boardGame[i][N-1-i].equals(boardGame[i+1][N-1-(i+1)]))
            {
                count = count+1;
            }
            if (count==N)
            {
                return true;
            }
        }
        return false;
    }

    int x = 1;

    //create & initate board game
    public void createBoardGame()
    {
        for(int i = 0; i < boardGame.length; i++)
        {
            for(int j = 0; j < boardGame.length; j++)
            {
                boardGame[i][j] = "" + (x);
                x++;
            }
        }
    }

    //print board game
    public void printBoardGame()
    {
        for(int i = 0; i < boardGame.length; i++)
        {
            for(int j = 0; j < boardGame.length; j++)
            {
                System.out.print("[ " + boardGame[i][j] + " ]" + " ");
            }
            System.out.println();
        }
    }

    public String[][] getBoardGame()
    {
        return boardGame;
    }
}
