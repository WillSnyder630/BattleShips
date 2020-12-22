package BattleShips;

import java.util.Random;
import java.util.Arrays;

public class Computer_Board {

    Random r = new Random();

    protected int rand_row(){ // Function that picks random row
        return r.nextInt(7) + 1;
    }

    protected int rand_col(){ // Function that picks a random column
        return r.nextInt(7) + 1;
    }

    private int getSize(String[] list){
        int count = 0;
        for(int i =0; i< list.length; i++){
            if(list[i] != null) count++;
        }
        return count;
    }

    private String[] check_fit(int row, int col, int length){
        int count = 0;
        int i = 0;
        if((row + length) <= 9) count++;
        if((row - length) >= 0) count++;
        if((col + length) <= 9) count++;
        if((col - length) >= 0) count++;
        String[] dir = new String[count];
        if((row + length) <= 9) dir[i++] = "down";
        if((row - length) >= 0) dir[i++] = "up";
        if((col + length) <= 9) dir[i++] = "right";
        if((col - length) >= 0) dir[i++] = "left";
        //System.out.println(row + "+ " + col );
        //System.out.println(Arrays.toString(dir));
        return dir;
    }

    protected String rand_dir(String[] dir_options) {
        int rand_choice = r.nextInt(dir_options.length);
        return dir_options[rand_choice];
    }

    private void placeBoats(Human_Turn HT, Board BF){
        //System.out.println(HT.getDiff_num() + " placeBoats");
        switch(HT.getDiff_num()) {
            case 1:
                //System.out.println("Case 1");
                int space = 5;
                for(int i = 0; i < 3; i++){
                    int row = rand_row();
                    int col = rand_col();
                    String dir = rand_dir(check_fit(row, col, space));
                    check_fit(row, col, space);
                    //System.out.println(rand_dir(check_fit(row, col, 3))+ " AAAAA");
                    //System.out.println(BF.computer_ships(row, col, space, dir, ControlCenter.com_board));
                    while(BF.computer_ships(row, col, space, dir, ControlCenter.com_board) < 0){
                        //System.out.println("Change starting place");
                        row = rand_row();
                        col = rand_col();
                        dir = rand_dir(check_fit(row, col, space));
                    }
                    BF.human_ships(row, col, space, dir, ControlCenter.com_board);
                    //System.out.println(BF.print_board(ControlCenter.com_board));
                    space--;
                }
                //System.out.println(BF.print_board(ControlCenter.com_board));
                break;
            case 2:
                //System.out.println("Case 2");
                space = 4;
                for(int i = 0; i < 3; i++){
                    int row = rand_row();
                    int col = rand_col();
                    String dir = rand_dir(check_fit(row, col, space));
                    check_fit(row, col, space);
                    //System.out.println(BF.computer_ships(row, col, space, dir, ControlCenter.com_board));
                    while(BF.computer_ships(row, col, space, dir, ControlCenter.com_board) < 0){
                        //System.out.println("Change starting place");
                        row = rand_row();
                        col = rand_col();
                        dir = rand_dir(check_fit(row, col, space));
                    }
                    BF.human_ships(row, col, space, dir, ControlCenter.com_board);
                    //System.out.println(BF.print_board(ControlCenter.com_board));
                    space--;
                }
                //System.out.println(BF.print_board(ControlCenter.com_board));
                break;
            case 3:
                //System.out.println("Case 3");
                space = 3;
                for(int i = 0; i < 2; i++){
                    int row = rand_row();
                    int col = rand_col();
                    String dir = rand_dir(check_fit(row, col, space));
                    check_fit(row, col, space);
                    //System.out.println(rand_dir(check_fit(row, col, 3))+ " AAAAA");
                    //System.out.println(BF.computer_ships(row, col, space, dir, ControlCenter.com_board));
                    while(BF.computer_ships(row, col, space, dir, ControlCenter.com_board) < 0){
                        //System.out.println("Change starting place");
                        row = rand_row();
                        col = rand_col();
                        dir = rand_dir(check_fit(row, col, space));
                    }
                    BF.human_ships(row, col, space, dir, ControlCenter.com_board);
                    //System.out.println(BF.print_board(ControlCenter.com_board));
                    space--;
                }
                //System.out.println(BF.print_board(ControlCenter.com_board));
                break;
            case 4:
                BF.human_ships(1, 1, 1, "right", ControlCenter.com_board);
                //System.out.println(BF.print_board(ControlCenter.com_board));
                break;
        }
    }

    public static void main(String[] args){
        Computer_Board CB = new Computer_Board();
        Human_Turn HT = new Human_Turn();
        Board BF = new Board();
        HT.setCom_boats();
        CB.placeBoats(HT, BF);
    }
}
