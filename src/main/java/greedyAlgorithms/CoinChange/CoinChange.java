package greedyAlgorithms.CoinChange;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

public class CoinChange {

    TreeSet<Integer> coins;

    public CoinChange() {
        this.coins = new TreeSet<>();
    }

    public void insertCoin(Integer coin) {
        this.coins.add(coin);
    }

    public void removeCoin(Integer coin) {
        this.coins.add(coin);
    }

    public Map<Integer, Integer> getChanges(Integer value) {
        if (this.coins.size() == 0)
            throw new RuntimeException("Please insert some coin changes");

        Map<Integer, Integer> changes = new TreeMap<Integer, Integer>();

        do {
            Integer higherCoin = this.getHigherCoin(value);
            value -= higherCoin;

            Integer amount = changes.get(higherCoin);
            if (amount == null)
                amount = 0;

            changes.put(higherCoin, ++amount);
        } while (value > 0);

        return changes;
    }

    Integer getHigherCoin(Integer value) {
        List<Integer> list = Arrays.asList(this.coins.descendingSet().toArray(new Integer[4]));
        Queue<Integer> coinStack = new LinkedList<Integer>(list);

        Integer higher = null;
        while (higher == null || higher > value) {
            higher = coinStack.poll();
        }

        return higher;
    }

}