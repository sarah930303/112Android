package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txvshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvshow = findViewById(R.id.txvshow);
        txvshow.setTextSize(36);
        Button btnCalc = findViewById(R.id.btncalc);
        Button btnClear = findViewById(R.id.btnclear);
        btnCalc.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText ediHeight = findViewById(R.id.edthight);
        EditText editWeight = findViewById(R.id.edtweight);

        if (v.getId() == R.id.btncalc) {
            double height = Double.parseDouble(ediHeight.getText().toString());
            double weight = Double.parseDouble(editWeight.getText().toString());
            double bmi = weight / Math.pow(height / 100.0, 2);

            if (bmi >= 24.9)
                txvshow.setTextColor(Color.RED);
            else if (bmi < 18.5)
                txvshow.setTextColor(Color.BLUE);
            else
                txvshow.setTextColor(Color.GREEN);

            txvshow.setText(String.format("%.2f", bmi));
        } else {
            editWeight.setText("");
            ediHeight.setText("");
            txvshow.setText("");
        }
    }
}
