package BattleShips;

public class Computer_Attack {

    protected void comAttacking(String[][] board, int diff_number){
        Computer_Board CB = new Computer_Board();
        switch(diff_number){
            case 0:
                System.out.println("INCORRECT");
                break;
            case 1:
                int row = CB.rand_row();
                int col = CB.rand_col();
                if(board[row][col].equals("B")){
                    System.out.println("The computer hit.");
                    board[row][col] = "X";
                }
                else{
                    board[row][col] = "o";
                    System.out.println("The computer missed.");
                }
                break;
            case 2:
                int chance = CB.rand_row();
                boolean htormss = false;
                if(chance > 4){
                    htormss = true;
                }
                if(htormss == true){
                    comHit();
                }
                else{
                    comMiss();
                }
            case 3:
                int Hchance = CB.rand_row();
                boolean Hhtormss = false;
                if(Hchance > 3){
                    Hhtormss = true;
                }
                if(Hhtormss == true){
                    comHit();
                }
                else{
                    comMiss();
                }
                break;
        }
    }

    protected void comHit(){
        ControlCenter CC = new ControlCenter();
        for(int i = 0; i < CC.human_board.length; i++){
            for(int j = 0; j < CC.human_board.length; j++){
                if(CC.human_board[i][j].equals("B")){
                    System.out.println("The computer hit");
                    CC.human_board[i][j] = "x";
                }
            }
        }
    }

    protected void comMiss(){
        ControlCenter CC = new ControlCenter();
        Computer_Board CB = new Computer_Board();
        int row = CB.rand_row();
        int col = CB.rand_col();
        if(CC.human_board[row][col].equals("-")){
            System.out.println("The computer missed!");
            CC.human_board[row][col] = "o";
        }
        else{
            comMiss();
        }
    }

    public static void main(String[] args) {
    }
}
