package com.example.mm.gdgcairo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button subOrder;
    private EditText EdT_Name;
    private TextView TV_numOfOrder;
    private TextView TV_Price;

    private CheckBox chB1;
    private CheckBox chB2;

    private int order = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subOrder = (Button)findViewById(R.id.But_order);

        EdT_Name = (EditText) findViewById(R.id.ET_name);
        TV_numOfOrder = (TextView) findViewById(R.id.TV_num);
        TV_Price = (TextView) findViewById(R.id.TV_Price);
        chB1 = (CheckBox) findViewById(R.id.CB_Whipped);
        chB2 = (CheckBox) findViewById(R.id.CB_Choocolate);

        chB1.setOnClickListener((View.OnClickListener) this);
        chB2.setOnClickListener((View.OnClickListener) this);

    }
    @Override
    public void onClick(View view) {
        reCal(view);
    }
    public void increase(View view){
        order = Integer.parseInt(TV_numOfOrder.getText().toString());
        order +=1;
        TV_numOfOrder.setText("" + order);
        calPrice(view);
    }
    public void decrease (View view){
        order = Integer.parseInt(TV_numOfOrder.getText().toString());
        if(order > 0) {
            order -= 1;
        }
        else{
            Toast.makeText(this,"IT is the minimum number of order!",Toast.LENGTH_LONG).show();
        }
        TV_numOfOrder.setText("" + order);
        calPrice(view);
    }
    public void calPrice(View view){

        int price = 10;
        int custPrice = order * price;
        boolean cb1 = chB1.isChecked();
        boolean cb2 = chB2.isChecked();
        if(cb1){
            custPrice += 2;
        }
        if(cb2){
            custPrice += 1;
        }
        TV_Price.setText("$ " + custPrice);
    }
    public void reCal(View view){
        switch (view.getId()) {
            case R.id.CB_Choocolate:
            case R.id.CB_Whipped:
                calPrice(view);
                break;
        }
    }
    public void submitOrder(View view){
        calPrice(view);
        String text = "Successfully :)" + EdT_Name.getText();
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();

    }
}
