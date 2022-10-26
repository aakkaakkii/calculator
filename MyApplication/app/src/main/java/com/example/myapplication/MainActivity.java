package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;

    private double operand = 0;
    private String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

    }

    public void numberClick(View view) {

        if (view instanceof TextView) {


            String text = resultTextView.getText().toString();
            String number = ((TextView) view).getText().toString();

            if (text.equals("0")) {
                text = "";
            }


            resultTextView.setText(text + number);
        }
    }

    public void operationClick(View view) {

        if (view instanceof TextView) {
            operation = ((TextView) view).getText().toString();
            String operationText = resultTextView.getText().toString();

            if (!operationText.isEmpty()) {
                operand = Double.parseDouble(operationText);
            }

            resultTextView.setText("");

        }
    }

    public void equalsClick(View view) {

        String secOperandText = resultTextView.getText().toString();
        double secOperand = 0.0;

        if (!TextUtils.isEmpty(secOperandText)) {
            secOperand = Double.parseDouble(secOperandText);
        }

        switch (this.operation) {
            case "+":
                resultTextView.setText(String.valueOf(operand + secOperand));
                break;
            case "-":
                resultTextView.setText(String.valueOf(operand - secOperand));
                break;
            case "X":
                resultTextView.setText(String.valueOf(operand * secOperand));
                break;
            case "/":
                resultTextView.setText(String.valueOf(operand / secOperand));
                break;
            case "C":
                operand = 0;
                operation = "";
                resultTextView.setText("");
                break;
            case "%":
                resultTextView.setText(String.valueOf(operand * secOperand / 100));
                break;
        }
    }

    public void plusMinusClick(View view) {
        String secOperandText = resultTextView.getText().toString();
        resultTextView.setText( String.valueOf(Double.parseDouble(secOperandText) * -1));
    }

    public void delClick(View view) {
        String res = resultTextView.getText().toString();

        if (TextUtils.isEmpty(res)) {
            return;
        }

        resultTextView.setText(res.substring(0, res.length() - 1));
    }


    public void dotClick(View view) {
        String res = resultTextView.getText().toString();

        if (TextUtils.isEmpty(res)) {
            resultTextView.setText("0.");

        } else if (!res.contains(".")) {
            resultTextView.setText(res + ".");
        }
    }

}