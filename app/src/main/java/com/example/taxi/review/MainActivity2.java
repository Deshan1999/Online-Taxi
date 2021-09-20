package com.example.taxi.review;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.taxi.user.user;
import com.example.taxiapp2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {
    EditText t1,t2,t3,t4,t5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
    }
    public void signup(View view){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user");

        final long[] childCount = {0};

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                childCount[0] = dataSnapshot.getChildrenCount() ;
                user usr = new user(String.valueOf(childCount[0] + 1) ,t1.getText().toString() ,t2.getText().toString() , t3.getText().toString() , t4.getText().toString() , t5.getText().toString());

                DatabaseReference myRef2 = database.getReference("user").child(String.valueOf(childCount[0] + 1));

                myRef2.setValue(usr);

                Intent i = new Intent(MainActivity2.this, MainActivity4.class);
                i.putExtra("id", (String.valueOf(childCount[0] + 1)));
                i.putExtra("name", t1.getText().toString());
                startActivity(i);
                Toast.makeText(MainActivity2.this, "Account Creation Successful", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void login(View view){
        Intent i = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(i);
    }
}