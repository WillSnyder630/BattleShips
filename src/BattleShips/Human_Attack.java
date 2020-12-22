package BattleShips;

import javax.naming.ldap.Control;
import java.util.Scanner;

public class Human_Attack {

    public Human_Attack(){
        int row;
        int col;
    }

    protected int attackRow(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What row would you like to attack?");
        int row = myScanner.nextInt();
        row--;
        return row;
    }

    protected int attackCol(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What column would you like to attack?");
        int col = myScanner.nextInt();
        col--;
        return col;
    }

    protected void checkHit(int row, int col){
        ControlCenter CC = new ControlCenter();
        if(CC.com_board[row][col].equals("B")){
            System.out.println("HIT!");
            CC.view_board[row][col] = "X";
            CC.com_board[row][col] = "-";
        }
        else{
            System.out.println("Miss");
            CC.view_board[row][col] = "o";
        }
    }

    protected boolean checkWin(String[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j].equals("B")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
//        Board BB = new Board();
//        Human_Attack HA = new Human_Attack();
//        ControlCenter CC = new ControlCenter();
//        HA.checkHit(HA.attackRow(), HA.attackCol());
//        System.out.println(BB.print_board(CC.view_board));
//        System.out.println(HA.checkWin());
    }
}
