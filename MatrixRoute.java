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
    public static final int N = 4;
    
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
            //Check below
            for(int i=row; i<N; i++)
            {
                if(board[col][i]==1)
                {
                    flag = false;
                }
            }
            //Check above
            for(int i=row; i>-1; i--)
            {
                if(board[col][i]==1)
                {
                    flag = false;
                }
            }
            //Check to the right
            int diag = 0;
            for(int i = col; i<N; i++)
            {
                //Row || diag up || diag down
                if(board[i][row]==1)
                {
                    flag = false;
                }
                //Diag up
                if(row-diag>-1 && board[i][row-diag]==1)
                {
                    flag = false;
                }
                //Diag down
                if(row+diag<N && board[i][row+diag]==1)
                {
                    flag = false;
                }
                diag++;
            }
            //Check to the left
            diag = 1;
            for(int i=col-1; i>-1; i--)
            {
                if(board[i][row]==1)
                {
                    flag = false;
                }
                //Diag up
                if(row-diag>-1 && board[i][row-diag]==1)
                {
                    flag = false;
                }
                //Diag down
                if(row+diag<N && board[i][row+diag]==1)
                {
                    flag = false;
                }
                diag++;
            }
            
            return flag;
        }
        
        void placeQueen()
        {
            if(col>3)
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
        
       while(currentGame.queens_on_board < N)
        {
            currentGame.printBoard();
            currentGame.placeQueen();

        }
       currentGame.printBoard();
    }
}
