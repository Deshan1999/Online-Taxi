package com.example.taxi.driver_management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.taxi.R;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class edit extends AppCompatActivity {

    EditText dname, demail, dpassword, daddress, dphone,dvehicle,res;
    Button update,delete;

    FirebaseDatabase database;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        dname = findViewById(R.id.enter_name);
        demail = findViewById(R.id.enter_email);
        dpassword = findViewById(R.id.enter_password);
        daddress = findViewById(R.id.enter_address);
        dphone = findViewById(R.id.enter_phone_number);
        dvehicle = findViewById(R.id.enter_vehicle_number);
        res =findViewById(R.id.res);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        String name,email,pass,address,phone,vehicleid;

        name =getIntent().getStringExtra("username");
        email =getIntent().getStringExtra("email");
        pass =getIntent().getStringExtra("password");
        address =getIntent().getStringExtra("address");
        phone =getIntent().getStringExtra("phoneno");
        vehicleid =getIntent().getStringExtra("vehiclenumber");

        dname.setText(name);
        demail.setText(email);
        dpassword.setText(pass);
        daddress.setText(address);
        dphone.setText(phone);
        dvehicle.setText(vehicleid);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                databaseReference = database.getReference("driver");

                String name = dname.getText().toString();
                String email = demail.getText().toString();
                String password = dpassword.getText().toString();
                String address = daddress.getText().toString();
                String phone = dphone.getText().toString();
                String vehiclid = dvehicle.getText().toString();

                com.example.taxi.driver_management.TaxiDriver taxiDriver = new com.example.taxi.driver_management.TaxiDriver(name, email, password, address, phone,vehiclid);
                databaseReference.child(name).setValue(taxiDriver);

                Toast.makeText(getApplicationContext(), "Driver Details Updated", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                databaseReference = database.getReference("driver");

                String name = dname.getText().toString();
                databaseReference.child(name).setValue(null);
                Toast.makeText(getApplicationContext(), "Driver Removed", Toast.LENGTH_SHORT).show();

                dname.setText("");
                demail.setText("");
                dpassword.setText("");
                daddress.setText("");
                dphone.setText("");
                dvehicle.setText("");

            }
        });
    }
}