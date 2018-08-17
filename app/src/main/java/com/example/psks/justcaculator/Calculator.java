package com.example.psks.justcaculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Calculator extends Activity implements View.OnClickListener {

    private enum OPERATOR {
        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    TextView txtCalculation;
    TextView txtResult;

    private String currentNumber;
    private String numberAtLeft;
    private String numberAtRight;
    private OPERATOR currentOperator;
    private int calculationsResult;
    private String calculationString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        currentNumber = "";
        calculationsResult = 0;

        calculationString = "";

        txtCalculation = findViewById(R.id.txtCalculation);
        txtResult = findViewById(R.id.txtResult);

        findViewById(R.id.btnPlus).setOnClickListener(Calculator.this);
        findViewById(R.id.btnDevide).setOnClickListener(Calculator.this);
        findViewById(R.id.btnMultiply).setOnClickListener(Calculator.this);
        findViewById(R.id.btnSubtract).setOnClickListener(Calculator.this);
        findViewById(R.id.btnEqual).setOnClickListener(Calculator.this);
        findViewById(R.id.btnClear).setOnClickListener(Calculator.this);
        findViewById(R.id.btn0).setOnClickListener(Calculator.this);
        findViewById(R.id.btn1).setOnClickListener(Calculator.this);
        findViewById(R.id.btn2).setOnClickListener(Calculator.this);
        findViewById(R.id.btn3).setOnClickListener(Calculator.this);
        findViewById(R.id.btn4).setOnClickListener(Calculator.this);
        findViewById(R.id.btn5).setOnClickListener(Calculator.this);
        findViewById(R.id.btn6).setOnClickListener(Calculator.this);
        findViewById(R.id.btn7).setOnClickListener(Calculator.this);
        findViewById(R.id.btn8).setOnClickListener(Calculator.this);
        findViewById(R.id.btn9).setOnClickListener(Calculator.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                numberIsTapped(0);
                break;
            case R.id.btn1:
                numberIsTapped(1);
                break;
            case R.id.btn2:
                numberIsTapped(2);
                break;
            case R.id.btn3:
                numberIsTapped(3);
                break;
            case R.id.btn4:
                numberIsTapped(4);
                break;
            case R.id.btn5:
                numberIsTapped(5);
                break;
            case R.id.btn6:
                numberIsTapped(6);
                break;
            case R.id.btn7:
                numberIsTapped(7);
                break;
            case R.id.btn8:
                numberIsTapped(8);
                break;
            case R.id.btn9:
                numberIsTapped(9);
                break;
            case R.id.btnPlus:
                operatorIsTapped(OPERATOR.PLUS);
                calculationString += " + ";
                break;
            case R.id.btnSubtract:
                operatorIsTapped(OPERATOR.SUBTRACT);
                calculationString += " - ";
                break;
            case R.id.btnMultiply:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationString += " * ";
                break;
            case R.id.btnDevide:
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationString += " / ";
                break;
            case R.id.btnEqual:
                operatorIsTapped(OPERATOR.EQUAL);
                break;
            case R.id.btnClear:
                clearTapped();
                break;
        }
        txtCalculation.setText(calculationString);
    }

    private void numberIsTapped(int tappedNumber) {
        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtResult.setText(currentNumber);
        calculationString = currentNumber;
        txtCalculation.setText(calculationString);
    }

    private void operatorIsTapped(OPERATOR tappedOperator) {
        if (currentOperator != null) {
            if (currentNumber != "") {

                numberAtRight = currentNumber;
                currentNumber = "";

                switch (currentOperator) {
                    case PLUS:
                        calculationsResult = Integer.parseInt(numberAtLeft) + Integer.parseInt(numberAtRight);
                        break;
                    case DIVIDE:
                        calculationsResult = Integer.parseInt(numberAtLeft) - Integer.parseInt(numberAtRight);
                        break;
                    case MULTIPLY:
                        calculationsResult = Integer.parseInt(numberAtLeft) * Integer.parseInt(numberAtRight);
                        break;
                    case SUBTRACT:
                        calculationsResult = Integer.parseInt(numberAtLeft) / Integer.parseInt(numberAtRight);
                        break;
                }

                numberAtLeft = String.valueOf(calculationsResult);
                txtResult.setText(numberAtLeft);
                calculationString = numberAtLeft;
            }

        } else {
            numberAtLeft = currentNumber;
            currentNumber = "";
        }
        currentOperator = tappedOperator;
    }

    private void clearTapped() {
        numberAtLeft = "";
        numberAtRight = "";
        calculationsResult = 0;
        currentNumber = "";
        currentOperator = null;
        txtResult.setText("0");
        calculationString = "";
        txtCalculation.setText("0");
    }
}
