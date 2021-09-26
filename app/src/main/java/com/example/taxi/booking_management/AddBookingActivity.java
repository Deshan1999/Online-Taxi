package com.example.taxi.booking_management;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.taxi.R;

public class AddBookingActivity extends AppCompatActivity {
    EditText fullname,phonenumber,date,time,from,to;
    Button cancel,save;
    DatabaseReference addbooking;
    booking bk;
    RadioButton Car, Bike, Tuk;
    String Vehicle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        fullname = findViewById(R.id.fullname);
        phonenumber = findViewById(R.id.Phonenumber);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        from = findViewById(R.id.from1);
        to = findViewById(R.id.to);
        cancel = findViewById(R.id.cancel);
        save = findViewById(R.id.save);
        Car = findViewById(R.id.radioButton4);
        Bike = findViewById(R.id.radioButton5);
        Tuk = findViewById(R.id.radioButton6);

        bk = new booking();

        addbooking= FirebaseDatabase.getInstance().getReference().child("vehiclebooking");

        save.setOnClickListener(new View.OnClickListener() {

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
                addbooking = FirebaseDatabase.getInstance().getReference().child(" vehiclebooking");
                try{
                    if(TextUtils.isEmpty( fullname.getText().toString())){
                        Toast.makeText(getApplicationContext()," is Emplty",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(phonenumber.getText().toString())){
                        Toast.makeText(getApplicationContext()," is Emplty",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(date.getText().toString())){
                        Toast.makeText(getApplicationContext()," is Emplty",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(time.getText().toString())){
                        Toast.makeText(getApplicationContext()," is Emplty",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(from.getText().toString())){
                        Toast.makeText(getApplicationContext()," is Emplty",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(to.getText().toString())){
                        Toast.makeText(getApplicationContext()," is Emplty",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(Vehicle)){
                        Toast.makeText(getApplicationContext()," is Emplty",Toast.LENGTH_SHORT).show();
                    }

                    else{
                        bk.setFullName( fullname.getText().toString());
                        bk.setPhoneNum( phonenumber.getText().toString());
                        bk.setdate( date.getText().toString());
                        bk.settime( time.getText().toString());
                        bk.setfrom( from.getText().toString());
                        bk.setto( to.getText().toString());
                        bk.setVehicle(Vehicle);

                         addbooking.push().setValue(bk);
                        Toast.makeText(getApplicationContext()," Record added successful",Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Please Check Your Entered Details",Toast.LENGTH_SHORT).show();

                }
            }
        });
         cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(AddBookingActivity.this, ShowTicket.class);
                //startActivity(intent);
            }
        });

    }
}
