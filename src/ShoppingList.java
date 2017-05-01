import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ShoppingList
{
    private static final String SHOPPING_LIST = "shopping_list.txt";
    private List<String> list = new ArrayList<>();

    public void addItem()
    {
        System.out.print("Enter item to add: ");
        Scanner scanner = new Scanner(System.in);
        String item = scanner.nextLine();

        if (list.contains(item)) {
            System.out.println("Item \"" + item + "\" already exists.");
        } else {
            list.add(item);
            System.out.println("Item \"" + item + "\" added.");
        }
    }

    public void listItems()
    {
        System.out.println("There are " + list.size() + " items.");

        for (String item : list) {
            System.out.println(item);
        }
    }

    public void deleteItem()
    {
        if (list.isEmpty()) {
            System.out.println("Nothing to delete. List is empty...");

            return;
        }

        System.out.print("Enter item name to remove: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Iterator<String> i = list.iterator();

        while (i.hasNext()) {
            String item = i.next();

            if (line.equals(item)) {
                i.remove();
                System.out.println("Item \"" + item + "\" removed.");

                return;
            }
        }

        System.out.println("Item not found...");

    }

    public void saveList()
    {
        if (list.isEmpty()) {
            System.out.println("Nothing to save. List is empty...");

            return;
        }

        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(SHOPPING_LIST));

            for (String item : list) {
                writer.println(item);
            }

            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error! File not found...");
        }
    }

    public void loadList()
    {
        list.clear();

        try {
            Scanner scanner = new Scanner(new File(SHOPPING_LIST));

            if (!scanner.hasNextLine())
                System.out.println("File is empty...");

            while (scanner.hasNextLine()) {
                String item = scanner.nextLine();
                list.add(item);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error! File not found...");
        }
    }
}