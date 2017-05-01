import java.util.Scanner;

public class Application
{
    enum MenuOption {
        ADD_ITEM("Add an item"),
        LIST_ITEMS("List items"),
        DELETE_ITEM("Delete an item"),
        SAVE_LIST("Save list to file"),
        LOAD_LIST("Load list from file"),
        EXIT("Exit");

        private final String message;

        MenuOption(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static void main(String[] args) {
        ShoppingList list = new ShoppingList();
        Scanner scanner = new Scanner(System.in);
        MenuOption selectedOption = null;

        System.out.println("This is a shopping list application.");

        while (selectedOption != MenuOption.EXIT) {

            selectedOption = askUserOption(scanner);

            switch (selectedOption) {
                case ADD_ITEM:
                    list.addItem();
                    break;
                case LIST_ITEMS:
                    list.listItems();
                    break;
                case DELETE_ITEM:
                    list.deleteItem();
                    break;
                case SAVE_LIST:
                    list.saveList();
                    break;
                case LOAD_LIST:
                    list.loadList();
                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    break;
            }
        }
    }

    private static void printMenu()
    {
        for (int i = 0; i < MenuOption.values().length; i++) {
            MenuOption option = MenuOption.values()[i];
            System.out.println("[" + (i+1) + "] " + option.getMessage());
        }
    }

    private static MenuOption askUserOption(Scanner scanner)
    {
        System.out.println("Enter your choice:");
        printMenu();

        int option;

        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Wrong choice, here are available choices:");
                printMenu();
                scanner.next();
            }

            option = scanner.nextInt();

            if (option < 1 || option > MenuOption.values().length) {
                System.out.println("Wrong choice, here are available choices:");
                printMenu();
            }
        } while (option < 1 || option > MenuOption.values().length);

        return MenuOption.values()[option-1];
    }
}
