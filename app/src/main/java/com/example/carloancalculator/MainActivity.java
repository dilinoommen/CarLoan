package com.example.carloancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private EditText PurchasePrice;
    private EditText DownPayment;
    private EditText APR;
    private EditText LengthofLoan;
    private TextView Display;
    private Button Button;
    private ToggleButton toggleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        PurchasePrice = findViewById(R.id.PurchasePrice);
        DownPayment = findViewById(R.id.DownPayment);
        APR = findViewById(R.id.APR);
        LengthofLoan = findViewById(R.id.LengthofLoan);
        Display = findViewById(R.id.Display);
        Button = findViewById(R.id.Button);
        toggleButton = findViewById(R.id.toggleButton);


        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num = Double.parseDouble(PurchasePrice.getText().toString());
                double num1 = Double.parseDouble(DownPayment.getText().toString());
                double num2 = Double.parseDouble(APR.getText().toString());
                double num3 = Integer.parseInt(LengthofLoan.getText().toString());
                if (toggleButton.isChecked()) {
                    double a = num  / 3;
                    num3 = 36;
                    double r2 = num2 / 100 / 12;
                    Display.setText("Monthly payment for Lease: " +(r2 * ((a-num1)) / (1 - (Math.pow(1 + r2, -num3)))));

                } else {

                    double r = num2 / 100 / 12;
                    double r1 = Math.pow(num2, num3);
                    Display.setText("Monthly payment for Loan: " + (r * (num - num1) / (1 - (Math.pow(1 + r, -num3)))));

                }
            }
        });
    }
}
