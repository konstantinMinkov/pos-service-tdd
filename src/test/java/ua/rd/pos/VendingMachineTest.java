package ua.rd.pos;

import org.junit.Test;

/**
 * Created by Kostiantyn_Minkov on 10/6/2016.
 */
public class VendingMachineTest {

    @Test
    public void createVendingMachine() {
        VendingMachine machine = new VendingMachine();
    }

    @Test
    public void insertCoin() {
        int coinValue = 25;
        VendingMachine machine = new VendingMachine();
        machine.insertCoin(coinValue);
    }
}
