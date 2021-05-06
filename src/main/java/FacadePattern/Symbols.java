package FacadePattern;

import java.util.Locale;

public enum Symbols {

    X,
    O;

    public static String getSymbolString(Symbols symbol) {
        switch (symbol){
            case O:
                return "O";
            case X:
                return "X";
            default:
                return null;
        }
    }

    public static Symbols getOtherSymbol(Symbols symbol) {
        switch (symbol){
            case O:
                return Symbols.X;
            case X:
                return Symbols.O;
            default:
                return null;
        }
    }
    public static Symbols getSymbolFromString(String symbolString){
        switch (symbolString){
            case "O":
                return Symbols.O;
            case "X":
                return Symbols.X;
            default:
                return null;
        }
    }

}
