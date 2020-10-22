package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import toantu.BinaryExpression;

public class Controller3 {

    @FXML
    private TextField textA, textB, textResult;

    public void onAdd(ActionEvent event) {
        textResult.setText(BinaryExpression.add(textA.getText(), textB.getText()));
    }

    public void onSub(ActionEvent event) {
        textResult.setText(BinaryExpression.sub(textA.getText(), textB.getText()));
    }

    public void onMul(ActionEvent event) {
        textResult.setText(BinaryExpression.mul(textA.getText(), textB.getText()));
    }

    public void onDivide(ActionEvent event) {
        textResult.setText(BinaryExpression.divide(textA.getText(), textB.getText()));
    }


    @FXML
    public void initialize() {
        textResult.setEditable(false);
    }
}
