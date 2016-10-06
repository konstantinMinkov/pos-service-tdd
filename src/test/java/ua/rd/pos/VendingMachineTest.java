package ua.rd.pos;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class VendingMachineTest {

    private VendingMachine machine = new VendingMachine();
    private Product lemonade = new Product(160, "Lemonade");

    @Test
    public void insertCoin() {
        machine.insertCoin(Coin.TWENTY_FIVE);
    }

    @Test
    public void insertCoinsAndCancel() {
        machine.insertCoin(Coin.FIFTY);
        machine.insertCoin(Coin.ONE);

        final List<Coin> change = machine.cancelOrder();

        assertThat(change, hasItems(Coin.FIFTY, Coin.ONE));
        assertThat(change.size(), is(2));
    }

    @Test
    public void buyUnavailableProduct() {
        insertCoinsForCoffee();

        assertThat(machine.buy(lemonade), CoreMatchers.nullValue());
    }

    @Test
    public void buyProductWithoutMoney() {
        assertThat(machine.buy(Product.COFFEE), CoreMatchers.nullValue());
    }

    @Test
    public void buyProductWithNotEnoughMoney() {
        machine.insertCoin(Coin.FIFTY);
        assertThat(machine.buy(Product.COFFEE), CoreMatchers.nullValue());
    }

    @Test
    public void buyProductWithZeroChange() {
        insertCoinsForCoffee();

        assertThat(machine.buy(Product.COFFEE), is(Product.COFFEE));
        assertThat(machine.getChange(), is(0));
    }

    @Test
    public void buyProductWithChange() {
        insertCoinsForCoffee();
        machine.insertCoin(Coin.FIVE);

        assertThat(machine.buy(Product.COFFEE), is(Product.COFFEE));
        assertThat(machine.getChange(), is(Coin.FIVE.getValue()));
    }

    @Test
    public void getChangeWithoutBuying() {
        assertThat(machine.getChange(), is(0));
    }

    @Test
    public void containsProducts() {
        assertThat(machine.containsProduct(Product.COFFEE), is(true));
        assertThat(machine.containsProduct(Product.TEA), is(true));
        assertThat(machine.containsProduct(Product.JUICE), is(true));
        assertThat(machine.containsProduct(lemonade), is(false));
    }

    private void insertCoinsForCoffee() {
        machine.insertCoin(Coin.FIFTY);
        machine.insertCoin(Coin.FIFTY);
        machine.insertCoin(Coin.FIFTY);
        machine.insertCoin(Coin.FIFTY);
    }
}
