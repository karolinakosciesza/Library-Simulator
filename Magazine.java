package pl.library;

import java.util.Objects;

public class Magazine extends Item {
    private String number;


    public Magazine(String number, String title) {
        super(title, 1, 'M');
        this.number = number;
    }

    public Magazine(String number, String title, int totalAmount) {
        super(title, totalAmount, 'M');
        this.number = number;
    }

    @Override
    public String rentedItem() {
        return super.rentedItem()+number;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ";" + number + ";" + totalAmount + ";" + amountToRent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return number.equals(magazine.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number);
    }


}
