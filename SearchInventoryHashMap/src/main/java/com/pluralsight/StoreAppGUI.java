package com.pluralsight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class StoreAppGUI extends Application {

    private TextArea outputArea;
    private TextField newNameField;
    private TextField newPriceField;

    @Override
    public void start(Stage primaryStage) {
        Main.readTheFileFirst(); // Load inventory

        VBox layout = new VBox(15);
        layout.setStyle("-fx-padding: 20; -fx-background-color: #f0f8ff;");

        Label title = new Label("Store Inventory System");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Buttons
        Button listButton = new Button("List All Products");
        Button searchByIdButton = new Button("Search by ID");
        Button searchByPriceButton = new Button("Search by Price Range");
        Button addButton = new Button("Add Product");

        // Output area
        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(300);
        outputArea.setStyle("-fx-control-inner-background: #e0f7fa; -fx-font-family: monospace;");

        // ID search
        TextField idField = new TextField();
        idField.setPromptText("Enter Product ID");

        searchByIdButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                Product found = null;
                for (Product p : Main.inventory) {
                    if (p.getId() == id) {
                        found = p;
                        break;
                    }
                }
                outputArea.setText(found != null ? found.toString() : "Product not found.");
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid ID.");
            }
        });

        // Price range search
        TextField minField = new TextField();
        minField.setPromptText("Min Price");
        TextField maxField = new TextField();
        maxField.setPromptText("Max Price");

        searchByPriceButton.setOnAction(e -> {
            try {
                double min = Double.parseDouble(minField.getText());
                double max = Double.parseDouble(maxField.getText());
                List<Product> found = Main.searchByPrice(min, max);
                outputArea.clear();
                for (Product p : found) {
                    outputArea.appendText(p.toString() + "\n");
                }
                if (found.isEmpty()) {
                    outputArea.setText("No products found in that range.");
                }
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid price range.");
            }
        });

        // Add new product (auto ID)
        newNameField = new TextField();
        newNameField.setPromptText("Product Name");

        newPriceField = new TextField();
        newPriceField.setPromptText("Price");

        addButton.setOnAction(e -> {
            try {
                String name = newNameField.getText();
                double price = Double.parseDouble(newPriceField.getText());

                int maxId = 0;
                for (Product p : Main.inventory) {
                    if (p.getId() > maxId) {
                        maxId = p.getId();
                    }
                }
                int newId = maxId + 1;

                Product newProduct = new Product(newId, name, price);
                Main.inventory.add(newProduct);
                writeToCSV(newProduct);
                outputArea.setText("Product added:\n" + newProduct);
                newNameField.clear();
                newPriceField.clear();
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid input.");
            }
        });

        // List all products
        listButton.setOnAction(e -> {
            outputArea.clear();
            for (Product p : Main.inventory) {
                outputArea.appendText(p.toString() + "\n");
            }
        });

        // Layout
        layout.getChildren().addAll(
                title, listButton,
                new Label("Search by ID:"), idField, searchByIdButton,
                new Label("Search by Price Range:"), minField, maxField, searchByPriceButton,
                new Label("Add New Product (ID auto-generated):"),
                newNameField, newPriceField, addButton,
                outputArea
        );

        ScrollPane scrollPane = new ScrollPane(layout);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 500, 650);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Store Inventory");
        primaryStage.show();
    }

    private void writeToCSV(Product product) {
        try (FileWriter writer = new FileWriter("products.csv", true)) {
            writer.write(product.getId() + "|" + product.getName() + "|" + product.getPrice() + "\n");
        } catch (IOException e) {
            outputArea.setText("Failed to write to file.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
