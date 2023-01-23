package pl.library;


import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String lastName;
    private int libraryCard = 0;
    private char userType;
    private int itemLimit;
    private List<Item> rentedItems = new ArrayList<>();

    public User(String name, String lastName, char userType, int itemLimit) {
        this.name = name;
        this.lastName = lastName;
        this.userType = userType;
        this.itemLimit = itemLimit;
    }

    public void setLibraryCard(int libraryCard) {
        this.libraryCard = libraryCard;
    }

    public String toCSV() {
        return name + ";" + lastName + ";" + libraryCard + ";" + userType;
    }

    public String toLibraryCard() {
        String libraryCardText = libraryCard + "[";
        for (Item item : rentedItems) {
            libraryCardText += item.rentedItem() + ";";
        }
        libraryCardText = libraryCardText.substring(0, libraryCardText.length() - 1);
        return libraryCardText + "]";
    }

    public boolean hasAnyItems() {
        return !rentedItems.isEmpty();
    }

    public void rentItem(Item item) {
        rentedItems.add(item);
    }

    public boolean isLimitReached() {
        if (rentedItems.size() >= itemLimit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", libraryCard=" + libraryCard +
                ", userType=" + userType +
                ", itemLimit=" + itemLimit +
                ", rentedItems=" + rentedItems +
                '}';
    }
}
