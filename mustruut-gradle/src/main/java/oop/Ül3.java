package oop;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.Event;

import javax.swing.*;


public class Ül3 extends Application {

    @Override
    public void start(Stage peaLava) throws Exception {
        Group juur = new Group();

        //ringide loomine
        Circle ring1 = new Circle(100, 60, 35, Color.YELLOW);
        Circle ring2 = new Circle(350,40, 40, Color.GRAY);

        juur.getChildren().addAll(ring1,ring2);

        class HiireKäsitleja implements EventHandler<MouseEvent>{
            public void handle(MouseEvent event){
                System.out.println("Siht " + event.getTarget());
                System.out.println("allikas" + event.getSource());
                System.out.println("Käsitleja, sees");
            }
        }
        EventHandler<MouseEvent> käsitleja = new HiireKäsitleja();
        ring1.setOnMouseEntered(käsitleja);
        ring1.setOnMouseExited(
                new EventHandler<MouseEvent>(){
                    public void handle(MouseEvent event) {
                        if (ring1.getFill() == Color.YELLOW){
                            ring1.setFill(Color.DEEPSKYBLUE);}
                        else
                            ring1.setFill(Color.LIGHTCORAL);
                    }});
        ring2.setOnMousePressed(käsitleja);
        ring2.setOnMousePressed(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if(ring2.getFill() == Color.GRAY) {
                            ring2.setFill(Color.YELLOW);
                        }
                        else
                            ring2.setFill(Color.GRAY);
                }});





        Scene stseen1 = new Scene(juur,500,300,Color.SNOW); //ekraani mõõtmed & värv

        peaLava.setTitle("Ringid");  // lava tiitelribale pannakse tekst
        peaLava.setScene(stseen1);  // lavale lisatakse stseen
        peaLava.show();  // lava tehakse nähtavaks
    }

    public static void main(String[] args) {
        launch(args);
    }
}
