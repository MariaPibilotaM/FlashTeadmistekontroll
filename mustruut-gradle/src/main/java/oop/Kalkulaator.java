package oop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kalkulaator extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // juureks on vBox, mis seab oma lluvad järjest üksteise alla.
        VBox vBox = new VBox();

        // lisame juurele tekstivälja
        TextField textField = new TextField();
        vBox.getChildren().add(textField);

        //Loome kustutamiseks vajalikud nupud
        Button ce = new Button("CE");
        ce.setMinWidth(80);
        Button c = new Button("C");
        c.setMinWidth(80);
        //Hbox seab elemendid ühte ritta
        HBox hBox = new HBox();
        hBox.getChildren().addAll(ce, c);
        Button backSpace = new Button("Backspace");
        backSpace.setMinWidth(80);

        //borderPane'i abil saame sättida ühe nupu vasakule, teised kaks paremale
        BorderPane borderPane1 = new BorderPane();
        borderPane1.setLeft(backSpace);
        borderPane1.setRight(hBox);
        //lisame borderPane'i juurele
        vBox.getChildren().add(borderPane1);

        //list nuppude nimedega
        final List<String> nuppudeTekstid = new ArrayList<>(Arrays.asList("7", "8", "9", "/", "sqrt",
                "4", "5", "6", "*", "%",
                "1", "2", "3", "-", "1/x",
                "0", "+/-", ",", "+", "="));


        //gridpane'i abil on mugav nuppudest soovitud ruudustik luua
        GridPane gridPane = new GridPane();
        int reaNumber;
        for (String nupuTekst : nuppudeTekstid) {
            //Jagame täisarvu täisarvuga, saame tulemuseks täisarvu, mis näitab, mis ritta antud nupp kuulub.
            reaNumber = nuppudeTekstid.indexOf(nupuTekst) / 5;
            Button button = new Button(nupuTekst);
            button.setMinWidth(80);
            //Lisame nupud ritta
            gridPane.addRow(reaNumber, button);
        }
        //lisame ruudustiku juurele
        vBox.getChildren().add(gridPane);
        //loome stseeni, määrame suuruse, keelame suuruse muutmise
        Scene scene = new Scene(vBox, 400, 155);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        // TODO: Lisada kõigile nuppudele sündmused
        //Vihje1: salvesta nupud listi.
        //vihje2: button.getText() võib kasuks tulla.


    }
}
