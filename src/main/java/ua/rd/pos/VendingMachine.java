package ua.rd.pos;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private List<Coin> insertedCoins = new ArrayList<>();

    public void insertCoin(Coin coin) {
        insertedCoins.add(coin);
    }
}
