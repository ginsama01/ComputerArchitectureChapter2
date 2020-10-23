package sample;

import doubletype.DoubleType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Controller2 {

    @FXML
    private TextField text1, text2, text3, text4, bitNguyen, bitThuc;

    @FXML
    private TextArea text5, text6;

    @FXML
    public void onActionTen(ActionEvent event) {
        text2.setText(DoubleType.tenToTinh(text1.getText()));
        text3.setText(DoubleType.tenToTinhSign(text1.getText(), bitNguyen.getText(), bitThuc.getText()));
        text4.setText(DoubleType.tenToDauPhayDong(text1.getText()));
        text5.setText(DoubleType.dauPhayDongToDoCxacDon(text4.getText()));
        text6.setText(DoubleType.dauPhayDongToDoCxacKep(text4.getText()));
    }

    public void onActionTwo(ActionEvent event) {
        text1.setText(DoubleType.tinhToTen(text2.getText()));
        text3.setText(DoubleType.tenToTinhSign(text1.getText(), bitNguyen.getText(), bitThuc.getText()));
        text4.setText(DoubleType.tenToDauPhayDong(text1.getText()));
        text5.setText(DoubleType.dauPhayDongToDoCxacDon(text4.getText()));
        text6.setText(DoubleType.dauPhayDongToDoCxacKep(text4.getText()));
    }

    public void onActionBitdau(ActionEvent event) {
        text1.setText(DoubleType.bitdauToTen(text3.getText(), bitNguyen.getText(), bitThuc.getText()));
        text2.clear();
        text4.clear();
        text5.clear();
        text6.clear();
    }
    public void onActionDauPhayDong(ActionEvent event) {
        text5.setText(DoubleType.dauPhayDongToDoCxacDon(text4.getText()));
        text6.setText(DoubleType.dauPhayDongToDoCxacKep(text4.getText()));
        text1.clear();
        text2.clear();
        text3.clear();
    }

    public void onActionDoCxacKep(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            text4.setText(DoubleType.doCxacKepToDauPhayDong(text6.getText()));
            text5.setText(DoubleType.dauPhayDongToDoCxacDon(text4.getText()));
            text1.clear();
            text2.clear();
            text3.clear();
        }
    }

    public void onAcTionDoCxacDon(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            text4.setText(DoubleType.doCxacDonToDauPhayDong(text5.getText()));
            text6.setText(DoubleType.dauPhayDongToDoCxacKep(text4.getText()));
            text1.clear();
            text2.clear();
            text3.clear();
        }
    }

    public void initialize() {
        text5.setWrapText(true);
        text6.setWrapText(true);
    }
}
