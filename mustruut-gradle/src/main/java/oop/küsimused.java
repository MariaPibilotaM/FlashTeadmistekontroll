package oop;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class küsimused extends Application {

    private String küsimus = "Testi alustamiseks vajuta alumist nuppu :) \n \n";
    //Küsimuse õige vastus
    private String õigeVastus ="";
    //Vastused, mis lisatakse hiljem faili
    public ArrayList<String> tulemused = new ArrayList<String>();
    //Valikvastused ja õige vastus
    private String[] kasutatavInfo = new String[4];
    private int i = 0;

    public void start(Stage primaryStage) throws IOException {
        //Loeme failist küsimused sisse
        Loe a = new Loe();
        //Lisame failist saadud info ridade kaupa
        String[] failiRead = a.loe().split("\r\n");

        //Pealava nimetuse määramine
        primaryStage.setTitle("OOP testike");

        //Küsimuse lisamine
        Label labelfirst= new Label(küsimus);
        Label labelresponse= new Label();

        //Vastamise nupp
        Button button= new Button("Alusta");

        button.setOnAction(actionEvent -> {
            //Rea kasutamine (saame kätte küsimuse, vastused ja õige vastuse
            kasutatavInfo = failiRead[0].split(";");
            //Uue küsimuse teksti määramine
            küsimus = kasutatavInfo[i];
            labelfirst.setText(küsimus);
            //Uue nuputeksti lisamine
            button.setText("Vasta");
            //õigevastus
            õigeVastus = kasutatavInfo[4];
            //Nuppude väärtustamine
            RadioButton radio1, radio2, radio3;
            radio1 = new RadioButton(kasutatavInfo[1]);
            radio1.setUserData(kasutatavInfo[1]);
            radio2 = new RadioButton(kasutatavInfo[2]);
            radio2.setUserData(kasutatavInfo[2]);
            radio3 = new RadioButton(kasutatavInfo[3]);
            radio3.setUserData(kasutatavInfo[3]);

            ToggleGroup question1 = new ToggleGroup();
            ;
            radio1.setUserData(kasutatavInfo[1]);
            radio2.setUserData(kasutatavInfo[2]);
            radio3.setUserData(kasutatavInfo[3]);

            radio1.setToggleGroup(question1);
            radio2.setToggleGroup(question1);
            radio3.setToggleGroup(question1);

            //Vaikesätted
            button.setDisable(true);

            radio1.setOnAction(e -> button.setDisable(false));
            radio2.setOnAction(e -> button.setDisable(false));
            radio3.setOnAction(e -> button.setDisable(false));

            button.setOnAction(e ->
                    {      //Kui vastab õigesti, siis lisame "õige" kirjutatavasse teksti
                        if (question1.getSelectedToggle().getUserData().toString().equals(õigeVastus)) {
                            String kirjutatavTekst = (i + 1) + ") Õige";
                            tulemused.add(kirjutatavTekst);

                        }
                        //Kui vastab õigesti, siis lisame "õige" kirjutatavasse teksti
                        if (!question1.getSelectedToggle().getUserData().toString().equals(õigeVastus)) {
                            String kirjutatavTekst = (i + 1) + ") Vale";
                            tulemused.add(kirjutatavTekst);

                        }
                        //Suurendame i'd
                        i++;
                        //Kui oleme jõudnud faili lõppu
                        if (i == failiRead.length - 1) {
                            //Kirjutame ja ss sulgeme akna
                            try {
                                a.kirjuta(tulemused);
                            } catch (IOException e1) {
                                System.out.println("Error! Ei saa faili kirjutada");
                                e1.printStackTrace();
                            }
                            primaryStage.close();
                        }
                        else {//Muudame i väärtust ja liigume uue küsimuse juurde
                            kasutatavInfo = failiRead[i].split(";");
                            õigeVastus = kasutatavInfo[4];
                            labelfirst.setText(kasutatavInfo[0]);
                            radio1.setText(kasutatavInfo[1]);
                            radio2.setText(kasutatavInfo[2]);
                            radio3.setText(kasutatavInfo[3]);
                            radio1.setUserData(kasutatavInfo[1]);
                            radio2.setUserData(kasutatavInfo[2]);
                            radio3.setUserData(kasutatavInfo[3]);
                        }
                    }
            );
            //Paigutus ja lisamine
            VBox layout = new VBox(5);
            layout.setAlignment(Pos.CENTER);

            layout.getChildren().addAll(labelfirst, radio1, radio2, radio3, button, labelresponse);

            Scene scene1 = new Scene(layout, 400, 250);
            primaryStage.setScene(scene1);

            primaryStage.show();
        });
        //Paigutus ja lisamine
        VBox layout= new VBox(5);
        layout.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(labelfirst, button, labelresponse);

        Scene scene1= new Scene(layout, 400, 250);
        primaryStage.setScene(scene1);

        primaryStage.show();
    }

    //Käivitamine
    public static void main(String[] args) {
        launch(args);
    }

}
