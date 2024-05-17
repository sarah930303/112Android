package com.example.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private BreakIterator txvshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txvshow = findViewById(R.id.txvshow);
        Button btnAbout = findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               new AlertDialog.Builder(MainActivity.this)
                .setTitle("關於本書")
                .setMessage("Android App 開發教學")
                       .setCancelable(true)
                          .setPositiveButton("確定", null)
                            .show();
            }
        });
        Button btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("確認視窗")
                        .setMessage("確定要離開嗎?")
                        .setCancelable(false)
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"按下取消按鈕",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
        Button btnColor = (Button) findViewById(R.id.btnColor);
        btnColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("選擇顏色")
                        .setItems(new String[]{"紅色", "綠色", "藍色"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        Toast.makeText(MainActivity.this, "你選擇了紅色", Toast.LENGTH_SHORT).show();
                                        btnColor.setBackgroundColor(Color.RED);
                                        break;
                                    case 1:
                                        Toast.makeText(MainActivity.this, "你選擇了綠色", Toast.LENGTH_SHORT).show();
                                        btnColor.setBackgroundColor(Color.GREEN);
                                        break;
                                    case 2:
                                        Toast.makeText(MainActivity.this, "你選擇了藍色", Toast.LENGTH_SHORT).show();
                                        btnColor.setBackgroundColor(Color.BLUE);
                                        break;
                                }
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"按下取消按鈕",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
        Button btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("請勾選選項")
                        .setPositiveButton("確定", MainActivity.this)
                        .setNegativeButton("取消", MainActivity.this)
                        .setMultiChoiceItems(new String[]{"Samsung", "oppo", "Apple", "ASUS"}, new boolean[]{false, false, false, false}, null)
                        .show();
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
//        switch (which) {
//            case DialogInterface.BUTTON_POSITIVE:
//                finish();
//                break;
//            case DialogInterface.BUTTON_NEGATIVE:
//                Toast.makeText(this,"按下取消按鈕",Toast.LENGTH_SHORT).show();
//                break;
//        }
        String msg = "你選擇了:";
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                SparseBooleanArray checked = ((AlertDialog) dialog).getListView().getCheckedItemPositions();
                for (int i = 0; i < checked.size(); i++) {
                    if (checked.valueAt(i)) {
                        msg += ((AlertDialog) dialog).getListView().getAdapter().getItem(checked.keyAt(i)) + " ";
                    }
                }
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(this, "按下取消按鈕", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}