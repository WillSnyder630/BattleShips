package BattleShips;

import java.util.Scanner;

public class Human_Turn {

    private int num_boats;
    private int com_boats;
    private static int diff_num; // 1 = easy, 2 = medium, 3 = hard

    public Human_Turn(){
    }

    public void setNum_boats(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("How many boats would you like?");
        this.num_boats = myScanner.nextInt(); // Variable that holds the number of boats the user uses
    }

    public void setCom_boats(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What difficulty mode would you like the game to be? Easy, Medium, or Hard?" + "\n" + "For more information type 'help'");
        String difficulty = myScanner.next();

        switch (difficulty) {
            case "Easy":
            case "easy":
                this.com_boats = 3;
                this.diff_num = 1;
                return;
            case "Medium":
            case "medium":
                this.com_boats = 3;
                this.diff_num = 2;
                return;
            case "Hard":
            case "hard":
                this.com_boats = 2;
                this.diff_num = 3;
                return;
            case "Help":
            case "help":
                System.out.println("Easy Mode: Three boats, each with a length of 3-5");
                System.out.println("Medium Mode: Three boats, each with a length of 2-4");
                System.out.println("Hard Mode: Two boats, each with a length of 2-3");
                setCom_boats();
                break;
            case "test":
                this.diff_num = 4;
                this.com_boats = 1;
                break;
            default:
                System.out.println("Incorrect input entered");
                break;
        }
    }

    public int getNum_boats(){
        return num_boats;
    }

    public int getCom_boats(){
        return com_boats;
    }

    public int getDiff_num()  { return diff_num; }

    protected int human_row() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Which row would you like the boat to be?");
        int row = myScanner.nextInt();
        //row = row - 1;
        return row;
    }

    protected int human_col() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Which column would you like the boat to be?");
        int col = myScanner.nextInt();
        //col = col - 1;
        return col;
    }

    protected boolean boat_fit(int row, int col, int boat_len, String direction) {
        switch (direction) {
            case "left": {
                int final_loc = col - boat_len;
                System.out.println(final_loc);
                return final_loc >= -2;
            }
            case "right": {
                int final_loc = col + boat_len;
                return final_loc <= 9;
            }
            case "up": {
                int final_loc = row - boat_len;
                return final_loc >= -2;
            }
            case "down": {
                int final_loc = row + boat_len;
                return final_loc <= 9;
            }
            default:
                return true;
        }
    }


    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Human_Turn HT = new Human_Turn();
        Board board_func = new Board();
        HT.setNum_boats();
        for (int i = 0; i < HT.getNum_boats(); i++) { // Runs the same loop for each number of boats the user wants to play with
            int j = i + 1;
            System.out.println("How long would you like boat number " + j + " to be? (Recommeded 3)");
            int boat_length = myScanner.nextInt();
            int row1 = HT.human_row();
            int col1 = HT.human_col();
            System.out.println("What direction should the boat be going (left, right, up, or down)"); // (row1, col1) is the end square
            String dir = myScanner.next();
            if(HT.boat_fit(row1, col1, boat_length, dir)){
                board_func.human_ships(row1, col1, boat_length, dir, ControlCenter.human_board);
            }
            else{
                System.out.println("Boat will not fit at that length, direction, and spot");
            }
            System.out.println(board_func.print_board(ControlCenter.human_board));
        }
    }
}
