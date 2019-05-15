package oop;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class küsimused extends Application {

    private String küsimus = "Tere!\nTesti alustamiseks vajuta alumist nuppu :) \n \n";
    private String õigeVastus ="";
    String[] sisseloetudTekst = new String[0];
    public void start(Stage primaryStage) {

        //Pealava nimetuse määramine
        primaryStage.setTitle("OOP testike");

        //Küsimuse lisamine
        Label labelfirst= new Label(küsimus);
        Label labelresponse= new Label();

        //Vastamise nupp
        Button button= new Button("Alusta");

        button.setOnAction(actionEvent -> {
            Loe a = new Loe();
            try {
                sisseloetudTekst = a.loe().split(";");
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Uue küsimuse teksti määramine
            küsimus = sisseloetudTekst[0];
            labelfirst.setText(küsimus);
            //Uue nuputeksti lisamine
            button.setText("Vasta");
            //õigevastus
            õigeVastus = sisseloetudTekst[4];
            //Nuppude väärtustamine
            RadioButton radio1, radio2, radio3;
            radio1 = new RadioButton(sisseloetudTekst[1]);
            radio2 = new RadioButton(sisseloetudTekst[2]);
            radio3 = new RadioButton(sisseloetudTekst[3]);
            ToggleGroup question1 = new ToggleGroup();

            radio1.setToggleGroup(question1);
            radio2.setToggleGroup(question1);
            radio3.setToggleGroup(question1);

            //Vaikesätted
            button.setDisable(true);

            radio1.setOnAction(e -> button.setDisable(false));
            radio2.setOnAction(e -> button.setDisable(false));
            radio3.setOnAction(e -> button.setDisable(false));

            button.setOnAction(e ->
                    {
                        if(radio1.getText().equals(õigeVastus) && radio1.isSelected()){
                            labelresponse.setText("Õige vastus");
                            button.setDisable(true);
                            labelfirst.setText("UUS KÜSIMUS");
                        } else if(radio2.getText().equals(õigeVastus) && radio2.isSelected()){
                        labelresponse.setText("Õige vastus");
                        button.setDisable(true);
                        }else if(radio3.getText().equals(õigeVastus) && radio3.isSelected()){
                            labelresponse.setText("Õige vastus");
                            button.setDisable(true);
                        } else {
                            labelresponse.setText("Vale vastus");
                            button.setDisable(true);
                        }
                    }
            );

            VBox layout = new VBox(5);

            layout.getChildren().addAll(labelfirst, radio1, radio2, radio3, button, labelresponse);

            Scene scene1 = new Scene(layout, 400, 250);
            primaryStage.setScene(scene1);

            primaryStage.show();
        });
        VBox layout= new VBox(5);

        layout.getChildren().addAll(labelfirst, button, labelresponse);

        Scene scene1= new Scene(layout, 400, 250);
        primaryStage.setScene(scene1);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
