package com.example.taxi.driver_management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.taxi.R;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DriverActivity extends AppCompatActivity {


    EditText dname, demail, dpassword, daddress, dphone,dvehicle,res;
    Button button;

    public static final String EXTRA_MESSAGE =
            "com.example.myfirstapp.MESSAGE";
    FirebaseDatabase database;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);



        dname = findViewById(R.id.enter_name);
        demail = findViewById(R.id.enter_email);
        dpassword = findViewById(R.id.enter_password);
        daddress = findViewById(R.id.enter_address);
        dphone = findViewById(R.id.enter_phone_number);
        dvehicle = findViewById(R.id.enter_vehicle_number);
        res =findViewById(R.id.res);
        button = findViewById(R.id.update);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                databaseReference = database.getReference("driver");

                String name = dname.getText().toString();
                String email = demail.getText().toString();
                String password = dpassword.getText().toString();
                String address = daddress.getText().toString();
                String phone = dphone.getText().toString();
                String vehiclid = dvehicle.getText().toString();
                String ress = res.getText().toString();

                if (name.isEmpty()||email.isEmpty()||password.isEmpty()||address.isEmpty()||phone.isEmpty()||vehiclid.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill all Fields", Toast.LENGTH_SHORT).show();

                }else{
                    com.example.onlinetaxi.TaxiDriver taxiDriver = new com.example.onlinetaxi.TaxiDriver(name, email, password, address, phone,vehiclid);
                    databaseReference.child(name).setValue(taxiDriver);

                    Toast.makeText(getApplicationContext(), "Driver Inserted", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(getApplicationContext(), Edit_.class);
                    intent.putExtra("username", dname.getText().toString());
                    intent.putExtra("email", demail.getText().toString());
                    intent.putExtra("password", dphone.getText().toString());
                    intent.putExtra("address", daddress.getText().toString());
                    intent.putExtra("phoneno", dphone.getText().toString());
                    intent.putExtra("vehiclenumber", dvehicle.getText().toString());
                    startActivity(intent);
                }
            }
        });



    }
}