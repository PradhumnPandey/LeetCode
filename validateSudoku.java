import java.util.*;
public class validateSudoku {
     public static void main(String[] args) {
        char[][] board = new char[][]{{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
     }

    public static boolean isValidSudoku(char[][] board) {
        
       Map<Integer,List<Character>> rows = new HashMap<>();
       Map<Integer,List<Character>> cols = new HashMap<>();
       Map<Integer,List<Character>> grid = new HashMap<>();
       List<Character> temp;
       int k;
        for(int i = 0; i< 9; i++)
        {
            for(int j = 0; j< 9;j++)
            {
                if((int)board[i][j] > 57 || (int)board[i][j] < 48) continue;
                //rows
                temp = rows.getOrDefault(i, null);
                if(temp != null)
                {
                    if(temp.contains(board[i][j])) return false;
                    else
                    temp.add(board[i][j]);
                }
                else
                {
                    temp = new ArrayList<>();
                    temp.add(board[i][j]);
                    rows.put(i,temp);
                }

                 //cols
                 temp = cols.getOrDefault(j, null);
                 if(temp != null)
                 {
                     if(temp.contains(board[i][j])) return false;
                     else
                     temp.add(board[i][j]);
                 }
                 else
                 {
                     temp = new ArrayList<>();
                     temp.add(board[i][j]);
                     cols.put(j,temp);
                 }

                  //grid
                if(i<3)
                {
                    if(j<3) k = 0;
                    else if( j < 6) k = 1;
                    else k = 2;
                }
                else if(i<6)
                {
                    if(j<3) k = 3;
                    else if( j < 6) k = 4;
                    else k = 5;
                }
                else
                {
                    if(j<3) k = 6;
                    else if( j < 6) k = 7;
                    else k = 8;
                }
                temp = grid.getOrDefault(k, null);
                if(temp != null)
                {
                    if(temp.contains(board[i][j])) return false;
                    else
                    temp.add(board[i][j]);
                }
                else
                {
                    temp = new ArrayList<>();
                    temp.add(board[i][j]);
                    grid.put(k,temp);
                }
            }
        }

        return true;
    }
}
