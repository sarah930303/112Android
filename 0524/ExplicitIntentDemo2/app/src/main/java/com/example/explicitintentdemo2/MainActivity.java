package com.example.explicitintentdemo2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.lblOutput);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtOpd1, txtOpd2;
                txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
                txtOpd2 = (EditText) findViewById(R.id.txtOpd2);

                double opd1 = Double.parseDouble(txtOpd1.getText().toString());
                double opd2 = Double.parseDouble(txtOpd2.getText().toString());

                Intent intent = new Intent(MainActivity.this, OpActivity.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("OPERAND01", opd1);
                bundle.putDouble("OPERAND02", opd2);
                intent.putExtras(bundle);

                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    double result = data.getDoubleExtra("RESULT", 0.0);
                    output.setText("計算結果: " + result);
                }
                break;
        }
    }
}
