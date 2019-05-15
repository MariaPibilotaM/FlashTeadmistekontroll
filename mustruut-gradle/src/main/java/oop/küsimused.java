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
import java.util.ArrayList;
import java.util.Arrays;


public class küsimused extends Application {

    private String küsimus = "Tere!\nTesti alustamiseks vajuta alumist nuppu :) \n \n";
    private String õigeVastus ="";
    public ArrayList<String> tulemused = new ArrayList<String>();

    //private String[] sisseloetudTekst = new String[2];
    private String[] kasutatavInfo = new String[4];
    private int i = 0;

    public void start(Stage primaryStage) throws IOException {
        //Loeme failist küsimused sisse
        Loe a = new Loe();

        String[] sisseloetudTekst = a.loe().split("\r\n");
        System.out.println(Arrays.toString(sisseloetudTekst));
        System.out.println(sisseloetudTekst.length);
        //Pealava nimetuse määramine
        primaryStage.setTitle("OOP testike");

        //Küsimuse lisamine
        Label labelfirst= new Label(küsimus);
        Label labelresponse= new Label();

        //Vastamise nupp
        Button button= new Button("Alusta");

        button.setOnAction(actionEvent -> {
            kasutatavInfo = sisseloetudTekst[0].split(";");
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
                        if(question1.getSelectedToggle().getUserData().toString().equals(õigeVastus)){
                            String kirjutatavTekst = (i+1)+") Õige";
                            tulemused.add(kirjutatavTekst);

                        }
                       if (!question1.getSelectedToggle().getUserData().toString().equals(õigeVastus)) {
                           String kirjutatavTekst = (i+1) + ") Vale";
                           tulemused.add(kirjutatavTekst);
                       }

                           if (i < sisseloetudTekst.length-1) {
                               i++;
                           }

                           if (i == sisseloetudTekst.length) {
                               try {
                                   a.kirjuta(tulemused);
                               } catch (IOException e1) {
                                   e1.printStackTrace();
                               }
                               primaryStage.close();
                           }

                           kasutatavInfo = sisseloetudTekst[i].split(";");
                           labelfirst.setText(kasutatavInfo[0]);
                           radio1.setText(kasutatavInfo[1]);
                           radio2.setText(kasutatavInfo[2]);
                           radio3.setText(kasutatavInfo[3]);
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
