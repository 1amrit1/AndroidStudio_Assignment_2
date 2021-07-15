package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PlaceOrderActivity extends AppCompatActivity {
    TextView txtTotal ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        txtTotal = findViewById(R.id.txtFinalTotal);
        txtTotal.setText(String.valueOf(MainActivity.total));
    }
}