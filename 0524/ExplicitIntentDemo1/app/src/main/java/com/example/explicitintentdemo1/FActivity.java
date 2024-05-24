package com.example.explicitintentdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factivity);
        convertTempture();
        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void convertTempture() {
        int c;
        double f=0.0;
        String place="";
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            c = bundle.getInt("tempC",0);
            f = c * 9.0 / 5.0 + 32;
            place = bundle.getString("place","");
            TextView output = (TextView) findViewById(R.id.lblOutput    );
            output.setText(place +"\n華氏溫度"+Double.toString(f));
        }
    }
}