package FacadePattern;

import java.util.Locale;
import java.util.Scanner;

public class Game {

    Board boardGame;
    Symbols currentTurn;

    public Game(){
        this.boardGame = new Board();
        currentTurn = Symbols.X;
    }


    public void NewGame()
    {
        System.out.println("Hi !! Welcome to Tic Tac Toe ..!!");
        System.out.println("Try <Symbol> <Space> <Location Number> to start");
        while(startGame()){
            System.out.println("Do you want to play another Game ?");
            Scanner sc = new Scanner(System.in);
            if(sc.next().trim().toUpperCase(Locale.ROOT)=="N")
                break;
            resetBoard();
        }

    }

    private boolean startGame()
    {
        int stepsCounter=0;
        while(true) {
            boardGame.getBoardStatus();
            Scanner sc = new Scanner(System.in);
            Symbols symbol = parseSymbolString(sc.next());
            int location = Integer.parseInt(sc.next());
            if(symbol!=null){
                if(symbol != currentTurn){
                    System.out.println("This is not your turn..!!!");
                    continue;
                }
                else if (Operations.move(boardGame, location, symbol)) {
                    boardGame.getBoardStatus();
                    System.out.println(Symbols.getSymbolString(symbol) + " Wins the Game");
                    break;
                }
                currentTurn = Symbols.getOtherSymbol(symbol);
                if(isGameOver(++stepsCounter)){
                    break;
                }

            }
            else{
                System.out.println("Invalid Command..!!!");
            }

        }
        return true;
    }
    public Symbols parseSymbolString(String symbol){
        try {
            return Symbols.getSymbolFromString(symbol.trim().toUpperCase(Locale.ROOT));
        }
        catch (Exception e){
            System.out.println("Invalid Command: Try <Symbol> <Space> <Location Number>");
        }
        return null;
    }
    private void resetBoard(){
        this.boardGame.initializeBoard();
        this.currentTurn = Symbols.X;
    }
    private boolean isGameOver(int stepsCounter){
        if(stepsCounter ==9){
            System.out.println("Game Over..!!");
            return true;
        }
        return false;
    }
}
