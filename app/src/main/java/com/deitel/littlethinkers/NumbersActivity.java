package com.deitel.littlethinkers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NumbersActivity extends AppCompatActivity {

    Button btnLearnNumbers, btnActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        btnLearnNumbers = findViewById(R.id.btnLearnNumbers);
        btnActivity = findViewById(R.id.btnActivity);

        btnLearnNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NumbersActivity.this);

                builder.setTitle("LEARNING NUMBERS");
                builder.setMessage("Click on a number to start learning.   Click next to move to the next set of numbers");


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent loginInt = new Intent(NumbersActivity.this, zero_to_6numbers.class);
                        startActivity(loginInt);
                    }
                });
                builder.show();
            }
        });
    }
}
