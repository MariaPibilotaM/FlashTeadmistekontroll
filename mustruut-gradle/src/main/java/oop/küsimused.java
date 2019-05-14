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


public class küsimused extends Application {
    String küsimus;
    String vastus;

    public küsimused(String Küsimus,String Vastus){
        küsimus = Küsimus;
        vastus = Vastus;
    }
    @Override

    public void start(Stage primaryStage) {
        String[] vastusevariandid = vastus.split(" "); //splitime lisatavad
        //Pealava nimetuse määramine
        primaryStage.setTitle("Testike");
        //Küsimuse lisamine
        Label labelfirst= new Label(küsimus);
        Label labelresponse= new Label();

        //Vastamise nupp
        Button button= new Button("Vasta");
        //Valikvõimaluste lisamine
        RadioButton radio1, radio2, radio3;
        radio1=new RadioButton(vastusevariandid[0]);
        radio2= new RadioButton(vastusevariandid[1]);
        radio3= new RadioButton(vastusevariandid[3]);

        //Grupi loomine
        ToggleGroup question1= new ToggleGroup();

        radio1.setToggleGroup(question1);
        radio2.setToggleGroup(question1);
        radio3.setToggleGroup(question1);
        //Vaikesätted
        button.setDisable(true);

        radio1.setOnAction(e -> button.setDisable(false) );
        radio2.setOnAction(e -> button.setDisable(false) );
        radio3.setOnAction(e -> button.setDisable(false) );
        //Väärtustamine
        button.setOnAction(e ->
                {

                    if (radio3.isSelected())
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

        layout.getChildren().addAll(labelfirst, radio1, radio2, radio3, button, labelresponse);

        Scene scene1= new Scene(layout, 400, 250);
        primaryStage.setScene(scene1);

        primaryStage.show();
    }


    public static void main(String[] args) {
        String k1 = "Mis värvi on banaan?";
        String vastused = "kollane punane lilla";
        küsimused uus = new küsimused(k1,vastused);
        launch(args);
    }

}
