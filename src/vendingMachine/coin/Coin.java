package vendingMachine.coin;

import java.util.ArrayList;
import java.util.List;

public class Coin {

    public static List<Coin> coins = new ArrayList<Coin>();

    int coinNum;
    String coinName;

    public static final Coin[] coin = new Coin[]{
            new Coin(5, "ten"),
            new Coin(5, "fifty"),
            new Coin(5, "hundred"),
            new Coin(5, "fiveHundred"),
            new Coin(5, "thousand")
    };

    public Coin(int coinNum, String coinName) {
        this.coinNum = coinNum;
        this.coinName = coinName;
    }

    public int getCoinNum() {
        return coinNum;
    }

    public void setCoinNum(int coinNum) {
        this.coinNum = coinNum;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }
}
