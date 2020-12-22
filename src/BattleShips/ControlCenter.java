package BattleShips;

import java.util.Scanner;
import java.util.Arrays;

public class ControlCenter {
    public static String[][] view_board; //board user sees and tries to attack
    public static String[][] human_board; // Board which holds the human's data
    public static String[][] com_board; // Board which holds the computers data

    public static void main(String[] args){
        Board BB = new Board();
        Human_Turn HT = new Human_Turn();
        Computer_Board CT = new Computer_Board();
        Human_Attack HA = new Human_Attack();
        Computer_Attack CA = new Computer_Attack();
        view_board = new String[8][8];
        human_board = new String[8][8];
        com_board = new String[8][8];
        BB.board_set(view_board); // Filling the view board with "o"
        BB.board_set(human_board); // Filling the human board with "o"
        BB.board_set(com_board); // Filling the computer board with "o"
        //System.out.println(BB.print_board(view_board));
        HT.main(args); // Starts the process which lets the human fill their board
        System.out.println(BB.print_board(human_board));
        CT.main(args);
        //HA.checkHit(HA.attackRow(), HA.attackCol());
        while(HA.checkWin(human_board) == false && HA.checkWin(com_board) == false){
            HA.checkHit(HA.attackRow(), HA.attackCol());
            System.out.println(BB.print_board(view_board));
            System.out.println("Now the computers turn!");
            CA.comAttacking(human_board, HT.getDiff_num());
            System.out.println(BB.print_board(human_board));
        }
        if(HA.checkWin(human_board) == true){
            System.out.println("You lost. Don't worry, you'll get them next time.");
        }
        if(HA.checkWin(com_board) == true){
            System.out.println("YOU WON!!!");
        }
    }

}
