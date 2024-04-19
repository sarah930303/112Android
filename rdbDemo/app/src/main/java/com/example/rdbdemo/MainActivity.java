package com.example.rdbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "";
                RadioButton rdbboy = (RadioButton) findViewById(R.id.rdbBoy);
                RadioButton rdbgirl = (RadioButton) findViewById(R.id.rdbGirl);
                if (rdbboy.isChecked())
                    str += getResources().getString(R.string.male) + "\n";
                else if (rdbgirl.isChecked())
                    str += getResources().getString(R.string.female) + "\n";
                RadioGroup rgType = (RadioGroup) findViewById(R.id.rgType);
                if (rgType.getCheckedRadioButtonId() == R.id.rgType)
                    str += getResources().getString(R.string.regularticket) + "\n";
                else if (rgType.getCheckedRadioButtonId() == R.id.rdbChild)
                    str += getResources().getString(R.string.regularticket) + "\n";
                else
                    str += getResources().getString(R.string.studentticket) + "\n";

                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText(str);
            }
        });
    }
}