package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String productNames[] = {"Apple Iphone 12 plus","Samsung S20+","Nokia 1100"};
    ArrayList<Product> prList = new ArrayList<>();
    public static Product prObj;//public static variables are available globally
    public static int total = 0;

    TextView price, txtTotal;
    ImageView imgProduct;
    Spinner spProduct;
    Button showMore, placeOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillArrayList();

        //initializing the view components
        price = findViewById(R.id.txtPrice);
        txtTotal = findViewById(R.id.txtTotal);
        imgProduct = findViewById(R.id.imgProduct);
        spProduct = findViewById(R.id.spinner);
        showMore = findViewById(R.id.btnShowMore);
        placeOrder = findViewById(R.id.btnPlaceOrder);

        txtTotal.setText(String.valueOf(total));

        //create an array adaptor and fill from the array (to add menu in spinner from array)
        ArrayAdapter aa = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,productNames);
        spProduct.setAdapter(aa);

        //implement spinner event
        spProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                price.setText(String.valueOf(prList.get(position).getPrice()));
                imgProduct.setImageResource(prList.get(position).getImage());
                prObj = prList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        showMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here we need to move to another class activity
                // no direct transition. But need to go through transition state
                //and we do it thorough intent
                Intent intent = new Intent(getBaseContext(),DetailsActivity.class);
                startActivity(intent);
            }
        });

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),PlaceOrderActivity.class);
                startActivity(intent);
            }
        });

    }

    public void fillArrayList(){
        //order of elements should be same as that of productNames array
        prList.add(new Product("Apple Iphone 12 plus", 1299, R.mipmap.iphone12, "Meet the ultimate iPhone. With the fastest smartphone chip. 5G speed. A Pro camera system that’s killer in low light. A LiDAR Scanner for more realistic AR. And two great sizes to choose from — including our largest display ever."));
        prList.add(new Product("Samsung S20+", 1249, R.mipmap.s20, "Samsung Galaxy S20 smartphone was launched on 11th February 2020. The phone comes with a 6.20-inch touchscreen display with a resolution of 1440x3200 pixels and an aspect ratio of 20:9. "));
        prList.add(new Product("Nokia 1100", 150, R.mipmap.nokia1100, "The Nokia 1100 (and closely related variants, the Nokia 1101 and the Nokia 1108) is a basic GSM mobile phone produced by Nokia. Over 250 million 1100s have been sold since its launch in late 2003, making it the world's best selling phone handset"));

    }
}