package com.example.scenebuildercalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class CalcController {

    @FXML
    private TextField left, right;

    @FXML
    private Label operationSign, equationSign, result;

    @FXML
    private Button plusBtn, minusBtn, divBtn, multBtn, eqBtn;

    private enum op {
        ADD,
        SUB,
        MUL,
        DIV
    }

    private op currOp = op.ADD;

    @FXML
    protected void onPlusClick() {
        operationSign.setText("+");
        currOp = op.ADD;
    }

    @FXML
    protected void onMinusClick() {
        operationSign.setText("-");
        currOp = op.SUB;
    }

    @FXML
    protected void onDivClick() {
        operationSign.setText("/");
        currOp = op.DIV;
    }

    @FXML
    protected void onMultClick() {
        operationSign.setText("*");
        currOp = op.MUL;
    }

    @FXML
    protected void onLeftAction() {
        left.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!".0123456789".contains(event.getCharacter())) event.consume();
            if (".".equals(event.getCharacter())) {
                if (left.getText().contains(".")) event.consume();
                if ("".equals(left.getText())) left.insertText(left.getCaretPosition(), "0");
            }
            if ("0".equals(event.getCharacter()) && "0".equals(left.getText())) event.consume();
        });
    }

    @FXML
    protected void onRightAction() {
        right.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!".0123456789".contains(event.getCharacter())) event.consume();
            if (".".equals(event.getCharacter())) {
                if (right.getText().contains(".")) event.consume();
                if ("".equals(right.getText())) right.insertText(right.getCaretPosition(), "0");
            }
            if ("0".equals(event.getCharacter()) && "0".equals(right.getText())) event.consume();
        });
    }

    @FXML
    protected void onEqClick() {
        double l, r;
        if ("".equals(left.getText())) l = 0.0;
        else l = Double.parseDouble(left.getText());
        if ("".equals(right.getText())) r = 0.0;
        else r = Double.parseDouble(right.getText());

        switch (currOp) {
            case ADD -> doOp(l + r);
            case SUB -> doOp(l - r);
            case MUL -> doOp(l * r);
            case DIV -> {
                if (r != 0.0) doOp(l / r);
                else result.setText("");
            }
        }

    }

    private void doOp(double res) {
        if (res == (int)res) result.setText(String.format("%d", (int)res));
        else result.setText(String.format("%.2f", res));
    }
}