package ua.rd.pos;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class VendingMachineTest {

    private VendingMachine machine = new VendingMachine();
    private Product coffee = new Product(200, "Coffee");

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

        assertThat(machine.buy(new Product(150, "Lemonade")), CoreMatchers.nullValue());
    }

    @Test
    public void buyProductWithoutMoney() {
        assertThat(machine.buy(coffee), CoreMatchers.nullValue());
    }

    @Test
    public void buyProductWithNotEnoughMoney() {
        machine.insertCoin(Coin.FIFTY);
        assertThat(machine.buy(coffee), CoreMatchers.nullValue());
    }

    @Test
    public void buyProductWithZeroChange() {
        insertCoinsForCoffee();

        assertThat(machine.buy(coffee), is(coffee));
        assertThat(machine.getChange(), is(0));
    }

    @Test
    public void buyProductWithChange() {
        insertCoinsForCoffee();
        machine.insertCoin(Coin.FIVE);

        assertThat(machine.buy(coffee), is(coffee));
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
        assertThat(machine.containsProduct(new Product(160, "Lemonade")), is(false));
    }

    private void insertCoinsForCoffee() {
        machine.insertCoin(Coin.FIFTY);
        machine.insertCoin(Coin.FIFTY);
        machine.insertCoin(Coin.FIFTY);
        machine.insertCoin(Coin.FIFTY);
    }
}
