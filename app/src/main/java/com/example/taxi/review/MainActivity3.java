package com.example.taxi.review;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taxiapp2.R;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void nextwindow(View view){
        Intent i = new Intent(MainActivity3.this, MainActivity4.class);
        startActivity(i);
    }
}