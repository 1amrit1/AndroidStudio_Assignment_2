package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView txtTitle,txtPrice,txtDescp;
    EditText extQuantity;
    Button btnAddToCart, btnBack;
    ImageView ImgPersonalPr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txtTitle = findViewById(R.id.txtTitle);
        txtDescp = findViewById(R.id.txtDescp);
        txtPrice = findViewById(R.id.txtPrice);
        extQuantity = findViewById(R.id.extQuantity);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        btnBack = findViewById(R.id.btnBack);
        ImgPersonalPr = findViewById(R.id.ImgPersonalPr);

        txtTitle.setText(MainActivity.prObj.getName());
        txtDescp.setText(MainActivity.prObj.getDescription());
        txtPrice.setText(String.valueOf( MainActivity.prObj.getPrice()));
        ImgPersonalPr.setImageResource(MainActivity.prObj.getImage());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int productPrice = MainActivity.prObj.getPrice();
                int quantity = Integer.parseInt(extQuantity.getText().toString());
                int costOfProducts = productPrice * quantity;
                MainActivity.total += costOfProducts;
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);

            }
        });

    }
}