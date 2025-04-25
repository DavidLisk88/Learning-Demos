package com.pluralsight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class StoreAppGUI extends Application {

    private List<Product> inventory = new ArrayList<>();
    private TextArea outputArea = new TextArea();
    private Scene mainScene, listScene, searchIdScene, searchPriceScene, addScene;

    @Override
    public void start(Stage primaryStage) {
        Main.readTheFileFirst();
        inventory = Main.inventory;

        String darkStyle = "-fx-background-color: #2b2b2b; -fx-text-fill: white;";
        String buttonStyle = "-fx-background-color: #3c3f41; -fx-text-fill: white; -fx-font-weight: bold;";
        String labelStyle = "-fx-text-fill: white; -fx-font-size: 14px;";

        // MAIN MENU
        VBox mainMenu = new VBox(10);
        mainMenu.setStyle("-fx-padding: 20; -fx-alignment: center;" + darkStyle);

        Label title = new Label("Store Inventory System");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");
        Button listBtn = new Button("List All Products");
        Button searchIdBtn = new Button("Search by ID");
        Button searchPriceBtn = new Button("Search by Price Range");
        Button addBtn = new Button("Add Product");

        Arrays.asList(listBtn, searchIdBtn, searchPriceBtn, addBtn).forEach(btn -> btn.setStyle(buttonStyle));

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
        listLayout.setStyle("-fx-padding: 20;" + darkStyle);

        outputArea.setPrefHeight(300);
        outputArea.setWrapText(true);
        outputArea.setEditable(false);
        outputArea.setStyle("-fx-control-inner-background: #3c3f41; -fx-text-fill: white;");

        ScrollPane scroll = new ScrollPane(outputArea);
        scroll.setFitToWidth(true);
        scroll.setPrefHeight(350);
        scroll.setStyle("-fx-background: #2b2b2b;");

        Button backFromList = new Button("Back");
        backFromList.setStyle(buttonStyle);
        backFromList.setOnAction(e -> primaryStage.setScene(mainScene));

        listLayout.getChildren().addAll(new Label("All Products:") {{ setStyle(labelStyle); }}, scroll, backFromList);
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
        searchIdLayout.setStyle("-fx-padding: 20;" + darkStyle);
        TextField idInput = new TextField();
        idInput.setPromptText("Enter Product ID");
        TextArea idResult = new TextArea();
        idResult.setEditable(false);
        idResult.setStyle("-fx-control-inner-background: #3c3f41; -fx-text-fill: white;");

        Button idSearch = new Button("Search");
        Button backFromId = new Button("Back");
        backFromId.setOnAction(e -> primaryStage.setScene(mainScene));

        Arrays.asList(idSearch, backFromId).forEach(btn -> btn.setStyle(buttonStyle));

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
        searchIdLayout.getChildren().addAll(new Label("Search by ID:") {{ setStyle(labelStyle); }}, idInput, idSearch, idResult, backFromId);
        searchIdScene = new Scene(searchIdLayout, 500, 400);

        // SEARCH BY PRICE SCREEN
        VBox priceLayout = new VBox(10);
        priceLayout.setStyle("-fx-padding: 20;" + darkStyle);
        TextField minPrice = new TextField();
        TextField maxPrice = new TextField();
        minPrice.setPromptText("Min Price");
        maxPrice.setPromptText("Max Price");

        TextArea priceResult = new TextArea();
        priceResult.setEditable(false);
        priceResult.setStyle("-fx-control-inner-background: #3c3f41; -fx-text-fill: white;");

        Button priceSearch = new Button("Search");
        Button backFromPrice = new Button("Back");
        backFromPrice.setOnAction(e -> primaryStage.setScene(mainScene));


        Arrays.asList(priceSearch, backFromPrice).forEach(btn -> btn.setStyle(buttonStyle));

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
        priceLayout.getChildren().addAll(new Label("Search by Price Range:") {{ setStyle(labelStyle); }}, minPrice, maxPrice, priceSearch, priceResult, backFromPrice);
        searchPriceScene = new Scene(priceLayout, 500, 450);

        // ADD PRODUCT SCREEN
        VBox addLayout = new VBox(10);
        addLayout.setStyle("-fx-padding: 20;" + darkStyle);

        Label autoIdLabel = new Label("ID will be auto-generated");
        autoIdLabel.setStyle(labelStyle);

        TextField nameInput = new TextField();
        TextField priceInput = new TextField();
        nameInput.setPromptText("Product Name");
        priceInput.setPromptText("Product Price");

        Button addProduct = new Button("Add Product");
        addProduct.setStyle(buttonStyle);
        Label confirmation = new Label();
        confirmation.setStyle("-fx-text-fill: lightgreen;");
        Button backFromAdd = new Button("Back");
        backFromAdd.setStyle(buttonStyle);
        backFromAdd.setOnAction(e -> primaryStage.setScene(mainScene));


        backFromAdd.setOnAction(e -> primaryStage.setScene(mainScene));

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
            writer.write(product.getId() + "|" + product.getName() + "|" + product.getPrice() + "\n");
        } catch (IOException e) {
            System.out.println("Failed to write product to file.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
