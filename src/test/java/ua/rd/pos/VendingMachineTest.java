package ua.rd.pos;

import org.junit.Test;

public class VendingMachineTest {

    private VendingMachine machine = new VendingMachine();

    @Test
    public void insertCoin() {
        machine.insertCoin(Coin.TWENTY_FIVE);
    }
}
