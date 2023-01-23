package pl.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<User> usersList = new ArrayList<>();
    private int nextUniqueLibraryCard = 1;
    private List<Item> itemsList = new ArrayList<>();


    public Library() {
    }

    public void addUserToLibrary(User... users) {
        for (User user : users) {
            user.setLibraryCard(nextUniqueLibraryCard);
            nextUniqueLibraryCard++;
            usersList.add(user);

        }
    }

    public void addItemToLibrary(Item... items) {
        for (Item item : items) {
            if (itemsList.contains(item)) {
                for (Item existingItem : itemsList) {
                    if (existingItem.equals(item)) {
                        existingItem.increaseAmount(item.getAmountToRent());
                    }
                }
            } else {
                itemsList.add(item);
            }
        }
    }

    public boolean rentItemToUser(Item item, User user) {
        if (!user.isLimitReached()) {
            return false;
        }
        for (Item itemInStock : itemsList) {
            if (itemInStock.equals(item) && itemInStock.getAmountToRent() > 0) {
                user.rentItem(itemInStock);
                itemInStock.rent(1);
                return true;
            }

        }
        return false;
    }

    public void printListOfMagazines() {
        for (Item item : itemsList) {
            if (item.getType() == 'M') {
                System.out.println(item.toCSV());
            }
        }
    }

    public void printListOfBooks() {
        for (Item item : itemsList) {
            if (item.getType() == 'B') {
                System.out.println(item.toCSV());
            }
        }
    }

    public void printListOfUsers() {
        for (User user : usersList) {
            System.out.println(user.toCSV());
        }
    }

    public void importItemsFromFile(String csvFile) {
        ItemFileRepository itemFileRepository = new ItemFileRepository();
        List<Item> itemsFromFile = itemFileRepository.loadItems(csvFile);
        Item[] itemsArray = new Item[itemsFromFile.size()];
        addItemToLibrary(itemsFromFile.toArray(itemsArray));
    }

    public void exportUsersWithItemsToFile(String csvFile) {
        ItemFileRepository itemFileRepository = new ItemFileRepository();
        itemFileRepository.saveUsers(usersList, csvFile);

    }

    @Override
    public String toString() {
        return "Library{" +
                "usersList=" + usersList +
                ", nextUniqueLibraryCard=" + nextUniqueLibraryCard +
                ", itemsList=" + itemsList +
                '}';
    }
}
