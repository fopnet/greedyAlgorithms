package greedyAlgorithms.CoinChange;

import java.text.NumberFormat;
import java.util.Map;

import org.junit.Test;

public class CoinChangeTest {

    @Test
    public void testExecute() {

        CoinChange cc = new CoinChange();
        cc.insertCoin(1);
        cc.insertCoin(5);
        cc.insertCoin(10);
        cc.insertCoin(25);

        Map<Integer, Integer> changes = cc.getChanges(41);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        changes.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getValue() + " coin of " + formatter.format(entry.getKey()));
        });
    }
}