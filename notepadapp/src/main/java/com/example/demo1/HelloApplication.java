package com.example.demo1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class NotepadApp extends Application {

    private TextArea textArea;
    private Stage stage;
    private File currentFile;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Notepad App");

        // Create the text area
        textArea = new TextArea();
        textArea.setWrapText(true);

        // Create the menu bar
        MenuBar menuBar = new MenuBar();

        // Create the File menu
        Menu fileMenu = new Menu("File");

        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(new NewFileHandler());

        MenuItem openMenuItem = new MenuItem("Open");
        openMenuItem.setOnAction(new OpenFileHandler());

        MenuItem saveMenuItem = new MenuItem("Save");
        saveMenuItem.setOnAction(new SaveFileHandler());

        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem, new SeparatorMenuItem(), exitMenuItem);

        // Create the Edit menu
        Menu editMenu = new Menu("Edit");

        MenuItem cutMenuItem = new MenuItem("Cut");
        cutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.cut();
            }
        });

        MenuItem copyMenuItem = new MenuItem("Copy");
        copyMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.copy();
            }
        });

        MenuItem pasteMenuItem = new MenuItem("Paste");
        pasteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.paste();
            }
        });

        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.deleteText(textArea.getSelection());
            }
        });

        MenuItem selectAllMenuItem = new MenuItem("Select All");
        selectAllMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.selectAll();
            }
        });

        editMenu.getItems().addAll(cutMenuItem, copyMenuItem, pasteMenuItem, deleteMenuItem, new SeparatorMenuItem(), selectAllMenuItem);

        // Create the Help menu
        Menu helpMenu = new Menu("Help");

        MenuItem aboutMenuItem = new MenuItem("About");
        aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
                aboutAlert.setHeaderText("Notepad App");
                aboutAlert.setContentText("This is a simple notepad application created using JavaFX.");
                aboutAlert.showAndWait();
            }
        });

        helpMenu.getItems().addAll(aboutMenuItem);

        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        // Create the layout
        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);
        layout.setCenter(textArea);

        // Set the scene
        Scene scene = new Scene(layout, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    private class NewFileHandler implements EventHandler<ActionEvent>
