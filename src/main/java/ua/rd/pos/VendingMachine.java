package ua.rd.pos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachine {

    private List<Coin> insertedCoins = new ArrayList<>();
    private int change;

    public void insertCoin(Coin coin) {
        insertedCoins.add(coin);
    }

    public List<Coin> cancelOrder() {
        final List<Coin> change = Collections.unmodifiableList(insertedCoins);
        insertedCoins = new ArrayList<>();
        return change;
    }

    public Product buy(Product product) {
        final int insertedCoinsSum = countInsertedCoinsSum();
        if (isEnoughMoney(product, insertedCoinsSum)) {
            countChange(product, insertedCoinsSum);
            return product;
        }
        return null;
    }

    private boolean isEnoughMoney(Product product, int insertedCoinsSum) {
        return insertedCoinsSum >= product.getPrice();
    }

    private int countInsertedCoinsSum() {
        int insertedCoinsSum = 0;
        for (Coin coin : insertedCoins) {
            insertedCoinsSum += coin.getValue();
        }
        return insertedCoinsSum;
    }

    private void countChange(Product product, int insertedCoins) {
        change = insertedCoins - product.getPrice();
    }

    public int getChange() {
        final int change = this.change;
        this.change = 0;
        return change;
    }

    public boolean containsProduct(Product product) {
        return Product.COFFEE.equals(product)
                || Product.TEA.equals(product)
                || Product.JUICE.equals(product);
    }
}
