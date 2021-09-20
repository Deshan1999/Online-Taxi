package com.example.taxi.review;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.taxiapp2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText t6,t7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);

    }

    public void login(View view){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                long childCount = dataSnapshot.getChildrenCount() ;

                final int[] count = {0};
                final int[] count2 = {1};
                DatabaseReference familyListReference = FirebaseDatabase.getInstance().getReference().child("user");
                familyListReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            String key = (String) ds.getKey();
                            DatabaseReference keyReference = FirebaseDatabase.getInstance().getReference().child("user").child(key);
                            keyReference.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    String un = dataSnapshot.child("email").getValue(String.class);
                                    String name = dataSnapshot.child("name").getValue(String.class);
                                    String pw = dataSnapshot.child("password").getValue(String.class);
                                    String RetrivedId = dataSnapshot.child("id").getValue(String.class);
                                    if(un.equals(t6.getText().toString()) && pw.equals(t7.getText().toString())){
                                        count[0]++;
                                        Intent i = new Intent(MainActivity.this, MainActivity4.class);
                                        i.putExtra("id", RetrivedId);
                                        i.putExtra("name", name);
                                        startActivity(i);
                                    }
                                    else {
                                        if(count[0] == 0 && childCount <= count2[0]){
                                            Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                    count2[0]++;
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void signUp(View view){
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }
}