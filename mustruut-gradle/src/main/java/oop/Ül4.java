package oop;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Ül4 extends Application {
    public void start(Stage peaLava) {
        int kõrgus =600;
        int laius = 200;
        int x = 65;
        int y = 35;
        Group juur = new Group(); // luuakse juur

        Button nupuke = new Button("PÜÜA!"); // luuakse nupp
        nupuke.setLayoutX(x); // nupu paigutamine x-koordinaadi mõttes
        nupuke.setLayoutY(y); // nupu paigutamine y-koordinaadi mõttes
        nupuke.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                int suvalineX = (int)(Math.random()*(kõrgus-nupuke.getHeight()));
                int suvalineY = (int)((Math.random()*(laius-nupuke.getWidth())));

                nupuke.relocate(suvalineX,suvalineY);

            }
        });
        juur.getChildren().add(nupuke); // nupp lisatakse juure alluvaks


        Scene stseen1 = new Scene(juur);  // luuakse stseen
        peaLava.setTitle("Nupuke");  // lava tiitelribale pannakse tekst
        peaLava.setScene(stseen1);  // lavale lisatakse stseen
        peaLava.show();  // lava tehakse nähtavaks
    }

    public static void main(String args[])
    {
        launch(args);
    }
}


