import java.util.Stack;

/*
http://www.techiedelight.com/print-possible-solutions-n-queens-problem/
The N queens puzzle is the problem of placing N chess queens on an N × N chessboard so that no two queens threaten each other. Thus, a solution requires that no two queens share the same row, column, or diagonal.

planning
--------
- chessboard is 8x8
- create matrix int[8][8]
>> noQueen = 0, ifQueen = 1
- Queen moves row, column, diagonal
!!! MUST have a queen in every column
e.g. 4x4
1. Place Queen, move to next column (continue)
>> If you can't place queen, move back one column
>> find Queen, place it in next position (continue)


 */
public class MatrixRoute
{
    public static final int N = 8;
    
    public static class ChessBoard
    {
        int[][] board = new int[N][N]; //Default {0}
        int queens_on_board;
        int row, col; //Current row and column
        Stack<Integer> save = new Stack<>();
        
        ChessBoard()
        {
            queens_on_board = 0;
            row = 0;
            col = 0;
            save.push(0);
        }
        
        boolean isSafe()
        {
            boolean flag = true;
            for(int i = 0; i<N;i++)
            {
                //Check column
                if(board[i][col]==1)
                {
                    flag = false;
                }
                //Check row
                if(board[row][i]==1)
                {
                    flag = false;
                }
            }
            //Check diagonal up
            for(int i=0; row-i>-1; i++)
            {
                //Diag up right
                if(col+i<N && board[row-i][col+i]==1)
                {
                    flag = false;
                }
                //Diag up left
                if(col-i>-1 && board[row-i][col-i]==1)
                {
                    flag = false;
                }
            }
            //Check diag down
            for(int i=0; row+i<N; i++)
            {
                //Diag down right
                if(col+i<N && board[row+i][col+i]==1)
                {
                    flag = false;
                }
                //Diag down left
                if(col-i>-1 && board[row+i][col-i]==1)
                {
                    flag = false;
                }

            }
            return flag;
        }
        
        void placeQueen()
        {
            if(col>N-1)
            {
                row--;
                queens_on_board--;
                if(save.isEmpty())
                {
                    save.push(0);
                }
                if(row==-1)
                {
                    row=0;
                }
                board[row][save.peek()]=0;
                col = save.pop() + 1;
            }
            else if(!isSafe())
            {
                col++;
                placeQueen();
            }
            else
            {
                board[row][col] = 1;
                queens_on_board++;
                row++;
                save.push(col);
                col = 0;
            }

        }
        
        void printBoard()
        {
            System.out.println();

            for(int i = 0; i<N; i++)
            {
                for(int j = 0; j<N; j++)
                {
                    System.out.print(board[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args)
    {
        ChessBoard currentGame = new ChessBoard();
        System.out.println("...calculating...");
       while(currentGame.queens_on_board < N)
        {
            //currentGame.printBoard();
            currentGame.placeQueen();

        }
       currentGame.printBoard();
    }
}
