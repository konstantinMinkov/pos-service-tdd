package ua.rd.pos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachine {

    private List<Coin> insertedCoins = new ArrayList<>();

    public void insertCoin(Coin coin) {
        insertedCoins.add(coin);
    }

    public List<Coin> cancelOrder() {
        final List<Coin> change = Collections.unmodifiableList(insertedCoins);
        insertedCoins = new ArrayList<>();
        return change;
    }

    public Product buy(Product product) {
        int insertedCoinsSum = 0;
        for (Coin coin : insertedCoins) {
            insertedCoinsSum += coin.getValue();
        }
        if (insertedCoinsSum >= product.getPrice()) {
            countChange();
            return product;
        }
        return null;
    }

    private void countChange() {
    }
}
