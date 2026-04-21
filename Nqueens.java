import java.util.*;

public class NQueens {
    static int N;

    static boolean isSafe(int[][] board,int row,int col){
        for(int i=0;i<row;i++)
            if(board[i][col]==1) return false;

        for(int i=row,j=col;i>=0&&j>=0;i--,j--)
            if(board[i][j]==1) return false;

        for(int i=row,j=col;i>=0&&j<N;i--,j++)
            if(board[i][j]==1) return false;

        return true;
    }

    static boolean solve(int[][] board,int row){
        if(row==N) return true;

        for(int col=0;col<N;col++){
            if(isSafe(board,row,col)){
                board[row][col]=1;
                if(solve(board,row+1)) return true;
                board[row][col]=0;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();

        int[][] board=new int[N][N];

        if(solve(board,0)){
            for(int[] r:board)
                System.out.println(Arrays.toString(r));
        }
    }
}
