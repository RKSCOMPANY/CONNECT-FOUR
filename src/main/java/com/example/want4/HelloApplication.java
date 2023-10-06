package com.example.want4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {

     private HelloController controller ;

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();

        controller = loader.getController() ;
        controller.createPlayground() ;

        //menu
        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        //  adding menu to pane
        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().addAll(menuBar);


        Scene scene = new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("WANT--4");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private MenuBar createMenu() {
        // file menu
        Menu fileMenu = new Menu("File");

        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(actionEvent -> controller.resetGame()
        );

        MenuItem resetGame = new MenuItem("Reset Game");
        resetGame.setOnAction(actionEvent -> controller.resetGame() );

        SeparatorMenuItem xyz = new SeparatorMenuItem();

        MenuItem exitGame = new MenuItem("Exit Game");
        exitGame.setOnAction(actionEvent -> {
            exitGame();
        });

        fileMenu.getItems().addAll(newGame, resetGame, xyz, exitGame);

        // about menu
        Menu helpMenu = new Menu("Help");

        MenuItem about4want = new MenuItem("About Want--4");
        about4want.setOnAction(actionEvent -> {
            about4want();
        });

        SeparatorMenuItem abc = new SeparatorMenuItem();

        MenuItem aboutMe = new MenuItem("About Developer");
        aboutMe.setOnAction(actionEvent -> {
            aboutMe();
        });

        helpMenu.getItems().addAll(about4want, abc, aboutMe);


        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        return menuBar;

    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ABOUT THE DEVELOPER");
        alert.setHeaderText("RAGHAV KHANDELWAL");
        alert.setContentText(" Specialized in Java, Object Oriented Programming , Java App Development modules , Web Developer For Contact (TEXT MESSAGE) : Khandelwalraghav364@gmail.com \n ");
        alert.show();
    }

    private void about4want() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ABOUT WANT--4");
        alert.setHeaderText("How to play?");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored disc from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves \n ");

        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch();
    }
}
