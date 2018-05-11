package com.KMCoding;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) throws Exception {
        IRCBot.main("redtek720");
        launch(args);
    }

    Stage DART;
    Scene scene;
    ListView listIn;
    ListView listOut;
    GridPane layout;
    TextField qInput;
    Button qSubmit;

    Rectangle2D screenRes = Screen.getPrimary().getVisualBounds();
    double screenWidth = screenRes.getWidth()/2;
    double screenHeight = screenRes.getHeight()/2;

    public static ListView listChat = new ListView();

    public void start(Stage primaryStage) {
        qInput = new TextField();
        qInput.setPromptText("Type question");
        GridPane.setConstraints(qInput,0,0);

        qSubmit = new Button();
        qSubmit.setText("Input");
        GridPane.setConstraints(qSubmit, 1,0);
        qSubmit.setOnAction(event -> {
            if (listIn.getItems().size() > 16) {
                listIn.getItems().clear();
                listOut.getItems().clear();
            }

            listIn.getItems().add(0, qInput.getCharacters().toString());
            listOut.getItems().add(0, Commands.Main(qInput.getCharacters().toString()));
            qInput.clear();
        });

        listIn = new ListView();
        listIn.setId("Input");
        GridPane.setConstraints(listIn,0,1);

        listOut = new ListView();
        listOut.setId("Output");
        GridPane.setConstraints(listOut,1,1);

        listChat.setId("Chat");
        GridPane.setConstraints(listChat,2,1);

        layout = new GridPane();
        layout.getChildren().addAll(qInput, qSubmit, listIn, listOut, listChat);

        scene = new Scene(layout, screenWidth, screenHeight);

        DART = primaryStage;
        DART.setTitle("DART 2.0");
        DART.setScene(scene);
        DART.show();
        DART.setOnCloseRequest(event -> closeDART());
    }

    private void closeDART() {
        System.out.println("Closed properly");
        DART.close();
    }
}