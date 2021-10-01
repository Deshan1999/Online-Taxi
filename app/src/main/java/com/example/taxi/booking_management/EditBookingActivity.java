package com.example.taxi.booking_management;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taxi.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditBookingActivity extends AppCompatActivity {
    TextView id;

    EditText fullname, phonenumber, date, time, from, to;
    Button update, delete;
    DatabaseReference addbooking;
    booking bk;
    RadioButton Car, Bike, Tuk;
    String Vehicle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        fullname = findViewById(R.id.full_name);
        phonenumber = findViewById(R.id.phone_number);
        date = findViewById(R.id.day);
        time = findViewById(R.id.time2);
        from = findViewById(R.id.from2);
        to = findViewById(R.id.to2);
        update = findViewById(R.id.update);
        Car = findViewById(R.id.radioButton1);
        Bike = findViewById(R.id.radioButton2);
        Tuk = findViewById(R.id.radioButton3);
        id = findViewById(R.id.id);
        delete = findViewById(R.id.delete);


        bk = new booking();

        addbooking = FirebaseDatabase.getInstance().getReference().child("vehiclebooking");
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Car.isChecked()){
                    Vehicle = "Car";
                }
                else if(Bike.isChecked()){
                    Vehicle = "Bike";
                }
                else{
                    Vehicle = "Tuk";
                }
                addbooking = FirebaseDatabase.getInstance().getReference();
                addbooking.child("vehiclebooking").child(id.getText().toString()).child("fullname").setValue( fullname.getText().toString().trim());
                addbooking.child("vehiclebooking").child(id.getText().toString()).child("phonenumber").setValue(phonenumber.getText().toString().trim());
                addbooking.child("vehiclebooking").child(id.getText().toString()).child("date").setValue(date.getText().toString().trim());
                addbooking.child("vehiclebooking").child(id.getText().toString()).child("time").setValue(time.getText().toString().trim());
                addbooking.child("vehiclebooking").child(id.getText().toString()).child("from").setValue(from.getText().toString().trim());
                addbooking.child("vehiclebooking").child(id.getText().toString()).child("to").setValue(to.getText().toString().trim());
                addbooking.child("vehiclebooking").child(id.getText().toString()).child("Vehicle").setValue(Vehicle);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 addbooking = FirebaseDatabase.getInstance().getReference().child("Vehicle").child(id.getText().toString());
                addbooking.removeValue();
                Toast.makeText(getApplicationContext(),"Successfully Delete", Toast.LENGTH_SHORT).show();
            }
        });


    }
}