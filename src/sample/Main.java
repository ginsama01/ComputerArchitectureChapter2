package sample;

import doubletype.DoubleType;
import integer.IntegerType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import toantu.BinaryExpression;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        String s = BinaryExpression.add("1.110 x 2^(-2)", "-1.000x2^(-1)");
        System.out.println(s);
    }
}
