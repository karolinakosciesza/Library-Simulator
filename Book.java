package pl.library;

import java.util.Objects;

public class Book extends Item {
    private String author;

    public Book(String author, String title) {
        super(title, 1, 'B');
        this.author = author;
    }

    public Book(String author, String title, int totalAmount) {
        super(title, totalAmount, 'B');
        this.author = author;
    }

    @Override
    public String rentedItem() {
        return super.rentedItem()+author;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ";" + author + ";" + totalAmount + ";" + amountToRent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }
}
