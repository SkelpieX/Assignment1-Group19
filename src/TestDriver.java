import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TestDriver {
    private static final String MANIFEST_FILE = "ItemManifest.csv";
    private static Map<String, Double> itemPrices = new HashMap<>();

    private static void loadItemPrices() {
        try (BufferedReader reader = new BufferedReader(new FileReader(MANIFEST_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].toLowerCase();
                    double price = Double.parseDouble(parts[1]);
                    itemPrices.put(name, price);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double getPriceFromManifest(String itemName) {
        return itemPrices.get(itemName);
    }

    private static boolean isProductValid(String productName) {
        return itemPrices.containsKey(productName.toLowerCase());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> itemsToAdd = new ArrayList<>();

        loadItemPrices();

        while (true) {
            System.out.println("Enter the product you want to add (or 'done' when finished):");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("done")) {
                break;
            }

            itemsToAdd.add(userInput);
        }

        System.out.println("_______________________________________________________");
        System.out.println("_______________________________________________________");

        for (String itemName : itemsToAdd) {
            if (!isProductValid(itemName)) {
                System.out.println("Invalid product name: " + itemName);
                continue;
            }

            GenericProductFactory productFactory = new GroceryProductFactory();
            GroceryProduct product = productFactory.createProduct(itemName);

            product.setPrice(getPriceFromManifest(itemName));

            System.out.println(product.getName() + " has been created in the main inventory");
        }

        System.out.println("_______________________________________________________");
        System.out.println("_______________________________________________________");

        for (String itemName : itemsToAdd) {
            if (isProductValid(itemName)) {
                System.out.println("Price of " + itemName + " has been set to $" + getPriceFromManifest(itemName));
            }
        }

        scanner.close();
    }
}
