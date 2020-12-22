package BattleShips;


import java.util.Arrays;

public class Board {

    protected void board_set(String[][] board){ //Function that fills a board with "o" to show empty
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j] = "-";
            }
        }
    }

    protected void human_ships(int row, int col, int length, String dir, String[][] board){ // Function that sets user board
        row = row -1;
        col = col -1;
        int test_row = row;
        int test_col = col;
        if(dir.equals("left")){
            for(int i = 0; i < length; i++){
                if(board[row][col].equals("B")){
                    System.out.println("There is already a boat in this spot!");
                    return;
                }
                test_col = test_col - 1;
            }
            for(int i = 0; i < length; i++){
                board[row][col] = "B";
                col = col - 1;
            }
        }
        if(dir.equals("right")){
            for(int i = 0; i < length; i++){
                if(board[row][col].equals("B")){
                    System.out.println("There is already a boat in this spot!");
                    return;
                }
                test_col = test_col + 1;
            }
            for(int i = 0; i < length; i++){
                board[row][col] = "B";
                col = col + 1;
            }
        }
        if(dir.equals("up")){
            for(int i = 0; i < length; i++){
                if(board[row][col].equals("B")){
                    System.out.println("There is already a boat in this spot!");
                    return;
                }
                test_row = test_row - 1;
            }
            for(int j = 0; j < length; j++){
                board[row][col] = "B";
                row = row - 1;
            }
        }
        if(dir.equals("down")){
            for(int i = 0; i < length; i++){
                if(board[row][col].equals("B")){
                    System.out.println("There is already a boat in this spot!");
                    return;
                }
                test_row = test_row + 1;
            }
            for(int i = 0; i < length; i++){
                board[row][col] = "B";
                row = row + 1;
            }
        }
    }

    protected int computer_ships(int row, int col, int length, String dir, String[][] board){ // Function that sets user board
        row = row -1;
        col = col -1;
        int test_row = row;
        int test_col = col;
        if(dir.equals("left")){
            //System.out.println(dir);
            for(int i = 0; i < length; i++){
                //System.out.println(test_col);
                if(board[row][test_col].equals("B")){
                    return -1;
                }
                test_col = test_col - 1;
            }
        }
        if(dir.equals("right")){
            //System.out.println(dir);
            for(int i = 0; i < length; i++){
                //System.out.println(test_col);
                if(board[row][test_col].equals("B")){
                    return -1;
                }
                test_col = test_col + 1;
            }
        }
        if(dir.equals("up")){
            //System.out.println(dir);
            for(int i = 0; i < length; i++){
                //System.out.println(test_row);
                if(board[test_row][col].equals("B")){
                    return -1;
                }
                test_row = test_row - 1;
            }
        }
        if(dir.equals("down")){
            //System.out.println(dir);
            for(int i = 0; i < length; i++){
                //System.out.println(test_row);
                if(board[test_row][col].equals("B")){
                    return -1;
                }
                test_row = test_row + 1;
            }
        }
        return 1;
    }

    public String print_board(String[][] board){ // Function that prints the boards
        String print = "";
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                print += board[i][j] + "  ";
            }
            print += "\n";
        }
        return print;
    }

}
