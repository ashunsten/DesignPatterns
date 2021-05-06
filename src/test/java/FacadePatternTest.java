import FacadePattern.Symbols;
import org.junit.Assert;
import org.junit.Test;

public class FacadePatternTest {

    @Test
    public void SymbolsTest(){
        Symbols symbol = Symbols.O;
        Assert.assertEquals("O", symbol.getSymbolString(symbol));

    }
}
