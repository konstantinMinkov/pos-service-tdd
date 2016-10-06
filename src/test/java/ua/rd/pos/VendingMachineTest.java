package ua.rd.pos;

import org.junit.Test;

public class VendingMachineTest {

    private VendingMachine machine = new VendingMachine();

    @Test
    public void insertCoin() {
        int coinValue = 25;
        machine.insertCoin(coinValue);
    }
}
