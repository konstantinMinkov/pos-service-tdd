package ua.rd.pos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kostiantyn_Minkov on 10/6/2016.
 */
public class VendingMachine {

    private List<Integer> insertedCoins = new ArrayList<>();

    public void insertCoin(int coinValue) {
        insertedCoins.add(coinValue);
    }
}
