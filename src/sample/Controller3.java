package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import toantu.BinaryExpression;

public class Controller3 {

    @FXML
    private TextField textA, textB, textResult, textInput;

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

    public void onActionExpression(ActionEvent event) {
        String text = textInput.getText();
        String numA = "", numB = "";
        for (int i = 0; i < text.length(); ++i)
        {
            char t = text.charAt(i);
            if (t == '+' || t == '-' || t == '*' || t == '/') {
                numA = text.substring(0, i);
                numB = text.substring(i+1, text.length());
                String result = "";
                if (t == '+') {
                    result = BinaryExpression.add(numA, numB);
                } else if (t == '-') {
                    result = BinaryExpression.sub(numA, numB);
                } else if (t == '*') {
                    result = BinaryExpression.mul(numA, numB);
                } else if (t == '/') {
                    result = BinaryExpression.divide(numA, numB);
                }
                textResult.setText(result);
                break;
            }
        }
    }

    @FXML
    public void initialize() {
        textResult.setEditable(false);
    }
}
