package oop;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static java.lang.Math.round;


public class Hiireasukoht extends Application {
    public void start(Stage peaLava) {
        int kõrgus =600;
        int laius = 200;


        Group juur = new Group(); // luuakse juur

        Scene stseen1 = new Scene(juur);  // luuakse stseen
        stseen1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {

                juur.getChildren().add(new Text(me.getSceneX()+15,me.getSceneY(),
                        "X: "+round(me.getSceneX())+"  Y:"+round(me.getSceneY())));
                System.out.print("X: "+ round(me.getSceneX()) +"  ");
                System.out.print("Y: "+round(me.getSceneY()));
                System.out.println();
            }
        });

        peaLava.setTitle("Asukoht");  // lava tiitelribale pannakse tekst
        peaLava.setScene(stseen1);  // lavale lisatakse stseen
        peaLava.show();  // lava tehakse nähtavaks
    }

    public static void main(String args[])
    {
        launch(args);
    }
}


