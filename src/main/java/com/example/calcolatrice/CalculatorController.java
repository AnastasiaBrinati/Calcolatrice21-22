package com.example.calcolatrice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static java.lang.Float.parseFloat;


public class CalculatorController {

    @FXML
    private TextField bar;

    @FXML
    private Button btn0;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnC;

    @FXML
    private Button btnCE;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnDot;

    @FXML
    private Button btnE;

    @FXML
    private Button btnEquals;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btnMultiply;

    @FXML
    private Button btnPi;

    private boolean dot = false;
    private boolean op = false;
    private String operation = "";
    float firstNum;
    float result;

    public void delete(){
        if(bar.getText().length() >0){
            bar.setText("");
            dot = false;

        }

    }
    public void deleteOne(){
        if(bar.getText().length() >0){
            if(bar.getText().charAt(bar.getLength() - 1) == '.'){
                dot = false;
            }
            bar.setText(bar.getText().substring(0,bar.getLength()-1));
         }

    }


    public void selectOperation(ActionEvent event){

        if(bar.getText().length()>0){
            operation = ((Button)event.getTarget()).getText().toString();
            System.out.println("Op selected : "+operation);
            op = true;
            firstNum = parseFloat(bar.getText());
        }
    }

    public void displayDot(ActionEvent event){
        if(bar.getText().length()>0){
            if(!dot){
                bar.setText(bar.getText()+".");
            }
            dot=true;
        }
    }

    public void pi(ActionEvent event){
        bar.setText("3.14");
        dot = true;
    }

    public void nepero(ActionEvent event){
        bar.setText("2.7");
        dot = true;
    }

    public void calculateResult(ActionEvent event){

        dot=true;

        switch (operation) {
            case "+" -> {
                result = Calculator.getInstance().sum(firstNum, parseFloat(bar.getText()));
                bar.setText(Float.toString(result));
            }
            case "-" -> {
                result = Calculator.getInstance().sub(firstNum, parseFloat(bar.getText()));
                bar.setText(Float.toString(result));
            }
            case "x" -> {
                result = Calculator.getInstance().mul(firstNum, parseFloat(bar.getText()));
                bar.setText(Float.toString(result));
            }
            case ":" -> {
                result = Calculator.getInstance().div(firstNum, parseFloat(bar.getText()));
                bar.setText(Float.toString(result));
            }
            default -> {
                break;
            }
        }
        op = true;
    }


    @FXML
    void write(ActionEvent event) {

        if(op){
            dot = false;
            bar.setText("");
            op = false;

        }
        bar.setText(bar.getText() + ((Button)event.getTarget()).getText());

    }

}
