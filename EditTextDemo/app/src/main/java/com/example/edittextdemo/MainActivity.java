package com.example.edittextdemo;

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
        EditText name =(EditText) findViewById(R.id.txtName);
        String str =name.getText().toString();
        TextView output =(TextView) findViewById(R.id.lblOutput);
        output.setText("你好!"+str);
    }
}