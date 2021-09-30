package com.example.taxi.driver_management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.taxi.R;

import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import android.content.Intent

public class locations extends AppCompatActivity {


    TextView from,where,pnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);




        Spinner dropdown = findViewById(R.id.spinner1);

        String[] items = new String[]{"1", "2", "three"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);



        from = findViewById(R.id.from);
        where = findViewById(R.id.where);
        pnumber = findViewById(R.id.pnum);

        intent intent = getIntent();
        intent.getStringextra( from :"",from)


    }
}