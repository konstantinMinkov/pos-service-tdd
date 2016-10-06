package ua.rd.pos;

public enum Coin {

    ONE(1), FIVE(5), TEN(10), TWENTY_FIVE(25), FIFTY(50);

    private int centsValue;

    Coin(int centsValue) {
        this.centsValue = centsValue;
    }
}
