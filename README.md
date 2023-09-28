# SOFE3650-Assignment1-Group19
# Grocery Store Product Management

This program allows users to manage products in a grocery store. It employs the Abstract Factory pattern to create different types of grocery products dynamically. The price of each product is set based on data read from a CSV file according to user input.

## Repository Structure

- `README.md`: This file provides an overview of the project and instructions for usage.
- `src/`: Contains all the Java source files.
  - `ItemManifest.csv`: Contains sample data for product names and prices in CSV format.
  - `GenericProduct.java`: Defines the interface for all products, allowing for different product creations.
  - `GroceryProductFactory.java`: Implements the `GenericProductFactory.java` interface to create different types of grocery products dynamically. It serves as the concrete factory for product creation.
  - `GroceryProduct.java`: Defines the interface for grocery products, including methods for setting and retrieving product information.
  - `GenericProductFactory.java`: The abstract factory interface, declaring a method for creating grocery products. It serves as the contract for all concrete product factories.
  - `GenericProduct.java`: Defines the interface for all products, allowing for different product creations.
  - `TestDriver.java`: Contains the main program to test the functionality including the logic to read pricing data from a file via partial loading.

--- 

Please let me know if there's anything else you'd like to include or modify in the README file!



## Test Methods

### Test 1: Adding Products

1. Run the program using the command `java TestDriver`.
2. Follow the prompts to enter the products you want to add.
3. Type `done` when finished adding products.

### Test 2: Viewing Prices

1. After adding products, the program will display the names of the products and their corresponding prices.

## Execution Example
# NOTE: The ItemManifest.csv only has real values for the following item: Watermelon, Apple, Banana and Egg. All other values are dummy values meant to test the partial loading capabilities of the code.
# NOTE: For some reason running the code while the `src/` folder is within another folder causes the code to not read the .csv file. Please run just the `src` folder by itself for the code to work as intended. 
