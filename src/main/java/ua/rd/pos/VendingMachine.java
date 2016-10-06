package ua.rd.pos;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private List<Integer> insertedCoins = new ArrayList<>();

    public void insertCoin(int coinValue) {
        insertedCoins.add(coinValue);
    }
}
