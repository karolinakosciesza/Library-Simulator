package pl.library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemFileRepository {

    public List<Item> loadItems(String csvFile) {
        List<Item> itemsList = new ArrayList<>();
        File file = new File(csvFile);
        try {
            Scanner skaner = new Scanner(file);
            while (skaner.hasNextLine()) {
                String line = skaner.nextLine();
                Item item = convertLineToItem(line);
                itemsList.add(item);
            }
            skaner.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("File not found");
        }

        return itemsList;
    }

    public Item convertLineToItem(String line) {
        String[] lineElements = line.split(";");
        if (lineElements[3].equals("B")) {
            return new Book(lineElements[1], lineElements[0], Integer.parseInt(lineElements[2]));
        } else {
            return new Magazine(lineElements[1], lineElements[0], Integer.parseInt(lineElements[2]));
        }
    }

    public void saveUsers(List<User> users, String csvFile) {
        File file = new File(csvFile);
        try {
            PrintWriter printWriter = new PrintWriter(file);
            for (User user : users) {
                if (user.hasAnyItems()) {
                    printWriter.println(user.toLibraryCard());
                }
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }


}
