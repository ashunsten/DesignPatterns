package FacadePattern;

public class Board {

    private String[][] board;

    public Board(){
        this.board = new String[3][3];
        initializeBoard();
    }

    public void initializeBoard(){

        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                this.board[i][j]= String.valueOf(i*3+(j+1));
            }
        }
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoardBlock(int location, Symbols symbol) {
        this.board[(location-1)/3][(location-1)%3] = symbol.getSymbolString(symbol);
    }

    public void getBoardStatus(){
        for (int i=0;i<3;i++){

            for (int j=0;j<3;j++){
                System.out.print("  "+ this.board[i][j] + "  | ");
            }
            System.out.println();
            System.out.println("--------------------");
        }
    }


}
