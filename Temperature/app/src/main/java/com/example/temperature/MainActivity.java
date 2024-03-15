package com.example.temperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button(View view)
    {
        EditText txtTemp =(EditText) findViewById(R.id.txtTemp);
        int tmp = Integer.parseInt(txtTemp.getText().toString());
        double result=(9.0*tmp)/5.0+32.0;
        TextView output =(TextView) findViewById(R.id.lblOutput);
        output.setText("華氏溫度"+result);

    }
}