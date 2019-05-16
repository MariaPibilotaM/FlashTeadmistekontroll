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

//Koodi näidise sain siit https://bit.ly/2VEEgLK
public class Ül6 extends Application {
    @Override
        public void start(Stage primaryStage) {
        //Pealava nimetuse määramine
            primaryStage.setTitle("Oluline küssa:");
         //Küsimuse lisamine
            Label labelfirst= new Label("Kas progemine on raske?");
            Label labelresponse= new Label();

            //Vastamise nupp
            Button button= new Button("Vasta");
            //Valikvõimaluste lisamine
            RadioButton radio1, radio2, radio3, radio4;
            radio1=new RadioButton("Jah, vägagi!");
            radio2= new RadioButton("Ei, asi on suhtumises!");
            radio3= new RadioButton("Mis on progemine?");
            radio4= new RadioButton("Mulle meeldibki öösel ekraani vaadata.");

            //Grupi loomine
            ToggleGroup question1= new ToggleGroup();

            radio1.setToggleGroup(question1);
            radio2.setToggleGroup(question1);
            radio3.setToggleGroup(question1);
            radio4.setToggleGroup(question1);
            //Vaikesätted
            button.setDisable(true);

            radio1.setOnAction(e -> button.setDisable(false) );
            radio2.setOnAction(e -> button.setDisable(false) );
            radio3.setOnAction(e -> button.setDisable(false) );
            radio4.setOnAction(e -> button.setDisable(false) );
            //Väärtustamine
            button.setOnAction(e ->
                    {

                        if (radio4.isSelected())
                        {
                            labelresponse.setText("Õige vastus");
                            button.setDisable(true);
                        }

                        else
                        {
                            labelresponse.setText("Vale vastus");
                            button.setDisable(true);
                        }
                    }
            );

            VBox layout= new VBox(5);

            layout.getChildren().addAll(labelfirst, radio1, radio2, radio3, radio4, button, labelresponse);

            Scene scene1= new Scene(layout, 400, 250);
            primaryStage.setScene(scene1);

            primaryStage.show();
        }


        public static void main(String[] args) {
            launch(args);
        }

    }



