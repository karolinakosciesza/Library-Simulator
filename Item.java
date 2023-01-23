package pl.library;

import java.util.Objects;

public class Item {
    private String title;
    int totalAmount;
    int amountToRent;
    private char type;

    public Item(String title, int totalAmount, char type) {
        this.title = title;
        this.totalAmount = totalAmount;
        amountToRent = totalAmount;
        this.type = type;

    }

    public void increaseAmount(int amount) {
        totalAmount += amount;
        amountToRent += amount;
    }

    public void rent(int amount) {
        amountToRent -= amount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getAmountToRent() {
        return amountToRent;
    }

    public char getType() {
        return type;
    }

    public String toCSV() {
        return title;
    }

    public String rentedItem(){
        return title+"-";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return title.equals(item.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", totalAmount=" + totalAmount +
                ", amountToRent=" + amountToRent +
                '}';
    }
}
