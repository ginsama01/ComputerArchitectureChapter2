package sample;

import integer.FormatInteger;
import integer.IntegerType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Controller1 {
    @FXML
    private TextField text1, text2, text3, text4, text5, text6, text7;

    String bit1 = "4", bit2 = "4", bit3 = "4", bit4 = "4";

    @FXML
    private ChoiceBox choice1, choice2, choice3, choice4;

    @FXML
    ObservableList<String> list = FXCollections.observableArrayList("4", "8", "16", "32", "64");

    @FXML
    public void tenOnAction(ActionEvent event) {
        text2.setText(IntegerType.tenToTwo(text1.getText(), bit1));
        text3.setText(IntegerType.tenToBitDau(text1.getText(), bit2));
        text4.setText(IntegerType.tenToChuanBu1(text1.getText(), bit3));
        text5.setText(IntegerType.tenToChuanBu2(text1.getText(), bit4));
        text6.setText(IntegerType.twoToBatPhan(text2.getText()));
        text7.setText(IntegerType.twoToThapLucPhan(text2.getText()));
    }

    @FXML
    public void twoOnAction(ActionEvent event) {
        text2.setText(FormatInteger.formatBinary(text2.getText(), bit1));
        text1.setText(IntegerType.twoToTen(text2.getText()));
        text3.setText(IntegerType.tenToBitDau(text1.getText(), bit2));
        text4.setText(IntegerType.tenToChuanBu1(text1.getText(), bit3));
        text5.setText(IntegerType.tenToChuanBu2(text1.getText(), bit4));
        text6.setText(IntegerType.twoToBatPhan(text2.getText()));
        text7.setText(IntegerType.twoToThapLucPhan(text2.getText()));
    }

    @FXML
    public void bitDauOnAction(ActionEvent event) {
        text3.setText(FormatInteger.formatBinaryBit(text3.getText(), bit2));
        text1.setText(IntegerType.bitDauToTen(text3.getText()));
        text2.setText(IntegerType.tenToTwo(text1.getText(), bit1));
        text4.setText(IntegerType.tenToChuanBu1(text1.getText(), bit3));
        text5.setText(IntegerType.tenToChuanBu2(text1.getText(), bit4));
        text6.setText(IntegerType.twoToBatPhan(text2.getText()));
        text7.setText(IntegerType.twoToThapLucPhan(text2.getText()));
    }

    @FXML
    public void chuanBu1OnAction(ActionEvent event) {
        text4.setText(FormatInteger.formatBinaryCb(text4.getText(), bit3));
        text1.setText(IntegerType.chuanBu1ToTen(text4.getText()));
        text2.setText(IntegerType.tenToTwo(text1.getText(), bit1));
        text3.setText(IntegerType.tenToBitDau(text1.getText(), bit2));
        text5.setText(IntegerType.tenToChuanBu2(text1.getText(), bit4));
        text6.setText(IntegerType.twoToBatPhan(text2.getText()));
        text7.setText(IntegerType.twoToThapLucPhan(text2.getText()));
    }

    @FXML
    public void chuanBu2OnAction(ActionEvent event) {
        text5.setText(FormatInteger.formatBinaryCb(text5.getText(), bit4));
        text1.setText(IntegerType.chuanBu2ToTen(text5.getText()));
        text2.setText(IntegerType.tenToTwo(text1.getText(), bit1));
        text3.setText(IntegerType.tenToBitDau(text1.getText(), bit2));
        text4.setText(IntegerType.tenToChuanBu1(text1.getText(), bit3));
        text6.setText(IntegerType.twoToBatPhan(text2.getText()));
        text7.setText(IntegerType.twoToThapLucPhan(text2.getText()));
    }

    @FXML
    public void initialize() {
        choice1.setItems(list);
        choice2.setItems(list);
        choice3.setItems(list);
        choice4.setItems(list);
        choice1.getSelectionModel().selectFirst();
        choice2.getSelectionModel().selectFirst();
        choice3.getSelectionModel().selectFirst();
        choice4.getSelectionModel().selectFirst();
        choice1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            bit1 = newValue.toString();
        });
        choice2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            bit2 = newValue.toString();
        });
        choice3.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            bit3 = newValue.toString();
        });
        choice4.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            bit4 = newValue.toString();
        });
    }

}
