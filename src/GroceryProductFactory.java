public class GroceryProductFactory implements GenericProductFactory {
    @Override
    public GroceryProduct createProduct(String productName) {
        return new GroceryProduct(productName);
    }
}
