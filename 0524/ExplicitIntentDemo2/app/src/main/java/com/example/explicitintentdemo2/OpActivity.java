package com.example.explicitintentdemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompatSideChannelService;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class OpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op);

        Button button2 = (Button) findViewById(R.id.button2);

        CheckBox chkDivide = (CheckBox) findViewById(R.id.chkDivide);
        chkDivide.setEnabled(false);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int opd1,opd2;
                double result=0.0;
                RadioButton rdoAdd, rdoSub, rdoMul, rdoDiv;

                Bundle bundle = OpActivity.this.getIntent().getExtras();
                if(bundle==null) return;

                opd1 = Integer.parseInt(bundle.getString("OPERAND01"));
                opd2 = Integer.parseInt(bundle.getString("OPERAND02"));

                rdoAdd = (RadioButton) findViewById(R.id.rdbAdd);
                chkDivide.setEnabled(false);
                if (rdoAdd.isChecked()) {
                    result = opd1 + opd2;
                }
                rdoSub = (RadioButton) findViewById(R.id.rdbSubtract);
                chkDivide.setEnabled(false);
                if (rdoSub.isChecked()) {
                    result = opd1 - opd2;
                }
                rdoMul = (RadioButton) findViewById(R.id.rdbMultiply);
                chkDivide.setEnabled(false);
                if (rdoMul.isChecked()) {
                    result = opd1 * opd2;
                }
                rdoDiv = (RadioButton) findViewById(R.id.rdbDivide);
                if (rdoDiv.isChecked()) {
                    chkDivide.setEnabled(true);
                    if (chkDivide.isChecked())
                    result = opd1 / opd2;
                    else
                    result = opd1 / (double)opd2;
                }
                Intent rIntent = new Intent();

                Bundle resultBundle = new Bundle();
                resultBundle.putDouble("RESULT", result);
                rIntent.putExtras(resultBundle);
                setResult(RESULT_OK, rIntent);
                finish();
            }
        });
    }
}