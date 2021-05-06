package FacadePattern;

import java.util.Locale;

public class Operations {

    public static boolean move(Board board, int location, Symbols symbol) {
        if(!verifyMove(board,location)){
            System.out.println("Invalid Move, Please try again..!!!");
            return false;
        }
        board.setBoardBlock(location,symbol);
        return (verifyWin(board,symbol));
    }

    private static boolean verifyMove(Board board,int location) {

        if(board.getBoard()[(location-1)/3][(location-1)%3] == "X" ||
                board.getBoard()[(location-1)/3][(location-1)%3] == "O")
            return false;
        return true;
    }
    private static boolean verifyWin(Board board,Symbols symbol){

        for(int i=0;i<3;i++){
            if(board.getBoard()[i][0]==board.getBoard()[i][1]
                    && board.getBoard()[i][1]==board.getBoard()[i][2]
                    && board.getBoard()[i][2]==symbol.getSymbolString(symbol)){
                return true;

            }
            else if(board.getBoard()[0][0]==board.getBoard()[1][1]
                    && board.getBoard()[1][1]==board.getBoard()[2][2]
                    && board.getBoard()[2][2]==symbol.getSymbolString(symbol)){
                return true;

            }
            else if(board.getBoard()[0][i]==board.getBoard()[1][i]
                    && board.getBoard()[1][i]==board.getBoard()[2][i]
                    && board.getBoard()[2][i]==symbol.getSymbolString(symbol)){
                return true;

            }
            else if(board.getBoard()[0][2]==board.getBoard()[1][1]
                    && board.getBoard()[1][1]==board.getBoard()[2][0]
                    && board.getBoard()[2][0]==symbol.getSymbolString(symbol)){
                return true;

            }
        }
        return false;

    }
}
