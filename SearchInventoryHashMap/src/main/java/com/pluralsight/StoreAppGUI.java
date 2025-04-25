package com.pluralsight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


public class StoreAppGUI extends Application {

    private List<Product> inventory = new ArrayList<>();
    private TextArea outputArea = new TextArea();
    private Scene mainScene, listScene, searchIdScene, searchPriceScene, addScene;

    @Override
    public void start(Stage primaryStage) {
        Main.readTheFileFirst();
        inventory = Main.inventory;

        // MAIN MENU
        VBox mainMenu = new VBox(10);
        mainMenu.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-background-color: #f0f0f0;");

        Label title = new Label("Store Inventory System");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        Button listBtn = new Button("List All Products");
        Button searchIdBtn = new Button("Search by ID");
        Button searchPriceBtn = new Button("Search by Price Range");
        Button addBtn = new Button("Add Product");

        listBtn.setOnAction(e -> primaryStage.setScene(listScene));
        searchIdBtn.setOnAction(e -> primaryStage.setScene(searchIdScene));
        searchPriceBtn.setOnAction(e -> primaryStage.setScene(searchPriceScene));
        addBtn.setOnAction(e -> {
            updateNextId();
            primaryStage.setScene(addScene);
        });

        mainMenu.getChildren().addAll(title, listBtn, searchIdBtn, searchPriceBtn, addBtn);
        mainScene = new Scene(mainMenu, 500, 400);

        // LIST SCREEN
        VBox listLayout = new VBox(10);
        outputArea.setPrefHeight(300);
        outputArea.setWrapText(true);
        outputArea.setEditable(false);
        ScrollPane scroll = new ScrollPane(outputArea);
        scroll.setFitToWidth(true);
        scroll.setPrefHeight(350);

        Button backFromList = new Button("Back");
        backFromList.setOnAction(e -> primaryStage.setScene(mainScene));
        listLayout.setStyle("-fx-padding: 20;");
        listLayout.getChildren().addAll(new Label("All Products:"), scroll, backFromList);
        listScene = new Scene(listLayout, 600, 500);

        listBtn.setOnAction(e -> {
            outputArea.clear();
            for (Product p : inventory) {
                outputArea.appendText(p.toString() + "\n");
            }
            primaryStage.setScene(listScene);
        });

        // SEARCH BY ID SCREEN
        VBox searchIdLayout = new VBox(10);
        TextField idInput = new TextField();
        idInput.setPromptText("Enter Product ID");
        TextArea idResult = new TextArea();
        idResult.setEditable(false);
        Button idSearch = new Button("Search");
        Button backFromId = new Button("Back");

        idSearch.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idInput.getText());
                Product found = inventory.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
                idResult.setText(found != null ? found.toString() : "Product not found.");
            } catch (NumberFormatException ex) {
                idResult.setText("Invalid ID format.");
            }
        });
        backFromId.setOnAction(e -> primaryStage.setScene(mainScene));
        searchIdLayout.setStyle("-fx-padding: 20;");
        searchIdLayout.getChildren().addAll(new Label("Search by ID:"), idInput, idSearch, idResult, backFromId);
        searchIdScene = new Scene(searchIdLayout, 500, 400);

        // SEARCH BY PRICE SCREEN
        VBox priceLayout = new VBox(10);
        TextField minPrice = new TextField();
        TextField maxPrice = new TextField();
        minPrice.setPromptText("Min Price");
        maxPrice.setPromptText("Max Price");
        TextArea priceResult = new TextArea();
        priceResult.setEditable(false);
        Button priceSearch = new Button("Search");
        Button backFromPrice = new Button("Back");

        priceSearch.setOnAction(e -> {
            try {
                double min = Double.parseDouble(minPrice.getText());
                double max = Double.parseDouble(maxPrice.getText());
                List<Product> results = Main.searchByPrice(min, max);
                priceResult.clear();
                if (results.isEmpty()) {
                    priceResult.setText("No products found.");
                } else {
                    for (Product p : results) {
                        priceResult.appendText(p.toString() + "\n");
                    }
                }
            } catch (NumberFormatException ex) {
                priceResult.setText("Invalid price format.");
            }
        });

        backFromPrice.setOnAction(e -> primaryStage.setScene(mainScene));
        priceLayout.setStyle("-fx-padding: 20;");
        priceLayout.getChildren().addAll(new Label("Search by Price Range:"), minPrice, maxPrice, priceSearch, priceResult, backFromPrice);
        searchPriceScene = new Scene(priceLayout, 500, 450);

        // ADD PRODUCT SCREEN
        VBox addLayout = new VBox(10);
        Label autoIdLabel = new Label("ID will be auto-generated");
        TextField nameInput = new TextField();
        TextField priceInput = new TextField();
        nameInput.setPromptText("Product Name");
        priceInput.setPromptText("Product Price");

        Button addProduct = new Button("Add Product");
        Label confirmation = new Label();
        Button backFromAdd = new Button("Back");

        addProduct.setOnAction(e -> {
            try {
                String name = nameInput.getText();
                NumberFormat format = NumberFormat.getInstance(Locale.US);
                Number number = format.parse(priceInput.getText());
                double price = number.doubleValue();

                int id = getNextId();
                Product newProduct = new Product(id, name, price);
                inventory.add(newProduct);
                writeToCSV(newProduct);
                confirmation.setText("Product added: " + newProduct);
                nameInput.clear();
                priceInput.clear();
                updateNextId();
            } catch (NumberFormatException | ParseException ex) {
                confirmation.setText("Invalid price format.");
            }
        });


        backFromAdd.setOnAction(e -> primaryStage.setScene(mainScene));
        addLayout.setStyle("-fx-padding: 20;");
        addLayout.getChildren().addAll(autoIdLabel, nameInput, priceInput, addProduct, confirmation, backFromAdd);
        addScene = new Scene(addLayout, 500, 400);

        // Show main scene
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Store Inventory System");
        primaryStage.show();
    }

    private void updateNextId() {
        int nextId = getNextId();
        Label idLabel = (Label) ((VBox) addScene.getRoot()).getChildren().get(0);
        idLabel.setText("Next Product ID: " + nextId);
    }

    private int getNextId() {
        return inventory.stream().map(Product::getId).max(Comparator.naturalOrder()).orElse(0) + 1;
    }

    private void writeToCSV(Product product) {
        try (FileWriter writer = new FileWriter(Main.INVENTORY_FILE_PATH, true)) {
            writer.write(product.getId() + " | " + product.getName() + " | " + product.getPrice() + "\n");
        } catch (IOException e) {
            System.out.println("Failed to write product to file.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
