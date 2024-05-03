package com.example.rdbdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgGender, rgType;
    private EditText etQuantity;
    private TextView lblOutput;
    private Button btnSave, btnConfirm;
    private List<String> savedRecords = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgGender = findViewById(R.id.rgGender);
        rgType = findViewById(R.id.rgType);
        etQuantity = findViewById(R.id.etQuantity);
        lblOutput = findViewById(R.id.lblOutput);
        btnSave = findViewById(R.id.btnSave);
        btnConfirm = findViewById(R.id.btnConfirm);

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                updateOutput();
            }
        });

        rgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                updateOutput();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRecord();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start MainActivity2
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                // Pass the saved records to MainActivity2
                intent.putStringArrayListExtra(getString(R.string.savedRecords), (ArrayList<String>) savedRecords);
                // Start MainActivity2
                startActivity(intent);
            }
        });

        updateOutput();
    }

    private void updateOutput() {
        String str = "";
        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        RadioButton rdbGender = findViewById(selectedGenderId);
        if (rdbGender != null) {
            str += getResources().getString(R.string.gender) + ": " + rdbGender.getText() + "\n";
        }

        int selectedTypeId = rgType.getCheckedRadioButtonId();
        RadioButton rdbType = findViewById(selectedTypeId);
        if (rdbType != null) {
            String selectedType = rdbType.getText().toString();
            switch (selectedType) {
                case "Regular Ticket":
                    str += getResources().getString(R.string.ticketType) + ": " + getResources().getString(R.string.regularTicket) + "\n";
                    break;
                case "Children Ticket":
                    str += getResources().getString(R.string.ticketType) + ": " + getResources().getString(R.string.childrenTicket) + "\n";
                    break;
                case "Student Ticket":
                    str += getResources().getString(R.string.ticketType) + ": " + getResources().getString(R.string.studentTicket) + "\n";
                    break;
            }
        }

        String quantityStr = etQuantity.getText().toString();
        int quantity = quantityStr.isEmpty() ? 0 : Integer.parseInt(quantityStr);

        // Calculate total price
        int totalPrice = calculateTotalPrice(selectedTypeId, quantity);
        str += getResources().getString(R.string.numberOfTickets) + ": " + quantity + "\n";
        str += getResources().getString(R.string.total) + ": " + totalPrice + getResources().getString(R.string.currency) + "\n";

        lblOutput.setText(str);
    }

    // Calculate total price based on selected ticket type and quantity
    private int calculateTotalPrice(int selectedTypeId, int quantity) {
        int price = 0;
        if (selectedTypeId == R.id.rdbAdult) {
            price = 500;
        } else if (selectedTypeId == R.id.rdbChild) {
            price = 250;
        } else if (selectedTypeId == R.id.rdbStudent) {
            price = 400;
        }
        return price * quantity;
    }


    private void saveRecord() {
        if (rgGender.getCheckedRadioButtonId() == -1 || rgType.getCheckedRadioButtonId() == -1 || etQuantity.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, getResources().getString(R.string.completeData), Toast.LENGTH_SHORT).show();
            return;
        }

        String record = lblOutput.getText().toString();
        savedRecords.add(record);
        // Clear input fields
        etQuantity.setText("");
        Toast.makeText(MainActivity.this, getResources().getString(R.string.recordSaved), Toast.LENGTH_SHORT).show();
    }
}
