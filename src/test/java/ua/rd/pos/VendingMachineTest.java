package ua.rd.pos;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    private VendingMachine machine = new VendingMachine();

    @Test
    public void insertCoin() {
        machine.insertCoin(Coin.TWENTY_FIVE);
    }

    @Test
    public void buyAndCancel() {
        machine.insertCoin(Coin.FIFTY);
        machine.insertCoin(Coin.ONE);

        final List<Coin> change = machine.cancelOrder();

        assertThat(change, hasItems(Coin.FIFTY, Coin.ONE));
        assertThat(change.size(), is(2));
    }
}
