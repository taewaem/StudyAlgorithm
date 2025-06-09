package vendingMachine.drink;

import vendingMachine.coin.Coin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Drink {

    private String drinkName;
    private int drinkNum;
    private int drinkPrice;

    public Drink(String drinkName, int drinkNum, int drinkPrice) {
        this.drinkName = drinkName;
        this.drinkNum = drinkNum;
        this.drinkPrice = drinkPrice;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public int getDrinkNum() {
        return drinkNum;
    }

    public void setDrinkNum(int drinkNum) {
        this.drinkNum = drinkNum;
    }

    public int getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(int drinkPrice) {
        this.drinkPrice = drinkPrice;
    }
}
